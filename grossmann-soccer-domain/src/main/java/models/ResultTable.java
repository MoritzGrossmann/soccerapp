package models;

import java.util.*;

public class ResultTable {

    public ResultTable(Collection<Match> matches) {

        Map<Team, TeamStatistics> stats = new HashMap<>();

        this.rows = new ArrayList<>();

        matches.forEach(match -> {
            if (!stats.containsKey(match.getTeam1())) {
                stats.put(match.getTeam1(), new TeamStatistics());
            }
        });


        matches.forEach(match -> {
            try {
                MatchResult result = new ArrayList<>(match.getResults()).get(match.getResults().size() - 1);
                stats.get(match.getTeam1()).addGoals(result.getPointsTeam1());
                stats.get(match.getTeam2()).addGoalsAgainst(result.getPointsTeam1());
                stats.get(match.getTeam2()).addGoals(result.getPointsTeam2());
                stats.get(match.getTeam1()).addGoalsAgainst(result.getPointsTeam2());

                if (result.getPointsTeam1() > result.getPointsTeam2()) {
                    stats.get(match.getTeam1()).addVictory();
                    stats.get(match.getTeam2()).addLooses();
                } else if (result.getPointsTeam1() == result.getPointsTeam2()) {
                    stats.get(match.getTeam1()).addDraw();
                    stats.get(match.getTeam2()).addDraw();
                } else {
                    stats.get(match.getTeam1()).addLooses();
                    stats.get(match.getTeam2()).addVictory();
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        });

        stats.forEach((team, statistics) -> this.rows.add(
                new TableRow(
                        team,
                        statistics.getGoals(),
                        statistics.getGoalsAgainst(),
                        statistics.getVictories(),
                        statistics.getDraws(),
                        statistics.getLooses(),
                        statistics.getPoints(),
                        statistics.getMatches()
                )
        ));
    }

    private List<TableRow> rows;

    public List<TableRow> getRows() {
        Collections.sort(this.rows);
        Collections.reverse(this.rows);
        return rows;
    }
}

