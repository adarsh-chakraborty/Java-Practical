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
      Statement statement = conn.createStatement();
      String sql = "select * from "+tablName;

      ResultSet rs = statement.executeQuery(sql);

      ResultSetMetaData rsMetaData = rs.getMetaData();
      int count = rsMetaData.getColumnCount();
      for(int i = 1; i<=count; i++) {
         pw.println(rsMetaData.getColumnName(i));
      }
      
    }catch(Exception e){
  
     e.printStackTrace();
     pw.println("Error: Something went wrong, try again later...");
    }finally{
      
      try{
        conn.close();
      }catch(SQLException e){
        e.printStackTrace();
      }
    }
  }else {
      pw.println("Error: Table name is required!");
  }
}}