# Java Programming Assignments

## Overview

This repository contains four Java programming assignments covering game development, graphical user interfaces, concurrency, file handling, exception handling, and unit testing.

The assignments progress from a basic Tic-Tac-Toe implementation to a GUI-based version, followed by two multithreaded prime-number applications.

This project was originally developed as part of the **Programming for AI 3 (Java)** module at Ostbayerische Technische Hochschule Amberg-Weiden (OTH Amberg-Weiden).

## Assignments

### Task 1 – Tic-Tac-Toe

A Java implementation of the classic **Tic-Tac-Toe** game.

The project includes the game board and player logic, support for human and AI players, input handling, a custom exception, and tests for important game functionality.

Main classes include:

```text
Main.java
Playground.java
Player.java
HumanPlayer.java
TicTacToeAI.java
CoordinatePair.java
IncorrectNumberOfPlayersException.java
```

Tests are included for the playground and Tic-Tac-Toe AI.

### Task 2 – Tic-Tac-Toe GUI

An extended version of the Tic-Tac-Toe project that adds a **graphical user interface** and allows the size of the playing board to be changed.

Main classes include:

```text
Main.java
Playground.java
CoordinatePair.java
```

A test for the playground implementation is also included.

### Task 3 – Concurrent Prime Number Checker

A multithreaded Java application that finds all **prime numbers up to a user-defined limit**.

The user can specify the **number of threads** used for the calculation, demonstrating concurrent computation in Java.

Main classes include:

```text
Main.java
ConcurrentPrimeNumberChecker.java
PrimeNumbersThread.java
```

Unit tests are included for the concurrent checker and prime-number thread implementation.

### Task 4 – Concurrent Prime Number Checker with Persistence

An extended version of Task 3.

In addition to calculating prime numbers using multiple threads, discovered prime numbers are **saved to a file and reused in later executions**.

The project adds file persistence through:

```text
FileManager.java
savednumbers.txt
```

Tests are included for the prime-number checker, worker thread, and file manager.

## Concepts Demonstrated

Across the four assignments, the repository demonstrates:

- Java object-oriented programming
- Classes and inheritance
- Interfaces between game components
- Exception handling
- Graphical user interfaces
- Java concurrency and multithreading
- File input/output
- Data persistence
- Unit testing
- Separation of application logic into multiple classes

## Project Structure

```text
Java-Programming-Assignments/
├── aufgabe1/
│   └── src/
│       ├── main/
│       └── test/
│
├── aufgabe2/
│   └── src/
│       ├── main/
│       └── test/
│
├── aufgabe3/
│   └── src/
│       ├── main/
│       └── test/
│
└── aufgabe4/
    ├── savednumbers.txt
    └── src/
        ├── main/
        └── test/
```

## Requirements

- Java Development Kit (JDK)
- An IDE such as IntelliJ IDEA can be used to open and run the individual assignments.

## Running the Projects

Each assignment is an independent Java project and contains its own `Main.java` entry point.

To run an assignment using IntelliJ IDEA:

1. Open the desired assignment folder (`aufgabe1`, `aufgabe2`, `aufgabe3`, or `aufgabe4`) as a project.
2. Navigate to:

```text
src/main/Main.java
```

3. Run the `Main` class using the IDE's run functionality.

No additional setup is required by the original project instructions.

## Testing

The assignments include Java test classes under:

```text
src/test/
```

Depending on the assignment, these cover game-board behavior, Tic-Tac-Toe AI behavior, concurrent prime-number calculation, worker-thread behavior, and file management.

## Technologies

- Java
- Java GUI programming
- Java concurrency / multithreading
- File I/O
- Unit testing
- IntelliJ IDEA

## Author

**Tsvetan Stanchev**  
Ostbayerische Technische Hochschule Amberg-Weiden (OTH Amberg-Weiden)
