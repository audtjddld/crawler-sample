# crawler-sample

Java crawling sample project.

크롤링 관련 샘플 코드

crawler4j = 크롤링

jsoup = 스크래이핑


[정리 내용](http://kkforgg.blog.me/221444984380)

예제를 이용하여 크롤링을 구현해보자.

로컬 설정 방법
---

1. docker를 로컬 PC에 설치한다.

[docker mac 설치](http://kkforgg.blog.me/221404509671)

[docker 기본 사용법](http://kkforgg.blog.me/221459908128)

2. kafka , zookeeper docker image를 pull 받는다. 아래 링크 보고 따라할 것  

[kafka docker 설치 링크](http://www.kwangsiklee.com/2017/03/docker-compose%EB%A1%9C-kafka%EB%A5%BC-%EB%A1%9C%EC%BB%AC%EC%97%90-%EB%9D%84%EC%9B%8C%EB%B3%B4%EC%9E%90/) 

docker 실행 후 `docker-compose-single-broker.yml` 을 실행한다.  
KAFKA_ADVERTISED_HOST_NAME을 `127.0.0.1` 로 변경한다. 

3. 로컬에 정상적으로 설치되었는지 확인한다.
현재 버전은 `kafka_2.12-2.1.0` 버전이다.

```
wget http://mirror.apache-kr.org/kafka/2.1.0/kafka_2.12-2.1.0.tgz
tar xzvf kafka_2.12-2.1.0.tgz
```
실행한 뒤 아래와 같이 접속해본다.

```
bin/kafka-topics.sh --list --zookeeper localhost:2181
```

```
test
```
topic list에 test가 나타나면 정상 셋팅 된 것이다.


구동 후 로컬에서 다음과 같이 입력한다.

```
curl -d '{"companyId" :  "test", "type": "MAKESHOP", "seedURL" : "url" }' -H "Content-Type: application/json" -X POST http://localhost:9091/crawling
```


