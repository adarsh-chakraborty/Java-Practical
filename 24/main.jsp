<!-- Importing classes using page directive -->
<%@page import="java.util.Date" %>

<main>
  <form action="division.jsp" method="post">
    <div class="container">
      <h2>Enter number in both fields and click submit</h2>

      <div class="main">
        <label
          >Enter first number:
          <input type="text" name="value1" />
        </label>
        <label>
          Enter second number:
          <input type="text" name="value2" />
        </label>
      </div>
      <button class="btn" type="submit">submit</button>
    </div>
  </form>
</main>
