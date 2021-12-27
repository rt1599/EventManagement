import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidate {
    public static boolean Validation(String name,String pass) throws SQLException {
        boolean status=false;
        LoginServletClass obj=new LoginServletClass();
        PreparedStatement stmt=obj.conn.obj.prepareStatement("select * from Participants where username=? and password=?");
        stmt.setString(1,name);
        stmt.setString(2,pass);
        ResultSet rs=stmt.executeQuery();
        status=rs.next();
        obj.conn.obj.close();
        return status;
    }
}
