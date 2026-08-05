# Episode 01 — Stream Creation

> **Series:** Java 8 Interview Series | [@theconsistentcoder](https://www.instagram.com/theconsistentcoder)

---

## What You Will Learn

There are 3 ways to create a Stream in Java 8. Most developers only know one. This episode covers all three — and when to use each.

---

## Methods Covered

| Method | When to Use |
|---|---|
| `stream()` | You have a `List` or `Collection` — use this 90% of the time |
| `Stream.of()` | You have individual objects — great for tests and quick demos |
| `Arrays.stream()` | Your data is in an array — common in legacy codebases |

---

## The Domain — Movie

All examples across this series use a `Movie` object with 7 fields:

```java
public class Movie {
    int id;
    String title;
    String genre;       // Action, Drama, Sci-Fi, Animation, Romance
    double rating;      // IMDb-style rating out of 10
    int year;           // Release year
    int duration;       // Duration in minutes
    boolean isAvailable;
}
```

### Dataset

| # | Title | Genre | Rating | Year | Duration | Available |
|---|---|---|---|---|---|---|
| 1 | Titanic | Romance | 7.8 | 1997 | 195 mins | ✅ |
| 2 | Avatar | Sci-Fi | 7.9 | 2009 | 162 mins | ✅ |
| 3 | Iron Man | Action | 7.9 | 2008 | 126 mins | ✅ |
| 4 | The Lion King | Animation | 8.5 | 1994 | 88 mins | ✅ |
| 5 | Joker | Drama | 8.4 | 2019 | 122 mins | ❌ |
| 6 | Avengers | Action | 8.4 | 2019 | 181 mins | ✅ |
| 7 | Frozen | Animation | 7.5 | 2013 | 102 mins | ❌ |
| 8 | Spider-Man | Action | 7.4 | 2002 | 121 mins | ✅ |
| 9 | The Dark Knight | Action | 9.0 | 2008 | 152 mins | ✅ |
| 10 | Forrest Gump | Drama | 8.8 | 1994 | 142 mins | ❌ |

---

## Code Walkthrough

### Way 1 — `stream()` from a List

```java
List<Movie> movies = MovieData.getMovies();
Stream<Movie> s1 = movies.stream();
s1.forEach(m -> System.out.println(m.getTitle()));
```

Called directly on any `List` or `Collection`. This is the most common way — use it whenever you already have a collection.

**Output:**
```
Titanic
Avatar
Iron Man
The Lion King
Joker
Avengers
Frozen
Spider-Man
The Dark Knight
Forrest Gump
```

---

### Way 2 — `Stream.of()` from individual objects

```java
Stream<Movie> s2 = Stream.of(
    new Movie(1, "Titanic", "Romance", 7.8, 1997, 195, true),
    new Movie(2, "Avatar",  "Sci-Fi",  7.9, 2009, 162, true)
);
s2.forEach(m -> System.out.println(m.getTitle() + " | Genre: " + m.getGenre()));
```

No List needed. Pass objects directly. Perfect for unit tests and demos with hardcoded data.

**Output:**
```
Titanic | Genre: Romance
Avatar | Genre: Sci-Fi
```

---

### Way 3 — `Arrays.stream()` from an array

```java
Movie[] movieArray = movies.toArray(new Movie[0]);
Stream<Movie> s3 = Arrays.stream(movieArray);
s3.forEach(m -> System.out.println(m.getTitle() + " | Duration: " + m.getDuration() + " mins"));
```

Use when your data comes as an array — common in legacy Java code or APIs that return arrays.

**Output:**
```
Titanic | Duration: 195 mins
Avatar | Duration: 162 mins
Iron Man | Duration: 126 mins
...
```

---

## Key Takeaways

- A `Stream` is **not** a data structure — it does not store data
- It is a **pipeline** — data flows in, gets processed, result comes out
- A stream can only be **used once** — reuse it and you get `IllegalStateException`
- All three methods produce the same `Stream<Movie>` — the rest of the pipeline is identical

---

## How to Run

### Prerequisites
- Java 8 or higher
- Maven 3.x

### Steps

```bash
cd episode01-stream-creation
mvn compile
mvn exec:java
```

Or open in IntelliJ IDEA and run `StreamCreationDemo.java` directly.

---

## Project Structure

```
episode01-stream-creation/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/theconsistentcoder/java8/episode01/
                ├── Movie.java                  ← Domain model
                ├── MovieData.java              ← Shared test data
                └── StreamCreationDemo.java     ← Main demo
```

---

## Series Navigation

| Episode | Topic | Methods |
|---|---|---|
| **Episode 01** | **Stream Creation ← you are here** | `stream()`, `Stream.of()`, `Arrays.stream()` |
| Episode 02 | filter + map | `filter()`, `map()` |
| Episode 03 | sorted + distinct + limit | `sorted()`, `distinct()`, `limit()` |
| Episode 04 | skip + count + peek | `skip()`, `count()`, `peek()` |
| Episode 05 | Match + Find | `anyMatch()`, `allMatch()`, `noneMatch()`, `findFirst()` |
| Episode 06 | min + max + reduce | `min()`, `max()`, `reduce()` |
| Episode 07 | Primitive Streams | `mapToInt()`, `sum()`, `average()`, `summarizingInt()` |
| Episode 08 | Collectors Basics | `toList()`, `toSet()`, `toMap()` |
| Episode 09 | Grouping + Partitioning | `groupingBy()`, `partitioningBy()` |
| Episode 10 | Downstream Collectors | `joining()`, `counting()`, downstream |
