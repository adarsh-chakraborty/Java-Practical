import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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

      Statement statement = conn.createStatement();
      String sql = "select * from CUSTOMERS";

      // Step 4: Execute the query
      ResultSet result = statement.executeQuery(sql);

      while (result.next()) {
        String id = result.getString("id");
        String name = result.getString("name");
        String age = result.getString("age");
        String address = result.getString("address");
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