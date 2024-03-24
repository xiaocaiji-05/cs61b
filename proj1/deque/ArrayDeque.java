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
        items = (T[]) new Object[8];
        size = 0;
        capacity = 8;
        front = 0;
        end = -1;
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
        size++;
    }

    private int minusOne(int x , int module )
    {
        return (x + module - 1) % module;
    }
    private int plusOne(int x, int module)
    {
        x %= module;
        return x == module - 1 ? 0 : x + 1;
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
        front = plusOne(front,capacity);
        size--;
        if(size > 0 && size * 4 > capacity) shrink();
        return del;
    }
    public T removeLast()
    {
        if(isEmpty()) return null;
        T del = items[end];
        if(size == 1)
        {
            front = 0;
            end = -1;
        }
        else
        {
            end = minusOne(end,capacity);
        }
        size--;
        if(size > 0 && size * 4 >capacity) shrink();
        return del;
    }

}
