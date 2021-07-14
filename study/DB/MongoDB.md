# MongoDB

## How to install MongoDB
on Linux
```
$ apt install mongodb
```
on Max
```
$ tap mongodb/brew
$ brew install mongodb-community@4.4
$ brew services start mongodb-community@4.4
```
## Nodejs Mongodb plugin

## MongoDB cli

* DB생성
```
> use mongodb_tutorial
switched to db mongodb_tutorial
```

* 현 Context의 DB확인
```
> db
mongodb_tutorial
```

* DB리스트 조회
collection이 있는 DB만 조회됨. 

```
> show dbs
local  0.000GB
```

* DB제거
이 명령어를 사용하기 전, use DATABASE_NAME 으로 삭제하고자 하는 데이터베이스를 선택해줘야합니다.
```
> use mongodb_tutorial
switched to db mongodb_tutorial
> db.dropDatabase();
{ "dropped" : "mongodb_tutorial", "ok" : 1 }
```

* Collection생성
db.createCollection(name, [options]) 
    * name 은 생성하려는 컬렉션의 이름이며 option 은 document 타입으로 구성된 해당 컬렉션의 설정값입니다.
    * options 매개변수는 선택적인(Optional) 매개변수로서 생략하셔도 되고, 필요에따라 사용하면 됩니다.

* Collection list조회
```
> show collections
articles
books
people
```

* Collection 제거
```
> show collections
articles
books
people
> db.people.drop()
true
> show collections
articles
books
```

* Document추가
```
> db.books.insert({"name": "NodeJS Guide", "author": "Velopert"})
WriteResult({ "nInserted" : 1 })
```

```
> db.books.insert([
... {"name": "Book1", "author": "Velopert"},
... {"name": "Book2", "author": "Velopert"}
... ]);
```

* document 목록 조회

```
> db.books.find(query, projection)
```
    * query Optional. 다큐먼트를 조회할 때 기준을 정합니다. 기준이 없이 컬렉션에 있는 모든 다큐먼트를 조회 할때는 이 매개변수를 비우거나 비어있는 다큐먼트 { } 를 전달하세요.
    * projection Optional. 다큐먼트를 조회할 때 보여질 field를 정합니다.

* document 삭제
> db.COLLECTION_NAME.remove(criteria, justOne)
    * criteria	삭제 할 데이터의 기준 값 (criteria) 입니다. 이 값이 { } 이면 컬렉션의 모든 데이터를 제거합니다.
    * justOne	선택적(Optional) 매개변수이며 이 값이 true 면 1개 의 다큐먼트만 제거합니다. 이 매개변수가 생략되면 기본값은 false 로 서, criteria에 해당되는 모든 다큐먼트를 제거합니다.

## 출처
https://velopert.com/tag/mongodb
https://mongodb.github.io/node-mongodb-native/3.6/api/index.html
https://docs.mongodb.com/manual/reference/
