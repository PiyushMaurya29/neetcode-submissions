class Node{
    Node next;
    int key;
    Node(int key){
        this.key = key;
    }
}
class MyHashSet {

    int size;
    Node[] arr;
    public MyHashSet() {
        size = 1000;
        arr = new Node[size];
    }

    public int getHash(int key){
        return key%size;
    }
    
    public void add(int key) {
        int hash = getHash(key);
        if(arr[hash] == null){
            arr[hash] = new Node(key);
            return;
        }
        Node curr = arr[hash];
        while(curr != null){
            if(curr.key == key){
                return;
            }
            if(curr.next == null){
                break;
            }
            curr = curr.next;
        }
        curr.next = new Node(key);
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
    
    public boolean contains(int key) {
        int hash = getHash(key);
        Node curr = arr[hash];
        while(curr != null){
            if(curr.key == key){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}



// class MyHashSet {
//     boolean[] arr;
//     public MyHashSet() {
//         arr = new boolean[1000001];
//     }
    
//     public void add(int key) {
//         arr[key] = true;
//     }
    
//     public void remove(int key) {
//         arr[key] = false;
//     }
    
//     public boolean contains(int key) {
//         return arr[key];
//     }
// }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */