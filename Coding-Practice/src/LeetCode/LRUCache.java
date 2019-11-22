package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    LRUCache(int capacity) {
        this.capacity = capacity;
        size =0;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    private int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.val;
    }
    
    public void put (int key, int val) {
        if (map.containsKey(key))  {
            Node node = map.get(key);
            node.val = val;
            moveToHead(node);
        } else {
            Node node = new Node(key, val);
            map.put(key, node);
            addToFront(node);
            size++;
            if(size>capacity) {
                removeLRUEntry();
            }
        }
    }

    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeLRUEntry() {
        Node nodeToRemove = tail.prev;
        removeNode(nodeToRemove);
        map.remove(nodeToRemove.key);
        size--;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(Node node) {
        Node tempPrev = node.prev;
        Node tempNext = node.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
    }
}
