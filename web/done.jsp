<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 8/2/16
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="style.css" type="text/css">

    <script type="text/javascript" src="hover.js"></script>
    <title>Upload Done</title>
</head>
<body>

<div class="bd-pageheader">
    <div class="container">
        <h1>Java Validation</h1>
    </div>
</div>
<div class="main">
    <a class="btn btn-primary" id="collapseButton" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
        Show Error Summary
    </a>
    <div class="collapse" id="collapseExample">
        <div class="card card-block" id ="errorSummaryContent">
            <table>
                <tr><td>1 Class Name Error</td><td>3 Variable Name Errors</td></tr>
                <tr><td>3 Public Variables</td><td>2 Constant Name Errors</td></tr>
                <tr><td>2 Function Name Errors</td><td>3 Keyword Errors</td></tr>
            </table>
        </div>
    </div>

    <div class="button-header">
        <input type="button" errorType="classError" id="class-button" class="btn btn-warning toggleButton" aria-pressed="true" value="Class Name" />
        <input type="button" errorType="variable" id="variable-name-button" class="btn btn-warning toggleButton" aria-pressed="true" value="Variable Name" />
        <input type="button" errorType="public" id="public-variable-button" class="btn btn-warning toggleButton" aria-pressed="true" value="Public Variable" />
       <!-- <input type="button" errorType="functionSpace" id="function-spacing-button" class="btn btn-secondary toggleButton" aria-pressed="false" value="Function Spacing" />
       -->

    </div>
    <div class="button-header">
        <input type="button" errorType="functionName" id="function-name-button" class="btn btn-warning toggleButton" aria-pressed="true" value="Function Name" />
        <input type="button" errorType="constant" id="constant-name-button" class="btn btn-warning toggleButton" aria-pressed="true" value="Constant Name" />
        <input type="button" errorType="keywordSpacing" id="keyword-spacing-button" class="btn btn-warning toggleButton" aria-pressed="true" value="Keyword Spacing" />
        <!--<input type="button" id="javadoc-button" class="btn btn-secondary toggleButton" aria-pressed="false" value="Javadoc" />
        -->
    </div>

    <div class="code-body">

    <c:forEach var="line" items="${fileContents}">
        ${line}


    </c:forEach>
    </div>

</body>
</html>
