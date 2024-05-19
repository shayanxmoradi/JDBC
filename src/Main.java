import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            System.out.println("Fetching table names...");

            // Database connection URL
            String url = "jdbc:postgresql://localhost:5432/postgres";

            // Database credentials
            String user = "postgres";
            String password = "1234";

            // Establish connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // SQL query to get all table names in the 'gallery' schema
            String sql = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'mk_115'";
            String sql2 = "SELECT * FROM mk_115.CITY";
            // Create a statement and execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            Statement statement2 = connection.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(sql2);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("table_name"));
            }
            // Iterate through the result set and print each table name
            while (resultSet2.next()) {
                //  System.out.println(resultSet.getString("id"));
                System.out.println(resultSet2.getString("name"));
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}