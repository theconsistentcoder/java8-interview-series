# Episode 02 — filter() + map()

> **Series:** Java 8 Interview Series | [@theconsistentcoder](https://www.instagram.com/theconsistentcoder)

---

## What You Will Learn

The most used combo in the entire Stream API. `filter()` keeps only what matches your condition. `map()` transforms each element into something else. Think SQL WHERE + SELECT in one pipeline.

---

## Methods Covered

| Method | Description |
|---|---|
| `filter()` | Keeps elements that match the condition — everything else is discarded |
| `map()` | Transforms each element into something else |

---

## Code Walkthrough

### filter() — keep only Action movies

```java
List<String> actionTitles = movies.stream()
        .filter(m -> m.getGenre().equals("Action"))
        .map(Movie::getTitle)
        .collect(Collectors.toList());

System.out.println("Action movies: " + actionTitles);
```

**Output:**
```
Action movies: [Iron Man, Avengers, Spider-Man, The Dark Knight]
```

`filter()` ran first — dropped Romance, Sci-Fi, Animation, Drama. Only 4 Action movies survived. Then `map()` converted each Movie object into just its title string.

---

### Chaining multiple filters

```java
List<String> topAvailable = movies.stream()
        .filter(Movie::isAvailable)
        .filter(m -> m.getRating() > 8.0)
        .map(m -> m.getTitle() + " (" + m.getRating() + ")")
        .collect(Collectors.toList());

System.out.println("Top available: " + topAvailable);
```

**Output:**
```
Top available: [The Lion King (8.5), Avengers (8.4), The Dark Knight (9.0), Forrest Gump (8.8)]
```

You can chain as many `filter()` calls as you need. Each one narrows the stream further.

---

## Key Takeaways

- `filter()` — think SQL WHERE. Keeps what matches, discards everything else
- `map()` — think SQL SELECT. Transforms each element into something new
- You can chain multiple `filter()` calls in one pipeline
- `map()` changes the type — `Stream<Movie>` becomes `Stream<String>` after `map(Movie::getTitle)`

---

## How to Run

```bash
cd episode02-filter-map
mvn compile
mvn exec:java
```

---

## Project Structure

```
episode02-filter-map/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/theconsistentcoder/java8/episode02/
                ├── Movie.java
                ├── MovieData.java
                └── FilterMapDemo.java
```

---

## Series Navigation

| Episode | Topic | Methods |
|---|---|---|
| Episode 01 | Stream Creation | `stream()`, `Stream.of()`, `Arrays.stream()` |
| **Episode 02** | **filter + map ← you are here** | `filter()`, `map()` |
| Episode 03 | sorted + distinct + limit | `sorted()`, `distinct()`, `limit()` |
| Episode 04 | skip + count + peek | `skip()`, `count()`, `peek()` |
| Episode 05 | Match + Find | `anyMatch()`, `allMatch()`, `noneMatch()`, `findFirst()` |
| Episode 06 | min + max + reduce | `min()`, `max()`, `reduce()` |
| Episode 07 | Primitive Streams | `mapToInt()`, `sum()`, `average()`, `summarizingInt()` |
| Episode 08 | Collectors Basics | `toList()`, `toSet()`, `toMap()` |
| Episode 09 | Grouping + Partitioning | `groupingBy()`, `partitioningBy()` |
| Episode 10 | Downstream Collectors | `joining()`, `counting()`, downstream |
