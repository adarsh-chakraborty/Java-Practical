<jsp:useBean id="currentUser" class="p1.User" scope="application">
</jsp:useBean>

<!DOCTYPE html>
<html>
  <style>
    html {
      background-color: #e3f2fd;
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
      background-color: #fbe9e7;
      padding: 20px;
      font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
      text-align: center;
      box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px,
        rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
    }

    .bio {
      font-weight: 500;
      font-size: large;
    }
  </style>
  <body>
    <h1 class="heading">User Profile</h1>

    <!-- 4. Jsp include action tag  -->
    <jsp:include page="userbio.jsp"></jsp:include>
    <div class="container">
      <h2>Name: <%= currentUser.getFullName() %></h2>
      <h2>Email: <jsp:getProperty name="currentUser" property="email" /></h2>
      <h2>
        Country: <jsp:getProperty name="currentUser" property="country" />
        <img src="assets/rus.png" width="30px" />
      </h2>
      <h2>Your UserId is: <%=request.getParameter("userId")%>.</h2>
      <p>Please use the id for future references.</p>
      <p>
        You've will further notifications on your email address at: <%=
        currentUser.getMailtoUrl() %>
      </p>
    </div>
  </body>
</html>
