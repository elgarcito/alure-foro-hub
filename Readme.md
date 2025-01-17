# Alure Challenge: Foro HUB
### ¡¡¡Hola!!!, Bienvenido a este repositorio

Aquí encontrarás la respuesta al desafío planteado en la ultima parte del curso
**Formaciones en programación** de
[Oracle Next Education](https://www.oracle.com/ar/education/oracle-next-education/).

### Acerca del desafío
El objetivo de este proyecto es poder aplicar cada uno de los módulos aprendidos
en el trayecto formativo **Java y Spring Framework G7** en un proyecto complejo:

### La API Foro hub

A continuación, presentaremos cómo se aplicó cada uno de los cursos en la resolución de
este desafío. 
Los pasos son los siguientes:

## Paso 1 diseño de los modelos
Se utilizaron los cursos:
1. Java: Java: trabajando con lambdas, streams y Spring Framework
2. Java: persistencia de datos y consultas con Spring Data JPA


Se crearon los objetos que representan nuestro modelo.
Estos son las clases Usuarios y Topico, ademas de crear los DTO DatosTopico
y DatosAutenticacionUsuarios que posteriormente se utilizaran para mapear
las entidades a la base de datos

## Paso 2 Creacion de la base de datos
Se utilizo el curso:
1. Java: persistencia de datos y consultas con Spring Data JPA
2. Spring Boot 3: desarrollar una API Rest en Java

Aqui utilizando la dependencia Flyway creamos los archivos para crear las tablas
en la base de datos. Utilizamos la base de datos de MYSQL tambien creada.
El utilizado es el siguiente:
```bash
CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensaje VARCHAR(500) NOT NULL UNIQUE,
    fecha_de_creacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
  CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(255) NOT NULL,
    clave VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);



```

## Paso 3
Se utilizo el curso:
1. Spring Boot 3: desarrollar una API Rest en Java
2. Spring Boot 3: aplique las mejore practicas y proteja una API Rest

En esta etapa se crearon los controllers, Repository y Serivices  que permiten hacer peticiones http a la API

## Paso 4
Se utilizo el curso:
1. Spring Boot 3: desarrollar una API Rest en Java
2. Spring Boot 3: aplique las mejore practicas y proteja una API Rest
3. Spring Boot 3: documentar, probar y preparar una API para su implementacion

Aqui se agregaron las clases y configutaciones necesarias de seguridad para poder utilizar las 
dependencias Spring Security y Auth0, lo que permite finalmente al usuario ingresar y utilizar
la API luego de loguearse

### Resumen final

Para copiar este repositorio en caso de necesitarlo:
1. Asegúrate de tener instalado Git en tu computadora. Si no lo tienes, puedes descargarlo desde [este link](https://git-scm.com/downloads).
2. Abre una terminal o ventana de comandos y navega hasta la carpeta raíz de tu repositorio local.
2. Ejecuta el siguiente comando para agregar todos los archivos modificados al área de preparación de Git:

```bash
  git clone this-repo-url
```

Tal como se indica en el desafío el proyecto no se deployo.

Como conclusión y a titulo personal, el desafío presento una complejidad acorde a la dificultad de los cursos.
Los contenidos de cada curso fueron aplicados directamente en el proyecto final, lo que indica una gran posibilidad
de aplicación de cada tema.
La complejidad de este proyecto fue alta, debido al material extra a leer para poder realizarlo correctamente
Quedo muy satisfecho con el resultado y espero que ustedes también


### Author
[@Edgar Aguirre](https://github.com/elgarcito)

For educative purpose.
