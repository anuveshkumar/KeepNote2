<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send
		 button. Handle errors like empty fields -->

    <div>
        <form:form action="saveUpdatedNote" modelAttribute="keepNote" method="POST">
        <form:hidden path="noteId"/>

        Title: <br><form:input path="noteTitle"/><br>
        Content: <br><form:input path="noteContent"/><br>
        Status: <br><form:select path="noteStatus">
            <option value="To Start">To Start</option>
            <option value="Ongoing">Ongoing</option>
            <option value="On Hold">On Hold</option>
            <option value="Completed">Completed</option>
            </form:select>
        <br><br>
        <input type="submit" value="Save" class="save"/>
        </form:form>
    </div>
</body>
</html>