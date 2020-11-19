<%@ page import="java.util.List" %>
<%@ page import="metube.domain.models.views.AllTubesViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="head.jsp"/>
</head>
<body>
<% List<AllTubesViewModel> tubes = (List<AllTubesViewModel>) request.getAttribute("allTubes"); %>
<div class="container">
    <main>
        <div class="jumbotron">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h1>All Tubes</h1>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <p>Check our tubes below.</p>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <% if (tubes.isEmpty()) { %>
                        <p>No tubes - <a href="/tubes/create">Create some!</a></p>
                    <% } else {%>
                    <ul>
                        <% for (AllTubesViewModel tube : tubes) { %>
                        <li><a href="/tubes/details?=<%= tube.getName()%>"><%= tube.getName()%></a></li>
                      <%  }%>
                    </ul>
                    <% } %>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <a href="/">Back to Home.</a>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <c:import url="footer.jsp"/>
    </footer>
</div>
</body>
</html>
