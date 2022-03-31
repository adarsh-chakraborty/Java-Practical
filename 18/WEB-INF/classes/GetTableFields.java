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

public class GetTableFields extends HttpServlet{

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  String tablName = req.getParameter("table");
  res.setContentType("text/html");
  PrintWriter pw=res.getWriter();

  if(tablName != null && tablName.trim() != ""){

    Connection conn = null;
    
    try{


      String url = "jdbc:mysql://localhost:3306/java_practicals";
      Properties property = new Properties();
      property.put("user", "root");
      property.put("password", "superdoge1234");
      Class.forName("com.mysql.cj.jdbc.Driver");
    
      conn = DriverManager.getConnection(url,property);

      // Create the statement object and sql string.
      Statement statement = conn.createStatement();
      String sql = "select * from "+tablName;

      ResultSet rs = statement.executeQuery(sql);

      ResultSetMetaData rsMetaData = rs.getMetaData();
      int count = rsMetaData.getColumnCount();
      for(int i = 1; i<=count; i++) {
         pw.println(rsMetaData.getColumnName(i));
      }
      
    }catch(Exception e){
        // pw.println(e.getMess);
     e.printStackTrace();
     pw.println("Error: Something went wrong, try again later...");
    }finally{
      
      try{
        conn.close();
      }catch(SQLException e){
        e.printStackTrace();
      }
    }


// String name=req.getParameter("name");

  }else {
      pw.println("Error: Table name is required!");
  }
}}










/*
pw.println("""
<!DOCTYPE html>
<html lang=\"en\">
  <head>
    <meta charset=\"UTF-8\" />
    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />
    <title>DB TABLE</title>
    <style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 4.5rem;
}

.select_style {
  overflow: hidden;
}
.select_style select {
  -webkit-appearance: none;
  appearance: none;
  width: 120%;
  background: none;
  background: transparent;
  border: none;
  outline: none;
}

.select_style {
  background: #fff;
  overflow: hidden;
  display: inline-block;
  color: #525252;
  font-weight: 300;
  -webkit-border-radius: 5px 4px 4px 5px/5px 5px 4px 4px;
  -moz-border-radius: 5px 4px 4px 5px/5px 5px 4px 4px;
  border-radius: 5px 4px 4px 5px/5px 5px 4px 4px;
  -webkit-box-shadow: 0 0 5px rgba(123, 123, 123, 0.2);
  -moz-box-shadow: 0 0 5px rgba(123, 123, 123, 0.2);
  box-shadow: 0 0 5px rgba(123, 123, 123, 0.2);
  border: solid 1px #dadada;
  font-family: 'helvetica neue', arial;
  position: relative;
  cursor: pointer;
  padding: 10px 15px;
}

.select_style span {
  position: absolute;
  right: 10px;
  width: 10px;
  height: 10px;
  background: url('http://projects.authenticstyle.co.uk/niceselect/arrow.png')
    no-repeat;
  top: 50%;
  margin-top: -4px;
}
</style>
  </head>
  <body>
    <div class=\"container\">
      <select name=\"cars\" id=\"cars\" class=\"select_style\">
        <option value=\"volvo\">Volvo</option>
        <option value=\"saab\">Saab</option>
        <option value=\"mercedes\">Mercedes</option>
        <option value=\"audi\">Audi</option>
      </select>
    </div>
  </body>
</html>
""");
*/