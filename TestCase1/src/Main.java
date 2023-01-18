import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connect;
        Statement stmt;
        ResultSet resultSet;
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/assign2?user=root&password=aman&useSSL=false");
        stmt = connect.createStatement();
        resultSet = stmt.executeQuery("select * from covid;");
        while (resultSet.next()){
            int userID = resultSet.getInt("SNo");
            String userID2 = resultSet.getString("ACTIVE_CASES");
            String userID3= resultSet.getString("CURED_CASES");
            String userID4= resultSet.getString("DEATH_CASES");
            System.out.println(userID+" "+userID2+" "+userID3+" "+userID4+" ");
        }
    }
}
