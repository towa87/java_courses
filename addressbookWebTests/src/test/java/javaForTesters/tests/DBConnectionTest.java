package javaForTesters.tests;

import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by Антон on 05.10.2016.
 */
public class DBConnectionTest {
  @Test
  public void testDBConection(){
    Connection conn = null;

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=&serverTimezone=UTC");
      // Do something with the Connection
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer FROM group_list");
      Groups groups = new Groups();
      while(rs.next()){
       groups.add(new GroupData().withId(rs.getInt("group_id")).withName("group_name").withFooter("group_footer")
               .withHeader("group_header"));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(groups);
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }

}
