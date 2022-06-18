package com.member.hp;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import com.common.DBConnPool;

public class MemberDAO extends DBConnPool{  //DB 연결
	
	//MemberDAO에서 객체를 리턴하는 메소드 
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance; 
	}
	
	public MemberDAO () {super(); };
	
	// 1. joinMember : 회원가입
	public int joinMember(MemberDTO dto) {
			
		int succ = 0;
		// SQL 문장 작성
		String sql = "INSERT INTO boardMember VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			//Form에서 넘겨받은 Password를 DB에 저장할때 암호화 
				//orgPass : Form에서 넘겨 받은 password
			String orgPass = dto.getMember_pw();
		
			//인코딩
			byte[] targetBytes = orgPass.getBytes();
			Encoder encoder =Base64.getEncoder();
			byte[] encodedBytes = encoder.encode(targetBytes);
			String encodedTxt = new String(encodedBytes);

				//  PreapareStatement 설정
			
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getMember_id());
				ps.setString(2, encodedTxt);	// 암호화된 비밀번호 저장
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
				System.out.println("회원가입 예외 발생!" + e);
				
			} finally {
				// instance.close();
			}

			return succ;
			
		} 	//joinMember() 종료
		
		// 2.  isMember : 회원 여부 : 폼에서 넘겨 받은 ID와 비밀번호를 DB를 통해 확인.
			// 사용자 인증처리, DB의 정보를 수정할때 , DB의 정보를 삭제 할때. 
			// 사용자 인증 (MemberCheck.jsp) 에서 사용하는 메소드
		public int isMember(String member_id, String member_pw) {
			
			int result = -1; 
				//result = -1  : 아이디가 존재하지 않음  
			  	//result = 0   : 아이디는 존재하지만 패스워드가 일치 하지 않을때 
			  	//result = 1   : 인증 성공
			
			//복호화 : 암호화된 Password를 암호흘 해독된 Password로 변환 
			
			try {
				
				String orgPass = member_pw;    //폼에서 넘어오는 패스워드 
				
				String sql = "SELECT member_pw FROM boardMember WHERE member_id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, member_id);
				rs = ps.executeQuery();
				
				if(rs.next()) {	//아이디가 존재시
					
					String dbpasswd = rs.getString("member_pw");     //DB에서 가져온 패스워드 
					
					Decoder decoder = Base64.getDecoder();
					byte[] decodedBytes = decoder.decode(dbpasswd);
					String decodedTxt = new String(decodedBytes);		
					
					if (orgPass.equals(decodedTxt)) {	// DB에서 가져온 비밀번호를 디코딩 후 비교
						result = 1;  // 폼에서 넘겨온 패스워드와 DB에서 가져온 패스워드가 일치 할때 x: 1 
					} else {
						result = 0;   // 패스워드가 일치하지 않을때 
					}

				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				System.out.println("아이디와 패스워드 인증에 실패 했습니다." + e);
				
			} finally {
				// instance.close();
			}
			
			return result;
			
		} 	//isMember() 종료
		
		//3. 아이디 중복 체크 (confirmId.jsp) : 아이디 중복을 확인하는 메소드 
		public int confirmID (String member_id) {
			int result = -1; 
			//x = -1 일때 : 같은 ID가 DB에 존재하지 않음
			//x = 1 일때 : 같은 ID 가 DB에 존재 한다. (중복)
			
			try {
				String sql = "SELECT member_id FROM boardMember WHERE member_id = ?" ;
				ps = conn.prepareStatement(sql);
			
				System.out.println(sql);
				
				ps.setString(1, member_id);
				rs = ps.executeQuery();
				
				if ( rs.next()) { 	// 아이디가 DB에 존재하는 경우
				
					System.out.println(member_id + "는 DB에 존재하는 ID 입니다.");
					result = 1;
					
				} else {  			// 아이디가 DB에 존재하지 않는 경우
					
					System.out.println(member_id + " 는 DB에 존재하지 않는 ID 입니다. ");
					result = -1 ; 
				}
			
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ID 중복 체크중 예외 발생" + e);
			} finally {
				// instance.close;
			}
			return result;
			
		}	// confirmID () 종료
					
		// 4. 회원정보 수정 (modifyForm.jsp) : DB에서 회원 정보의값을 가져오는 메소드 	: 당장 안쓰지만 추후 추가 가능 
		
		public MemberDTO getMember (String member_id, String member_pw) {
			MemberDTO dto = null;
			
			try {
				//orgPass : Form에서 넘겨 받은 password
				String orgPass = member_pw;
				
				String sql = "SELECT * FROM boardMember WHERE member_id = ?"; 
				ps = conn.prepareStatement(sql); 
				ps.setString(1, member_id);
				rs = ps.executeQuery(); 
				
				if (rs.next() ) {   //해당 아이디가  DB 에 존재한다. 
					String dbpasswd = rs.getString("member_pw");   // DB의 패스워드를 변수에 할당
					
					Decoder decoder = Base64.getDecoder();
					byte[] decodedBytes = decoder.decode(dbpasswd);
					String decodedTxt = new String(decodedBytes);
					// decodedTxt : 디코딩시킨 DB의 패스워드
				
					if ( orgPass.equals(decodedTxt)) {
						// 디코딩된 DB의 패스워드 와 폼에서 넘겨온 패스워드가 같을때 처리할 부분
							//DB에서 select 레코드를 DTO (MemberDTO) 에 Setter주입 해서 값을 반환 
						
						//member 객체 생성 후 DB의 rs 에 저장된 값을 setter 주입후 리턴 
						dto = new MemberDTO();    //
						
					    dto.setMember_id(rs.getString("member_id"));
					    dto.setMember_name(rs.getString("member_name"));
					    dto.setMember_age(rs.getInt("member_age"));
					    dto.setMember_address(rs.getString("member_address"));
					    dto.setMember_tel(rs.getString("member_tel"));
					    dto.setMember_pw(rs.getString("member_pw"));
					    
					} else { 
						//DB의 member_pw 와 폼에서 넘겨온 member_pw가 다를때 처리할 부분 
					}
					
				}
		
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("회원 정보 읽어 오는 중 예외 발생" + e);
			}finally {
				
			}
			return dto; 			
			
		}	// getMember() 종료
		
		// 5. 회원 정보 수정 처리 (update.jsp) 에서 회원정보를 수정 처리하는 메소드
		public int updateMember(MemberDTO dto) {
			int result = -1 ; 	// result = - 1 : 아이디가 DB에 존재 하지 않는 경우 
						 		// result = 0   : 아이디는 존재하고 비밀번호가 틀린 경우 
						 		// result = + 1 : 아이디와 패스워드가 일치 
			
			//ID 와 패스워드 를 확인후 업데이트 진행 . 
			
			try {
				// orgPass : 폼에서 받은 패스워드
				String orgPass = dto.getMember_pw(); 
				System.out.println(orgPass);
				byte[] targetBytes = orgPass.getBytes();
				
				Encoder encoder = Base64.getEncoder();
				byte[] encodedByte =encoder.encode(targetBytes);
				String encoderText = new String(encodedByte);
				
				String sql = "select member_pw from boardMember where member_id = ?" ; 
				ps = conn.prepareStatement(sql); 
				ps.setString(1, dto.getMember_id());
				rs = ps.executeQuery();  
				
				if (rs.next()) {	// 해당 아이디가 DB에 존재한다.
					
						//DTO (member)에서 들어온 값을 DB에 UPDATE 
						       sql = "update boardMember set member_name = ?, member_address = ?, member_tel= ?, member_age = ?, member_pw = ? " ;  
							   sql += " where member_id = ?"; 
							   
						ps = conn.prepareStatement(sql); 
						ps.setString(1, dto.getMember_name());
						ps.setString(2, dto.getMember_address());
						ps.setString(3, dto.getMember_tel());
						ps.setInt(4, dto.getMember_age());
						ps.setString(5, encoderText); 		// 인코딩 시킨 패스워드
						ps.setString(6, dto.getMember_id());
						
						ps.executeUpdate();
						result = 1; 	//update 성공시 result 변수에 1 을 할당. 	
					
					}else {
						result = 0;   //ID는 존재하고 패스워드 일치 하지 않는 경우 
					}
						
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("회원 정보 수정시 예외 발생" + e);
			}finally {
				
			}
						
			return result; 		
			
		}	// updateMember () 종료
			
		
		
		// 6. 회원 탈퇴 처리 ( delete.jsp ) 에서 회원 정보 삭제 메소드 
		public int deleteMember(String member_id, String member_pw) {
			int result = -1;  // result = -1 : 회원 탈퇴 실패 
						 // result = 1 : 회원 탈퇴 성공 
			
			try {
				// orgPass : 폼에서 가져온 패스워드
				String orgPass = member_pw; 
				
				byte[] targetBytes = orgPass.getBytes();
				
				Encoder encoder = Base64.getEncoder();
				byte[] encodedByte =encoder.encode(targetBytes);
				String encoderText = new String(encodedByte);
				
				String sql = "SELECT member_pw FROM boardMember WHERE member_id = ?"; 
				ps = conn.prepareStatement(sql); 
				ps.setString(1, member_id);
				rs = ps.executeQuery(); 
				System.out.println("테스트 : " + member_id);
				
				if (rs.next()) {  //id가 DB에 존재 
					String dbpasswd = rs.getString("member_pw"); 
					
					if (encoderText.equals(dbpasswd)) {	// 폼에서 받은 패스워드를 암호화 후 db의 패스워드와 비교
	
					sql = "delete boardMember where member_id = ?"; 
						
						ps = conn.prepareStatement(sql); 
						ps.setString(1, member_id);
						ps.executeUpdate(); 
						result = 1;     //delete 성공시 								
					}		
				}
						
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("회원 탈퇴시 예외가 발생 했습니다");
			} finally {
				
			}
			return result; 			// 성공시 x = 1, 실패시 x= -1
		}	// deleteMember() 종료
		
} 	//class 종료
