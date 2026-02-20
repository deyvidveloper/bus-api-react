# 🚍 Proyecto FullStack - Gestión de Buses

Este proyecto es una aplicación **FullStack** que permite gestionar información de buses.  
Incluye un **backend en Java Spring Boot** y un **frontend en React**, conectados a una base de datos relacional PostgreSQL.

---

## 📌 Backend

### Tecnologías utilizadas
- Java 17
- Spring Boot 3.x
- PostgreSQL
- Maven

### Funcionalidades
- API REST para la gestión de buses.
- Endpoints disponibles:
  - `GET /bus` → Obtiene la lista de todos los buses registrados.
  - `GET /bus/{id}` → Obtiene la información de un bus por su ID.
- Relación entre tablas:
  - Tabla **Bus** con relación a la tabla **MarcaBus**.
- Campos de la entidad **Bus**:
  - `id` (autogenerado)
  - `numeroBus`
  - `placa`
  - `fechaCreacion` (autogenerada)
  - `caracteristicas`
  - `activo` (booleano)
  - `marcaBusId` (FK hacia tabla MarcaBus)

### Extras implementados
- Paginación en el listado de buses.
- Seguridad básica en los endpoints (Spring Security).

---

## 🎨 Frontend

### Tecnologías utilizadas
- React 18
- JavaScript (opcional: TypeScript)
- CSS / Bootstrap

### Funcionalidades
- Consumo del endpoint `GET /bus` y visualización en una tabla.
- Manejo de estado con `useState`.
- Fetching de datos con `fetch` y `useEffect`.
- Extras:
  - Paginación en la tabla de buses.
  - Consumo de `GET /bus/{id}` y visualización en un **alert** o nueva vista.

---

## ⚙️ Instalación y ejecución

### Backend
1. Clonar el repositorio.
2. Configurar la base de datos PostgreSQL:
   ```sql
   CREATE DATABASE busesdb;
