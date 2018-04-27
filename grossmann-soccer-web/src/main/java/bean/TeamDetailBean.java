package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
}
