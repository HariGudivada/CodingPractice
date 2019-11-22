import java.util.Arrays;

public class MinIntHeap {
    private int size = 0;
    private int capacity = 10;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    private int getParentIndex(int childIndex) {
        return (childIndex-1) / 2;
    }


    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) > size;
    }
    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) > size;
    }
    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= size;
    }

    private int parent(int childIndex){ return items[getParentIndex(childIndex)];}
    private int leftChild(int parentIndex){ return items[getLeftChildIndex(parentIndex)];}
    private int rightChild(int parentIndex){ return items[getRightChildIndex(parentIndex)];}

    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int item = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = item;
    }

    public int peek () {
        if (size == 0) {
            throw new IllegalStateException("dsfa");
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("dsfa");
        }
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return  item;
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyDown () {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallestValueIndex = getLeftChildIndex(index);
            if (hasRightChild(index)) {
                smallestValueIndex = smallestValueIndex < getRightChildIndex(index) ? smallestValueIndex : getRightChildIndex(index);
            }

            if( items[index]< items[smallestValueIndex]) {
                break;
            }

            swap(index, smallestValueIndex);
            index = smallestValueIndex;
        }


    }

    private void heapifyUp(){
        int index = size -1;
        while (hasParent(index) && parent(index) > items[index]) {
            final int parentIndex = getParentIndex(index);
            swap(parentIndex, index);
            index = parentIndex;
        }
    }
}
