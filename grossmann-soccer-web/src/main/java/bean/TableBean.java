package bean;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;
import models.MatchResult;
import models.Team;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "tableBean")
@SessionScoped
public class TableBean {

    private Map<Team, Integer> pointsFromTeam;

    public Map<Team, Integer> getPointsFromTeam() {
        Map<Team, Integer> teams = new HashMap<>();
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        soccerPersistence.getTeams().forEach(team ->{
            teams.put(team, 0);
            team.getMatchesTeam1().forEach(match -> {
                MatchResult end = new ArrayList<MatchResult>(match.getResults()).get(match.getResults().size()-1);
                if (end.getPointsTeam1() > end.getPointsTeam1()) {
                    teams.put(team, teams.get(team) + 3);
                } else if (end.getPointsTeam1() == end.getPointsTeam2()) {
                    teams.put(team, teams.get(team) + 1);
                }
            });
        });
        return teams;
    }
}
