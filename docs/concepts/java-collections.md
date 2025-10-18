# Java Collections: List<User>

## TIBCO Comparison
- In TIBCO BusinessWorks, you typically work with XML structures and arrays
- TIBCO uses XMLSchema to define data structures
- In TIBCO, you might have used `<xsd:sequence>` or repeating elements to represent multiple items
- The closest TIBCO equivalent would be an array of User objects in a process variable

## Explanation
`List<User>` is a Java collection type that represents an ordered collection of User objects. Let's break this down:

- `List` is an interface in Java's Collection framework
- `<User>` is a generic type parameter specifying that this List can only contain User objects
- It's similar to an array but with more flexibility and built-in methods

## Implementation Steps
1. First, import the List interface:
   ```java
   import java.util.List;
   ```

2. Choose an implementation (most common is ArrayList):
   ```java
   import java.util.ArrayList;
   ```

3. Create a List of Users in one of these ways:
   ```java
   List<User> users = new ArrayList<>();  // Preferred
   ArrayList<User> users = new ArrayList<>();  // Also valid
   ```

4. Common operations:
   - Add a user: `users.add(user)`
   - Get a user: `users.get(index)`
   - Remove a user: `users.remove(index)` or `users.remove(user)`
   - Check if empty: `users.isEmpty()`
   - Get size: `users.size()`

## Interview Notes
- Key points to remember:
  1. List is an interface, ArrayList is an implementation
  2. Lists maintain insertion order (unlike Sets)
  3. Lists can contain duplicate elements
  4. Lists are zero-indexed
  5. Lists are dynamic in size (unlike arrays)
  
- Common interview questions:
  1. Difference between List and Array
  2. Why use List interface instead of ArrayList directly
  3. Thread safety considerations (ArrayList vs Vector)
  4. Performance characteristics (access, insertion, deletion)

## Best Practices
1. Always declare variables using the interface type:
   ```java
   List<User> users = new ArrayList<>();  // Good
   ArrayList<User> users = new ArrayList<>();  // Less flexible
   ```

2. Use the diamond operator `<>` for cleaner syntax
3. Consider using `Collections.unmodifiableList()` for immutable lists
4. Use meaningful names that indicate plurality (users, customerList, etc.)
5. Consider capacity planning for large lists