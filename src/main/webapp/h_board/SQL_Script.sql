


CREATE TABLE hpboard (
    idx NUMBER PRIMARY KEY,						-- 번호
    name VARCHAR2(50) NOT NULL,					-- 이름
    title VARCHAR2(200) NOT NULL,				-- 제목
    content VARCHAR2(2000) NOT NULL,			-- 내용
    postdate DATE DEFAULT sysdate NOT NULL,		-- 게시일
    ofile VARCHAR2(200),						-- 첨부파일명
    sfile VARCHAR2(50),							-- 바뀐이름
    downcount NUMBER(5) DEFAULT 0 NOT NULL,		-- 다운로드 수 
    pass VARCHAR2(50) NOT NULL,					-- 비밀번호
    visitcount NUMBER DEFAULT 0 NOT NULL		-- 조회 수 
);

desc hpboard;

CREATE SEQUENCE seq_hpboard_num
    INCREMENT by 1
    START with 1
    NOCACHE;
    
INSERT INTO hpboard (idx,name,title,content,pass)
VALUES (seq_hpboard_num.nextval, '사용자1','제목1','내용1','1234');


INSERT INTO hpboard (idx,name,title,content,pass)
VALUES (seq_hpboard_num.nextval, '사용자2','제목2','내용2','1234');


INSERT INTO hpboard (idx,name,title,content,pass)
VALUES (seq_hpboard_num.nextval, '사용자3','제목3','내용3','1234');


INSERT INTO hpboard (idx,name,title,content,pass)
VALUES (seq_hpboard_num.nextval, '사용자4','제목4','내용4','1234');


INSERT INTO hpboard (idx,name,title,content,pass)
VALUES (seq_hpboard_num.nextval, '사용자5','제목5','내용5','1234');

SELECT * FROM hpboard;
    