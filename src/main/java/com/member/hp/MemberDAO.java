package com.member.hp;

import java.util.ArrayList;

import com.board.action.DBConnPool;

public class MemberDAO extends DBConnPool{
//	private Connection conn;
//	private PreparedStatement ps;
//	private ResultSet rs;
//	
//	public Connection getConn() {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String id = "hr2";
//		String pwd = "1234";
//		try {
//			//Class.forName("oracle.jdbc.driver.OracleDriver");
//			Class.forName("oracle.jdbc.OracleDriver");
//			conn = DriverManager.getConnection(url, id, pwd);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("getConn() Exception!!!");
//		}
//		return conn;
//		
//	} 	//getConn()
	
		//joinMember : 회원가입
//		public boolean joinMember(MemberDTO dto) {
		public int joinMember(MemberDTO dto) {
			//① 접속
			
			//② SQL 문장 작성
			String sql = "INSERT INTO boardMember VALUES (?, ?, ?, ?, ?, ?)";
			int succ = 0;
			
			//③ try-catch 블록 작성 후 PreapareStatement 설정
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getMember_id());
				ps.setString(2, dto.getMember_pw());
				ps.setString(3, dto.getMember_name());
				ps.setInt(4, dto.getMember_age());
				ps.setString(5, dto.getMember_address());
				ps.setString(6, dto.getMember_tel());
				succ = ps.executeUpdate();
				
				if(succ != 0) {
					return 1;   // 회원가입 성공시
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("joinMember() Exception!!!");
			} finally {
				dbClose();
			}
			return succ;	
		} //joinMember()
		
		//isMember : 회원 여부
		public int isMember(MemberDTO dto) {
			String sql = "SELECT member_pw FROM boardMember WHERE member_id = ?";
			int result = -1;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getMember_id());
				rs = ps.executeQuery();
				
				if(rs.next()) {	//아이디 존재
					if(rs.getString("member_pw").equals(dto.getMember_pw())) {
						result = 1;	//비밀번호 일치
					} else {
						result = 0;	//비밀번호 불일치
					}
				} else {	//아이디가 존재하지 않는다
					result = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("isMember() Exception!!!");
			} finally {
				dbClose();
			}
			return result;
		} //isMember()
		
		//전체 회원 검색
		public ArrayList<MemberDTO> getAllMember() {
			String sql = "SELECT * FROM boardMember";
			ArrayList<MemberDTO> list = new ArrayList<>();
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					//하나씩 받아오는 방법도 있다.
					//String member_id = rs.getString("member_id");
					MemberDTO dto = new MemberDTO();
					dto.setMember_id(rs.getString("member_id"));
					dto.setMember_pw(rs.getString("member_pw"));
					dto.setMember_name(rs.getString("member_name"));
					dto.setMember_age(rs.getInt("member_age"));
					dto.setMember_address(rs.getString("member_address"));
					dto.setMember_tel(rs.getString("member_tel"));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getAllMember() Exception!!!");
			} finally {
				dbClose();
			}
			return list;
		} //getAllMember()
		
		//회원 삭제
		public void deleteMember(String member_id) {
			String sql = "DELETE FROM boardMember WHERE member_id = ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, member_id);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("deleteMember() Exception!!!");
			} finally {
				dbClose();
			}
		} //deleteMember()
		
		//특정 회원 검색
		public MemberDTO getDetailMember(String member_id) {
			String sql = "SELECT * FROM boardMember WHERE member_id = ?";
			MemberDTO dto = null;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, member_id);
				rs = ps.executeQuery();
				if(rs.next()) {
					dto = new MemberDTO();
					dto.setMember_id(rs.getString("member_id"));
					dto.setMember_pw(rs.getString("member_pw"));
					dto.setMember_name(rs.getString("member_name"));
					dto.setMember_age(rs.getInt("member_age"));
					dto.setMember_address(rs.getString("member_address"));
					dto.setMember_tel(rs.getString("member_tel"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getDetailmember() Exception!!!");
			} finally {
				dbClose();
			}
			return dto;
		} //getDetailMember()
		
		//비밀번호 검색
		public String getMember_pw(String id) {
			String sql = "SELECT member_pw FROM boardMember WHERE member_id = ?";
			String member_pw = null;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					member_pw = rs.getString("member_pw");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getMember_pw() Exception!!!");
			} finally {
				dbClose();
			}
			return member_pw;
		} //getMember_pw()
		
		//회원 정보 수정
		public int updateMember(MemberDTO dto) {
			String sql = "UPDATE boardMember SET member_pw = ?, member_name = ?,";
			sql += " member_age = ?, member_address = ?, member_tel = ? WHERE member_id = ?";
			int succ = 0;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getMember_pw());
				ps.setString(2, dto.getMember_name());
				ps.setInt(3, dto.getMember_age());
				ps.setString(4, dto.getMember_address());
				ps.setString(5, dto.getMember_tel());
				ps.setString(6, dto.getMember_id());
				succ = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("updateMember() Exception!!!");
			} finally {
				dbClose();
			}
			return succ;
		} //updateMember()
	

		
		//DB 종료
		public void dbClose() {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("dbClose() Exception!!!");
			}
		} //dbClose()
	
} 	//class
