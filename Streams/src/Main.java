import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 20));
        people.add(new Person("Charlie", 17));
        people.add(new Person("David", 22));
        people.add(new Person("Eve", 17));
        people.add(new Person("Frank", 22));

        // Print all people older than 18
        System.out.println("People older than 18: \n For loop:");
        for(Person person : people) {
            if(person.getAge() >= 18) {
                System.out.println(person);
            }
        }
        System.out.println("Stream:" );
        people.stream()
                .filter(person -> person.getAge() >= 18) // Lambda expression
                .forEach(System.out::println);

        // Save all people with names in uppercase and ages increased by 1 to a new list
        System.out.println("--------------------\nPeople with names in uppercase and ages increased by 1:");
        List <Person> filteredPeople = people.stream().map(
                person -> new Person(person.getName().toUpperCase(), person.getAge() +1)
        ).collect(Collectors.toList());
        filteredPeople.forEach(System.out::println);

        // Add all ages
        System.out.println("--------------------\nSum of all ages:");
        int sum = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sum);

        // Sort people by age
        System.out.println("--------------------\nPeople sorted by age:");
        filteredPeople.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
        
        // Group by characterisitc
        System.out.println("--------------------\nPeople grouped by age:");
        people.stream()
                .collect(Collectors.groupingBy(Person::getAge))
                .forEach((age, group) -> {
                    System.out.println("Age: " + age);
                    group.forEach(System.out::println);
                });
        
        //
    }
}