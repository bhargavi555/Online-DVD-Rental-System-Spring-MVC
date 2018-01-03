<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>

<%@include file="Header.jsp"%>
    <h1>Add Record to DVD Table</h1>
    <form:form action="insertDVDToDB" method="post">
      DVD Id: <form:input path="id"/><br/>
      DVD Category: <form:input path="dvdCategory"/><br/>
      DVD Name: <form:input path="dvdName"/><br/>
      DVD Description: <form:input path="dvdDescription"/><br/>
      DVD Price: <form:input path="dvdPrice"/><br/>
      DVD Image path: <form:input path="imagePath"/><br/>
      
      
       <input type="reset"/>
      <input type="submit"/>
    </form:form>
    
      <%@ include file="Footer.jsp"%>
</body>
</html>