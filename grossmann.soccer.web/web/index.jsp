<%@ page import="models.Team" %>
<%@ page import="controller.DatabaseHelper" %><%--
  Created by IntelliJ IDEA.
  User: morit
  Date: 23.04.2018
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello World</title>
  </head>
  <body>
    <table>
      <%for(Team team : new DatabaseHelper().getTeams()){
          %><tr><td><img src=<%=String.format("\"%s\"", team.getIconUrl())%></td><td></td></tr><%
      }%>
    </table>
  </body>
</html>
