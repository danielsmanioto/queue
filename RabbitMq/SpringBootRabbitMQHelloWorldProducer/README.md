1. Install JDk 11

2. Up rabbit-mq container on Docker    
`docker run -d --hostname my-rabbit --name rabbit13 -p 8080:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3-management`	    

3. Up application

`mvn clean install`

`java -jar target/<app.jar>` or ``

4. Sending message
`http://localhost:8081/rabbit-mq/producer?sender=daniel&&message=ilovesananders`

5. Testing on Rabbit MQ

`http://localhost:8080`

<ul>
  <li>user: guest</li>
  <li>password: guest</li>
</ul>

6. How can I see in Rabbit MQ ? 

