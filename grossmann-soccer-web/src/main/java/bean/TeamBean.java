package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Collection;

@ManagedBean(name = "teamBean")
@SessionScoped
public class TeamBean implements Serializable{

    public TeamBean() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        this.teams = soccerPersistence.getTeams();
    }

    private Collection<Team> teams;

    public Collection<Team> getTeams() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getTeams();
    }
}
