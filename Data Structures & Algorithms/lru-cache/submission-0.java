class LRUCache {
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
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addNodeAtLast(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int maxCapacity;
    public LRUCache(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addNodeAtLast(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeAtLast(node);
        }
        else{
            if(map.size() == maxCapacity){
                Node node = head.next;
                deleteNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            addNodeAtLast(node);
            map.put(key, node);
        }
    }
}
