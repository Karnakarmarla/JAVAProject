package JDBC;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;
public class BankOperations {
    public static Connection con=null;
    public static void main(String args[]) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank", "root", "root");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 for Account creation , 2 for Transaction");
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println("Enter Account Type");
                String accountType = sc.next();
                sc.nextLine();
                System.out.println("Enter Account Holder name");
                String name = sc.nextLine();
                System.out.println("Enter Aadhar Number");
                String aadhar = sc.next();
                System.out.println("Enter initial balance");
                int balance = sc.nextInt();
                System.out.println("Enter Account subtypes");
                sc.nextLine();
                String subTypes[] = sc.nextLine().split(",");
                createAccount(accountType,name,aadhar,balance,subTypes);
            }
            else {
                System.out.println("Enter Account Number");
                int accountNumber=sc.nextInt();
                System.out.println("Enter transacion type as deposit or withdrawal");
                String tranxType = sc.next();
                System.out.println("Enter amount");
                int amount = sc.nextInt();
               doTransaction(accountNumber,tranxType,amount);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            con.close();
        }
    }

    public static void createAccount(String accountType,String name,String aadhar,int balance,String subTypes[]) throws SQLException {

        String q1 = "Insert into Account(UserName,AadharNumber,Balance) values(?,?,?)";
        PreparedStatement p1 = con.prepareStatement(q1, PreparedStatement.RETURN_GENERATED_KEYS);
        p1.setString(1, name);
        p1.setString(2, aadhar);
        p1.setInt(3, balance);
        p1.executeUpdate();
        ResultSet rs=p1.getGeneratedKeys();
        int accountNumber = 0;
        if(rs.next())
            accountNumber=rs.getInt(1);

        q1 = "Insert into Products(AccountNumber,AccountType) values(?,?)";
        PreparedStatement p2 = con.prepareStatement(q1, PreparedStatement.RETURN_GENERATED_KEYS);
        p2.setInt(1, accountNumber);
        p2.setString(2, accountType);
        int productId=0;
        p2.executeUpdate();
        rs=p2.getGeneratedKeys();
        if(rs.next())
            productId=rs.getInt(1);

        q1 = "Insert into Addons(ProductId,AccountSubType) values(?,?)";
        PreparedStatement p3 = con.prepareStatement(q1);
        for (int i = 0; i < subTypes.length; i++) {
            p3.setInt(1, productId);
            p3.setString(2, subTypes[i]);
            p3.executeUpdate();
        }

    }

    public static void doTransaction(int accountNumber,String tranxType,int amount) throws SQLException {
        String q1 = "select Balance from Account where AccountNumber=?";
        PreparedStatement p4 = con.prepareStatement(q1);
        p4.setInt(1, accountNumber);
        String q2 = "Update Account set Balance=? where AccountNumber=?";
        PreparedStatement p5 = con.prepareStatement(q2);

        String status="Failed";
        if (tranxType.equalsIgnoreCase("deposit")) {
            ResultSet rs = p4.executeQuery();
            if (rs.next()) {
                int bal = rs.getInt(1) + amount;
                p5.setInt(1, bal);
                p5.setInt(2, accountNumber);
                int flag=p5.executeUpdate();
                if(flag!=0)
                    status="success";
            }
        }
        else {
            ResultSet rs = p4.executeQuery();
            if (rs.next()) {
                int bal = rs.getInt(1);
                if (bal < amount)
                    System.out.println("Insufficient Funds");
                else {
                    bal=bal-amount;
                    p5.setInt(1, bal);
                    p5.setInt(2, accountNumber);
                    int flag=p5.executeUpdate();
                    if(flag!=0)
                        status="success";
                }
            }

        }
        q2="Insert into Transaction(AccountNumber,TransactionType,Amount,Date,Status) values(?,?,?,?,?)";
        p5= con.prepareStatement(q2);
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentTime = calendar.getTime();
        long time = currentTime.getTime();
        p5.setInt(1,accountNumber);
        p5.setString(2,tranxType);
        p5.setInt(3,amount);
        p5.setTimestamp(4, new Timestamp(time));
        p5.setString(5,status);
        p5.executeUpdate();

    }
}
