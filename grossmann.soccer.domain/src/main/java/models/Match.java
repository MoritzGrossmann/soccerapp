package models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "t_match", schema = "soccer")
public class Match {
    private int id;
    private Date lastUpdateTime;
    private Date dateTime;
    private Date dateTimeUtc;
    private boolean isFinished;
    private int numberOfViewers;
    private String timeZoneId;
    private Collection<Goal> goals;
    private League league;
    private Location location;
    private Team team1;
    private Team team2;
    private Group group;
    private Collection<MatchResult> results;

    public Match() {
    }

    @Id
    @Column(name = "MatchID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "MatchDateTimeUTC")
    public Date getDateTimeUtc() {
        return dateTimeUtc;
    }

    public void setDateTimeUtc(Date dateTimeUtc) {
        this.dateTimeUtc = dateTimeUtc;
    }

    @Basic
    @Column(name = "MatchIsFinished")
    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
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
        return id == match.id &&
                isFinished == match.isFinished &&
                numberOfViewers == match.numberOfViewers &&
                Objects.equals(lastUpdateTime, match.lastUpdateTime) &&
                Objects.equals(dateTime, match.dateTime) &&
                Objects.equals(dateTimeUtc, match.dateTimeUtc) &&
                Objects.equals(timeZoneId, match.timeZoneId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, lastUpdateTime, dateTime, dateTimeUtc, isFinished, numberOfViewers, timeZoneId);
    }

    @OneToMany(mappedBy = "match")
    public Collection<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Collection<Goal> goals) {
        this.goals = goals;
    }

    @ManyToOne
    @JoinColumn(name = "LeagueID", referencedColumnName = "LeagueID", nullable = false)
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @ManyToOne
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationiD")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne
    @JoinColumn(name = "Team1ID", referencedColumnName = "TeamID", nullable = false)
    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    @ManyToOne
    @JoinColumn(name = "Team2ID", referencedColumnName = "TeamID", nullable = false)
    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    @ManyToOne
    @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @OneToMany(mappedBy = "match")
    public Collection<MatchResult> getResults() {
        return results;
    }

    public void setResults(Collection<MatchResult> results) {
        this.results = results;
    }
}
