package com.football.model;

/**
 * Represents a match result in the league.
 */
public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;

    /**
     * Constructor for Match.
     *
     * @param homeTeam home team name
     * @param awayTeam away team name
     * @param homeGoals goals scored by home team
     * @param awayGoals goals scored by away team
     */
    public Match(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }
}
