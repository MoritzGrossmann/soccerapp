import models.Match;
import models.Player;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collection;

public class DatabaseHelper {

    private static final String PERSISTENCE_UNIT = "soccerunit";

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
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