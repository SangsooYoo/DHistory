# SQL query 기초 
## SELECT 컬럼명 FROM 테이블명 
테이블에서 특정 컬럼을 읽어옴  
컬럼 명에 *를 넣어서 전체를 불러올 수 있음
## WHERE 컬럼명=값
테이블에서 WHERE이하 조건의 컬럼만 읽어옴
* AND/OR으로 여러 조건 추가 가능
```
SELECT * FROM student WHERE status > 0 AND belong = 'IDE'
SELECT * FROM student WHERE status > 0 OR belong = 'IDE';
```
* LIKE 키워드로 regular expression사용가능
```
SELECT * FROM student WHERE _id LIKE '2009%';
```
출처: https://futurists.tistory.com/11?category=587334 [미래학자]

## WHERE  + IN/BETWEEN
AND/OR를 이용한 조건 검색보다 빠른 검색이 가능한 키워드 

* 동일한 결과를 얻지만 BETWEEN이 더 빠름
```
SELECT * FROM student WHERE _id > '2009' AND _id < '2011'; 
SELECT * FROM student WHERE _id BETWEEN '2009' AND '2011';
```
* 동일한 결과를 얻지만 IN이 더 빠름  
```
SELECT * FROM student WHERE belong = 'MSE' OR belong = 'ESE' OR belong = 'CSE'; 
SELECT * FROM student WHERE belong IN ('MSE', 'ESE', 'CSE');
```

출처: https://futurists.tistory.com/12?category=587334 [미래학자]


## ORDER BY 컬럼명 ASC, DESC
테이블에서 WHERE이하 조건을 만족하는 컬럼 중에서 ORDER BY에 의해 지정된 컬럼의 오름 내림차순으로 정렬하여 읽어옴
```
SELECT * FROM student ORDER BY _id;
```

## LIMIT 
LIMIT수 만큼의 데이터를 불러옴
```
SELECT 컬럼명 FROM 테이블명 WHERE 컬럼명=값 ORDER BY 컬럼명 ASC, DESC LIMIT 개수
```
## INSERT INTO 
테이블의 컬럼에 값을 삽입  
테이블에 값을 삽입, 컬럼 수에 맞게 값을 입력해야 함
```
INSERT INTO table_Student (Name, Class, Age) VALUES ('Jane','A',16);
INSERT INTO 테이블명 VALUES (값1, 값2, 값3)
```

## UPDATE
테이블에 있는 모든 데이터의 컬럼의 값을 변경.  
* 특정한 데이터만 수정하고 싶다면 WHERE절을 사용
```
UPDATE 테이블명 SET 컬럼명 = 변경할 값
```

* WHERE절에 맞는 데이터만 변경
```
UPDATE 테이블명 SET 컬럼명 = 변경할 값 WHERE 컬럼명=값
```

* 변경해야할 컬럼이 여러개일 때 콤마(,)를 사용하여 여러개의 값을 변경
```
UPDATE 테이블명 SET 컬럼명1 = 변경할 값1,컬럼명2 = 변경할 값2 WHERE 컬럼명=값
```

## DELETE 
* 테이블에 있는 모든 데이터를 삭제 
```
DELETE from 테이블명
```

* WHERE절에 맞는 데이터만 삭제
```
DELETE from 테이블명 WHERE 컬럼명=값
```

## DROP DATABASE
* DB자체를 삭제
```
DROP DATABASE db_name;
```
* DB에서 특정 테이블을 삭제
```
DROP TABLE table_name;
```
출처: https://futurists.tistory.com/12?category=587334 [미래학자]

## CREATE TABLE
테이블 생성
``` 
CREATE TABLE 조건 테이블 이름 (
    컬럼명 데이터타입 조건, 
    ...
)

CREATE TABLE professor 
( 
    _id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(32) NOT NULL, 
    belong VARCHAR(12) DEFAULT 'FOO', 
    phone VARCHAR(12) 
) ENGINE=INNODB; 
DESCRIBE professor;

출처: https://futurists.tistory.com/11?category=587334 [미래학자]
```
## INNER JOIN 
여러 테이블에서 정보를 복합하여 추출해야 할때 사용  
출처 http://egloos.zum.com/sweeper/v/3002133

```
SELECT * // 모든 열
FROM BuyTable  // BuyTable에서 
        INNER JOIN UserTable   // UserTable과 함께 검색
        ON BuyTable.ID = UserTable.ID  // ID가 동일한 내용을 검색
WHERE BuyTable.ID = 'KJD'  // 검색하고자 하는 데이터 조건
```

## LEFT JOIN, RIGHT JOIN
FROM A_Table [LEFT|RIGHT] JOIN B_TABLE  
데이터 조회시 기준이 되는 테이블과 종속되는 테이블을 지정하여, 자료조회. 
종속되는 테이블의 값을 무시해도 될 경우 사용.   
출처 https://futurists.tistory.com/17 [미래학자]
```
SELECT gg._id, gg.name, s.title 
FROM girl_group AS gg 
    LEFT OUTER JOIN song AS s 
    ON s._id = gg.hit_song_id; 

SELECT s._id, s.title, gg.name 
FROM girl_group AS gg 
    RIGHT OUTER JOIN song AS s 
    ON s._id = gg.hit_song_id;
```

## ALTER
테이블 변경에 사용됨  
* 테이블의 이름변경
```
ALTER TABLE student RENAME TO hero; 
```
* 테이블에 컬럼이나 제약조건의 추가
```
ALTER TABLE hero ADD COLUMN star INT NOT NULL AFTER _id, ADD PRIMARY KEY (_id);
```
* 테이블의 수정
```
ALTER TABLE hero MODIFY COLUMN star BIGINT DEFAULT 10000;
ALTER TABLE hero CHANGE COLUMN star rating INT DEFAULT 100;
```
* 테이블 제약조건 제거
```
ALTER TABLE hero DROP COLUMN star, DROP PRIMARY KEY;
```

출처: https://futurists.tistory.com/12?category=587334 [미래학자]

# Key와 종속성
## Key의 종류
* 후보키 (Candidate Key) : 테이블을 구석하는 열 중에서 유일하게 식별할 수 있는 열
* 기본키 (Primary Key) : 테이블에서 유일하게 식별하기 위해 사용하는 키
* 대체키 (Alternate Key) : 후보키 중 기본키를 제외한 나머지 후보키
출처: https://futurists.tistory.com/14?category=587334 [미래학자]
* 수퍼키 : 두개이상의 열을 합쳐서 기본키로 사용하는 것
* 외래키 : 한테이블에서, 그 테이블의 후보키 이지만. 다른 테이블의 기본키로 사용되는 데이터에 대해서 외래키라 함.  
외래키가 기본키로 사용되는 테이블에서 삭제될 경우 참조 무결성을 위해서 이 테이블에서도 삭제되어야 함.
## 함수적 종속
회사원의 정보가 아래와 같을 때 
주민번호 | 이름 | 주소 | 연락처 | 직장 | 직장 주소 | 직장 전화번호 
각 정보는 아래와 같이 함수적으로 종속됨.
주민번호 -> 이름 , 주소, 연락처, 직장
직장 -> 직장 주소, 직장 전화번호
## 이행적 함수 종속
위 정보에서 주민 번호를 통해서 -> 직장을 알 수 있고 -> 직장전화번호를 알 수 있음. 
주민번호에 대해서 직장전화번호는 이행적으로 종속됨
출처: https://futurists.tistory.com/14?category=587334 [미래학자]
## 부분적 함수 종속

# 정규화