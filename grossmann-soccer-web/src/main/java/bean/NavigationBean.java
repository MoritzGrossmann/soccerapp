package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Group;
import models.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collection;

@ManagedBean(name = "navigationBean")
@SessionScoped
public class NavigationBean {

    private Collection<Team> teams;

    private Collection<Group> groups;

    public Collection<Team> getTeams() {
        if (this.teams == null) {
            loadTeams();
        }
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
        this.teams = teams;
    }

    public Collection<Group> getGroups() {
        if (groups == null) {
            loadGroups();
        }
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }

    private void loadTeams() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        this.teams = soccerPersistence.getTeams();
    }

    private void loadGroups() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        this.groups = soccerPersistence.getGroups();
    }
}
