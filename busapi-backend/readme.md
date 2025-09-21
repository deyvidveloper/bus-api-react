# API de Gestión de Buses 🚍

Este proyecto consiste en una API REST desarrollada con **Java 17** y **Spring Boot 3**, orientada a la gestión de buses. La aplicación permite registrar, consultar y listar buses con sus respectivas marcas, características y estado.

## 🧩 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.6
- PostgreSQL
- Maven
- Spring Data JPA
- Spring Security (autenticación básica)
- Postman (para pruebas)

## 📦 Estructura de datos

Cada bus registrado contiene los siguientes campos:

- `id`: autogenerado
- `numeroBus`: código único del bus
- `placa`: número de placa
- `fechaCreacion`: generada automáticamente
- `caracteristicas`: descripción del bus
- `marca`: relación con tabla `Marca` (Volvo, Scania, Fiat, etc.)
- `activo`: estado booleano (true/false)

## 🔗 Endpoints disponibles

### 1. Obtener todos los buses

```http
GET /bus