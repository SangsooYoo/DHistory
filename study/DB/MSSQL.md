# *MS SQL*
RDBMS중 MS SQL의 고유 특성을 정리함

## APIs 
+ **PWDCOMPARE**  
암호화된 컬럼의 값과 입력값의 차이를 비교하는 함수
같을경우 1, 다를경우 0  
    ```
    WHERE 1=1
    AND Account = '${userId}'
    AND PWDCOMPARE('${password}',Password)=1
    ```

+ **PWDENCRYPT**  
입력값을 암호화하는 함수
    ```
    INSERT
        ...
    VALUES 
        ...PWDENCRYPT('{pRegister.password}'))
    ```
