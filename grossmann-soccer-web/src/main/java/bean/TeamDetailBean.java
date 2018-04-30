package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Match;
import models.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "teamDetailBean")
@SessionScoped
public class TeamDetailBean {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Team team;

    public Team getTeam() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getTeamById(id);
    }

    private Collection<Match> matches;

    public Collection<Match> getMatches() {
        List<Match> matches = new ArrayList<>();
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        Team team = soccerPersistence.getTeamById(this.id);
        matches.addAll(team.getMatchesTeam1());
        matches.addAll(team.getMatchesTeam2());
        Collections.sort(matches);
        return matches;
    }
}
