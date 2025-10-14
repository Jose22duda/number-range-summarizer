# Number Range Summarizer

This project implements a Java utility to produce a comma-delimited list of numbers, grouping sequential numbers into ranges.  
It is designed to fulfill a coding assessment using Java 8, clean object-oriented design, and comprehensive unit testing.

## Features

- Parses comma-separated numbers from a string input.
- Summarizes consecutive numbers into succinct ranges (e.g., `1,3,6-8,12-15`).
- Robust object-oriented design following the provided interface.
- Includes complete JUnit unit tests for all logic.


## How to Compile & Run Tests (Without Maven)

1. **Compile the classes:**
    ```
    javac -cp "libs/junit-4.13.2.jar;libs/hamcrest-core-1.3.jar;src/main/java" src/main/java/numberrangesummarizer/*.java
    javac -cp "libs/junit-4.13.2.jar;libs/hamcrest-core-1.3.jar;src/main/java" src/test/java/numberrangesummarizer/*.java
    ```
2. **Run the tests:**
    ```
    java -cp "libs/junit-4.13.2.jar;libs/hamcrest-core-1.3.jar;src/main/java;src/test/java" org.junit.runner.JUnitCore numberrangesummarizer.NumberRangeSummarizerImplementationTest
    ```

> **Note:**  
> Make sure you have `junit-4.13.2.jar` and `hamcrest-core-1.3.jar` in your `libs` folder.

## Author

- Joseph Duda

## License

This code is provided for assessment and educational purposes.


