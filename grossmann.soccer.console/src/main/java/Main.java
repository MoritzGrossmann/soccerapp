import controller.DatabaseHelper;
import models.Player;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.getTeams().forEach(team -> System.out.printf("%s\n", team.getTeamName()));
    }
}
