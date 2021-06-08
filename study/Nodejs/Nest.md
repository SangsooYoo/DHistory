
# NestJS

* Nodejs에서 지원되는 Framework중 하나 
* Javascript와 Typescript를 둘다 사용가능.
* 구조가 Java Springboot와 유사
* 프로젝트 생성시 아래처럼 기본 구조가 잡힘
```
import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
    
async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  await app.listen(3000);
}
bootstrap();
```

# 데코레이터.
Springboot의 Annotation과 유사한 역할.

## @Controller 
Express의 Router와 비슷한 역할
constructor를 통해서 지정된 endpoint에 해당하는 Provider를 지정
예제 http://host/cats 에 GET으로 Request를 요청한 경우 처리됨.
```
import { Controller, Get } from '@nestjs/common';

@Controller('cats')
// '/cats/' 엔드포인트로 접속
export class CatsController {
  @Get()
	// HTTP GET 요청에 대한 응답을 지정
  findAll(@Req() request: Request): string {
    return 'This action returns all cats';
  }
}
```
## @Put @Get @Delete @Post
Http Method에 따라 선택사용  
wildcard도 사용 가능
```
@Get('ab*cd')
//ab*cd에 대한 요청을 모두 수행.
findAll() {
  return 'This route uses a wildcard';
}
```
## @Req, @Param, @Body
Request정보에 접근 필요할 경우 사용하여 해당 정보에 접근 가능
@Body를 사용할 경우 *.dts.ts파일을 선언하여 별도 Parser구현없이 사용가능
```
//create-cat.dto.ts
export class CreateCatDto {
  name: string;
  age: number;
  breed: string;
}

@Post()
async create(@Body() createCatDto: CreateCatDto) {
//@Body()데코레이터를 통해 createCatDto를 body객체로 지정하고 CreateCatDto 타입을 지정한다.
  return 'This action adds a new cat';
}
```

## @Res
Response객체에 접근 필요한 경우 통해 접근가능

## @Header('키워드', '값')
응답헤더의 임의의 값 지정
```
@Post()
@Header('Cache-Control', 'none')
create() {
  return 'This action adds a new cat';
}
```
## @HttpCode(200)
Http response코드 지정
```
@Post()
@HttpCode(204)
create() {
  return 'This action adds a new cat';
}
```
## @Redirect("https://docs.nestjs.com", 302)
redirection 위치와 응답코드 지정가능
```
@Get("docs")
@Redirect("https://docs.nestjs.com", 302)
//기본적인 Redirect 속성
getDocs(@Query("version") version) {
    if (version && version === "7") {
        return {url: "https://docs.nestjs.com/v5/"};
				//메소드를 통해 특정 조건에서 속성을 재설정할 수도 있다.
    }
}
```

## @Module
모듈의 조합을 통해 NestJS의 구조가 결정됨  
어플리케이션은 반드시 하나의 Root Module이 존재 해야 함. 
모든 모듈은 싱글톤으로 구동됨
아래는 AppModule을 정의한 코드

```
import {SubController} from "../SubController";
import {SubProvider} from "../SubProvider";

@Module({
    controllers: [SubController]],
    providers: [SubProvider],
    imports: [SubController, SubProvider],
    exports: [SubController, SubProvider]
})
export class AppModule {
}
```
* provider : Injectable된 클래스들을 인스턴스화 하고 인스턴스는 모듈안에서 최소한으로 공유된다.
* controllers : 해당모듈에서 사용하는 컨트롤러들의 모음.
* imports : 이 모듈에서 임포트하여 사용할 모듈들. 해당 모듈에서 export된 provider에 접근해서 사용
* exports : 이 모듈을 임포트하여 사용하는 모듈에 노출시킬 프로바이더를 지정.

* Dynamic Module
모듈을 파라미터에 의해서 특정 속성을 부여하여 동적으로 생성 
```
import {Module, DynamicModule} from "@nestjs/common";
import {createDatabaseProviders} from "./database.providers";
import {Connection} from "./connection.provider";

@Module({
    providers: [Connection]
		//기본적으로 Connection provider를 포함하고 있는 모듈이다.
})
export class DatabaseModule {
    static forRoot(entities = [], options?): DynamicModule {
		//forRoot static 메소드를 통해 인수를 받아 동적으로 모듈을 정의한다.
        const providers = createDatabaseProviders(options, entities);
        return {
            module: DatabaseModule,
						//동적으로 재구성할 모듈을 지정한다.
            providers,
            exports: providers
        }
				//동적으로 모듈을 재구성한다.
    }
}

@Module({
    imports: [DatabaseModule.forRoot([User])]
})
```

## @Global
모든 모듈에서 사용가능한 글로벌 모듈로 지정  
글로벌 모듈은 단 하나만 가능, 별도 import없이 모든 모듈에서 Provider를 사용가능  

# 참고자료
https://docs.nestjs.com/
https://blog.martinwork.co.kr/nestjs/2020/03/22/what-is-nestjs.html
https://velog.io/@kimjeongwonn/NestJS-%EB%8F%85%ED%95%99-Module