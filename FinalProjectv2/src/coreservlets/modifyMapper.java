package coreservlets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class modifyMapper implements modifyService {

	public modifyBean mod1(String emplid, String uID, String passWord, String date){
		
		modifyBean coursebean = new modifyBean();
		ArrayList<String> ArrayListCourse = new ArrayList<String>();
		//
         
      
         
		 //String sqlstr2 = "INSERT INTO [CUNY_DB].[dbo].[TimeSheetTbl] VALUES (" + "'" +emplid + "'"+  ","  + "'" + starttime +"'" +"," + "'" + endtime+ "'" + "," + "'" + paytype +"'"  + ")";
         //String sqlstr = "SELECT * FROM [CUNY_DB].[dbo].[TimeSheetTbl]";
		 String sqlstr = "select t.StartTime, t.EndTime, t.PayTypeID from dbo.TimeSheetTbl as t where t.EmpID = "+emplid;
 		 if( emplid!= null){
				try {
					MyDButil db = new MyDButil();
					ResultSet resultset = db.getQuery(sqlstr, uID, passWord);
					//ResultSet resultset2 = db.getQuery(sqlstr2);
		
					while(resultset.next()){
	
					    ArrayListCourse.add( resultset.getString(1)+ resultset.getString(2)+ resultset.getString(3));
					  //  ArrayListType.add(resultset2.getString(1)+ resultset2.getString(2));
					
						System.out.println("Mapping");				
						
					}
		
					System.out.println("It worked!");
					coursebean.setInfo(ArrayListCourse);
					//resultset2.close();
					resultset.close();
					db.closeConn();
					
					
				} catch (ClassNotFoundException | SQLException e) {
								
				     e.printStackTrace();     
				}
				
				return coursebean;				
			} else{
				return (null);
			}
		
		
		
		
		
	}

}