# eureka-zuul-tryout

## Motivation

Netflix uses [Zuul](https://github.com/Netflix/zuul) and [Eureka](https://github.com/Netflix/eureka) to manage the access to their large number of microservices instances. Zuul is an edge service router and Eureka is a location service. They play really well with each other and, more importantly, they work really well in the Amazon cloud.

Pivotal claims that [Spring Cloud](http://projects.spring.io/spring-cloud/) is the most straightforward way to use Zuul and Eureka.

I decide to give it a try!

## Instructions

This try-out comes with three example [Spring Boot](http://projects.spring.io/spring-boot/) microservices that host some basic REST endpoints. To run them:

	mvn clean spring-boot:run

They will complain while they can't find an Eureka instance to register with. Don't worry.

The [eureka-server](https://github.com/armeniopinto/eureka-zuul-tryout/tree/master/eureka-server) is a Spring Boot app as well, start it the same way.

Browse to [localhost:8761/](http://localhost:8761/) to access the Eureka console. There, if everything goes fine, you'll be able to see the registered services.

Finally, start the [zuul-proxy](https://github.com/armeniopinto/eureka-zuul-tryout/tree/master/zuul-proxy). Zuul will find Eureka, query the registered services and automagically route any requests!

For example, [localhost:8080/hello-world-app/hello](localhost:8080/hello-world-app/hello) will automatically route requests to (localhost:58081/hello)!

## Conclution

Pivotal isn't exaggerating! It's really simple to turn any Spring Boot service into an Eureka client and to create an Eureka server or a Zuul proxy. All it takes is a single annotation and very little configuration.