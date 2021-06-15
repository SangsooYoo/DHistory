# 블럭킹 처리에 대한 테스트
* 샘플코드 study\test1
* 테스트 방법
    ```
    cd study\test1
    npm install express
    node app.js
    ```
localhost:3000/sleep?param=c1  
localhost:3000/sleep?param=c2  
위 2가지 링크를 브라우저에서 각각 오픈   

결과 
```
/sleep?param=c2 let's wait 6:43:47 PM
/sleep?param=c2 let's make a response 6:43:52 PM
/sleep?param=c1 let's wait 6:43:52 PM
/sleep?param=c1 let's make a response 6:43:57 PM
```

http://localhost:3000/timeout?param=c2
http://localhost:3000/timeout?param=c1
위 2가지 링크를 브라우저에서 각각 오픈

결과
```
/timeout?param=c2 let's wait 6:44:16 PM
/timeout?param=c1 let's wait 6:44:17 PM
/timeout?param=c2 let's make a response 6:44:21 PM
/timeout?param=c1 let's make a response 6:44:22 PM
```

결론  
Route에 설정한 callback 내부에서 비동기 처리할 경우 blocking생기지 않음
Route에 설정한 callback 내부에서 동기하여 지연될 경우 성능저하를 일으킬 수 있음