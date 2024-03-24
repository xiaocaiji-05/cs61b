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
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        end = 0;
    }

    public int size()
    {
        return size;
    }

    public T get(int index)
    {
       if(index < 0|| index >= size) return null;
       return items[(front + index) % capacity];
    }
    public void printDeque()
    {
        for(int i = 0 ; i < size; i++)
        {
            System.out.print(items[(front + i) % capacity] + " ");
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
    public void addFirst(T x)
    {
        if(size == capacity)
        {
            grow();
        }
        front = minusOne(front, capacity);
        items[front] = x;
        if(size == 0) end = front;
        size++;
    }

    public void addLast(T x)
    {
        if(size == capacity)
        {
            grow();
        }
        end = plusOne(end, capacity);
        items[end] = x;
        if(size == 0) front = end;
        size++;
    }

    private int minusOne(int x , int module )
    {
        return (x + module - 1) % module;
    }
    private int plusOne(int x, int module)
    {
        return (x + 1) % module;
    }

    private void grow()
    {
        T[] newArray = (T[]) new Object[capacity*2];
        for(int i = 0; i < size; i++)
        {
            newArray[i] = items[(front+i)%capacity];
        }
        items = newArray;
        capacity = capacity* 2;
        front = 0;
        end = size - 1;
    }

    private void shrink()
    {
        if(capacity <= 16 || size * 4 > capacity) return;
        T[] newArray = (T[]) new Object[capacity / 2];
        for(int i = 0; i < size; i++)
        {
            newArray[i] = items[(front+ i)% capacity];
        }
        items = newArray;
        front = 0;
        end = size - 1;
        capacity = capacity / 2;
    }

    public T removeFirst()
    {
        if(isEmpty()) return null;
        T del = items[front];
        items[front] = null;
        front = plusOne(front,capacity);
        size--;
        if(size == 0) front = end = 0;
        if(size > 0 && size * 4 > capacity) shrink();
        return del;
    }
    public T removeLast()
    {
        if(isEmpty()) return null;
        T del = items[end];
        end = minusOne(end, capacity);
        items[end] = null;
        size--;
        if(size == 0) front = end = 0;
        if(size > 0 && size * 4 >capacity) shrink();
        return del;
    }

}
