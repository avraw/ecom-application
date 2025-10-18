# Immutable Lists in Java

## TIBCO Comparison
- In TIBCO BusinessWorks, data structures are generally immutable by default
- TIBCO process variables are copied when passed between activities
- Modifying TIBCO data structures typically creates new copies
- TIBCO's approach to immutability helps prevent side effects in business processes

## Explanation
An immutable list is a list that cannot be modified after it's created. This means:
- No elements can be added
- No elements can be removed
- The existing elements cannot be modified
- The order cannot be changed

This immutability provides several benefits:
1. Thread safety without synchronization
2. Safe to share across different parts of the application
3. Predictable behavior
4. Can be safely used as keys in HashMaps

## Implementation Steps
There are several ways to create immutable lists in Java:

1. Using `Collections.unmodifiableList()`:
   ```java
   List<User> mutableList = new ArrayList<>();
   mutableList.add(new User("John"));
   List<User> immutableList = Collections.unmodifiableList(mutableList);
   ```

2. Using `List.of()` (Java 9+):
   ```java
   List<String> immutableList = List.of("item1", "item2", "item3");
   ```

3. Using `ImmutableList` from Google Guava:
   ```java
   ImmutableList<String> immutableList = ImmutableList.of("item1", "item2");
   ```

4. Using Stream API (Java 8+):
   ```java
   List<String> immutableList = Stream.of("item1", "item2")
       .collect(Collectors.collectingAndThen(
           Collectors.toList(),
           Collections::unmodifiableList));
   ```

## Common Pitfalls

1. Reference Mutability:
   ```java
   List<User> users = List.of(new User("John"));
   users.get(0).setName("Jane"); // Still possible! Objects inside are still mutable
   ```

2. Backing List Changes:
   ```java
   List<String> mutableList = new ArrayList<>();
   List<String> immutableView = Collections.unmodifiableList(mutableList);
   mutableList.add("new item"); // Changes are reflected in immutableView!
   ```

## Interview Notes
- Key Points:
  1. Immutable lists are thread-safe by default
  2. Different ways to create immutable lists (List.of vs Collections.unmodifiableList)
  3. Immutability of container vs immutability of contents
  4. Performance benefits of immutable collections
  5. Memory usage considerations

- Common Questions:
  1. How to ensure deep immutability?
  2. Difference between unmodifiable view and truly immutable list
  3. When to use immutable lists vs synchronized lists
  4. Performance implications of immutable lists
  5. How to handle cases where modification is needed?

## Best Practices
1. Prefer `List.of()` for small, fixed lists (Java 9+)
2. Use defensive copying when returning immutable lists from methods:
   ```java
   private final List<User> users = List.of(new User("John"));
   
   public List<User> getUsers() {
       return List.copyOf(users); // Creates a new immutable copy
   }
   ```
3. Make the reference final when possible:
   ```java
   final List<String> immutableList = List.of("item1", "item2");
   ```
4. Consider using immutable objects inside immutable lists for true immutability
5. Document when a method returns an immutable list
6. Use appropriate exception handling for UnsupportedOperationException

## Common Use Cases
1. Configuration data
2. Constants
3. API responses
4. Value objects
5. Cache entries
6. Public API return values
7. Thread-safe data sharing