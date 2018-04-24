package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_goal", schema = "soccer")
public class Goal {
    private int goalGetterId;
    private String goalGetterName;
    private int id;
    private boolean isOverTime;
    private boolean isOwnGoal;
    private boolean isPenalty;
    private int matchMinute;
    private int scoreTeam1;
    private int scoreTeam2;
    private String comment;
    private Match match;

    public Goal() {
    }

    @Basic
    @Column(name = "GoalGetterID")
    public int getGoalGetterId() {
        return goalGetterId;
    }

    public void setGoalGetterId(int goalGetterId) {
        this.goalGetterId = goalGetterId;
    }

    @Basic
    @Column(name = "GoalGetterName")
    public String getGoalGetterName() {
        return goalGetterName;
    }

    public void setGoalGetterName(String goalGetterName) {
        this.goalGetterName = goalGetterName;
    }

    @Id
    @Column(name = "GoalID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IsOverTime")
    public boolean isOverTime() {
        return isOverTime;
    }

    public void setOverTime(boolean overTime) {
        isOverTime = overTime;
    }

    @Basic
    @Column(name = "IsOwnGoal")
    public boolean isOwnGoal() {
        return isOwnGoal;
    }

    public void setOwnGoal(boolean ownGoal) {
        isOwnGoal = ownGoal;
    }

    @Basic
    @Column(name = "IsPenalty")
    public boolean isPenalty() {
        return isPenalty;
    }

    public void setPenalty(boolean penalty) {
        isPenalty = penalty;
    }

    @Basic
    @Column(name = "MatchMinute")
    public int getMatchMinute() {
        return matchMinute;
    }

    public void setMatchMinute(int matchMinute) {
        this.matchMinute = matchMinute;
    }

    @Basic
    @Column(name = "ScoreTeam1")
    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    @Basic
    @Column(name = "ScoreTeam2")
    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    @Basic
    @Column(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return goalGetterId == goal.goalGetterId &&
                id == goal.id &&
                isOverTime == goal.isOverTime &&
                isOwnGoal == goal.isOwnGoal &&
                isPenalty == goal.isPenalty &&
                matchMinute == goal.matchMinute &&
                scoreTeam1 == goal.scoreTeam1 &&
                scoreTeam2 == goal.scoreTeam2 &&
                Objects.equals(goalGetterName, goal.goalGetterName) &&
                Objects.equals(comment, goal.comment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goalGetterId, goalGetterName, id, isOverTime, isOwnGoal, isPenalty, matchMinute, scoreTeam1, scoreTeam2, comment);
    }

    @ManyToOne
    @JoinColumn(name = "MatchID", referencedColumnName = "MatchID", nullable = false)
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
