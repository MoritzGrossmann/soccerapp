package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Group;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "groupDetailBean")
@SessionScoped
public class GroupDetailBean {

    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int nextGroup;

    public int getNextGroup() {
        return this.id+1;
    }

    private int previousGroup;

    public int getPreviousGroup() {
        return this.id -1;
    }

    private Group group;

    public Group getGroup() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getGroupById(this.id);
    }
}
