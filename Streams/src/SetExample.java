import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person("John", 25));
        people.add(new Person("John", 31));
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 20));
        people.add(new Person("Bob", 17));

        // Print all people
        System.out.println("All people:");
        people.forEach(System.out::println);
    }
}
    
