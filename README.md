# Especializacion Backend I - Digital House - Final

Autor: Jonathan Quiroz Laverde <br>
Fecha: 2022 - 04 - 07


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