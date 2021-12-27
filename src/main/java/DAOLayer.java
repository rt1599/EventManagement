import java.sql.*;

public class DAOLayer {
    Connection obj;
    public void registration(String url,String userName,String pass){
        try{
            //Register drive
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver is loaded");
            //Connection
            obj=DriverManager.getConnection(url, userName, pass);
            System.out.println("Connection Established");

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
//    public void registration() {
//        String url = "jdbc:oracle:thin:@//localhost:1521/XE";
//        String userName = "system";
//        String pass = "1234";
//        try {
//            //Register drive
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("Driver is loaded");
//            //Connection
//            Connection obj = DriverManager.getConnection(url, userName, pass);
//            System.out.println("Connection Established");
//            PreparedStatement m2=obj.prepareStatement("insert into employee(first_name,last_name,username,password,contact_no) values(?,?,?,?,?)");
//            m2.setString(1,emp.getFirstName());
//            m2.setString(2,emp.getLastName());
//            m2.setString(3,emp.getUserName());
//            m2.setString(4,emp.getPassword());
//            m2.setString(5,emp.getContact());
//            m2.executeUpdate();
//            System.out.println("Values are inserted using prepared statement");
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e);
//        }
//    }
//}
