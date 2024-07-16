package QueueExcercise;

import java.util.Stack;

public class LIFOQueue implements IQueue{
    Stack<Integer> stack = new Stack<>();
    
    @Override
    public void push(int a) {
        stack.push(a);
    }
    @Override
    public int pop() {
        if(stack.isEmpty())
            return -1;
        return stack.pop();
    }
}