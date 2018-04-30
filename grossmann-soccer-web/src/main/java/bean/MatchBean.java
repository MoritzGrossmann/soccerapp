package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Match;
import models.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "matchBean")
@SessionScoped
public class MatchBean {

    private int id;

    private Match match;

    public Team team1;

    public Team team2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Match getMatch() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        this.match = soccerPersistence.getMatchById(this.id);
        return this.match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

}
