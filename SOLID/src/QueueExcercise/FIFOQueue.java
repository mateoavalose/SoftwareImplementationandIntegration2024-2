package QueueExcercise;

import java.util.*;

public class FIFOQueue implements IQueue{
    Queue<Integer> queue = new LinkedList<>();
    
    @Override
    public void push(int a) {
        queue.add(a);
    }
    @Override
    public int pop() {
        if(queue.isEmpty())
            return -1;
        return queue.poll();
    }
}