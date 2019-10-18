<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

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
        <form action="saveNote" method="POST">

        Note ID: <br><input type="int" name="noteId"
        required data-required-message="Field is mandatory"
        pattern="\d{1-14}" data-pattern-mismatch="Translate('Please Enter a Number')"
        title="Please Enter a Number"><br>

        Title: <br><input type="text" name="noteTitle"><br>

        Content: <br><input type="text" name="noteContent"><br>

        Status: <br><select name="noteStatus" >
            <option value="To Start">To Start</option>
            <option value="Ongoing">Ongoing</option>
            <option value="On Hold">On Hold</option>
            <option value="Completed">Completed</option>
            </select>
        <br><br>
        <input type="submit" value="Submit"
    </div>

	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
	<hr>

	<div>
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Content</th>
                <th>Status</th>
                <th>Created At</th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempNote" items="${notes}">

                <c:url var="deleteLink" value="/deleteNote">
                    <c:param name="noteId" value="${tempNote.noteId}"/>
                </c:url>
                <tr>
                    <td> ${tempNote.noteId} </td>
                    <td> ${tempNote.noteTitle} </td>
                    <td> ${tempNote.noteContent} </td>
                    <td> ${tempNote.noteStatus} </td>
                    <td> ${tempNote.createdAt} </td>
                    <td> <a href="${deleteLink}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
	</div>
</body>
</html>