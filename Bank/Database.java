package Bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Database {
    private String url = "jdbc:mysql://localhost:3306/Bank";
    private String username = "root";
    private String password = "";

      public Connection connect() {
        try {

            Connection con = DriverManager.getConnection(url, username, password);
            return con;

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();

            return null;
        }
    }


     public BankAccount verifyAccount(String accountId, int accountPin) {

        String sql = "SELECT * FROM accounts WHERE account_id = ? AND pin = ?";

        try {

            Connection con = connect();

            PreparedStatement stmt =
                con.prepareStatement(sql);

            stmt.setString(1, accountId);
            stmt.setInt(2, accountPin);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {

                String accountName = result.getString("account_name");

                double accountBalance = result.getDouble("balance");

                String id = result.getString("account_id");

                return new BankAccount(accountName, accountBalance, id);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
     public void updateBalance(String accountId, double newBalance) {

        String sql =
            "UPDATE accounts SET balance = ? WHERE account_id = ?";

        try {

            Connection con = connect();

            PreparedStatement stmt =
                con.prepareStatement(sql);

            stmt.setDouble(1, newBalance);
            stmt.setString(2, accountId);

            stmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
