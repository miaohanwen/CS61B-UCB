package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node{
        public T item;
        public Node next;
        public Node prev;
        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int s;

    public LinkedListDeque(){
        sentinel = new Node(null, null,null);
        s = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item){
        Node p = sentinel;
//        if ((p.prev == null)&&(p.next==null)){
//            p.next = new Node(item, p, p);
//            p.prev = new Node(item, p, p);
//        }
//        else{
//            p.next = new Node(item, p, p.next);
//            p.next.prev = new Node(item, p, p.next);
//        }
//        Node newNode = new Node(item, p, p.next);
        Node firstNode = p.next;
        p.next = new Node(item, p, firstNode);
        firstNode.prev = p.next;
        s += 1;
    }

    public void addLast(T item){
        Node p = sentinel;
//        if ((p.prev == null)&&(p.next==null)){
//            p.next = new Node(item, p, p);
//            p.prev = new Node(item, p, p);
//        }
//        else{
//            p.prev = new Node(item, p, p.prev);
//            p.prev.next = new Node(item, p, p.prev);
//        }
        Node lastNode = p.prev;
        p.prev = new Node(item, lastNode, p);
        lastNode.next = p.prev;
        s += 1;
    }

    public int size(){
        return s;
    }

    public void printDeque(){
        Node p = sentinel;
        for(int i=0;i<s;i++){
            p = p.next;
            System.out.print(p.item);
            System.out.print(' ');
        }
        System.out.println(' ');
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        Node p = sentinel;
        Node rmNode = sentinel.next;
        T rmItem = rmNode.item;
        p.next = rmNode.next;
        rmNode.next.prev = p;
        s -= 1;
        return rmItem;
//        if ((p.next == null) || (p.next == sentinel)){
//            return null;
//        }
//        else{
//            T ret = p.next.item;
//            p.next = p.next.next;
//            p.next.prev = p;
//            s -= 1;
//            return ret;
//        }
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        Node p = sentinel;
        Node rmNode = sentinel.prev;
        T rmItem = rmNode.item;
        p.prev = rmNode.prev;
        rmNode.prev.next = p;
        s -= 1;
        return rmItem;
//        Node p = sentinel;
//        if ((p.prev == null) ||(p.next == sentinel)){
//            return null;
//        }
//        else{
//            T ret = p.prev.item;
//            p.prev = p.prev.prev;
//            p.prev.next = p;
//            s -= 1;
//            return ret;
//        }
    }

    public T get(int index){
        Node p = sentinel;
        for(int i=index;i>0;i--){
            p = p.next;
            if (p==null) {
                return null;
            }
        }
        return p.item;
    }
}
