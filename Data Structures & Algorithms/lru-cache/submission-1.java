class Node{
    Node next;
    Node prev;
    int key;
    int value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    int maxCapacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        maxCapacity = capacity;
        
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addNodeAtHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addNodeAtHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeAtHead(node);
        }
        else{
            if(map.size() == maxCapacity){
                Node lruNode = tail.prev;
                deleteNode(lruNode);
                map.remove(lruNode.key);
            }
            Node newNode = new Node(key, value);
            addNodeAtHead(newNode);
            map.put(key, newNode);
        }
    }
}
