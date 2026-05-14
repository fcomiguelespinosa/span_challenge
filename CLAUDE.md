# Project: Football standing table calculator
This is a command-line application that calculates a football league standing table.
It uses CSV format for input and output.
Calculation rules for the standing table are those used by the English First Division League season 1974/75.
Java 21 application using JUnit 5.0 for testing, OpenCSV and Maven.
It must be OS agnostic

## Build & Run Commands
- Build project: `mvn package`
- Run all tests: `mvn test`
- Check code style: `mvn checkstyle:check`

## Project Architecture
- `src/main/java`: Application source code
- `src/test/java`: Unit and integration tests

## Code Conventions
- **Naming**: Use camelCase for methods/variables; PascalCase for classes.
- **Error Handling**: No silent error handling; use global `@ControllerAdvice.
- **Documentation**: Use Javadoc.

## Quality Bar
- New features must include unit tests.
- Maintain 80% test coverage.
- Ensure no circular dependencies between packages.