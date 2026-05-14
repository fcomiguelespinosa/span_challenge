package com.football.service;

import com.football.model.Match;
import com.football.model.Standing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the StandingTableService class.
 */
class StandingTableServiceTest {
    private StandingTableService service;

    @BeforeEach
    void setUp() {
        service = new StandingTableService();
    }

    @Test
    void testCalculateStandingsWithWinDrawLoss() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("Team A", "Team B", 2, 1));
        matches.add(new Match("Team A", "Team C", 1, 1));
        matches.add(new Match("Team B", "Team C", 0, 3));

        List<Standing> standings = service.calculateStandings(matches);

        assertEquals(3, standings.size());
        assertEquals("Team C", standings.get(0).getTeamName());
        assertEquals(3, standings.get(0).getPoints());
    }

    @Test
    void testCalculateStandingsSorting() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("Team A", "Team B", 1, 0));
        matches.add(new Match("Team B", "Team C", 2, 0));

        List<Standing> standings = service.calculateStandings(matches);

        assertEquals("Team B", standings.get(0).getTeamName());
        assertEquals("Team A", standings.get(1).getTeamName());
        assertEquals("Team C", standings.get(2).getTeamName());
    }

    @Test
    void testCalculateStandingsEmpty() {
        List<Match> matches = new ArrayList<>();
        List<Standing> standings = service.calculateStandings(matches);
        assertTrue(standings.isEmpty());
    }

    @Test
    void testCalculateStandingsMatchStats() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("Team A", "Team B", 3, 1));

        List<Standing> standings = service.calculateStandings(matches);

        Standing teamA = standings.stream()
                .filter(s -> s.getTeamName().equals("Team A"))
                .findFirst()
                .orElse(null);

        assertNotNull(teamA);
        assertEquals(1, teamA.getPlayed());
        assertEquals(1, teamA.getWon());
        assertEquals(3, teamA.getGoalsFor());
        assertEquals(1, teamA.getGoalsAgainst());
    }
}
