package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.ResultTable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "tableBean")
@SessionScoped
public class TableBean {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private ResultTable resultTable;

    public ResultTable getResultTable() {
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        return soccerPersistence.getTable(this.id);
    }
}
