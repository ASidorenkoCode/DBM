// This code is for establishing connection with MySQL
// database and retrieving data
// from db Java Database connectivity

/*
 *1. import --->java.sql
 *2. load and register the driver ---> com.jdbc.
 *3. create connection
 *4. create a statement in ConnectionBuild
 *5. execute the query
 *6. process the results
 *7. close
 */

import java.io.*;
import java.sql.*;
import java.util.Properties;

class GFG {

    public static void main(String[] args) throws Exception {
        String[] credentialsAndDatabase = getCredentials();
        String url = "jdbc:mysql://localhost:3306/" + credentialsAndDatabase[2]; // table details
        String username = credentialsAndDatabase[0]; // MySQL credentialsAndDatabase
        String password = credentialsAndDatabase[1];

        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");

        DatabaseQueryRunner queryRunner = new DatabaseQueryRunner();
        queryRunner.getEmployeeNames(con); // Execute query

        con.close(); // close connection
        System.out.println("Connection Closed....");
    }

    private static String[] getCredentials() {
        Properties prop = new Properties();
        InputStream input = null;
        String[] credentials = new String[3];

        try {
            input = new FileInputStream("src/MySQLCredentialsAndDatabase");

            prop.load(input);

            credentials[0] = prop.getProperty("username");
            credentials[1] = prop.getProperty("password");
            credentials[2] = prop.getProperty("table_name");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return credentials;
    }
}

