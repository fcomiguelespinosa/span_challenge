# AI Reflection

The generated template was solid. The class and project structure worked well overall, though I encountered a few minor issues:

- The `StandingTableService` was missing the throws `IOException` declaration, so I had to add that manually.

- The logic to skip the CSV header was absent, even though the generated `sample_matches.csv` file included one.

After addressing these two issues, I was able to compile the project and run all tests successfully.

I also asked Claude to generate a CSV file with match results for rounds 1–10 of the 1974/75 Premier League season. Initially, this task failed — the values were completely inaccurate and essentially just mock data. The problem stemmed from my own misconception: I hadn't accounted for the fact that the competition was still called the First Division in 1974/75, as the Premier League name came later. Additionally, using the word "generate" instead of "get" led Claude to produce fabricated data. Once I rewrote the prompt with the correct terminology, I was able to retrieve the actual data I needed.

Finally, I reviewed the code and made a few small adjustments to better align with the expected results. For example, I requested that full quoting be removed from the file, and I changed the standings logic from goal difference to goal average (goals scored divided by goals conceded).

Regarding test coverage: although CLAUDE.md indicated an 80% coverage target, the actual coverage was around 57%. To address this, I added several additional test cases to bring coverage closer to the desired level.
