import java.sql.*;

public class postgres {
    public static void main(String[] args) {
        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/fibo","postgres", "jhamilex_jgr")) {
            System.out.println("Conectado a postgres!");
            Statement statement = connection.createStatement();
            System.out.printf("%-30.30s  %-30.30s%n", "pos", "num");
            //statement.executeQuery("INSERT INTO fibo (pos, num) VALUES (2, 3)");

            PreparedStatement st = connection.prepareStatement("INSERT INTO fibo (id, pos, num) VALUES (?, ?, ?)");
            st.setInt(1, 3);
            st.setInt(1, 2);
            st.setInt(1, 3);
            st.executeUpdate();
            st.close();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM nums");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("pos"), resultSet.getString("num"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}

