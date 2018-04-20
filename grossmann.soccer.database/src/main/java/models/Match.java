package models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_match", schema = "soccer", catalog = "")
public class Match {
    private int matchId;
    private Date lastUpdateTime;
    private Date matchDateTime;
    private Date matchDateTimeUtc;
    private byte matchIsFinished;
    private int numberOfViewers;
    private String timeZoneId;
    private League tLeagueByLeagueId;
    private Location tLocationByLocationId;
    private Group tGroupByGroupId;
    private Team tTeam1ByTeam1Id;
    private Team tTeam2ByTeam2Id;

    @Id
    @Column(name = "MatchID")
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Basic
    @Column(name = "LastUpdateTime")
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Basic
    @Column(name = "MatchDateTime")
    public Date getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(Date matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    @Basic
    @Column(name = "MatchDateTimeUTC")
    public Date getMatchDateTimeUtc() {
        return matchDateTimeUtc;
    }

    public void setMatchDateTimeUtc(Date matchDateTimeUtc) {
        this.matchDateTimeUtc = matchDateTimeUtc;
    }

    @Basic
    @Column(name = "MatchIsFinished")
    public byte getMatchIsFinished() {
        return matchIsFinished;
    }

    public void setMatchIsFinished(byte matchIsFinished) {
        this.matchIsFinished = matchIsFinished;
    }

    @Basic
    @Column(name = "NumberOfViewers")
    public int getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(int numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }

    @Basic
    @Column(name = "TimeZoneID")
    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (matchId != match.matchId) return false;
        if (matchIsFinished != match.matchIsFinished) return false;
        if (numberOfViewers != match.numberOfViewers) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(match.lastUpdateTime) : match.lastUpdateTime != null)
            return false;
        if (matchDateTime != null ? !matchDateTime.equals(match.matchDateTime) : match.matchDateTime != null)
            return false;
        if (matchDateTimeUtc != null ? !matchDateTimeUtc.equals(match.matchDateTimeUtc) : match.matchDateTimeUtc != null)
            return false;
        if (timeZoneId != null ? !timeZoneId.equals(match.timeZoneId) : match.timeZoneId != null) return false;
        if (tTeam1ByTeam1Id != null ? !tTeam1ByTeam1Id.equals(match.tTeam1ByTeam1Id) : match.tTeam1ByTeam1Id != null) return false;
        if (tTeam2ByTeam2Id != null ? !tTeam2ByTeam2Id.equals(match.tTeam2ByTeam2Id) : match.tTeam2ByTeam2Id != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = matchId;
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (matchDateTime != null ? matchDateTime.hashCode() : 0);
        result = 31 * result + (matchDateTimeUtc != null ? matchDateTimeUtc.hashCode() : 0);
        result = 31 * result + (int) matchIsFinished;
        result = 31 * result + numberOfViewers;
        result = 31 * result + (timeZoneId != null ? timeZoneId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LeagueID", referencedColumnName = "LeagueID", nullable = false)
    public League gettLeagueByLeagueId() {
        return tLeagueByLeagueId;
    }

    public void settLeagueByLeagueId(League tLeagueByLeagueId) {
        this.tLeagueByLeagueId = tLeagueByLeagueId;
    }

    @ManyToOne
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationiD")
    public Location gettLocationByLocationId() {
        return tLocationByLocationId;
    }

    public void settLocationByLocationId(Location tLocationByLocationId) {
        this.tLocationByLocationId = tLocationByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
    public Group gettGroupByGroupId() {
        return tGroupByGroupId;
    }

    public void settGroupByGroupId(Group tGroupByGroupId) {
        this.tGroupByGroupId = tGroupByGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "Team1ID", referencedColumnName = "TeamID")
    public Team gettTeam1ByTeam1Id() {
        return tTeam1ByTeam1Id;
    }

    public void settTeam1ByTeam1Id(Team tTeam1ByTeam1Id) {
        this.tTeam1ByTeam1Id = tTeam1ByTeam1Id;
    }

    @ManyToOne
    @JoinColumn(name = "Team2ID", referencedColumnName = "TeamID")
    public Team gettTeam2ByTeam2Id() {
        return tTeam2ByTeam2Id;
    }

    public void settTeam2ByTeam2Id(Team tTeam2ByTeam2Id) {
        this.tTeam2ByTeam2Id = tTeam2ByTeam2Id;
    }
}
