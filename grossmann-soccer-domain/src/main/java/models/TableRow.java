package models;

public class TableRow implements Comparable<TableRow> {

    public TableRow(Team team, int goals, int goalsAgainst, int victories, int draws, int looses, int points, int matches) {
        this.team = team;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.victories = victories;
        this.draws = draws;
        this.looses = looses;
        this.points = points;
        this.matches =matches;
    }

    private Team team;

    private int goals;

    private int goalsAgainst;

    private int victories;

    private int draws;

    private int looses;

    private int points;

    int matches;

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLooses() {
        return looses;
    }

    public void setLooses(int looses) {
        this.looses = looses;
    }

    public int getGoalDifference() {
        return this.goals - this.goalsAgainst;
    }

    @Override
    public int compareTo(TableRow o) {
        if (this.points == o.points) {
            if (this.getGoalDifference() == o.getGoalDifference()) {
                return this.goals - o.goals;
            } else {
                return this.getGoalDifference() - o.getGoalDifference();
            }
        } else {
            return this.points - o.points;
        }
    }
}
