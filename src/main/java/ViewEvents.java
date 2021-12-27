import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/viewevents")
public class ViewEvents extends HttpServlet{
    DAOLayer conn;
    public ViewEvents() {
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
            ResultSet rp = stmt1.executeQuery("select * from Events");


            out.println("<center><h1>Event Details</h1></center>");
            out.println("<br>");
            out.println("<div>");

            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>EventNumber</th><th>EventName</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>");
            while (rp.next())
            {
                String n = rp.getString("eventNumber");
                String nm = rp.getString("eventName");
                String co = rp.getString("coordinatorName");
                String cono  = rp.getString("coordinateNumber");
                String f=rp.getString("feeforRegistration");
                String v=rp.getString("venueOfEvent");
                Date d=rp.getDate("dateOfEvent");
                out.println("<tr><td>" + n + "</td><td>" + nm +"</td><td>"+co+"</td><td>"+cono+"</td><td>"+f+"</td><td>"+v+"</td><td>"+d+"</td></tr>");
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