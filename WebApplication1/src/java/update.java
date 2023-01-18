import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class update extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        String id = request.getParameter("did");
        String name = request.getParameter("dname");
        String email = request.getParameter("demail");
        String password = request.getParameter("dpass");
        response.setContentType("text/html");
       try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?user=root&password=budhrani");
            Statement stmt=connect.createStatement();
            String q = "select*from users where id = "+id+";";
            String query = "update users set username = '"+ name+"',email = '"+email+"',password = '"+password+"' where id = "+id+";";
            stmt.executeUpdate(query);
            RequestDispatcher rd = request.getRequestDispatcher("Update.html");
            out.println("<center><h1>User Profile Updated</h1><center>");
            rd.include(request, response);
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.close();
    }   
}
