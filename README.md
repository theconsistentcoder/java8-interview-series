# Java 8 Interview Series

> **By [@theconsistentcoder](https://www.instagram.com/theconsistentcoder)**
> Every Java 8 concept asked in interviews. One episode at a time.

---

## About This Series

This repository contains the complete source code for the **Java 8 Interview Series**. Each folder is one episode — focused demo, clean code, full README. No fluff. Just real code with a real domain.

The series covers everything Java 8 interviews test — Stream API, Functional Interfaces, Lambdas, Method References, Optional, Date & Time API, and coding questions.

---

## Domain — Movie

Every example across all episodes uses the same `Movie` object:

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

### Dataset Used Across All Episodes

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

## Episodes — Stream API

| Episode | Folder | Methods | Difficulty |
|---|---|---|---|
| Episode 01 | `episode01-stream-creation` | `stream()`, `Stream.of()`, `Arrays.stream()` | 🟢 Beginner |
| Episode 02 | `episode02-filter-map` | `filter()`, `map()` | 🟢 Beginner |
| Episode 03 | `episode03-sorted-distinct-limit` | `sorted()`, `distinct()`, `limit()` | 🟢 Beginner |
| Episode 04 | `episode04-skip-count-peek` | `skip()`, `count()`, `peek()` | 🟢 Beginner |
| Episode 05 | `episode05-match-find` | `anyMatch()`, `allMatch()`, `noneMatch()`, `findFirst()` | 🟡 Intermediate |
| Episode 06 | `episode06-min-max-reduce` | `min()`, `max()`, `reduce()` | 🟡 Intermediate |
| Episode 07 | `episode07-primitive-streams` | `mapToInt()`, `sum()`, `average()`, `summarizingInt()` | 🟡 Intermediate |
| Episode 08 | `episode08-collectors-basics` | `toList()`, `toSet()`, `toMap()` | 🟡 Intermediate |
| Episode 09 | `episode09-grouping-partitioning` | `groupingBy()`, `partitioningBy()` | 🔴 Advanced |
| Episode 10 | `episode10-downstream-collectors` | `joining()`, `counting()`, downstream | 🔴 Advanced |

*More episodes coming — Functional Interfaces, Lambdas, Optional, Date & Time API, Coding Questions*

---

## How to Use This Repo

### Clone

```bash
git clone https://github.com/theconsistentcoder/java8-interview-series.git
cd java8-interview-series
```

### Run Any Episode

```bash
cd episode01-stream-creation
mvn compile
mvn exec:java
```

Each episode folder has its own `README.md` with full explanation, code walkthrough, and expected output.

### Prerequisites

- Java 8 or higher
- Maven 3.x
- IntelliJ IDEA (recommended)

---

## Episode Descriptions

### Episode 01 — Stream Creation
**Methods:** `stream()` · `Stream.of()` · `Arrays.stream()`

There are 3 ways to create a Stream in Java 8. Most developers only know one. This episode covers all three and when to use each. Foundation of everything that follows.

### Episode 02 — filter() + map()
**Methods:** `filter()` · `map()`

The most used combo in the entire Stream API. `filter()` keeps only what matches your condition. `map()` transforms each element. Think SQL WHERE + SELECT in one pipeline.

### Episode 03 — sorted() + distinct() + limit()
**Methods:** `sorted()` · `distinct()` · `limit()`

Sort by any field, remove duplicates, cap results at N elements. These three replace most manual sorting and deduplication logic written with loops.

### Episode 04 — skip() + count() + peek()
**Methods:** `skip()` · `count()` · `peek()`

`skip()` and `limit()` together give you pagination. `count()` tells you how many elements survived. `peek()` lets you inspect elements mid-pipeline without consuming the stream — the best debugging trick in Streams.

### Episode 05 — Match + Find
**Methods:** `anyMatch()` · `allMatch()` · `noneMatch()` · `findFirst()`

Four short-circuit operations — they stop as soon as they have an answer. Replaces every boolean flag ever written inside a for loop.

### Episode 06 — min() + max() + reduce()
**Methods:** `min()` · `max()` · `reduce()`

`min()` and `max()` find the smallest and largest elements. `reduce()` folds the entire stream into a single value — the most powerful aggregation tool in Streams.

### Episode 07 — Primitive Streams
**Methods:** `mapToInt()` · `sum()` · `average()` · `summarizingInt()`

`mapToInt()` converts to a primitive `IntStream` — no boxing, extra numeric methods included. `summarizingInt()` returns count, sum, min, max, and average all in one single pass.

### Episode 08 — Collectors Basics
**Methods:** `Collectors.toList()` · `Collectors.toSet()` · `Collectors.toMap()`

Three ways to collect processed stream results. `toList()` preserves order. `toSet()` removes duplicates. `toMap()` builds a lookup map — the most interview-tested pattern in Streams.

### Episode 09 — Grouping + Partitioning
**Methods:** `Collectors.groupingBy()` · `Collectors.partitioningBy()`

`groupingBy()` creates one bucket per unique category. `partitioningBy()` always creates exactly two buckets — true and false. These two collectors replace entire blocks of HashMap manipulation code.

### Episode 10 — Downstream Collectors
**Methods:** `Collectors.joining()` · `Collectors.counting()` · downstream collectors

`joining()` concatenates strings. `counting()` counts per group. Downstream collectors let you compose — `groupingBy()` + `averagingInt()` gives average per category in one line. This is what separates junior devs from senior devs in code reviews.

---

## Connect

- Instagram: [@theconsistentcoder](https://www.instagram.com/theconsistentcoder)
- YouTube: [The Consistent Coder](https://www.youtube.com/@theconsistentcoder)

---

## License

MIT — use this code freely for learning, teaching, and interviews.
