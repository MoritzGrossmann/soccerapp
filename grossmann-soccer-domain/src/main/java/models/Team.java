package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_team", schema = "soccer")
public class Team {
    private String shortName;
    private String iconUrl;
    private int id;
    private String teamName;
    private Collection<Match> matchesTeam1;
    private Collection<Match> matchesTeam2;
    private Collection<Player> players;

    public Team(int teamId) {
        this.id = teamId;
    }

    public Team(int id,String shortName, String iconUrl,  String teamName) {
        this.shortName = shortName;
        this.iconUrl = iconUrl;
        this.id = id;
        this.teamName = teamName;
    }

    public Team() {
    }

    @Basic
    @Column(name = "ShortName")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "TeamIconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Id
    @Column(name = "TeamID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TeamName")
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                Objects.equals(shortName, team.shortName) &&
                Objects.equals(iconUrl, team.iconUrl) &&
                Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shortName, iconUrl, id, teamName);
    }

    @OneToMany(mappedBy = "team1")
    public Collection<Match> getMatchesTeam1() {
        return matchesTeam1;
    }

    public void setMatchesTeam1(Collection<Match> matchesTeam1) {
        this.matchesTeam1 = matchesTeam1;
    }

    @OneToMany(mappedBy = "team2")
    public Collection<Match> getMatchesTeam2() {
        return matchesTeam2;
    }

    public void setMatchesTeam2(Collection<Match> matchesTeam2) {
        this.matchesTeam2 = matchesTeam2;
    }

    @OneToMany(mappedBy = "team")
    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return String.format("Team: %s\nIconUrl: %s\nKurzname: %s", this.getTeamName(), this.getIconUrl(), this.getShortName());
    }
}
