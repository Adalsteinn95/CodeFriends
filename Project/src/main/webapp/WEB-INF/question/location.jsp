<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>kewlkvis</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Playball|Overpass:100,400|Raleway:200|Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/quiz.css" />">

</head>
<body>


  <h1 class="title fade-in">kewlkvis</h1>
  <div class="question-container">
        <h2 class="question-title fade-in">Which city is closer to ${Question.getData().getCurrentLoc()}?</h2>
        <div class="answear-container">
          <form class="answear left fade-in" action="/question/questionLocation" method="POST">
              <input class="answear left fade-in" type="submit" id="answer1" name="answer1" value="${Question.getData().getDest1()}">
          </form>
          <form class="answear right fade-in" action="/question/questionLocation2" method="POST">
              <input  class="answear right fade-in" type="submit" id="answer2" name="answer2" value="${Question.getData().getDest2()}">
          </form>

        </div>
  </div>
  <div class="highscore-container">
    <span class="current-score">Current score: 0</span>
    <span class="high-score">Highscore: 0</span>

  </div>

</body>
