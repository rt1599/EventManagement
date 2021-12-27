<%@ page import ="java.sql.*"%>
<%
PrintWriter pw= response.getWriter();
        response.setContentType("text/html");
        String username1="Rishabh";
        String password1="rishabh1599";
        if(username1.equals(request.getParameter("Ausername")) && password1.equals(request.getParameter("Apassword"))){
            RequestDispatcher rd= req.getRequestDispatcher("Admin.html");
            rd.forward(request,response);
        }
        else{
            pw.println("<center><h1>Invalid Login Credentials</h1><center>");
            RequestDispatcher rd=req.getRequestDispatcher("Alogin.html");
            rd.include(request,response);
        }
%>