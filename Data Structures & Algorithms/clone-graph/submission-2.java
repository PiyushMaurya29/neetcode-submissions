/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfsClone(Node node, Map<Node, Node> map){
        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node, newNode);
        for(var adjNode : node.neighbors){
            if(!map.containsKey(adjNode)){
                dfsClone(adjNode, map);
            }
        }
    }
    public void dfsSolve(Node node, Map<Node, Node> map, Set<Node> visitedSet){
        visitedSet.add(node);
        Node curr = map.get(node);
        for(var n : node.neighbors){
            curr.neighbors.add(map.get(n));
        }
        for(var adjNode : node.neighbors){
            if(!visitedSet.contains(adjNode)){
                dfsSolve(adjNode, map, visitedSet);
            }
        }
    }
    public void solveDFS(Node node, Map<Node, Node> map){
        Node newNode = new Node(node.val);
        // Node newNode = new Node();
        // newNode.val = node.val;
        map.put(node, newNode);
        for(var adjNode : node.neighbors){
            if(!map.containsKey(adjNode)){
                solveDFS(adjNode, map);
            }
        }
        for(var n : node.neighbors){
            newNode.neighbors.add(map.get(n));
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        solveDFS(node, map);
        return map.get(node); 

        // if(node == null) return null; 
        // Map<Node, Node> map = new HashMap<>();
        // dfsClone(node, map);
        // Set<Node> visitedSet = new HashSet<>();
        // dfsSolve(node, map, visitedSet);
        // return map.get(node);
    }
}