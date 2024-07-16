import Animals.*;
import QueueExcercise.*;
import Shapes.*;

public class Main {
    public static void main(String[] args) {
        /* SOLID Principle Examples: 
         * S: Single Responsibility Principle: A class should have only one reason to change.
         * O: Open/Closed Principle: Software entities should be open for extension, but closed for modification.
         * L: Liskov Substitution Principle: Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.
         * I: Interface Segregation Principle: A client should never be forced to implement an interface that it doesn't use or clients shouldn't be forced to depend on methods they do not use.
         * D: Dependency Inversion Principle: High-level modules should not depend on low-level modules. 
         *    Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
         */
        // Single Responsibility Principle, Open/Closed Principle, Liskov Substitution Principle
        System.out.println("Shape examples: ");
        IShape r1 = new Rectangle(2, 3);
        IShape c1 = new Circle(5);
        System.out.println(r1);
        System.out.println(c1);

        // Interface Segregation Principle
        System.out.println("\nAnimal examples: ");
        IAnimal cat = new Cat();
        cat.eat();

        // Dependency Inversion Principle
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