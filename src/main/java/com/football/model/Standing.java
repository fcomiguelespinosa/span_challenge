package com.football.model;

/**
 * Represents a team's position in the standing table.
 */
public class Standing implements Comparable<Standing> {
    private String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    /**
     * Constructor for Standing.
     *
     * @param teamName team name
     */
    public Standing(String teamName) {
        this.teamName = teamName;
        this.played = 0;
        this.won = 0;
        this.drawn = 0;
        this.lost = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.points = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLost() {
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void addWin(int goalsFor, int goalsAgainst) {
        this.played++;
        this.won++;
        this.points += 2;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }

    public void addDraw(int goalsFor, int goalsAgainst) {
        this.played++;
        this.drawn++;
        this.points += 1;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }

    public void addLoss(int goalsFor, int goalsAgainst) {
        this.played++;
        this.lost++;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }

    @Override
    public int compareTo(Standing other) {
        if (this.points != other.points) {
            return other.points - this.points;
        }
        int thisGoalDiff = this.getGoalDifference();
        int otherGoalDiff = other.getGoalDifference();
        if (thisGoalDiff != otherGoalDiff) {
            return otherGoalDiff - thisGoalDiff;
        }
        return other.goalsFor - this.goalsFor;
    }
}
