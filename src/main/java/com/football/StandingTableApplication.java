package com.football;

import com.football.service.StandingTableService;
import com.football.model.Match;
import com.football.model.Standing;
import java.io.IOException;
import java.util.List;

/**
 * Main entry point for the Football Standing Table Calculator application.
 * Processes CSV input and outputs standing table calculations based on 1974/75 rules.
 */
public class StandingTableApplication {
    private static final StandingTableService service = new StandingTableService();

    /**
     * Main method to start the application.
     *
     * @param args command line arguments (input CSV file path, output CSV file path)
     */
    public static void main(final String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar standing-table-calculator.jar <input.csv> <output.csv>");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            List<Match> matches = service.readMatches(inputFile);
            List<Standing> standings = service.calculateStandings(matches);
            service.writeStandings(standings, outputFile);
            System.out.println("Standing table calculated successfully. Output: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            System.exit(1);
        }
    }
}
