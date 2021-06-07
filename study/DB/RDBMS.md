# SQL query 기초 
## SELECT 컬럼명 FROM 테이블명 
테이블에서 특정 컬럼을 읽어옴 
컬럼 명에 *를 넣어서 전체를 불러올 수 있음
## SELECT 컬럼명 FROM 테이블명 WHERE 컬럼명=값
테이블에서 WHERE이하 조건의 컬럼만 읽어옴
## SELECT 컬럼명 FROM 테이블명 WHERE 컬럼명=값 ORDER BY 컬럼명 ASC, DESC
테이블에서 WHERE이하 조건을 만족하는 컬럼 중에서 ORDER BY에 의해 지정된 컬럼의 오름 내림차순으로 정렬하여 읽어옴
## SELECT 컬럼명 FROM 테이블명 WHERE 컬럼명=값 ORDER BY 컬럼명 ASC, DESC LIMIT 개수
LIMIT수 만큼의 데이터를 불러옴
## INSERT INTO 테이블명 (컬럼명1, 컬럼명2, 컬럼명3) VALUES (값1, 값2, 값3)
테이블의 컬럼에 값을 삽입 
```
ex. INSERT INTO table_Student (Name, Class, Age) VALUES ('Jane','A',16);
```
## INSERT INTO 테이블명 VALUES (값1, 값2, 값3)
테이블에 값을 삽입, 컬럼 수에 맞게 값을 입력해야 함
## UPDATE 테이블명 SET 컬럼명 = 변경할 값
테이블에 있는 모든 데이터의 컬럼의 값을 변경.  
특정한 데이터만 수정하고 싶다면 WHERE절을 사용
## UPDATE 테이블명 SET 컬럼명 = 변경할 값 WHERE 컬럼명=값
WHERE절에 맞는 데이터만 변경
## UPDATE 테이블명 SET 컬럼명1 = 변경할 값1,컬럼명2 = 변경할 값2 WHERE 컬럼명=값
변경해야할 컬럼이 여러개일 때 콤마(,)를 사용하여 여러개의 값을 변경
## DELETE from 테이블명
테이블에 있는 모든 데이터를 삭제 
## DELETE from 테이블명 WHERE 컬럼명=값
WHERE절에 맞는 데이터만 삭제
## CREATE TABLE
테이블 생성
``` 
CREATE TABLE 조건 테이블 이름 (
    컬럼명 데이터타입 조건, 
    ...
)
```