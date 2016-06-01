import java.util.Scanner;

public class ParProc {
    public static void main(String[] args) {
        ParProc mypp= new ParProc();
        mypp.run();
    }    
    public void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Queue q = new Queue();
        
        for(int i=0; i<m; i++) {
            q.enqueue(s.nextInt());
        }
        
        int[] threads = new int[n];
        //assert 0
        for(int i=0; i<n; i++)
        {
            threads[i] = 0;
        }
        
        int time = 0;
        while(!q.isEmpty()) {
            for(int i=0; i<n; i++) {
                if(threads[i]==0) {
                    threads[i] = q.dequeue();
                    System.out.println(Integer.toString(i) + " " + Integer.toString(time));
                }
                threads[i]--;
                if(q.isEmpty()) {
                    break;
                }
            }
            time++;
        }
        
    }
    
    private class Queue {
        private Node head;
        private Node tail;
        
        public Queue() {
            head = null;
            tail = null;
        }
        
        public void enqueue(int val) {
            Node a = new Node(val);
            if(isEmpty()) {
                head = a;
                tail = a;
            } else {
                tail.setNext(a);
                tail = a;
            }
        }
        
        public int dequeue() {
            if(isEmpty()) {
                return -1; // throw error
            } else {
                Node temp = head;
                head = head.getNext();
                if(head == null) {
                    tail = null;
                }
                return temp.getVal();
            }
        }
        
        public boolean isEmpty() {
            if(head == null) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public class Node {
        private int val;
        private Node next;
        
        public Node(int val) {
            this.val = val;
            next = null;
        }
        
        public int getVal() {
            return val;
        }
        
        public Node getNext() {
            return next;
        }
        
        public void setNext(Node a) {
            next = a;
        }
    }
}