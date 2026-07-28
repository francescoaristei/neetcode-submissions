class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node() {}
}

class LRUCache {
    private int maxCapacity;
    private int currCapacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        currCapacity = 0;
    }
    
    public int get(int key) {
        Node curr = head;
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        if (curr == null) {
            return -1;
        }

        // if access head
        if (curr.key == head.key) {
            return curr.val;
        }

        // if access tail move tail to head
        if (curr.key == tail.key) {
            // update head
            Node node = new Node(tail.key, tail.val);
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;

            // remove tail
            tail.prev.next = null;
            tail = tail.prev;

            return node.val;
        }

        // if access in the middle
        Node node = new Node(curr.key, curr.val);
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;

        // remove intermediate node
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if (currCapacity == 0) {
            Node node = new Node(key, value);
            head = node;
            tail = node;
            currCapacity++;
            return;
        }

        Node curr = head;
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        // new element
        if (curr == null) {
            // insert node in head
            Node node = new Node(key, value);
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;

            if (currCapacity == maxCapacity) {
                // remove tail
                tail.prev.next = null;
                tail = tail.prev;
            } else {

                currCapacity++;
            }
        } else { // update element

            // insert node in head
            Node node = new Node(key, value);
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;

            if (curr.key == tail.key) {
                // remove tail
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                // delete node in the middle
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
        }
    }
}
