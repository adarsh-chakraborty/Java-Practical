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

public class Servlet2Cookie extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  
  Cookie[] cookies = req.getCookies();
  String firstName = "";
  String lastName = "";
  String email = "";
  String country = "";

  if(cookies == null){
    pw.println("You are not logged in!");
    pw.println("<a href=\"cookies.html\">Go back to login page.</a>");
  }else{

    for(Cookie c : cookies){
      String cookieHeader = c.getName();
      if(cookieHeader.equals("firstname")){
        firstName = c.getValue();

      }

        if(cookieHeader.equals("lastname")){
        lastName = c.getValue();

      }

        if(cookieHeader.equals("email")){
        email = c.getValue();

      }

        if(cookieHeader.equals("country")){
        country = c.getValue();

      }
    }

  }


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
    pw.println(firstName);
    pw.println("""
    !</h2>
    <p>Thanks for registering.. We have received your following details:</p>
    <div class=\"container\">
    """);
      pw.println("<h2>Name: "+firstName+ " "+ lastName + "</h2>");
      pw.println("<h2>Country: "+country+ "</h2>");
      pw.println("<h2>Email: "+email+ "</h2>");

    pw.println("""
    <p>
        We will contact you through your registered email address:
        <a href=\"mailto:
    """);

    pw.println(email+"\">");
    pw.println(email);
    pw.println("""
    </a>
      </p>
    </div>
  </body>
</html>
    """);

}
}