package servlet;

import controller.DatabaseHelper;
import interfaces.IPersistSoccerData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TeamServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        int teamId = Integer.parseInt(request.getParameter("teamId"));
        IPersistSoccerData soccerPersistence = new DatabaseHelper();
        out.println(soccerPersistence.getTeamById(teamId));
        out.println(String.format("ServletConfig: %s", this.getServletConfig()));
        out.close();
    }
}
