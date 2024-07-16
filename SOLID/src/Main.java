import Animals.*;
import QueueExcercise.*;
import Shapes.*;

public class Main {
    public static void main(String[] args) {
        /* SOLID Principle Examples */
        // 
        System.out.println("Shape examples: ");
        IShape r1 = new Rectangle(2, 3);
        IShape c1 = new Circle(5);
        System.out.println(r1);
        System.out.println(c1);

        // 
        System.out.println("\nAnimal examples: ");
        IAnimal cat = new Cat();
        cat.eat();

        // 
        System.out.println("\nQueue examples: FIFO");
        IQueue fifo = new FIFOQueue();
        System.out.println("FIFO push: 1, 2, 3");
        fifo.push(1);
        fifo.push(2);
        fifo.push(3);
        System.out.println("FIFO pop: " + fifo.pop());

        System.out.println("Queue examples: LIFO");
        IQueue lifo = new LIFOQueue();
        System.out.println("LIFO push: 1, 2, 3");
        lifo.push(1);
        lifo.push(2);
        lifo.push(3);
        System.out.println("LIFO pop: " + lifo.pop());
    }
}