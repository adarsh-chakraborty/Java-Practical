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

public class GenerateIndexFile extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  
  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();

   pw.println("""
   <!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Init parameter access</title>
    <style>
      .container {
        width: 70%;
        margin: auto;
        text-align: center;
      }

      footer {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h2>Welcome to home page.</h2>
      <h3>yes it is homepage</h3>
      <hr />
    </div>
    <footer>
      <p>This site is designed by <strong>
   """);
   ServletConfig config = getServletConfig();
   String developer = config.getInitParameter("Developer");
   pw.println(developer);
   pw.println("""
   </strong></p>
    </footer>
  </body>
</html>
   """);
}
}