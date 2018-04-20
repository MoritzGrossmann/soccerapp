package models;

import javax.persistence.*;

@Entity
@Table(name = "t_league", schema = "soccer", catalog = "")
public class League {
    private int leagueId;
    private String leagueName;

    @Id
    @Column(name = "LeagueID")
    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    @Basic
    @Column(name = "LeagueName")
    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        League league = (League) o;

        if (leagueId != league.leagueId) return false;
        if (leagueName != null ? !leagueName.equals(league.leagueName) : league.leagueName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leagueId;
        result = 31 * result + (leagueName != null ? leagueName.hashCode() : 0);
        return result;
    }

    public League(int leagueId, String leagueName) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
    }
}