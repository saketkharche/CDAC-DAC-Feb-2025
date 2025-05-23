import java.util.LinkedHashSet;
import java.util.Set;

public class LinkSetDemo {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        Set<String> fruits = new LinkedHashSet<>();

        // Adding elements to the LinkedHashSet
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("pineapple");
        fruits.add("watermelon");
        fruits.add("apple"); // Duplicate, will be ignored
        fruits.add("banana"); // Duplicate, will be ignored

        // Displaying the elements (insertion order maintained)
        System.out.println(fruits);

        // Removing an element
        fruits.remove("cherry");
        System.out.println("After removing 'cherry': " + fruits);

        // Checking if an element exists
        System.out.println("Contains 'apple'? " + fruits.contains("apple"));

        // Size of the LinkedHashSet
        System.out.println("Size: " + fruits.size());

        // Iterating through the LinkedHashSet
        System.out.println("Iterating over elements:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Clearing the LinkedHashSet
        fruits.clear();
        System.out.println("After clearing: " + fruits);
    }
}
