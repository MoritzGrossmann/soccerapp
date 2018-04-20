package models;

import javax.persistence.*;

@Entity
@Table(name = "t_match_result", schema = "soccer", catalog = "")
public class MatchResult {
    private int pointsTeam1;
    private int pointsTeam2;
    private String resultDescription;
    private int resultId;
    private String resultName;
    private int resultOrderId;
    private int resultTypeId;
    private Match tMatchByMatchId;

    @Basic
    @Column(name = "PointsTeam1")
    public int getPointsTeam1() {
        return pointsTeam1;
    }

    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    @Basic
    @Column(name = "PointsTeam2")
    public int getPointsTeam2() {
        return pointsTeam2;
    }

    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    @Basic
    @Column(name = "ResultDescription")
    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    @Id
    @Column(name = "ResultID")
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    @Basic
    @Column(name = "ResultName")
    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    @Basic
    @Column(name = "ResultOrderID")
    public int getResultOrderId() {
        return resultOrderId;
    }

    public void setResultOrderId(int resultOrderId) {
        this.resultOrderId = resultOrderId;
    }

    @Basic
    @Column(name = "ResultTypeID")
    public int getResultTypeId() {
        return resultTypeId;
    }

    public void setResultTypeId(int resultTypeId) {
        this.resultTypeId = resultTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchResult that = (MatchResult) o;

        if (pointsTeam1 != that.pointsTeam1) return false;
        if (pointsTeam2 != that.pointsTeam2) return false;
        if (resultId != that.resultId) return false;
        if (resultOrderId != that.resultOrderId) return false;
        if (resultTypeId != that.resultTypeId) return false;
        if (resultDescription != null ? !resultDescription.equals(that.resultDescription) : that.resultDescription != null)
            return false;
        if (resultName != null ? !resultName.equals(that.resultName) : that.resultName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pointsTeam1;
        result = 31 * result + pointsTeam2;
        result = 31 * result + (resultDescription != null ? resultDescription.hashCode() : 0);
        result = 31 * result + resultId;
        result = 31 * result + (resultName != null ? resultName.hashCode() : 0);
        result = 31 * result + resultOrderId;
        result = 31 * result + resultTypeId;
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
