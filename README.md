# Especializacion Backend I - Digital House - Final

Autor: Jonathan Quiroz Laverde <br>
Fecha: 2022 - 04 - 07

## Justificación Circuit Breaker

Las caracteristicas usadas en el circuit breaker dentro de catalog para los microservicios de serie y movie son los siguientes:

- Se realizan 5 intentos. En este momento el circuit breaker tiene estado cerrado.
- Si 3 de los 5 intentos son fallidos entonces pasa a ejecutar el Fallback. Y se pasa a un estado abierto en el circuit breaker.
- En este caso el Fallback lo que hace es, en vez ya de ir a consultar a los microservicios de movie y serie, se dirige a la base de datos de MongoDB, donde tiene las movies y series que se han agregado y han quedado en la cola de RabbitMQ las cuales toma y almacena, devolviendo asi al usuario una respuesta.
- Luego de 15s el circuit breaker pasa a estado semi-abierto y hace 3 llamados para comprobar si el microservicio ya esta funcionando, sino vuelve a estado abierto y continua el ciclo.


## Pasos para la ejecución:

1. Construir la imagen de docker para mysql y ejecutar dicha imagen para levantar la instancia.


```sh
docker build -t mysql-image -f Dockerfile.mysql .
docker run -p 3306:3306 --name mysql-backend -d mysql-image
```
2. Ejecutar zipkin para el manejo del traceo distribuido.

```sh
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```
3. Levantar RabbitMQ para el manejo de mensajes de forma asincronica.

```sh
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management
```
4. Ejecutar el config server, para esto vamos a ingresar a la carpeta <strong>config-server</strong> y ejecutamos con Maven.
```sh
cd config-server
mvn spring-boot:run
```

5. Ejecutar el eureka server para el registro y descubrimiento de los microservicios, para esto vamos a ingresar a la carpeta <strong>eureka-server</strong> y ejecutamos con Maven.
```sh
cd eureka-server
mvn spring-boot:run
```

6. Ahora procederemos a ejecutar nuestros microservicios movie-service, serie-service y catalog-service, cada uno se ejecuta igual que las instancias anteriores
```sh
cd <nombre-microservicio>
mvn spring-boot:run
```

7. Por ultimo levantamos nuestro gateway y ya estaria listo todo para usar! Pdta: El gateway se levanta de la misma manera.

Pdta: Las bases de datos para serie y catalog estan embebidas y son base de datos de MongoDB, adicional recordar tener colas creadas para Movie y Series antes de ejecutar Catalog, ya que al tratar de consumir colas que no existen se produce un error.