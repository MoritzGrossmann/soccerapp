package models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "t_team", schema = "soccer", catalog = "")
public class Team {
    private String shortName;
    private String teamIconUrl;
    private int teamId;
    private String teamName;
    private Collection<Match> tMatchesByTeamId;
    private Collection<Match> tMatchesByTeamId_0;
    private Collection<Player> tPlayersByTeamId;

    public Team(int teamId, String shortName, String teamIconUrl,  String teamName) {
        this.shortName = shortName;
        this.teamIconUrl = teamIconUrl;
        this.teamId = teamId;
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
    public String getTeamIconUrl() {
        return teamIconUrl;
    }

    public void setTeamIconUrl(String teamIconUrl) {
        this.teamIconUrl = teamIconUrl;
    }

    @Id
    @Column(name = "TeamID")
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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

        if (teamId != team.teamId) return false;
        if (shortName != null ? !shortName.equals(team.shortName) : team.shortName != null) return false;
        if (teamIconUrl != null ? !teamIconUrl.equals(team.teamIconUrl) : team.teamIconUrl != null) return false;
        if (teamName != null ? !teamName.equals(team.teamName) : team.teamName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shortName != null ? shortName.hashCode() : 0;
        result = 31 * result + (teamIconUrl != null ? teamIconUrl.hashCode() : 0);
        result = 31 * result + teamId;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tTeamByTeam1Id")
    public Collection<Match> gettMatchesByTeamId() {
        return tMatchesByTeamId;
    }

    public void settMatchesByTeamId(Collection<Match> tMatchesByTeamId) {
        this.tMatchesByTeamId = tMatchesByTeamId;
    }

    @OneToMany(mappedBy = "tTeamByTeam2Id")
    public Collection<Match> gettMatchesByTeamId_0() {
        return tMatchesByTeamId_0;
    }

    public void settMatchesByTeamId_0(Collection<Match> tMatchesByTeamId_0) {
        this.tMatchesByTeamId_0 = tMatchesByTeamId_0;
    }

    @OneToMany(mappedBy = "tTeamByTeamId")
    public Collection<Player> gettPlayersByTeamId() {
        return tPlayersByTeamId;
    }

    public void settPlayersByTeamId(Collection<Player> tPlayersByTeamId) {
        this.tPlayersByTeamId = tPlayersByTeamId;
    }
}
