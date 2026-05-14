package com.football.service;

import com.football.model.Match;
import com.football.model.Standing;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for calculating football standing tables.
 * Uses English First Division League 1974/75 rules: 2 points for win, 1 point for draw, 0 for loss.
 */
public class StandingTableService {

    /**
     * Reads match results from a CSV file.
     * Expected format: HomeTeam,AwayTeam,HomeGoals,AwayGoals
     *
     * @param filePath path to the input CSV file
     * @return list of Match objects
     * @throws IOException if file cannot be read
     */
    public List<Match> readMatches(String filePath) throws IOException {
        List<Match> matches = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length >= 4) {
                    String homeTeam = line[0];
                    String awayTeam = line[1];
                    int homeGoals = Integer.parseInt(line[2]);
                    int awayGoals = Integer.parseInt(line[3]);
                    matches.add(new Match(homeTeam, awayTeam, homeGoals, awayGoals));
                }
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return matches;
    }

    /**
     * Calculates the standing table from match results.
     *
     * @param matches list of matches to process
     * @return sorted list of Standing objects
     */
    public List<Standing> calculateStandings(List<Match> matches) {
        Map<String, Standing> standings = new HashMap<>();

        for (Match match : matches) {
            Standing homeStanding = standings.computeIfAbsent(match.getHomeTeam(), Standing::new);
            Standing awayStanding = standings.computeIfAbsent(match.getAwayTeam(), Standing::new);

            if (match.getHomeGoals() > match.getAwayGoals()) {
                homeStanding.addWin(match.getHomeGoals(), match.getAwayGoals());
                awayStanding.addLoss(match.getAwayGoals(), match.getHomeGoals());
            } else if (match.getHomeGoals() < match.getAwayGoals()) {
                homeStanding.addLoss(match.getHomeGoals(), match.getAwayGoals());
                awayStanding.addWin(match.getAwayGoals(), match.getHomeGoals());
            } else {
                homeStanding.addDraw(match.getHomeGoals(), match.getAwayGoals());
                awayStanding.addDraw(match.getAwayGoals(), match.getHomeGoals());
            }
        }

        List<Standing> result = new ArrayList<>(standings.values());
        Collections.sort(result);
        return result;
    }

    /**
     * Writes standings to a CSV file.
     * Output format: Position,Team,Played,Won,Drawn,Lost,GoalsFor,GoalsAgainst,GoalDifference,Points
     *
     * @param standings list of Standing objects to write
     * @param filePath path to the output CSV file
     * @throws IOException if file cannot be written
     */
    public void writeStandings(List<Standing> standings, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"Position", "Team", "Played", "Won", "Drawn", "Lost",
                    "GoalsFor", "GoalsAgainst", "GoalDifference", "Points"});

            int position = 1;
            for (Standing standing : standings) {
                writer.writeNext(new String[]{
                        String.valueOf(position++),
                        standing.getTeamName(),
                        String.valueOf(standing.getPlayed()),
                        String.valueOf(standing.getWon()),
                        String.valueOf(standing.getDrawn()),
                        String.valueOf(standing.getLost()),
                        String.valueOf(standing.getGoalsFor()),
                        String.valueOf(standing.getGoalsAgainst()),
                        String.valueOf(standing.getGoalDifference()),
                        String.valueOf(standing.getPoints())
                });
            }
        }
    }
}
