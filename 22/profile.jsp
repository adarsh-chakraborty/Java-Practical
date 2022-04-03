<jsp:useBean id="currentUser" class="p1.User" scope="application">
</jsp:useBean>

<!DOCTYPE html>
<html>
  <style>
    html {
      color: #263238;
    }
    .heading {
      text-decoration: underline;
    }
    .heading,
    p {
      text-align: center;
      font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    }

    .container {
      width: 40%;
      margin: auto;
    }

    div {
      border-radius: 2px;
      background-color: #4db6ac;
      padding: 20px;
      font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
      text-align: center;
      box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px,
        rgba(0, 0, 0, 0.22) 0px 10px 10px;
    }

    .bio {
      font-weight: 500;
      font-size: large;
    }
  </style>
  <body>
    <h1 class="heading">User Profile</h1>
    <p><span class="bio">BIO:</span> <i><%= currentUser.getBIO() %></i></p>
    <div class="container">
      <h2>Name: <%= currentUser.getFullName() %></h2>
      <h2>Email: <jsp:getProperty name="currentUser" property="email" /></h2>
      <h2>
        Country: <jsp:getProperty name="currentUser" property="country" />
      </h2>
      <p>
        You've will further notifications on your email address at: <%=
        currentUser.getMailtoUrl() %>
      </p>
    </div>
  </body>
</html>
