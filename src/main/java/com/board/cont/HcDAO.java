package com.board.cont;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.common.DBConnPool;


public class HcDAO extends DBConnPool {
	
	//기본 생성자 호출시 부모 클래스를 호출
	public HcDAO() {
		super();		//DBConnPoll 객체의 기본 생성자 호출, DBCP에서 con 객체 활성화 ㅋㅋ
	}
	//검색 조건에 맞는 게시물 갯수를 반환한다.
	public int selectCount(Map<String,Object> map) {
		
		int totalCount=0;
		String query = "SELECT COUNT(*) FROM hpboard";	//레코드의 총갯수 반환,
		
		if(map.get("searchWord")!= null) {				//검색기능을 사용했을시 Where
			query += " WHERE " + map.get("searchField") + " " + "like '%" + map.get("searchWord") + "%'";
		}
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
			
		}catch(SQLException e) {
			System.out.println("게시물 카운트중 예외 발생");
			e.printStackTrace();
		}
		
		
		
		return totalCount;	//게시물 갯수를 서블릿으로 반환
		
	}
	
	
	//검색 조건에 맞는 게시물 목록을 반환한다.
		//DB에서 Select 한 결과 값을 DTO에 담아서 리턴 시켜줌 
	public List<HcDTO> selectListPage(Map<String,Object> map){
		List<HcDTO> board = new Vector<HcDTO>();
		String query = " "
				+ "SELECT * FROM ( " 
				+ "SELECT Tb.*, ROWNUM rNUM FROM ( "
				+ " SELECT * FROM hpboard ";
		if(map.get("searchWord")!=null) {	//검색기능을 사용했다라면 
			query += " WHERE " + map.get("searchField")
					+" LIKE '%" + map.get("searchWord") + "%'";
			
		}
		
		query += " ORDER BY idx DESC"
				+" ) Tb"
				+") "
				+ "WHERE rNUM BETWEEN ? AND ?";
		
		try {	//psmt 객체 생성후 쿼리 실행
			ps = conn.prepareStatement(query);	//PreparedStatement 객체 생성
			ps.setString(1, map.get("start").toString());
			ps.setString(2, map.get("end").toString());
			rs= ps.executeQuery(); //DB에서 Select한 결과값을 rs에 저장
			
			//rs의 저장돈 값을 DTO에 저장 ==> DTO 객체를 List에 add
			while(rs.next()) {
				HcDTO dto = new HcDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
				
				board.add(dto);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return board;	//board 는 DTO 객체를 저장하고 있다.
		
	}
	
	
	
	
	//목록 검색 (Select)	:주어진 일련번호에 해당 하는 값을 DTO에 담아 반환한다.(한 페이지 read)
	//ViewController 요청을 처리
	
	public HcDTO selectView(String idx) {
		HcDTO dto = new HcDTO();
		String query = "SELECT * FROM hpboard WHERE idx=?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, idx);
			rs= ps.executeQuery();
			
			if(rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
				
			}
			
			
		}catch(SQLException e) {
			System.out.println("게시물 상세보기중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	
	//주어진 일련 번호에 해당하는 게시물의 조회수를 1씩 증가시켜줌 
	public void updateVisitCount(String idx) {
		String query ="UPDATE hpboard SET visitcount= visitcount+1 WHERE idx=?";
		
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, idx);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외발생");
			e.printStackTrace();
		}
	}
	
	
	
	
	//다운로드 카운트 증가
	public void downCountPlus(String idx) {
		String sql = "UPDATE hpboard SET downcount= downcount+1 WHERE idx=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	//비밀번호를 확인 하는 메소드 (입력한 비밀 번호가 DB의 값과 일치하는지 확인)
	public boolean confirmPassword(String pass, String idx) {
		boolean isCorr = true;
		
		try {
			
			//COUNT(*) =1 : 레코드가 존재하면 : Client에서 넘긴 pass값과 idx값이 DB에 존재
			//COUNT(*) =0 : 레코드가 존재하지 않으면 Client에서 넘긴값이 DB에 존재하지 않는것 
			String query = "SELECT COUNT(*) FROM hpboard WHERE pass=? and idx=?";
			ps= conn.prepareStatement(query);
			ps.setString(1, pass);
			ps.setString(2, idx);
			rs = ps.executeQuery();
			rs.next();
			if(rs.getInt(1) == 0) {
				isCorr =false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("비밀번호가 일치하지 않습니다");
		}
		
		
		
		return isCorr;
		
		
		
	}
	
	
	
	
	
	
	//데이터 삽입 (Insert)
	
	public int insertWrite(HcDTO dto) {
		int result =0;
		
		try {
			String query ="INSERT INTO hpboard(idx,name,title,content,ofile,sfile,pass)"
					+ " VALUES (seq_board_num.nextval,?,?,?,?,?,?) ";
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getOfile());
			ps.setString(5, dto.getSfile());
			ps.setString(6, dto.getPass());
			
			result=ps.executeUpdate(); //insert가 성공일때 result는 0보다 큰 값이 저장됨	//DB에 값을 저장
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;	//result : Insert 성공시 0> , 실패시 : 0
	}
	
	//데이터 수정 (Update)
	public int updatePost(HcDTO dto) {
		int result =0;
		
		try {
			
			String query ="UPDATE hpboard SET title=?, name=?, content=?, ofile=?, sfile=? "
						+" WHERE idx=? and pass=?";
			
			ps= conn.prepareStatement(query);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getOfile());
			ps.setString(5, dto.getSfile());
			ps.setString(6, dto.getIdx());
			ps.setString(7, dto.getPass());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update 중 예외발생");
		}
		
		return result;	//result : Insert 성공시 0> , 실패시 : 0
	}
	
	//데이터 삭제 (Delete)
	public int deletePost(String idx ) {
		int result =0;
		try {
			String query ="DELETE FROM hpboard WHERE idx =?";
			ps = conn.prepareStatement(query);
			ps.setString(1, idx);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패했습니다");
		}
		
		return result;	//result : Insert 성공시 0> , 실패시 : 0
	}
	
	
	
	
	

}
