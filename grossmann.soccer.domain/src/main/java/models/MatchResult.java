package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_match_result", schema = "soccer")
public class MatchResult {
    private int pointsTeam1;
    private int pointsTeam2;
    private String description;
    private int id;
    private String name;
    private int orderId;
    private int typeId;
    private Match match;

    public MatchResult() {
    }

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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "ResultID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ResultName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ResultOrderID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "ResultTypeID")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return pointsTeam1 == that.pointsTeam1 &&
                pointsTeam2 == that.pointsTeam2 &&
                id == that.id &&
                orderId == that.orderId &&
                typeId == that.typeId &&
                Objects.equals(description, that.description) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pointsTeam1, pointsTeam2, description, id, name, orderId, typeId);
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
