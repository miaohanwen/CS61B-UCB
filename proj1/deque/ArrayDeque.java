package deque;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int s;
    private int iniCapacity = 8;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[iniCapacity];
        s = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        int i = 0;
        if (nextFirst < nextLast){
            for (int j=nextFirst;j<nextLast;j++){
                a[i] = items[j];
                i += 1;
            }
        }
        else{
            for (int j=nextFirst;j<items.length;j++){
                a[i] = items[j];
                i += 1;
            }
            for (int j=0;j<nextLast;j++){
                a[i] = items[j];
                i += 1;
            }
        }
        nextFirst = 0;
        nextLast = i;
        items = a;
    }

    public void addFirst(T item){
        if (s == items.length-2){
            iniCapacity = iniCapacity*2;
            resize(iniCapacity);
        }
        items[nextFirst] = item;
        if (nextFirst==0){
            nextFirst = items.length-1;
        }
        else{nextFirst -= 1;}
        s += 1;
    }

    public void addLast(T item){
        if (s == items.length-2){
            iniCapacity = iniCapacity*2;
            resize(iniCapacity);
        }
        items[nextLast] = item;
        if (nextLast==items.length - 1){
            nextLast = 0;
        }
        else{nextLast += 1;}
        s += 1;
    }

    public int size(){
        return s;
    }

    public void printDeque(){
        if (nextFirst < nextLast){
            for (int i=nextFirst+1;i<nextLast-1;i++){
                System.out.print(items[i]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }
        else{
            for (int i=nextFirst+1;i<items.length;i++){
                System.out.print(items[i]);
                System.out.print(' ');
            }
            for (int i=0;i<nextLast;i++){
                System.out.print(items[i]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        if (nextFirst == items.length - 1){
            nextFirst = 0;
        }
        else{nextFirst += 1;}
        s -= 1;
        T ret = items[nextFirst];

        return ret;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        if (nextLast == 0){
            nextLast = items.length - 1;
        }
        else{nextLast -= 1;}
        s -= 1;
        T ret = items[nextLast];
        return ret;
    }

    public T get(int index){
        return items[index];

    }
}
