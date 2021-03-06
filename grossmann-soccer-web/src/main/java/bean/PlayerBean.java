package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.Player;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "playerBean")
@SessionScoped
public class PlayerBean {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Player player;

    public Player getPlayer() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getPlayerById(this.id);
    }
}
