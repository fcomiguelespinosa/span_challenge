# Football Standing Table Calculator

A command-line Java application that calculates football league standing tables using English First Division League 1974/75 rules (2 points for win, 1 point for draw, 0 for loss).

## Requirements

- Java 21 or higher
- Maven 3.6 or higher

## Building the Project

```bash
mvn clean package
```

This command will:
- Compile the source code
- Run all tests (JUnit 5)
- Run code style checks (Checkstyle)
- Generate code coverage reports (JaCoCo)
- Build an executable JAR file

## Running the Application

```bash
java -jar target/standing-table-calculator-1.0.0.jar <input.csv> <output.csv>
```

### Input CSV Format

The input file should contain match results with the following format:

```
HomeTeam,AwayTeam,HomeGoals,AwayGoals
Arsenal,Liverpool,2,1
Manchester United,Everton,1,1
```

### Output CSV Format

The output file will contain the final standings:

```
Position,Team,Played,Won,Drawn,Lost,GoalsFor,GoalsAgainst,GoalAverage,Points
1,Manchester United,20,15,3,2,42,10,4.20,33
2,Arsenal,20,14,2,4,51,20,2.55,30
```

## Running Tests

```bash
mvn test
```

## Code Quality Checks

```bash
mvn checkstyle:check
```

## Project Structure

```
├── src/
│   ├── main/java/
│   │   └── com/football/
│   │       ├── StandingTableApplication.java (main entry point)
│   │       ├── model/
│   │       │   ├── Match.java
│   │       │   └── Standing.java
│   │       └── service/
│   │           └── StandingTableService.java
│   └── test/java/
│       └── com/football/
│           ├── model/
│           │   └── StandingTest.java
│           └── service/
│               └── StandingTableServiceTest.java
├── pom.xml
├── checkstyle.xml
└── README.md
```

## Dependencies

- **OpenCSV 5.9**: For CSV file handling
- **JUnit 5.10.1**: For unit testing
- **JaCoCo**: For code coverage analysis

## Scoring Rules (1974/75)

- Win: 2 points
- Draw: 1 point
- Loss: 0 points

Standings are sorted by:
1. Points (descending)
2. Goal average (descending) - calculated as goalsFor/goalsAgainst
3. Goals for (descending)

## Notes

- The application is OS agnostic (works on Windows, macOS, Linux)
- Data results extracted from https://www.worldfootball.net/