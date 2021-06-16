# Pandas
import pandas as pd

# API

## DataFrame
* df.info()  
Pandas의 DataFrame()객체의 정보를 표시함

* df.isnull()  
결측값의 유무를 표로 표시함
```
   col1   col2   col3   col4
a  False  False  False  False
b  False  False  False   True
c   True   True   True   True
d  False  False  False   True
e  False  False  False  False
f  False  False  False   True
```
* df.isnull().sum()  
결측값의 column별 합계 
```
   col1   col2   col3   col4
a  False  False  False  False
b  False  False  False   True
c   True   True   True   True
d  False  False  False   True
e  False  False  False  False
f  False  False  False   True

// true는 1, false는 0으로 치환 계산하여 합계를 구함
col1    1
col2    1
col3    1
col4    4
```

* df.isnull().sum(axis=1)  
sum계산을 위한 방향 설정

* df.dropna()  
결측치가 존재하는 데이터를 삭제함  
원본데이터는 유지되므로, 삭제된 값을 다시 이용하고자 할 경우 return 값을 받아 사용해야 함  
implace=True 파라미터 추가하여 원본데이터에 적용가능  
```
   col1  col2  col3  col4
a   0.0   1.0   2.0   1.7
b   3.0   4.0   5.0   NaN
c   NaN   NaN   NaN   NaN
d   9.0  10.0  11.0   NaN
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   NaN

df.dropna()

   col1  col2  col3  col4
a   0.0   1.0   2.0   1.7
e  12.0  13.0  14.0   1.2
```

df.dropna(how='all')  
how='[all]' 파라미터를 이용하여 전체 데이터가 없는 경우만 삭제 가능
```
   col1  col2  col3  col4
a   0.0   1.0   2.0   1.7
b   3.0   4.0   5.0   NaN
d   9.0  10.0  11.0   NaN
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   NaN
```

df.dropna(axis='columns')  column기준으로(세로) 결측치 탐색하여 있는 경우 해당 열을 제거함
```
   col1  col2  col3
a   0.0   1.0   2.0
b   3.0   4.0   5.0
d   9.0  10.0  11.0
e  12.0  13.0  14.0
f  15.0  16.0  17.0
```

* NaN값 할당하기  
np.nan으로 nan값을 할당 가능
```
df.iloc[:2, 0] = np.nan
df.iloc[:4, 1] = np.nan

   col1  col2  col3  col4
a   NaN   NaN   2.0   1.7
b   NaN   NaN   5.0   NaN
c   NaN   NaN   NaN   NaN
d   9.0   NaN  11.0   NaN
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   NaN
```

### df.fillna()  
결측값들을 지정된 값으로 교체하는 함수  
* df.fillna(값)  
결측값을 '값'으로 일괄 변경
```
   col1  col2  col3  col4
a   NaN   NaN   2.0   1.7
b   NaN   NaN   5.0   NaN
c   NaN   NaN   NaN   NaN
d   9.0   NaN  11.0   NaN
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   NaN

df.fillna(0) 

   col1  col2  col3  col4
a   0.0   0.0   2.0   1.7
b   0.0   0.0   5.0   0.0
c   0.0   0.0   0.0   0.0
d   9.0   0.0  11.0   0.0
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   0.0
```
* df.fillna(딕셔너리)
결측값을 '딕셔너리'에 지정된 위치에 지정된 값으로 일괄 변경
```
   col1  col2  col3  col4
a   NaN   NaN   2.0   1.7
b   NaN   NaN   5.0   NaN
c   NaN   NaN   NaN   NaN
d   9.0   NaN  11.0   NaN
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   NaN

df.fillna({'col2':0, 'col4':100})

   col1  col2  col3   col4
a   NaN   0.0   2.0    1.7
b   NaN   0.0   5.0  100.0
c   NaN   0.0   NaN  100.0
d   9.0   0.0  11.0  100.0
e  12.0  13.0  14.0    1.2
f  15.0  16.0  17.0  100.0
```

* df.fillna({'col1':df['col1'].mean()}, inplace=True)  
col1의 컬럼의 결측치에 col1컬럼의 평균값을 할당함
```
   col1  col2  col3  col4
a   NaN   NaN   2.0   1.7
b   NaN   NaN   5.0   NaN
c   NaN   NaN   NaN   NaN
d   9.0   NaN  11.0   NaN
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   NaN

df.fillna({'col1':df['col1'].mean()}, inplace=True)  

   col1  col2  col3  col4
a  12.0   NaN   2.0   1.7
b  12.0   NaN   5.0   NaN
c  12.0   NaN   NaN   NaN
d   9.0   NaN  11.0   NaN
e  12.0  13.0  14.0   1.2
f  15.0  16.0  17.0   NaN
```
-------------------------------
### 데이터 조회를 위한 indexing 방법
* df['column_name'] or df.colum_name 으로 접근하면 해당 단일 column에 접근 가능.  
* df[['column1', 'column2', 'column3']] 처럼 column의 이름으로 구성된 array를 이용하여 여러 column에 접근 가능
* df.set_index('column_name')   
기본 인덱스인 숫자 인덱스값을 대신하여 'column_name'의 값을 인덱스로 사용함
```
    name  score grade subject
0  Jessi    100     A  python
1   Emma     95     A    java
2   Alex     80     B  python
3  Jessi     85     B       c
4    Tom     97     A    java

       score grade subject
name                      
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c
Tom       97     A    java
```
* df.loc[]
DataFrame중 array에 포함된 index의 **이름으로**  조회함
* df.iloc[[index0, index4]]  
DataFrame중 array에 포함된 index의 **값으로** 조회함
```
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c
Tom       97     A    java

Jessi    100     A  python
Tom       97     A    java
```
* df.loc[df['score'] >= 95]  
* df.loc[df['subject'] == 'python']
특정 column에서 해당값이 조건을 만족하는 행만 조회함
```
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c
Tom       97     A    java

Jessi    100     A  python
Emma      95     A    java
Tom       97     A    java
```
-------------------------------
### 데이터 조회를 위한 슬라이싱 방법
* DataFrame [start : end : step]
DataFrame에서 start index 에서 (end - 1) index 행까지 step 단위로 조회함
``` 
// original                
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c
Tom       97     A    java

df[1:4]

Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c

df[::2]  

Jessi    100     A  python
Alex      80     B  python
Tom       97     A    java
```

* df[:'Index_Name']  
DataFrame에서 시작 index에서 index이름이 'Index_name'인 **행까지 포함하여** 조회
```
// original
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c
Tom       97     A    java

//sample_df[:'Alex']
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
```

* df.loc [start:stop, (start:stop)]
index의 행 시작점 이름에서, 종점이름까지, 열의 시작점 이름에서, 종점 이름까지 데이터를 slicing
```
// original
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c
Tom       97     A    java

//df.loc[:'Emma', ['subject','grade']]
Jessi  python     A
Emma     java     A
```

* df.iloc [start:stop, (start:stop)]  
index의 행 시작점 번호에서, 종점 번호까지, 열의 시작점 번호에서, 종점 번호까지 데이터를 slicing
```
// original
Jessi    100     A  python
Emma      95     A    java
Alex      80     B  python
Jessi     85     B       c
Tom       97     A    java

//df.iloc[:4, -1]
Jessi    python
Emma       java
Alex     python
Jessi         c
```
------------------------------------
### 집계함수
* DataFrame에 저장 가능한 2차원 이하의 경우 Pandas이용
* 3차원 이상의 데이터의 경우 Numphy를 통해서 집계함수 이용 해야 함
* 기본적으로 axis=0으로 동작, axis=1로 하고싶을 때만 지정

* df.count()
axis=0으로 기본 계산되어 열을 기준으로 NaN값이 아닌 행의 개수를 출력
axis=1으로 계산할 경우 행을 기준으로 계산
```
// original
   sub1  sub2  sub3  sub4
0     3   2.0   NaN   NaN
1     9   9.0   1.0   3.0
2     1   NaN   5.0   NaN
3     1   NaN   5.0   1.0
4     9   8.0   7.0   NaN

df.count()
sub1    5
sub2    3
sub3    4
sub4    2

df.count(axis=1)
0    2
1    4
2    2
3    3
4    3
```

* df.sum()
axis값은 count와 같은 방식으로 동작  
NaN값은 무시하고 합계  
skipna=[True|False] 속성으로 NaN값을 무시할지 결정할 수 있음
```
// original
   sub1  sub2  sub3  sub4
0     3   2.0   NaN   NaN
1     9   9.0   1.0   3.0
2     1   NaN   5.0   NaN
3     1   NaN   5.0   1.0
4     9   8.0   7.0   NaN

df.sum()
sub1    23.0
sub2    19.0
sub3    18.0
sub4     4.0

df.sum(skipna=False)
sub1    23.0
sub2     NaN
sub3     NaN
sub4     NaN
```