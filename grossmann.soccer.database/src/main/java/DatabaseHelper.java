import models.Match;
import models.Player;
import models.Team;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collection;

public class DatabaseHelper {

    private static final String PERSISTENCE_UNIT = "soccerunit";

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
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