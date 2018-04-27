package servlet;

import controller.SoccerJpaPersistence;
import interfaces.SoccerPersistence;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TeamServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        SoccerPersistence soccerPersistence = new SoccerJpaPersistence();
        soccerPersistence.getTeams().forEach(team -> {
            out.println(team.getTeamName());
            team.getPlayers().forEach(player -> {
                out.printf("\t%s\n", player);
            });
        });
        out.close();
    }
}