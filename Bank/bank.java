import java.sql.*;
import java.io.*;
class bank
{
public static void main(String args[])
{
try
{
int ch;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:bankdata","","");
Statement st=con.createStatement();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
do
{
System.out.println("n 1.Display Table\n2.Deposit Amount \n3.Withdraw\n4.Transfer Amount\n5.Quit");
System.out.println("\n Enter your choice:");
ch=Integer.parseInt(br.readLine());
switch(ch)
{
case 1:ResultSet rs=st.executeQuery("select *from EMPLOYEE");
System.out.println("\nAccno\tName\tBalance");
while(rs.next())
{
String a=rs.getString("Accno");
String n=rs.getString("Name");
String b=rs.getString("Balance");
System.out.println("\n"+a+"\t"+n+"\t"+b);
}
break;
case 2:
System.out.println("Enter the AC No.to be deposited:");
int a1=Integer.parseInt(br.readLine());
System.out.println("\nEnter the amount to be deposited:");
int b1=Integer.parseInt(br.readLine());
st.executeUpdate("update EMPLOYEE set Balance=b1 where Accno=a1");
break;
case 3:System.out.println("enter the accno to be withdrawn");
int a3=Integer.parseInt(br.readLine());
System.out.println("enter the amount to withdraw");
int b3=Integer.parseInt(br.readLine());
ResultSet ba=st.executeQuery("select Balance from EMPLOYEE where Accno=a3");
int c=0;
while(ba.next())
{
c=Integer.parseInt(ba.getString("Balance"));
}
if(b3>c)
{
System.out.println("customer have insufficient balance");
System.out.println("customer balance="+c);
}
else
{
st.executeUpdate("update EMPLOYEE set Balance=Balance-b3 where Accno=a3");
}
break;
case 4:
System.out.println("enter the accno to withdraw amount");
int a5=Integer.parseInt(br.readLine());
System.out.println("enter the amount to withdraw");
int b5=Integer.parseInt(br.readLine());
ResultSet ba1=st.executeQuery("select Balance from EMPLOYEE where Accno=a5");
int c1=0;

while(ba1.next())
{
c1=Integer.parseInt(ba1.getString("Balance"));
}
if(b5>c1)
{
System.out.println("customer have insufficient balance");
System.out.println("customer balance="+c1);
}
else
{
	st.executeUpdate("update EMPLOYEE set Balance=Balance-b5 where Accno=a5");
	System.out.println("Enter accno to deposite amount");
	int a6=Integer.parseInt(br.readLine());
	st.executeUpdate("update EMPLOYEE set Balance=Balance+b5 where Accno=a6");
}
break;
case 5:
break;
default:
System.out.println("wrong choice");
}
}
while(ch<=4);
con.close();
}
catch(Exception e)
{
}
}
}

 