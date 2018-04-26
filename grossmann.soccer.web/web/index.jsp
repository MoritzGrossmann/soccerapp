<%@ page import="models.Team" %>
<%@ page import="controller.SoccerJpaPersistence" %><%--
  Created by IntelliJ IDEA.
  User: moritz
  Date: 23.04.2018
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello World</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  </head>
  <body>
  <h1>Teams Bundesliga</h1>
    <table>
      <%for(Team team : new SoccerJpaPersistence().getTeams()){
          %><tr><td><img width="20px" src=<%=String.format("\"%s\"", team.getIconUrl())%></td><td><%=team.getTeamName()%></td></tr><%
      }%>
    </table>
  </body>
</html>
