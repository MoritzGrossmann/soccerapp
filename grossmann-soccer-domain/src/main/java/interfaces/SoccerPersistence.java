package interfaces;

import models.*;


import java.util.Collection;
import java.util.Collections;

public interface SoccerPersistence {

    Collection<Team> getTeams();

    Team getTeamById(int teamId);

    void persistTeam(Team team);

    Collection<Group> getGroups();

    Group getGroupById(int groupId);

    Player getPlayerById(int playerId);

    Match getMatchById(int matchId);

    ResultTable getTable(int leagueId);

    Collection<League> getLeagues();
}
