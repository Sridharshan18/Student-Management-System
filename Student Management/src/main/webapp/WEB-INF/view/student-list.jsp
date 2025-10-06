<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel = "stylesheet" type = "text/css" href ="/Student-Management/URLToReachResourcesFolder/css/studentlist.css"/>

</head>
<body>

<nav class="navbar navbar-expand-lg">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="/Student-Management/">Student Management</a>
  </div>
</nav>

<div class="container text-center">
  <h2>Student List</h2>
  <a href="/Student-Management/showAddStudentPage" class="btn btn-add mb-4">+ Add Student</a>

  <div class="table-responsive">
    <table class="table table-bordered table-striped align-middle">
        <thead class="table-primary text-white">
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Mobile</th>
            <th>Country</th>
            <th colspan="2">Actions</th>
          </tr>
        </thead>
      <tbody>
        <c:forEach var="student" items="${studentList}">
          <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.mobile}</td>
            <td>${student.country}</td>
            <td>
              <a href="/Student-Management/updateStudent?userId=${student.id}" class="btn btn-sm btn-warning text-white">Update</a>
            </td>
            <td>
              <a href="/Student-Management/deleteStudent?userId=${student.id}"
                 class="btn btn-sm btn-danger"
                 onclick="return confirm('Are you sure you want to delete this student?');">
                 Delete
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

</body>
</html>
