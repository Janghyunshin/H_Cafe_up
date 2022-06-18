

--테이블 생성
CREATE TABLE boardMember(
    Member_id VARCHAR2(15) PRIMARY KEY NOT NULL, 	-- ID
    Member_pw VARCHAR2(15) NOT NULL,				-- 비밀번호
    Member_name VARCHAR2(15),						-- 이름
    Member_age NUMBER,								-- 나이
    Member_address VARCHAR2(30),					-- 주소
    Member_tel VARCHAR2(30),						-- 전화번호
);

--테이블 조회
SELECT * FROM boardMember;

drop table boardMember;