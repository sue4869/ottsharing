# :clapper:ottsharing
## :pushpin: 개요
ottsharing은 OTT 계정 공유 중개 서비스입니다. 파티장이 계정을 공유하는 파티를 개설하면, 파티원 최대 3명이 공유받을 수 있게끔 중개합니다.
Java와 Spring Boot를 이용해 REST API 서버를 만들어보는걸 목표로 제작되었습니다. 

현재는 기존의 ottsharing에 대한 아쉬움으로 ddd구조로 전환하는 단계를 거치고 있습니다.(2022.11 ~ 현재)
### DDD 구조로 리팩토링하는 것에 대한 이유
1. '객체 지향을 추구하면서 프로젝트를 구성하였는가'에 대한 질문을 가지고 프로젝트를 다시 보니 전혀 고려하지 않은 프로젝트임을 깨달았다.
2. 기존의 프로젝트는 너무나도 높은 결합도와 의존성를 가지고 있다. 
-> 확장과 변경에 대한 유연성이 없다.
3. 후에, 내가 개발자로써 더 성장하여 다시 이 프로젝트에 새로운 기술/기능을 적용하고 싶을때 바꾸기 쉽고 적용하기 쉬운 환경을 만들어놓고 싶다. 
4. DDD구조에서 설명하고 있는 객체의 책임 분리에 대해 감명깊게 읽었고, 이를 프로젝트에 직접 적용하고 싶었다.  

기존 프로젝트 링크 : https://github.com/f-lab-edu/ottsharing

## :pushpin: 2차 버전 중점사항 및 사용 기술 스택 
<img src="https://img.shields.io/badge/Spring%20Boot-2.6.4-yellow"> <img src = "https://shields.io/badge/DataBase-MariaDB-blue?logo=mariadb&style=flat"> <img src = "https://img.shields.io/badge/Code%20Style-Naver%20CheckStyle-brightgreen?logo=naver&logoColor=brightgreen"> <img src="https://img.shields.io/badge/DataAccess-Spring%20JPA-lightgrey">
* 이유와 근거가 명확한 기술의 사용을 지향합니다. 그리고 이에 대해 블로그 글로 정리하여 해당 이유와 근거를 밝힐 것입니다. 
* legacy 버전을 그대로 보전하면서, 작은 기능부터 분리해내어 ddd구조를 적용하고 좀 더 발전된 기능을 구현하는 것을 목표로 합니다. 
* 기존에는 단순히 기능구현만을 집중하였다면, 이제는 기능구현뿐만 아니라 CS-level까지 생각할 수 있도록 분석하고 고민하는 과정을 거치려고 노력할 것입니다. 

## :pushpin: 현재까지 개선된 사항
1. MVC 구조 -> DDD 구조로 전환 (legacy는 따로 보존)
2. h2 DB로만 적용되어 있음 -> MairaDB로 전환
3. user엔티티에서 email과 password에 대한 책임분리를 위해 각각 객체화
4. 예외처리도입
5. 회원가입로직 흐름 개선 
  * 단순히 회원정보 저장 -> 토큰생성하여 이메일로 계정 확인하는 로직 추가
  * 비동기적용

## :pushpin: 문제 해결 및 기술 적용 이유에 대한 블로그 글 - 중요도 순 정렬
1. 🌟(회원가입이벤트와 토큰 생성 이벤트 1(설계 이유,@Transactional)[https://velog.io/@sweet_sumin/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EC%9D%B4%EB%B2%A4%ED%8A%B8%EC%99%80-%ED%86%A0%ED%81%B0-%EC%83%9D%EC%84%B1-%EC%9D%B4%EB%B2%A4%ED%8A%B81-%EC%84%A4%EA%B3%84%EC%9D%B4%EC%9C%A0-Transactional]
2. 🌟(회원가입이벤트와 토큰 생성 이벤트 2 (@Async))[https://velog.io/@sweet_sumin/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%EC%9D%B4%EB%B2%A4%ED%8A%B8%EC%99%80-%ED%86%A0%ED%81%B0-%EC%83%9D%EC%84%B1-%EC%9D%B4%EB%B2%A4%ED%8A%B8-2-Async]
3. (회원가입(1) - 예외처리 도입) [https://velog.io/@sweet_sumin/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%851%EC%98%88%EC%99%B8%EC%B2%98%EB%A6%AC%EB%8F%84%EC%9E%85]
4. (회원가입(2) - JPA 적용(MariaDB), 회원가입 로직 흐름 개선)[https://velog.io/@sweet_sumin/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%852-JPA-%EC%A0%81%EC%9A%A9-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%EB%A1%9C%EC%A7%81-%ED%9D%90%EB%A6%84-%EA%B0%9C%EC%84%A0]
## :pushpin: 프로젝트 구조도
![image](https://user-images.githubusercontent.com/33937365/183288666-95bead19-899e-41b1-9a50-36794c56fc92.png)

## :pushpin: ERD
![image](https://user-images.githubusercontent.com/33937365/183280542-d596dc1b-1032-422e-9c88-2a27aa3d29b8.png)


