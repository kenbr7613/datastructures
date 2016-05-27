public class MinHeap{
    
    int[] heap;
    int size;
    int capacity;
    
    public MinHeap() {
        size = 0;
        capacity = 2;
        heap = new int[capacity];
    }
    
    
    public int getSize() { return size ; }
    
    public boolean isEmpty() { return size == 0; }
    
    public void insert(int val) {
        if(size == capacity) {
            growHeap();
        }
        heap[size] = val;
        siftUp(size);
        size++;
    }
    
    public int readTop(){
        if(size==0) {
            return -1;
        }
        swap(0,size-1);
        size--;
        siftDown(0);
        return heap[size];
    }
    
    public int getTop() {
        if(size==0) {
            return -1;
        }
        return heap[0];
    }
    
    private void siftUp(int pos) {
        if(pos == 0) {
            return;
        }
        int par = parent(pos);
        if(heap[pos] < heap[par]) {
            swap(pos, par);
            siftUp(par);
        }
    }
    
    private void siftDown(int pos) {
        int lc = Integer.MAX_VALUE;
        int rc = Integer.MAX_VALUE;
        if(left(pos) < size) {
            lc = heap[left(pos)];
        }
        if(right(pos) < size) {
            rc = heap[right(pos)];
        }
        if(heap[pos] > lc || heap[pos] > rc) {
            if(lc < rc) {
                swap(pos, left(pos));
                siftDown(left(pos));
            } else {
                swap(pos, right(pos));
                siftDown(right(pos));
            }
        }
                
    }
    
    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }
    
    private int parent(int pos) {
        return pos / 2; // Integer division rounds down
    }
    
    private int left(int pos) {
        return pos * 2;
    }
    
    private int right(int pos) {
        return pos * 2 + 1;
    }
    
    private void growHeap(){
        capacity = capacity * 2;
        int[] tempHeap = new int[capacity];
        for(int i=0; i<size; i++) {
            tempHeap[i] = heap[i];
        }
        heap = tempHeap;
    }
    
    
}