package controller;

import interfaces.SoccerPersistence;
import models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SoccerJpaPersistence implements SoccerPersistence {

    private static final String PERSISTENCE_UNIT = "soccerunit";

    private EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public Collection<Team> getTeams() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Team> query = entityManager.createQuery("SELECT t from Team t", Team.class);
        return query.getResultList();
    }

    private Collection<Match> getMatches() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Match> query = entityManager.createQuery("SELECT m from Match m", Match.class);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public Team getTeamById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Team.class, id);
    }

    @Override
    public void persistTeam(Team team) {
        EntityManager entityManager = getEntityManager();
        entityManager.persist(team);
        entityManager.close();
    }

    @Override
    public Collection<Group> getGroups() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Group> query = entityManager.createQuery("SELECT g from Group g", Group.class);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public Group getGroupById(int groupId) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Group.class, groupId);
    }

    @Override
    public Player getPlayerById(int playerId) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Player.class, playerId);
    }

    @Override
    public Match getMatchById(int matchId) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Match.class, matchId);
    }

    @Override
    public ResultTable getTable(int leagueId) {
        EntityManager entityManager = getEntityManager();
        List<Match> matches = new ArrayList<>(entityManager.find(League.class, leagueId).getMatches());
        return new ResultTable(matches);
    }

    @Override
    public Collection<League> getLeagues() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<League> query = entityManager.createQuery("SELECT l from League l", League.class);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    public void persistPlayer(Player player) {
        EntityManager entityManager = getEntityManager();
        entityManager.persist(player);
        entityManager.close();
    }

    public void persistPlayers(Collection<Player> players) {
        EntityManager entityManager = getEntityManager();
        players.forEach(player -> {
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.getTransaction().commit();
        });

        entityManager.close();
    }
}