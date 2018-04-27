package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@ManagedBean(name = "teamBean")
@SessionScoped
public class TeamBean implements Serializable{

    public TeamBean() {
    }

    private Collection<Team> teams;

    public Collection<Team> getTeams() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getTeams();
    }

    private Collection<Integer> zahlen = new ArrayList<>();

    public Collection<Integer> getZahlen() {
        zahlen.add(1);
        zahlen.add(2);
        zahlen.add(3);
        return zahlen;
    }

    public Team getTeamById(int teamId) {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getTeamById(teamId);
    }
}
