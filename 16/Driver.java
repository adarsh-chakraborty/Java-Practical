import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

      Scanner sc = new Scanner(System.in);
      conn = DriverManager.getConnection(url,property);
      System.out.println("Connected to local mysql instance");

      // Get the user input
      System.out.println("Find employees based in city:\nEnter City:");
      String cityQuery = sc.nextLine();

      
      
      // Create the PreparedStatement object and pass sql string.
      String sqlString = "SELECT * FROM employees WHERE city like ?";
      PreparedStatement statement = conn.prepareStatement(sqlString);

      // Query index (?), value;
      statement.setString(1, cityQuery);

      // Execute the query
      ResultSet result = statement.executeQuery();

      System.out.println("Employees living in "+ cityQuery);
      while (result.next()) {
        String id = result.getString("id");
        String name = result.getString("name");
        String age = result.getString("age");
        String address = result.getString("city");
        String salary = result.getString("salary");
        System.out.println(id+" - " + " Name: "+ name + ", Age: "+age+", address:"+ address+", Salary: "+salary);
      }
      
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