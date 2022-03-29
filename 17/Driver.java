import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

class Driver{
  public static void main(String args[]){
    Connection conn = null;

    String url = "jdbc:mysql://localhost:3306/java_practicals";
    Properties property = new Properties();
    property.put("user", "root");
    property.put("password", "superdoge1234");

    try{

      
      conn = DriverManager.getConnection(url,property);
      System.out.println("Connected to local mysql instance");
      
      // Create the PreparedStatement object and pass sql string.
      String sqlString = "{ call getTotalEmployees(?) }";
      CallableStatement statement = conn.prepareCall(sqlString);

      // Register the out parameter and execute update query.
      statement.registerOutParameter(1, java.sql.Types.INTEGER);
      statement.executeUpdate();

      // Getting the outout parameter from the callableStatement object.
      int totalEmployees = statement.getInt(1);
      System.out.println("Total Employees: "+ totalEmployees);

    }catch(SQLException e){
     e.printStackTrace();
    }finally{
      System.out.println("Closing SQL connection.");
      try{
        conn.close();
      }catch(SQLException e){
        e.printStackTrace();
      }
    }
  }
}