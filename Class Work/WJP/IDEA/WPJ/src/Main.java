import java.sql.*;
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "cdac";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database!");

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
            }

            rs.close();
            st.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}