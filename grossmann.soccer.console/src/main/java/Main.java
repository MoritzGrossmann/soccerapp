import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;

public class Main {

    public static void main(String[] args) {
        SoccerPersistence databaseHelper = new SoccerJpaPersistence();
        databaseHelper.getTeams().forEach(team -> System.out.printf("%s\n", team.getTeamName()));
    }
}
