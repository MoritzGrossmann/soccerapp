package interfaces;

import models.Group;
import models.Team;

import java.util.Collection;

public interface IPersistSoccerData {

    Collection<Team> getTeams();

    Team getTeamById(int teamId);

    void persistTeam(Team team);

    Collection<Group> getGroups();
}
