package deque;

public class LinkedListDeque<T> {
    int size;
    TNode<T> sentinel = new TNode<>(null);

    public LinkedListDeque()
    {
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T x)
    {
        TNode<T> temp = new TNode<>(x);
        sentinel.next.next.prev = temp;
        temp.next = sentinel.next.next;
        temp.prev = sentinel;
        sentinel.next = temp;
        size++;
    }

    public void addLast(T x)
    {
        TNode<T> temp = new TNode<>(x);
        sentinel.prev.next = temp;
        temp.prev = sentinel.prev;
        temp.next = sentinel;
        sentinel.prev = temp;
        size++;
    }
    public T removeLast()
    {
        if(sentinel.next == sentinel) return sentinel.elem;
        TNode<T> temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return temp.elem;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return  sentinel.next == sentinel ;
    }

    public void printDeque()
    {
        TNode<T> x = sentinel;
        while(x.next != sentinel)
        {
            System.out.print(x.elem);
            System.out.print(' ');
            x = x.next;
        }
        System.out.print('\n');
    }

    public T removeFirst()
    {
        if(sentinel.next == sentinel) return sentinel.elem;
        TNode<T> temp = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size--;
        return temp.elem;
    }

    public T get(int i) {
        if(sentinel.next == sentinel) return null;
        TNode<T> head = sentinel.next;
        while(i > 0)
        {
            head = head.next;
            i--;
        }
        return head.elem;
    }

    public T getRecursive(int index)
    {
        if(index >= size)
        {
            return null;
        }

        return getRecursive(0,index,sentinel.next);
    }
    private T getRecursive(int pos, int index, TNode<T> x)
    {
        if(pos == index) return  x.elem;
        else return getRecursive(pos+1, index, x.next);
    }
}

