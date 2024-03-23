package deque;

public class TNode<T>{
    T elem;
    TNode<T> next;
    TNode<T> prev;

    public TNode(T x)
    {
        elem = x;
        next = null;
        prev = null;
    }

    public TNode()
    {
        next = null;
        prev = null;
    }

}
