import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryRunner {
        public void getEmployeeNames(Connection con) throws SQLException {
            String query = "SELECT * FROM emp";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                String name = rs.getString("ename"); // Retrieve name from db
                System.out.println("ename = " + name); // Print result on console
            }
        }
}