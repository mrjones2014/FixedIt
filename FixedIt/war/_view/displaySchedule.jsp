<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<meta charset="UTF-8">
		<title>FixedIt Scheduler - My Account</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: left;
		}		
		</style>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="_view/stylesheets/normalize.css" media="screen">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="_view/stylesheets/stylesheet.css" media="screen">
    <link rel="stylesheet" type="text/css" href="_view/stylesheets/github-light.css" media="screen">
    <link rel="stylesheet" type="text/css" href="_view/stylesheets/styles.css" media="screen" />
	</head>
	
	<section class="styled-body">
      <h1 class="project-name">FixedIt</h1>
      <h2 class="project-tagline">CS320 Software Engineering Project: York College Scheduling App</h2>
      <form action="${pageContext.servletContext.contextPath}/schedule" method="post">
      	<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
			<c:if test="${! empty errorMessage}">
				<div class="error">${errorMessage}</div>
			</c:if>
			
			<div class="sideBar">
				<table class="sideBarTable">
					<tr>
						<td><input class="sideBarBtn" type="button" value="Search Courses" onclick="window.location='search';" /></td>
					</tr>
					<tr>
						<td><input class="sideBarBtn" type="button" value="My Account" onclick="window.location='userInfo';" /></td>
					</tr>
					<tr>
						<td><input class="sideBarBtn" type="button" value="Dummy Button"  /></td>
					</tr>
					<tr>
						<td><input class="sideBarBtn" type="button" value="Dummy Button"  /></td>
					</tr>
					<tr>
						<td><input class="sideBarBtn" type="button" value="Dummy Button"  /></td>
					</tr>
					<tr>
						<td><input class="sideBarBtn" type="button" value="Logout" onclick="window.location='login';" /></td>
					</tr>
				</table>
			</div>
		</form>
    </section>
</html>