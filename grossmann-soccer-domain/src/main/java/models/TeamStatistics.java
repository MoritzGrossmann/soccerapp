package models;

public class TeamStatistics {

    private int goals = 0;

    private int goalsAgainst = 0;

    private int victories = 0;

    private int draws = 0;

    private int looses = 0;

    public int getPoints() {
        return victories * 3 + draws;
    }

    public int getMatches() {
        return victories + draws + looses;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getVictories() {
        return victories;
    }

    public int getDraws() {
        return draws;
    }

    public int getLooses() {
        return looses;
    }

    public void addGoals(int value) {
        this.goals += value;
    }

    public void addGoalsAgainst(int value) {
        this.goalsAgainst += value;
    }

    public void addVictory() {
        this.victories++;
    }

    public void addDraw() {
        this.draws++;
    }

    public void addLooses() {
        this.looses++;
    }
}