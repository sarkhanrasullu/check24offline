<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Anmeldeformular - Kennenlerntagaufgabe</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="http://code.jquery.com/jquery-2.1.3.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

  <script>
      $(document).ready(function () {
          $("#exampleInputAge").focusout(
              function validateAge() {
                  var val = $("#exampleInputAge").val();
                  if(val == null || val === ''){
                      $("#ageMsg").text("can not be empty");
                      return;
                  }
                  console.log('val'+val);
                  $.ajax({
                      url: 'http://localhost:8080/klt/rest/rest/age/' + val,
                      type: 'GET',
                      success: function (result) {
                          // alert(result.msg);
                          $("#ageMsg").text(result.msg);
                          table.ajax.reload();
                      }
                  });
              }
          );
      });
  </script>
</head>

<body>
<div class="container">
<h1>${formName}</h1>

<a href="requests">Show all requests</a>
<form:form action="index" method="POST" modelAttribute="form">
  <div class="form-group">
    <label for="exampleInputLastname">Nachname</label>
    <form:input type="text" path="lastName" class="form-control" id="exampleInputLastname" placeholder="Nachname"/>
    <form:errors path="lastName" />
    <span style="color:red">${lastnameMsg}</span>
  </div>
  <div class="form-group">
    <label for="exampleInputFirstname">Vorname</label>
    <form:input type="text" path="firstName" class="form-control" id="exampleInputFirstname" placeholder="Vorname"/>
    <form:errors path="firstName" />
    <span style="color:red">${firstnameMsg}</span>
  </div>
  <div class="form-group">
    <label for="exampleInputAge">Alter</label>
    <form:input type="text" path="age" class="form-control" id="exampleInputAge" placeholder="Alter"/>
    <form:errors path="age" />
    <span style="color:red" id="ageMsg">${ageMsg}</span>
  </div>
  <h3 style="color: green;">${msg}</h3>
  <button type="submit" class="btn btn-default">Anmelden!</button>
</form:form>
</div>
</body>
</html>
