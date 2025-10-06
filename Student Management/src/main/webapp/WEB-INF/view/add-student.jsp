<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel = "stylesheet" type = "text/css" href ="/Student-Management/URLToReachResourcesFolder/css/add-student.css"/>


</head>
<body>

<nav class="navbar navbar-expand-lg">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="/Student-Management/">Student Management</a>
    <div>
      <a class="nav-link d-inline" href="/Student-Management/">Student List</a>
    </div>
  </div>
</nav>

<div class="form-container">
  <h3 class="text-center text-primary fw-bold mb-4">Add Student</h3>

  <form:form action="showSaveStudentPage" modelAttribute="students" method="POST">
    <form:hidden path="id"/>

    <div class="mb-3">
      <label class="form-label">Name</label>
      <form:input path="name" cssClass="form-control" required="true"/>
    </div>

    <div class="mb-3">
      <label class="form-label">Mobile</label>
      <form:input path="mobile" cssClass="form-control" required="true"/>
    </div>

    <div class="mb-3">
      <label class="form-label">Country</label>
      <form:input path="country" cssClass="form-control" required="true"/>
    </div>

    <button type="submit" class="btn btn-primary w-100">Submit</button>
  </form:form>
</div>

</body>
</html>
