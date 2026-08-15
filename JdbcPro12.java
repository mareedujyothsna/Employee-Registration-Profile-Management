package com.pack1;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

//task==>lect-18
public class JdbcPro12 
{
	String driver="oracle.jdbc.OracleDriver";
	String DBUrl="jdbc:oracle:thin:@localhost:1521:orcl";
	String DBUname="system";
	String DBPwd="Your_oracle_password";
	
	String query="update EmployeeRegistrationss set  EADDRESS=? where EID=?";
	String query2="update EmployeeRegistrationss set EPHN=? where EID=?";
	
	Scanner sc=new Scanner(System.in);
	Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(DBUrl,DBUname,DBPwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	void Registration()
	{
		System.out.println("Welcome to Employees Registrations and Logins portal");
		try
		{
			Connection con=connect();
			CallableStatement cstmt=con.prepareCall("{call RegisterData(?,?,?,?,?,?,?)}");
			CallableStatement cstmt2=con.prepareCall("{call ReteriveData(?,?,?,?,?,?,?)}");
			PreparedStatement prstmt1=con.prepareStatement(query);
			PreparedStatement prstmt2=con.prepareStatement(query2);
			
			/*
			 //creating procedure for out //in sql
			
			create or replace procedure RegisterData
			(id number,passw varchar2,efname varchar2,elast varchar2,eadd varchar2,email varchar2,phn varchar2) is
			begin
			  insert into EmployeeRegistrationss values(id,passw,efname,elast,eadd,email,phn);
		    end;
			/
			  //to reterive emp data by id,pwd
			  
			create or replace procedure ReteriveData
			(id number,passw OUT varchar2,efname OUT varchar2,elast OUT varchar2,eadd OUT varchar2,email OUT varchar2,phn OUT varchar2) is
			begin
			  select EFNAME,ELNAME,EADDRESS,EMAILID,EPHN into efname,elast,eadd,email,phn from EmployeeRegistrationss where EID=id AND EPWD=passw;
			end;
			/ 
			 
			  
		create or replace procedure ReteriveData
		(p_id IN number,p_passw IN varchar2,efname OUT varchar2,elast OUT varchar2,eadd OUT varchar2,email OUT varchar2,phn OUT varchar2) is
		begin
		   select EFNAME,ELNAME,EADDRESS,EMAILID,EPHN into efname,elast,eadd,email,phn from EmployeeRegistrationss where EID=p_id AND EPWD=p_passw;
		end;
		/ 
		 
		*/
			System.out.println("Are u already registered??");
			System.out.println("Y/N");
			char result=sc.next().charAt(0);
			if(result=='Y' || result=='y')
			{
				System.out.println("Enter employee id to Login: ");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter password: ");
				String pas=sc.nextLine();
				
				int input;
				while(true)
				{
					System.out.println("\n1.View Profile \n"+"2.Update Profile \n"+"3.Exit");
					input=sc.nextInt();
					
					switch(input)
					{
					  	case 1:
					  	{ 
					  		System.out.println("Login Portal");
					  		System.out.println("Employer Profile\n");
							cstmt2.setInt(1,id);
							cstmt2.setString(2, pas);
							cstmt2.registerOutParameter(3,Types.VARCHAR);
							cstmt2.registerOutParameter(4,Types.VARCHAR);
							cstmt2.registerOutParameter(5,Types.VARCHAR);
							cstmt2.registerOutParameter(6,Types.VARCHAR);
							cstmt2.registerOutParameter(7,Types.VARCHAR);
							
							cstmt2.execute();
							
							System.out.println("User Found: ");
							System.out.println("Employee Data");
							System.out.println("Employee id: "+id);
							System.out.println("Employee pass: "+pas);
							System.out.println("Employee first name: "+cstmt2.getString(3));
							System.out.println("Employee last name: "+cstmt2.getString(4));
							System.out.println("Employee Address: "+cstmt2.getString(5));
							System.out.println("Employee Mail Id: "+cstmt2.getString(6));
							System.out.println("Employee Phone number: "+cstmt2.getString(7));
							break;
					  	}
					  	case 2:
					  	{
					  		System.out.println("To Update Employee Profile");
					  		System.out.println("Enter the employee id which you want to update: ");
					  		int eid=sc.nextInt();
					  		
					  		sc.nextLine();
					  		
					  		System.out.println("Enter the Address you want to update: ");
					  		String ad=sc.nextLine();
					  		System.out.println("Enter the Phone number you want to update: ");
					  		String ph=sc.nextLine();
					  		
					  		prstmt1.setString(1, ad);
					  		prstmt1.setInt(2, eid);
					  		
					  		prstmt2.setString(1,ph);
					  		prstmt2.setInt(2, eid);
					  		
					  		prstmt1.execute();
					  		prstmt2.execute();
					  		
					  		System.out.println("Your Updated data: ");
					  		System.out.println("Employee id: "+eid);
					  		System.out.println("Employee Address: "+ad);
					  		System.out.println("Employee Phone number: "+ph);
					  		break;
					  	}
					  	case 3:
					  	{
					  		System.out.println("Thank you! Exiting the application...");
					  		System.exit(0);
					  	}
					  	default:
					  	{
					  		System.out.println("Invalid option. Please try again.");
					  	}
					}
				}
			}
			else
			{
				//to register
				System.out.println("Employee Registration Portal\n");
				System.out.println("Enter Employee ID to register: ");
				int eid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter pass: ");
				String epass=sc.nextLine();
				System.out.println("Enter employee First name: ");
				String efirst=sc.nextLine();
				System.out.println("Enter employee Last name: ");
				String elname=sc.nextLine();
				System.out.println("Enter Employee Address: ");
				String eadd=sc.nextLine();
				System.out.println("Enter Employee mail id: ");
				String mail=sc.nextLine();
				System.out.println("Enter Employee Phone number: ");
				String ph=sc.nextLine();
				
				cstmt.setInt(1, eid);
				cstmt.setString(2, epass);
				cstmt.setString(3,efirst);
				cstmt.setString(4,elname);
				cstmt.setString(5, eadd);
				cstmt.setString(6, mail);
				cstmt.setString(7, ph);
				
				cstmt.execute();
				
				System.out.println("User Successfully registered");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		JdbcPro12 obj=new JdbcPro12();
		obj.Registration();
	}
	
}
