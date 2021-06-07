# 공식사이트
https://spring.io/projects/spring-boot

# SpringBoot란?
참조 https://velog.io/@galaxy/SpringBoot%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EB%9E%80  
>Spring Boot는 Java를 기반으로 한 웹 어플리케이션 프레임워크이다
Spring 프레임워크가 먼저 등장했는데 Spring의 초기 환경 설정시 시간이 많이 할애되는 문제를 해결하고자 등장한 프레임워크가 Spring Boot이다.
스프링부트는 메이븐이나 그레이들의 dependency에 starter 라이브러리만 작성한다면 초기 셋팅에 필요한 라이브러리들을 모두 세팅해주게 된다. 

> ## Maven과 Gradle은 무엇일까?
>초기 개발 환경을 설정할 때 메이븐의 pom.xml이나 그레이들의 build.gradle 파일을 통해 스프링과 스프링부트의 프로젝트를 관리할 수 있다.


>스프링 부트의 두 번째 특징은 톰캣과 같은 내장 서버가 존재한다는 것이다. 스프링 프레임워크의 경우 톰캣을 직접 설치해 프로젝트 내에서 서버를 설정해주고, 버전 관리도 함께 해 주어야 했다. 

>스프링의 경우 servlet-context, root-context와 같은 xml 파일을 직접 작성해서 웹과 관련된 설정이나 스프링 프로젝트 내 객체 의존성을 관리해줘야 했지만 스프링부트에서는 이럴 필요 없이 자동으로 의존성 관리가 가능해졌다.

# Spring Boot 프로젝트 생성 관리

https://goddaehee.tistory.com/238

# Spring Annotation

## @SpringBootApplication

## @ComponentScan
@Component 선언된 객채들을 스캔할 시점을 알려주는 Annotation  
참조 https://atoz-develop.tistory.com/entry/Spring-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B9%88Bean%EC%9D%98-%EA%B0%9C%EB%85%90%EA%B3%BC-%EC%83%9D%EC%84%B1-%EC%9B%90%EB%A6%AC

## @Controller
해당 클래스가 MVC모델 중, Controller임을 나타내기 위한 어노테이션

```
@Controller  
public class MainController {  
    ..  
}
```

## @Service
MVC패턴 구현시 M에 접근하기 위한 Service를 제공하는 클래스를 생성.
https://m.blog.naver.com/scw0531/220988401816

## @RestController
참조 https://mangkyu.tistory.com/49
Spring MVC Controlle에 @ResponseBody가 추가된 것, Json형태로 객체 데이터를 반환하기 위함.

## @RequestMapping
요청에 대해 어떤 Controller, 어떤 메소드가 처리할지를 맵핑하기 위한 어노테이션

```
@Controller  
@RequestMapping("/")  
public class MainController {  
    @RequestMapping("login")
	public String viewLogin() { 
        ....
	}
}
```

## @Repository
DAO임을 나타내는 어노테이션. 원래는 외부 I/O를 처리하는 목적으로 선언
https://m.blog.naver.com/scw0531/220988401816

## @Mapper
미리 정의된 Xml과 해당 클래스를 매핑하기 위해 사용됨
```
@Mapper
public interface UserSqlMapper {
    ...
}
```
user.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.smarthome.cms.repositories.main.UserSqlMapper">
....
```

# 기타 Annotation

## @Slf4j

로그 설정을 쉽게 해주는 라이브러리 
https://oingdaddy.tistory.com/46

## @Getter
## @Setter
## @ToString

Class의 private 멤버에 대해서 자동으로 getXX/ setXX/ isXXX를 생성해줌
https://www.daleseo.com/lombok-popular-annotations/

# Spring의 AOP
참조 https://engkimbs.tistory.com/746

# 기타
DAO /DTO/ VO
Annotation공부중 처음 접하는 용어   
1. DAO : Data Access Object, DB를 이용해 데이터를 조작하거나 조회하는 기능을 전담하는 오브젝트  
2. DTO : Data Transfer Object, 계층간 데이터 교환을 위한 자바 빈.  
3. VO : Value Object, DTO처럼 계층간 데이터 교환을 위해 사용되지만 Read only로 이용되는 오브젝트   
참조 https://genesis8.tistory.com/214  
