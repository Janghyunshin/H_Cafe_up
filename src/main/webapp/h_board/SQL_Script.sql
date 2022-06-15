


CREATE TABLE hpboard (
    idx NUMBER PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    postdate DATE DEFAULT sysdate NOT NULL,
    ofile VARCHAR2(200),
    sfile VARCHAR2(50),
    downcount NUMBER(5) DEFAULT 0 NOT NULL,
    pass VARCHAR2(50) NOT NULL,
    visitcount NUMBER DEFAULT 0 NOT NULL
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
    