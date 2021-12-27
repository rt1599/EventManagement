import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/TransactionsDetail")
public class TransactionDetail extends HttpServlet{
    DAOLayer conn;
    public TransactionDetail() {
        String url = "jdbc:oracle:thin:@//localhost:1521/XE";
        String userName = "system";
        String pass = "1234";
        conn = new DAOLayer();
        conn.registration(url, userName, pass);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event  Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        try{

            response.setContentType("text/html");
            Statement stmt1 = conn.obj.createStatement();
            ResultSet rp = stmt1.executeQuery("select * from card");


            out.println("<center><h1>Participation Registration</h1></center>");
            out.println("<br>");
            out.println("<div>");

            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>EventName</th><th>EventNo</th><th>CoordinatorName</th><th>cardHolderName</th><th>");
            while (rp.next())
            {
                String n = rp.getString("EventName");
                String nm = rp.getString("EventNo");
                String co = rp.getString("coordinatorName");
                String cono  = rp.getString("cardHolderName");
                out.println("<tr><td>" + n + "</td><td>" + nm +"</td><td>"+co+"</td><td>"+cono+"</td><td>");
            }
            conn.obj.commit();
            conn.obj.close();
            out.println("</table>");
            out.println("</center>");
            out.print("</body>");
            out.print("</html>");
        } catch(Exception exe){System.out.println("Exception caught"+exe);}
    }
}