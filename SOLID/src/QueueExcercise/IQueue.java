package QueueExcercise;

public interface IQueue {
    public void push(int value); // If the queue is FIFO, add it to the end of the queue. If the queue is LIFO, add it to the beginning of the queue.
    public int pop(); // If the queue is FIFO, remove the first element of the queue. If the queue is LIFO, remove the last element of the queue.
}