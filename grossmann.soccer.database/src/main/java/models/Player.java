package models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_player", schema = "soccer", catalog = "")
public class Player {
    private Integer teamId;
    private Integer trikotNr;
    private String name;
    private Date birthDate;
    private Integer minutes;
    private Integer goals;
    private Integer yellowCards;
    private Integer yellowRedCards;
    private Integer redCards;
    private Team tTeamByTeamId;

    @Basic
    @Column(name = "TeamID")
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (teamId != null ? !teamId.equals(player.teamId) : player.teamId != null) return false;
        if (trikotNr != null ? !trikotNr.equals(player.trikotNr) : player.trikotNr != null) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (birthDate != null ? !birthDate.equals(player.birthDate) : player.birthDate != null) return false;
        if (minutes != null ? !minutes.equals(player.minutes) : player.minutes != null) return false;
        if (goals != null ? !goals.equals(player.goals) : player.goals != null) return false;
        if (yellowCards != null ? !yellowCards.equals(player.yellowCards) : player.yellowCards != null) return false;
        if (yellowRedCards != null ? !yellowRedCards.equals(player.yellowRedCards) : player.yellowRedCards != null)
            return false;
        if (redCards != null ? !redCards.equals(player.redCards) : player.redCards != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId != null ? teamId.hashCode() : 0;
        result = 31 * result + (trikotNr != null ? trikotNr.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (minutes != null ? minutes.hashCode() : 0);
        result = 31 * result + (goals != null ? goals.hashCode() : 0);
        result = 31 * result + (yellowCards != null ? yellowCards.hashCode() : 0);
        result = 31 * result + (yellowRedCards != null ? yellowRedCards.hashCode() : 0);
        result = 31 * result + (redCards != null ? redCards.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TeamID", referencedColumnName = "TeamID")
    public Team gettTeamByTeamId() {
        return tTeamByTeamId;
    }

    public void settTeamByTeamId(Team tTeamByTeamId) {
        this.tTeamByTeamId = tTeamByTeamId;
    }
}
