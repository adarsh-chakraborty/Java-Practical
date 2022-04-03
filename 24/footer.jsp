
<footer>
  
  <!-- Printing the developer name using taglib directive -->
  <p>This site is made by <strong><c:out value="${developer}"/></strong></p>
  <p><strong>Time on the server:</strong> <%=
    new Date().toString() %></p>
</footer>
</body>
</html>