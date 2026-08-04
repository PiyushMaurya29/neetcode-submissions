class Node{
    Node next;
    int key;
    int value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class MyHashMap {
    int size;
    Node[] arr;
    public MyHashMap() {
        size = 1000;
        arr = new Node[size];
    }

    public int getHash(int key){
        return key%size;
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        if(arr[hash] == null){
            arr[hash] = new Node(key, value);
            return;
        }
        Node curr = arr[hash];
        while(curr != null){
            if(curr.key == key){
                curr.value = value;
                return;
            }
            if(curr.next == null){
                break;
            }
            curr = curr.next;
        }
        curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int hash = getHash(key);
        Node curr = arr[hash];
        while(curr != null){
            if(curr.key == key){
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        if(arr[hash] == null){
            return;
        }
        Node prev = null;
        Node curr = arr[hash];
        while(curr != null){
            if(curr.key == key){
                if(prev == null){
                    arr[hash] = curr.next;
                }
                else{
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}



// class MyHashMap {
//     int[] arr;
//     public MyHashMap() {
//         arr = new int[1000001];
//         Arrays.fill(arr, -1);
//     }
    
//     public void put(int key, int value) {
//         arr[key] = value;
//     }
    
//     public int get(int key) {
//         return arr[key];
//     }
    
//     public void remove(int key) {
//         arr[key] = -1;
//     }
// }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */