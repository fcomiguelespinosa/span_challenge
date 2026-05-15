# AI Reflection

The generated template was really good. The classes and project structure worked well. However, I did encounter a few small issues:

- The `StandingTableService` was missing the `throws IOException` declaration, so I had to add it manually.
- The logic to skip the header in the CSV file was missing, even though the generated `sample_matches.csv` included a header.

Once I fixed these two issues, I was able to compile the project and run all the tests successfully.

I also asked Claude to generate a CSV file with the match results for rounds 1–10 of the 1974/75 Premier League season. Unfortunately, that task failed — the values were not accurate at all. It was essentially just mock data. Seems like the issue was caused by my misconception regarding the name change from First Division League to Premier League cause and using the word 'generate' instead of 'get'. 

Finally, I reviewed the code and made a few small changes to better match the expected results. For example, I asked to remove the full quoting from the file and change the standing from goal difference to goal average((goals scored/goals conceded)).

Even if the 80% coverage was described in the CLAUDE.md it was lower around 57% so I added additional test cases.