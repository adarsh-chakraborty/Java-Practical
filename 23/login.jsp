<!-- 1. JSP useBean Action tag -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@page
import="java.util.Random" %>

<jsp:useBean id="currentUser" class="p1.User" scope="application">
</jsp:useBean>

<!-- 2. JSP SetProperty Action Tag -->
<jsp:setProperty name="currentUser" property="*" />

<!-- Generating a random Integer between 100 - 1000 -->
<% Random r = new Random(); int id = r.nextInt(1000)+100; %>
<!-- 3. JSP forward action tag -->
<c:if test="${currentUser.country == 'india'}">
  <jsp:forward page="indian.jsp">
    <jsp:param name="userId" value="<%= id %>" /> </jsp:forward
></c:if>

<c:if test="${currentUser.country == 'pakistan'}">
  <jsp:forward page="pakistani.jsp">
    <jsp:param name="userId" value="<%= id %>" /></jsp:forward
></c:if>

<c:if test="${currentUser.country == 'russia'}">
  <jsp:forward page="russian.jsp">
    <jsp:param name="userId" value="<%= id %>" /></jsp:forward
></c:if>
