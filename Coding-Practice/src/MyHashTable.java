import java.util.ArrayList;
import java.util.List;

public class MyHashTable {
    class Node <K, V> {
        K key;
        V value;

        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    class MyMap<K, V> {
        // Current size of array list
        int size;
        // Current capacity of array list
        int numBuckets;
        private List<Node<K, V>> bucketArray;

        public MyMap() {
            bucketArray = new ArrayList<>();
            size = 0;
            numBuckets = 10;

            for(int i = 0; i <numBuckets; i++) {
                bucketArray.add(null);
            }
        }

        private int size() {
            return size;
        }

        private boolean isEmpty() {
            return size() == 0;
        }

        private int getbucketIndex(K key) {
            int hashCode = key.hashCode();
            int index = hashCode%numBuckets;
            return index;
        }

        public V remove (K key) {
            int index = getbucketIndex(key);
            Node<K, V> head = bucketArray.get(index);
            Node<K, V> prev = null;
            while (head != null) {
                if (head.key == key) {
                    break;
                }

                prev = head;
                head = head.next;
            }

            if (head == null) {
                return null;
            }

            size--;
            if (prev != null) {
                prev.next = head.next;
            } else {
                bucketArray.set(index, head.next);
            }

            return head.value;
        }

        public void add(K key, V value) {
            int index = getbucketIndex(key);
            Node<K, V> head = bucketArray.get(index);
            while (head != null) {
                if (head.key == key) {
                    head.value = value;
                    return;
                }

                head = head.next;
            }
            size++;
            //Adding at the head of the linked list chain
            head = bucketArray.get(getbucketIndex(key));
             Node<K, V> node = new Node<>(key, value);
             node.next = head;
             bucketArray.set(index, node);

            // If load factor goes beyond threshold, then
            // double hash table size
            if (1.0 * size/numBuckets >= 0.7) {
                List<Node<K, V>> temp = bucketArray;
                bucketArray = new ArrayList<>();
                 size = 0;
                 numBuckets = 2 * numBuckets;

                 for (Node<K, V> headNode : temp) {
                     while (headNode != null) {
                         add(headNode.key, headNode.value);
                         headNode = headNode.next;
                     }
                 }

            }
        }

        public V get (K key) {
            int index = getbucketIndex(key);
            Node<K, V> head = bucketArray.get(index);
            while (head != null) {
                if (head.key == key) {
                    return head.value;
                }
                head  = head.next;
            }

            return null;
        }


    }

}
