<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 7/12/16
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
Select a file to upload: <br />
<form method="POST" action="FileUploadServlet" enctype="multipart/form-data" >
  <input type="file" name="file" id="file" /> <br/>
  <br />
  <input type="submit" value="Upload" name="upload" id="upload" />
</form>
</body>
</html>