package controller;

import models.Match;
import models.Player;
import models.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class DatabaseHelper {

    private static final String PERSISTENCE_UNIT = "soccerunit";

    private EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public Collection<Team> getTeams() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Team> query = entityManager.createQuery("SELECT v from Team v", Team.class);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    private Collection<Match> getMatches() {
        EntityManager entityManager = getEntityManager();
        return null;
    }

    public Team getTeamById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Team.class, id);
    }

    public void persistPlayer(Player player) {
        EntityManager entityManager = getEntityManager();
        entityManager.persist(player);
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