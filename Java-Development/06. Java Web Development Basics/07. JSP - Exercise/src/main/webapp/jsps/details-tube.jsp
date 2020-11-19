<%@ page import="metube.domain.models.views.TubeDetailsViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="head.jsp"/>
</head>
<body>
<% TubeDetailsViewModel tdvm = (TubeDetailsViewModel) request.getAttribute("tubeDetailsViewModel"); %>
<div class="container">
    <main>
        <div class="jumbotron">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h1><%= tdvm.getName()%></h1>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <p><%= tdvm.getDescription()%></p>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-6 d-flex justify-content-center">
                    <a href="<%= tdvm.getYoutubeLink()%>">Link to Video.</a>
                </div>

                <div class="col col-md-6 d-flex justify-content-center">
                    <p><%= tdvm.getUploader()%></p>
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
