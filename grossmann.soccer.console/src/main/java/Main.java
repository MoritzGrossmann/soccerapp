import models.Player;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        File playerFile = new File("C:\\Users\\morit\\IdeaProjects\\soccerapp\\grossmann.soccer.console\\src\\main\\resources\\Player-2018.csv");

        try {
            Collection<Player> players = new CsvImporter(playerFile).readPlayers();
            DatabaseHelper databaseHelper = new DatabaseHelper();
            databaseHelper.persistPlayers(players);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
