class Node{
    Node prev;
    Node next;
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
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addNodeAtTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addNodeAtTail(Node node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeAtTail(node);
        }
        else{
            if(map.size() == maxCapacity){
                Node lruNode = head.next;
                deleteNode(lruNode);
                map.remove(lruNode.key);
            }
            Node newNode = new Node(key, value);
            addNodeAtTail(newNode);
            map.put(key, newNode);
        }
    }
}




// class LRUCache {
//     List<int[]> list;
//     int maxCapacity;
//     public LRUCache(int capacity) {
//         maxCapacity = capacity;
//         list = new ArrayList<>();
//     }
    
//     public int get(int key) {
//         for(int i=0 ; i<list.size() ; i++){
//             if(list.get(i)[0] == key){
//                 int value = list.get(i)[1];
//                 list.remove(i);
//                 list.add(new int[]{key, value});
//                 return value;
//             }
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         int index = -1;
//         for(int i=0 ; i<list.size() ; i++){
//             if(list.get(i)[0] == key){
//                 index = i;
//                 break;
//             }
//         }
//         if(index == -1){
//             if(list.size() == maxCapacity){
//                 list.remove(0);
//             }
//             list.add(new int[]{key, value});
//         }
//         else{
//             list.remove(index);
//             list.add(new int[]{key, value});
//         }
//     }
// }
