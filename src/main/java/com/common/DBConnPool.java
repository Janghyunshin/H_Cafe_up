package com.common;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnPool {
	
	public Connection conn;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public DBConnPool() {

		try {
			String driver = "oracle.jdbc.driver.OracleDriver"; 
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "hr2","1234" );
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
//		try {
//			//톰캣에 설정한 커넥션 풀 (DBCP) 정보 얻어오기
//			Context initCtx = new InitialContext();
//			Context ctx = (Context)initCtx.lookup("java:comp/env");
//			DataSource source =(DataSource)ctx.lookup("dbcp_myoracle");
//			
//			//커넥션 풀을 통해서 연결 얻기
//			con = source.getConnection();
//			
//			System.out.println("커넥션풀(DBCP) 연결 성공");
//			
//			
//		}catch(Exception e){
//			System.out.println("커넥션풀(DBCP) 연결 실패");
//			e.printStackTrace(); 					//오류 메세지 출력 : 자세한 정보 출력
//			System.out.println(e.getMessage());		// 오류 메세지 출력 : 간략 정보 출력
//		} 
	}
	
	//자원 연결 해제 (자원 반납) : close() 메소드 호출시 자원을 반납하도록 설정
	public void close() {
		
			try {
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();	//자원을 커넥션 플로 반납됨
				
				System.out.println("DB 커넥션 풀 자원 반납");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
