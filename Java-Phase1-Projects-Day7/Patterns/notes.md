# Day 7 Notes – Pattern & Number Logic

## Focus
- Nested loops
- Star patterns
- Number patterns
- Problem-solving using loops
- Mini project: Pattern-based exercises

---

## Key Concepts

### 1. Nested Loops
- A loop inside another loop.
- Outer loop controls rows, inner loop controls columns.
- Example:

```java
for (int i = 1; i <= rows; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
