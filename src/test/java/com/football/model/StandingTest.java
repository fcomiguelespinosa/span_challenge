package com.football.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Standing class.
 */
class StandingTest {
    private Standing standing;

    @BeforeEach
    void setUp() {
        standing = new Standing("Test Team");
    }

    @Test
    void testConstructor() {
        assertEquals("Test Team", standing.getTeamName());
        assertEquals(0, standing.getPlayed());
        assertEquals(0, standing.getPoints());
    }

    @Test
    void testAddWin() {
        standing.addWin(2, 1);
        assertEquals(1, standing.getPlayed());
        assertEquals(1, standing.getWon());
        assertEquals(2, standing.getPoints());
        assertEquals(2, standing.getGoalsFor());
        assertEquals(1, standing.getGoalsAgainst());
    }

    @Test
    void testAddDraw() {
        standing.addDraw(1, 1);
        assertEquals(1, standing.getPlayed());
        assertEquals(1, standing.getDrawn());
        assertEquals(1, standing.getPoints());
        assertEquals(1, standing.getGoalsFor());
        assertEquals(1, standing.getGoalsAgainst());
    }

    @Test
    void testAddLoss() {
        standing.addLoss(0, 2);
        assertEquals(1, standing.getPlayed());
        assertEquals(1, standing.getLost());
        assertEquals(0, standing.getPoints());
        assertEquals(0, standing.getGoalsFor());
        assertEquals(2, standing.getGoalsAgainst());
    }

    @Test
    void testGoalAverage() {
        standing.addWin(3, 1);
        standing.addWin(2, 1);
        assertEquals(2.5, standing.getGoalAverage(), 0.01);
    }

    @Test
    void testCompareByPoints() {
        Standing team1 = new Standing("Team 1");
        Standing team2 = new Standing("Team 2");
        team1.addWin(1, 0);
        team2.addDraw(0, 0);
        assertTrue(team1.compareTo(team2) < 0);
    }

    @Test
    void testCompareByGoalAverageNotDifference() {
        Standing team1 = new Standing("Team 1");
        Standing team2 = new Standing("Team 2");
        team1.addWin(4, 2);
        team2.addWin(8, 5);

        assertEquals(2.0, team1.getGoalAverage(), 0.01);
        assertEquals(1.6, team2.getGoalAverage(), 0.01);

        assertTrue(team1.compareTo(team2) < 0);
    }
}
