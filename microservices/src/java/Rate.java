import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

public class Rate extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String a1 = request.getParameter("pname");
            String a2 = request.getParameter("fe");
            String a3 = request.getParameter("eno");
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true","root","budhrani");

            Statement stmt=connect.createStatement();
            
            String query = "insert into Rate values('"+a1+"',"+Integer.parseInt(a2)+","+Integer.parseInt(a3)+");";
            stmt.executeUpdate(query);
            RequestDispatcher rd = request.getRequestDispatcher("Rate.html");
            out.println("<center><h1> Feedback Registered </h1></center>");
            out.println("<center><h2> Thank you for your feedback </h2></center>");
            rd.include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
