DROP TABLE mem;

CREATE TABLE mem(
id VARCHAR2(20) PRIMARY KEY,
password VARCHAR2(20) NOT NULL,
name VARCHAR2(20) NOT NULL,
birth DATE NOT NULL,
gender VARCHAR2(20) NOT NULL,
cellphone VARCHAR2(20) UNIQUE NOT NULL
);


CREATE SEQUENCE SEQ_mem START WITH 1 INCREMENT BY 1 MAXVALUE 99999 CYCLE NOCACHE;

select * from mem; 

INSERT INTO mem(id,password,name,birth,gender,cellphone) 
VALUES('a','a','a',TO_DATE('1999-08-01', 'YYYY-MM-DD'),'남자','a');

--아이디 찾을떄 sql문
select * from mem where memberid = '';

DELETE mem WHERE idx=2;
