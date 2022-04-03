<!-- Declrating this as an error page using page directive -->
<%@page isErrorPage="true"%> <%@include file="styles.jsp" %>

<!-- Include styling -->
<%@include file="styles.jsp" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Error</title>
  </head>
  <body>
    <main>
      <div class="container error">
        <h2>An Error occured!</h2>

        <div class="main errorContainer" style="justify-content: center">
          <h3>The exception is : <%= exception %></h3>
        </div>
      </div>
    </main>
  </body>
</html>
