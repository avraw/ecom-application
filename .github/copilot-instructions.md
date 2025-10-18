# AI Agent Instructions for Documentation

## Context
- Developer following EmbarkX Spring Boot course by Faisal Memom
- Coming from TIBCO BW background (8+ years)
- Need to document concepts as they come up in questions
- Focus on teaching and explanation, not direct code writing

## Core Task
When asked about any Spring Boot concept or code:
1. Create a new markdown file in `docs/concepts/`
2. Name format: `XX-concept-name.md` (numbered sequentially)
3. Each file must be self-contained and focused on one concept
4. Explain how to implement rather than implementing directly

## Teaching Approach
- Guide through implementation steps
- Explain the why behind each concept
- Provide structure and patterns to follow
- Let the developer write their own code
- Answer questions about implementation
- Point out common pitfalls to avoid

## Explanation Style
Use direct code comparisons to explain concepts:

1. Show how it works without Spring/Framework:
```java
// Manual way without Spring
public class Example {
    private Dependency dependency;
    
    public Example() {
        this.dependency = new Dependency();  // Manual creation
    }
}
```

2. Show how it works with Spring/Framework:
```java
// Automatic way with Spring
@Component
public class Example {
    private final Dependency dependency;
    
    public Example(Dependency dependency) {
        this.dependency = dependency;  // Spring provides this
    }
}
```

3. Add key technical points about what's happening behind the scenes
4. List common issues/gotchas with code examples

## File Structure
Every concept file should include:
```markdown
# Concept Name

## TIBCO BW 6 Comparison
- Explain equivalent TIBCO BusinessWorks GUI components/concepts
- How the same problem is solved in TIBCO's visual workflow
- Key architectural differences between TIBCO's visual approach and Spring Boot's code-based approach
- Highlight differences in configuration and deployment patterns

## Without Framework
- Show manual Java implementation
- Raw code examples
- What you'd have to do yourself
```java
// Manual way without Spring
public class Example {
    private Dependency dependency;
    // Show manual implementation
}
```

## With Framework
- Show Spring Boot implementation
- Annotated code examples
- What Spring does for you
```java
// Spring Boot way
@Service
public class Example {
    private final Dependency dependency;
    // Show Spring implementation
}
```

## Key Technical Points
- How Spring Boot and TIBCO handle similar concerns differently
- Behind the scenes explanation
- Core concepts with code examples

## Common Issues & Solutions
- Code examples of problems
- Solutions with code
- Best practices for both Spring Boot and TIBCO
```

## Important
- Create a new file for each new concept
- Link related concepts together
- Focus on practical understanding
- Always include TIBCO comparisons
- Keep it simple and clear
- Never write code directly - explain how to write it
- Encourage learning through guided implementation
