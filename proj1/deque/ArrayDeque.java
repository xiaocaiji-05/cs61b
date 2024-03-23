package deque;

import edu.princeton.cs.algs4.TopologicalX;

@SuppressWarnings("unchecked")
public class ArrayDeque<T> {

    private int front;
    private int end;
    private T[] items;
    private  int size;
    int capacity;
    public ArrayDeque()
    {
        items = (T[]) new Object[9];
        size = 0;
        capacity = 8;
        front = 0;
        end = 0;
    }

    public int size()
    {
        return size;
    }

    public T get(int index)
    {
        if(index >= size) return null;
        int ptr = front;
        while(index > 0)
        {
            ptr = plusOne(ptr, capacity);
            index--;
        }
        return items[ptr];
    }
    public void printDeque()
    {
        int ptr = front;
        while(ptr != end)
        {
            System.out.print(items[ptr]+ " ");
            ptr = plusOne(ptr, capacity);
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
    public void addFirst(T x)
    {
        if(size == capacity - 1)
        {
            grow();
        }
        front = minusOne(front, capacity);
        items[front] = x;
        size++;
    }

    public void addLast(T x)
    {
        if(size == capacity - 1)
        {
            grow();
        }
        end = plusOne(end, capacity);
        items[end] = x;
        size++;
    }

    private int minusOne(int x , int module )
    {
        return x == 0 ? capacity - 1 : x - 1;
    }
    private int plusOne(int x, int module)
    {
        x %= module;
        return x == module - 1 ? 0 : x + 1;
    }

    private void grow()
    {
        T[] newArray = (T[]) new Object[capacity*2];
        int ptr1 = front;
        int ptr2 = capacity / 2;
        while(ptr1 != end)
        {
            newArray[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1 , capacity);
            ptr2 = plusOne(ptr2 ,capacity * 2);
        }
        front = capacity / 2;
        end = ptr2;
        items = newArray;
        capacity = capacity * 2;
    }

    private void shrink()
    {
        T[] newArray = (T[]) new Object[capacity / 2];
        int ptr1 = front;
        int ptr2 =  capacity / 4;
        while(ptr1 != end)
        {
            newArray[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1, capacity);
            ptr2 = plusOne(ptr2, capacity / 2);
        }
        front = capacity / 4;
        end = ptr2;
        capacity = capacity / 2;
    }

    public T removeFirst()
    {
        if(capacity >= 16 && capacity / size >= 4)
        {
            shrink();
        }
        if(size == 0) return null;
        T del = items[front];
        front = plusOne(front,capacity);
        size--;
        return del;
    }
    public T removeLast()
    {
        if(capacity >= 16 && capacity / size >= 4)
        {
            shrink();
        }
        if(size == 0) return null;
        T del = items[end];
        end = minusOne(end, capacity);
        size--;
        return del;
    }

}
