<jsp:useBean id="currentUser" class="p1.User" scope="application">
</jsp:useBean>
<jsp:setProperty name="currentUser" property="*" />
<!DOCTYPE html>
<html>
  <style>
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
      color: #212121;
      border-radius: 5px;
      background-color: #80cbc4;
      padding: 20px;
      font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
      text-align: center;
      box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px,
        rgba(0, 0, 0, 0.22) 0px 10px 10px;
    }
  </style>
  <body>
    <br />
    <br />
    <br />
    <div class="container">
      <h2 class="heading">
        Hello <jsp:getProperty name="currentUser" property="firstName" />!
      </h2>
      <p>
        You've been logged in with following email address: <br /><br />
        <%= currentUser.getMailtoUrl() %>
      </p>

      <a href="profile.jsp">Click here to visit your profile page...</a>
    </div>
  </body>
</html>
