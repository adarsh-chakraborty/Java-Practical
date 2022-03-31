import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Servlet1UrlRewrite extends HttpServlet{

public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  String firstname = req.getParameter("firstname");
  String lastname = req.getParameter("lastname");
  String email = req.getParameter("email");
  String country = req.getParameter("country");

  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();


  String customURL = "?firstname="+firstname+"&lastname="+lastname+"&email="+email+"&country="+country;

  

  pw.println("""
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
      border-radius: 5px;
      background-color: #f2f2f2;
      padding: 20px;
      font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
      text-align: center;
    }
  </style>
  <body>
    <h2 class=\"heading\">Hello """);
    pw.println(firstname);
    pw.println("""
    !</h2>
    <p>You've been logged in.</p>
    <div class=\"container\">
    <a href=\"serv2url""");

    pw.println(customURL);
    pw.println("""
    \">View full profile on servlet2...</a>
    </div>
  </body>
</html>
    """);

}
}