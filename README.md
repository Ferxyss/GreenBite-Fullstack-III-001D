# GreenBite - Arquitectura de Microservicios Fullstack

Proyecto desarrollado utilizando Spring Boot y arquitectura de microservicios, implementando distintos patrones de diseño, persistencia independiente por servicio y un BFF (Backend For Frontend) para centralizar el acceso a los servicios.

---

# Arquitectura del Proyecto

```txt
                Frontend / Postman
                        ↓
                 BFF :8080
                 (API Gateway)
                 ↙           ↘
      Productos :8081    Suscripciones :8082
          MongoDB              H2/JPA
```

---

# Microservicios

## Productos

Microservicio encargado de administrar el catálogo de productos.

### Tecnologías
- Spring Boot
- MongoDB
- Spring Data MongoDB
- Swagger / OpenAPI
- JUnit 5
- Mockito

### Funcionalidades
- CRUD de productos
- Validaciones
- Manejo global de errores
- Documentación REST
- Tests unitarios

### Puerto

```txt
8081
```

---

## Suscripciones

Microservicio encargado de administrar suscripciones y planes de usuarios.

### Tecnologías
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI
- JUnit 5
- Mockito

### Funcionalidades
- CRUD de suscripciones
- Validaciones
- Manejo global de errores
- Persistencia relacional
- Tests unitarios

### Puerto

```txt
8082
```

---

## BFF (Backend For Frontend)

Microservicio gateway encargado de centralizar las peticiones y redirigirlas hacia los distintos servicios.

### Tecnologías
- Spring Cloud Gateway
- Spring WebFlux

### Funcionalidades
- Routing centralizado
- Integración entre microservicios
- API Gateway

### Puerto

```txt
8080
```

---

# Patrones de Diseño Implementados

## Microservices Architecture
Separación del sistema en distintos microservicios independientes.

---

## Backend For Frontend (BFF)
Capa intermedia entre frontend y microservicios.

---

## API Gateway Pattern
Centralización del acceso a los servicios mediante routing.

---

## Repository Pattern
Separación del acceso a datos mediante repositorios.

---

## Service Layer Pattern
Separación de la lógica de negocio de los controladores REST.

---

## DTO Pattern
Uso de DTOs para controlar los datos enviados y recibidos por la API.

---

## Validation Pattern
Validación automática de datos usando anotaciones.

---

## Exception Handler Pattern
Manejo global de excepciones REST.

---

## Database per Service
Cada microservicio utiliza su propia base de datos.

- Productos → MongoDB
- Suscripciones → H2 Database

---

# Estrategia Git

Se utilizó GitHub Flow para el desarrollo del proyecto.

## Ramas utilizadas

```txt
main
feature/productos-mongodb
feature/productos-service
feature/suscripciones-jpa
feature/bff-gateway
```

---

# Cómo Ejecutar el Proyecto

## 1. Clonar repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
```

---

# Ejecutar Microservicios

## Productos

```bash
cd Productos
./mvnw spring-boot:run
```

---

## Suscripciones

```bash
cd Suscripciones
./mvnw spring-boot:run
```

---

## BFF

```bash
cd BFF
./mvnw spring-boot:run
```

---

# Endpoints Principales

## Productos

### Obtener productos

```http
GET http://localhost:8080/productos
```

### Crear producto

```http
POST http://localhost:8080/productos
```

---

## Suscripciones

### Obtener suscripciones

```http
GET http://localhost:8080/suscripciones
```

### Crear suscripción

```http
POST http://localhost:8080/suscripciones
```

---

# Swagger / OpenAPI

## Productos

```txt
http://localhost:8081/swagger-ui/index.html
```

---

## Suscripciones

```txt
http://localhost:8082/swagger-ui/index.html
```

---

# Testing

El proyecto incluye pruebas unitarias utilizando:

- JUnit 5
- Mockito

Para ejecutar tests:

```bash
./mvnw test
```

---

# Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Cloud Gateway
- MongoDB
- H2 Database
- Spring Data JPA
- Swagger / OpenAPI
- JUnit 5
- Mockito
- Maven

---

# Integrantes

- Fernanda Paredes
- Martina Flores
- Alexander Torres

---

# Estado del Proyecto

Proyecto funcional con arquitectura de microservicios, integración mediante BFF y persistencia independiente por servicio.
