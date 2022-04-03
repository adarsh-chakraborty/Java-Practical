<!-- Importing classes using page directive -->
<%@page import="java.util.Date" %>

<!-- Setting an Error Page using page directive -->
<%@page errorPage="error.jsp"%>

<!-- Include styling -->
<%@include file="styles.jsp" %>

<!-- Get both numbers from the request -->
<% int x = Integer.parseInt(request.getParameter("value1")); int y =
Integer.parseInt(request.getParameter("value2")); int result = x/y; %>
<main>
  <div class="container">
    <h2>Division Result:</h2>

    <div class="main" style="justify-content: center">
      <%= x %> / <%= y %> = <%= result %>
    </div>
  </div>
</main>
