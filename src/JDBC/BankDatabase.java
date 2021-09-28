package JDBC;
import java.sql.*;

public class BankDatabase {
    public static Connection con=null;
    public static void main(String args[]) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank","root","root");
            if(con!=null)
                System.out.println("Yes connected");

            Statement stmt=con.createStatement();
            String q1="create table if not exists Account(AccountNumber int not null auto_increment,UserName varchar(255)," +
                    "AadharNumber varchar(12),Balance int,Primary key(AccountNumber))";
            stmt.addBatch(q1);

            q1="create table if not exists Transaction(TransactionId int not null Auto_Increment,AccountNumber int,TransactionType Varchar(50)," +
                    "Amount int,Date timestamp,Status varchar(50),Primary Key(TransactionId),Foreign Key(AccountNumber) references Account(AccountNumber))";
            stmt.addBatch(q1);

            q1="create table if not exists Products(ProductId int not null Auto_Increment,AccountNumber int,AccountType varchar(50)," +
                    "Primary Key(ProductId),Foreign Key(AccountNumber) references Account(AccountNumber))";
            stmt.addBatch(q1);

            q1="create table if not exists Addons(Id int not null auto_increment Primary Key,ProductId int,AccountSubType varchar(255)," +
                    "Foreign Key(ProductId) references Products(ProductId))";
            stmt.addBatch(q1);

            stmt.executeBatch();

        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            con.close();
        }
    }
}
