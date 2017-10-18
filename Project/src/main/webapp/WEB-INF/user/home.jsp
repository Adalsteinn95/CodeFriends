<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>SUPER-AWESOME-HELLOWORLD</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/frontpage-signup.css" />">

</head>
<body>

    <div class="main-content">
      <h1 class="title fade-in">kewlkvis</h1>
      <div class="form-container fade-in">
        <h2 class="subtitle">Sign up to get started!</h2>
        <form class= "form" method="POST" action="/user/showuser">
          <div class="form_input-fields">
            <input class="input" placeholder="name" name="name" id="name" type="text" />
            <input class="input" placeholder="email" name="email" id="email" type="email" />
            <input class="input" placeholder="password" name="password" id="password" type="password" />
          </div>
          <button class="submit-button" type="submit">Sign up</button>
        </form>
      </div>
        <div class="form-container fade-in">
          <h2 class="subtitle">Already have an account? Sign in here!</h2>
          <form class="form" method="POST" action="/user/profile">
              <div class="form_input-fields">
                  <input placeholder="name" class="input" name="name" id="name" type="text" />
                  <input placeholder="password" class="input" name="password" id="password" type="password" />
              </div>
              <button class="submit-button "type="submit">Log in</button>
          </form>
        </div>
      </div>
</body>
</html>
