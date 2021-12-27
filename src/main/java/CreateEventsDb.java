import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/AddEventsDb")
public class CreateEventsDb extends HttpServlet {
    DAOLayer conn;

    public CreateEventsDb() {
        String url = "jdbc:oracle:thin:@//localhost:1521/XE";
        String userName = "system";
        String pass = "1234";
        conn = new DAOLayer();
        conn.registration(url, userName, pass);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String eventNumber = req.getParameter("AeNumber");
        String eName = req.getParameter("AeName");
        String coordinatorName = req.getParameter("Aname");
        String coordinateNumber = req.getParameter("Anumber");
        String feeforRegistration=req.getParameter("Afee");
        String venueofEvent=req.getParameter("Avenue");
        Date dateOfEvent= Date.valueOf(LocalDate.parse(req.getParameter("Adate")));
            try {
                PreparedStatement m2 = conn.obj.prepareStatement("insert into Events(eventNumber,eventName,coordinatorName,coordinateNumber,feeforRegistration,venueofEvent,dateOfEvent) values(?,?,?,?,?,?,?)");
                m2.setString(1, eventNumber);
                m2.setString(2, eName);
                m2.setString(3, coordinatorName);
                m2.setString(4, coordinateNumber);
                m2.setString(5, feeforRegistration);
                m2.setString(6, venueofEvent);
                m2.setDate(7, dateOfEvent);
                m2.executeUpdate();
                System.out.println("Values are inserted using prepared statement");
                RequestDispatcher rd=req.getRequestDispatcher("CreateEvents.html");
                rd.include(req,resp);
                out.println("<center><h1>Event Added Successfully</h1></center>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
