package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Group;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collection;

@ManagedBean(name = "groupBean")
@SessionScoped
public class GroupBean {

    private Collection<Group> groups;

    public Collection<Group> getGroups() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getGroups();
    }
}
