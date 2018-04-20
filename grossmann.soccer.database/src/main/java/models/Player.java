package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "t_player", schema = "soccer", catalog = "")
public class Player {
    private Integer trikotNr;
    private String name;
    private Date birthDate;
    private Integer minutes;
    private Integer goals;
    private Integer yellowCards;
    private Integer yellowRedCards;
    private Integer redCards;
    private int id;
    private Team team;

    public Player() {
    }

    @Basic
    @Column(name = "TrikotNr")
    public Integer getTrikotNr() {
        return trikotNr;
    }

    public void setTrikotNr(Integer trikotNr) {
        this.trikotNr = trikotNr;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "BirthDate")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "Minutes")
    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    @Basic
    @Column(name = "Goals")
    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    @Basic
    @Column(name = "YellowCards")
    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    @Basic
    @Column(name = "YellowRedCards")
    public Integer getYellowRedCards() {
        return yellowRedCards;
    }

    public void setYellowRedCards(Integer yellowRedCards) {
        this.yellowRedCards = yellowRedCards;
    }

    @Basic
    @Column(name = "RedCards")
    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id &&
                Objects.equals(trikotNr, player.trikotNr) &&
                Objects.equals(name, player.name) &&
                Objects.equals(birthDate, player.birthDate) &&
                Objects.equals(minutes, player.minutes) &&
                Objects.equals(goals, player.goals) &&
                Objects.equals(yellowCards, player.yellowCards) &&
                Objects.equals(yellowRedCards, player.yellowRedCards) &&
                Objects.equals(redCards, player.redCards);
    }

    @Override
    public int hashCode() {

        return Objects.hash(trikotNr, name, birthDate, minutes, goals, yellowCards, yellowRedCards, redCards, id);
    }

    @ManyToOne
    @JoinColumn(name = "TeamID", referencedColumnName = "TeamID")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
