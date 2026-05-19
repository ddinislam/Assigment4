# Assignment 4: Graph Traversal and Representation System

## Project Overview

This project implements a **graph data structure** using an adjacency list representation, along with two fundamental graph traversal algorithms: **BFS** (Breadth-First Search) and **DFS** (Depth-First Search). The implementation is tested on graphs of different sizes to analyze performance.

### What is a Graph?
A **graph** is a data structure consisting of:
- **Vertices (V)** — nodes/points in the graph
- **Edges (E)** — connections between vertices

Graphs are used to model networks, maps, social connections, dependencies, and many other real-world systems.

---

## Class Descriptions

### `Vertex.java`
Represents a single node in the graph.
- **Field:** `id` — unique integer identifier
- **Methods:** constructor, `getId()`, `toString()`

### `Edge.java`
Represents a directed connection between two vertices.
- **Fields:** `source` (starting vertex), `destination` (ending vertex)
- **Methods:** constructor, `getSource()`, `getDestination()`, `toString()`

### `Graph.java`
The core data structure. Uses an **adjacency list** — a `HashMap` where each key is a vertex ID and the value is a list of neighboring vertex IDs.

Why adjacency list over adjacency matrix?
| | Adjacency List | Adjacency Matrix |
|---|---|---|
| Space | O(V + E) | O(V²) |
| Best for | Sparse graphs | Dense graphs |
| Add edge | O(1) | O(1) |
| Find neighbors | O(degree) | O(V) |

**Methods:**
- `addVertex(Vertex v)` — adds a vertex to the graph
- `addEdge(int from, int to)` — adds a directed edge
- `printGraph()` — prints the adjacency list
- `bfs(int start)` — Breadth-First Search traversal
- `dfs(int start)` — Depth-First Search traversal

### `Experiment.java`
Handles performance testing.
- `runTraversals(Graph g)` — runs BFS and DFS, measures time with `System.nanoTime()`
- `runMultipleTests()` — tests on small (10), medium (30), and large (100) vertex graphs
- `printResults()` — prints a formatted comparison table

### `Main.java`
Entry point. Creates an `Experiment` instance and runs all tests.

---

## Algorithm Descriptions

### BFS — Breadth-First Search

**How it works (step by step):**
1. Start at the given vertex, mark it as visited, add to queue
2. Dequeue the front vertex, print it
3. Add all unvisited neighbors to the queue and mark them visited
4. Repeat until the queue is empty

**Data structure used:** Queue (FIFO)

**Use cases:**
- Finding the shortest path in an unweighted graph
- Level-order traversal
- Finding all nodes at distance K from source

**Time complexity:** O(V + E) — every vertex and edge is visited once

---

### DFS — Depth-First Search

**How it works (step by step):**
1. Start at the given vertex, mark it as visited, print it
2. Recursively visit the first unvisited neighbor
3. Backtrack when no unvisited neighbors remain
4. Continue until all reachable vertices are visited

**Data structure used:** Call stack (recursion)

**Use cases:**
- Detecting cycles in a graph
- Topological sorting
- Solving mazes and puzzles
- Finding connected components

**Time complexity:** O(V + E) — every vertex and edge is visited once

---

## Experimental Results

Graphs were generated with random directed edges using a fixed seed for reproducibility.

| Graph Size | Vertices | Edges | BFS Time (ns) | DFS Time (ns) |
|------------|----------|-------|---------------|---------------|
| Small      | 10       | 20    | 2,414,800     | 657,400       |
| Medium     | 30       | 80    | 1,059,200     | 688,200       |
| Large      | 100      | 300   | 2,841,300     | 1,867,100     |

### Observations
- Both BFS and DFS have the same theoretical complexity O(V + E), confirmed by results
- DFS is consistently faster in practice due to lower memory overhead (no queue)
- The first run (Small graph) shows higher time due to JVM warm-up
- As graph size grows from 30 → 100 vertices (3.3×), execution time grows roughly proportionally

---

## Screenshots

> Add screenshots of your program output here.
> Suggested screenshots:
> - Small graph adjacency list printout
> - BFS traversal output
> - DFS traversal output
> - Performance results table

---

## How to Run

```bash
# Compile all files
javac src/*.java

# Run the program
java -cp src Main
```

---

## Repository Structure

```
assignment3-graphs/
├── src/
│   ├── Vertex.java
│   ├── Edge.java
│   ├── Graph.java
│   ├── Experiment.java
│   └── Main.java
├── README.md
└── .gitignore
```

---

## Reflection

Working on this assignment deepened my understanding of how graphs are structured and traversed. Implementing an adjacency list made it clear why this representation is preferred for sparse graphs — it avoids wasting memory on storing zero-connections that an adjacency matrix would include.

The most interesting discovery was the behavioral difference between BFS and DFS. BFS explores layer by layer, which makes it ideal for finding shortest paths, while DFS dives as deep as possible before backtracking, making it better suited for exhaustive search problems. Measuring execution time with `System.nanoTime()` showed that despite having identical theoretical complexity O(V + E), DFS runs faster in practice due to simpler memory management — recursion on the call stack versus maintaining an explicit queue in BFS.

The main challenge was ensuring the traversal correctly handles disconnected components and avoids infinite loops through proper visited-node tracking.
