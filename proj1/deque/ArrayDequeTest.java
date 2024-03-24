package deque;
import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayDequeTest {
    @Test
    public void ArrayTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        System.out.println("Adding elements...");
        for (int i = 0; i < 10; i++) {
            deque.addLast(i);
        }
        System.out.println("Current size: " + deque.size());

        System.out.println("Removing elements...");
        while (!deque.isEmpty()) {
            System.out.println("Removed: " + deque.removeLast());
        }
        System.out.println("Final size: " + deque.size());
    }
}