package JDBC;
import java.sql.*;
public class DBConnection{
    public static Connection con=null;
    public static void main(String args[])throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db1","root","root");
            if(con!=null)
                System.out.println("dfgh");
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Create table if not exists student(name varchar(50),age int,degree varchar(40))");
            stmt.executeUpdate("insert into student values(\"Karnakar\",21,\"B.tech\")");
            ResultSet rs=stmt.executeQuery("select * from student");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            con.close();
        }
    }
}
