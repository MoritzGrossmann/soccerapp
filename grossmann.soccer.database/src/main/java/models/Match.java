package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

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
    private Collection<Goal> tGoalsByMatchId;
    private League tLeagueByLeagueId;
    private Location tLocationByLocationId;
    private Team tTeamByTeam1Id;
    private Team tTeamByTeam2Id;
    private Group tGroupByGroupId;
    private Collection<MatchResult> tMatchResultsByMatchId;

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

    @OneToMany(mappedBy = "tMatchByMatchId")
    public Collection<Goal> gettGoalsByMatchId() {
        return tGoalsByMatchId;
    }

    public void settGoalsByMatchId(Collection<Goal> tGoalsByMatchId) {
        this.tGoalsByMatchId = tGoalsByMatchId;
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
    @JoinColumn(name = "Team1ID", referencedColumnName = "TeamID", nullable = false)
    public Team gettTeamByTeam1Id() {
        return tTeamByTeam1Id;
    }

    public void settTeamByTeam1Id(Team tTeamByTeam1Id) {
        this.tTeamByTeam1Id = tTeamByTeam1Id;
    }

    @ManyToOne
    @JoinColumn(name = "Team2ID", referencedColumnName = "TeamID", nullable = false)
    public Team gettTeamByTeam2Id() {
        return tTeamByTeam2Id;
    }

    public void settTeamByTeam2Id(Team tTeamByTeam2Id) {
        this.tTeamByTeam2Id = tTeamByTeam2Id;
    }

    @ManyToOne
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
    public Group gettGroupByGroupId() {
        return tGroupByGroupId;
    }

    public void settGroupByGroupId(Group tGroupByGroupId) {
        this.tGroupByGroupId = tGroupByGroupId;
    }

    @OneToMany(mappedBy = "tMatchByMatchId")
    public Collection<MatchResult> gettMatchResultsByMatchId() {
        return tMatchResultsByMatchId;
    }

    public void settMatchResultsByMatchId(Collection<MatchResult> tMatchResultsByMatchId) {
        this.tMatchResultsByMatchId = tMatchResultsByMatchId;
    }
}
