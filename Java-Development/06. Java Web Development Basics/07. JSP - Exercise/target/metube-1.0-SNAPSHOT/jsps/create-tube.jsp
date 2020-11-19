<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="head.jsp"/>
</head>
<body>
<div class="container">
    <main>
        <div class="jumbotron">
            <form action="/tubes/create" method="POST">
                <div class="row">
                    <div class="col col-md-12 d-flex justify-content-center">
                        <h1>Create Tube!</h1>
                    </div>
                </div>
                <hr/>

                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="titleInput">Title</label>
                        </div>
                        <div class="row d-flex justify-content-center">
                            <input type="text" id="titleInput" name="title">
                        </div>
                    </div>
                </div>
                <hr/>

                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="descriptionTextArea">Description</label>
                        </div>
                        <div class="row d-flex justify-content-center">
                            <textarea name="description" id="descriptionTextArea" cols="22" rows="4"></textarea>
                        </div>
                    </div>
                </div>
                <hr/>

                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="youtubeLinkInput">Youtube Link</label>
                        </div>
                        <div class="row d-flex justify-content-center">
                            <input type="text" id="youtubeLinkInput" name="youtubeLink">
                        </div>
                    </div>
                </div>
                <hr/>

                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="uploaderInput">Uploader</label>
                        </div>
                        <div class="row d-flex justify-content-center">
                            <input type="text" id="uploaderInput" name="uploader">
                        </div>
                    </div>
                </div>
                <hr/>

                <div class="row mt-4">
                    <div class="col col-md-12 d-flex justify-content-center">
                        <button class="btn btn-primary">Create Tube</button>
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <a href="/">Back to Home.</a>
                </div>
            </div>
        </div>
        <footer>
            <c:import url="footer.jsp"/>
        </footer>
    </main>
</div>
</body>
</html>
