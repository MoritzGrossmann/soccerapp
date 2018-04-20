package models;

import javax.persistence.*;

@Entity
@Table(name = "t_goal", schema = "soccer", catalog = "")
public class Goal {
    private int goalGetterId;
    private String goalGetterName;
    private int goalId;
    private byte isOverTime;
    private byte isOwnGoal;
    private byte isPenalty;
    private int matchMinute;
    private int scoreTeam1;
    private int scoreTeam2;
    private String comment;
    private Match tMatchByMatchId;

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
    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    @Basic
    @Column(name = "IsOverTime")
    public byte getIsOverTime() {
        return isOverTime;
    }

    public void setIsOverTime(byte isOverTime) {
        this.isOverTime = isOverTime;
    }

    @Basic
    @Column(name = "IsOwnGoal")
    public byte getIsOwnGoal() {
        return isOwnGoal;
    }

    public void setIsOwnGoal(byte isOwnGoal) {
        this.isOwnGoal = isOwnGoal;
    }

    @Basic
    @Column(name = "IsPenalty")
    public byte getIsPenalty() {
        return isPenalty;
    }

    public void setIsPenalty(byte isPenalty) {
        this.isPenalty = isPenalty;
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

        if (goalGetterId != goal.goalGetterId) return false;
        if (goalId != goal.goalId) return false;
        if (isOverTime != goal.isOverTime) return false;
        if (isOwnGoal != goal.isOwnGoal) return false;
        if (isPenalty != goal.isPenalty) return false;
        if (matchMinute != goal.matchMinute) return false;
        if (scoreTeam1 != goal.scoreTeam1) return false;
        if (scoreTeam2 != goal.scoreTeam2) return false;
        if (goalGetterName != null ? !goalGetterName.equals(goal.goalGetterName) : goal.goalGetterName != null)
            return false;
        if (comment != null ? !comment.equals(goal.comment) : goal.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goalGetterId;
        result = 31 * result + (goalGetterName != null ? goalGetterName.hashCode() : 0);
        result = 31 * result + goalId;
        result = 31 * result + (int) isOverTime;
        result = 31 * result + (int) isOwnGoal;
        result = 31 * result + (int) isPenalty;
        result = 31 * result + matchMinute;
        result = 31 * result + scoreTeam1;
        result = 31 * result + scoreTeam2;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MatchID", referencedColumnName = "MatchID", nullable = false)
    public Match gettMatchByMatchId() {
        return tMatchByMatchId;
    }

    public void settMatchByMatchId(Match tMatchByMatchId) {
        this.tMatchByMatchId = tMatchByMatchId;
    }
}
