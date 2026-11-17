# NovaPrint Multiservicios

## 1. Objetivo
Desarrollar un sitio web para un negocio de impresiones, fotocopias y servicios de oficina, aplicando control de versiones con Git y GitHub para organizar el trabajo por etapas.

## 2. Alcance del proyecto

**Incluye:**
- Portada con los servicios del negocio y sus precios.
- Registro e inicio de sesión de clientes, con contraseñas cifradas.
- Formulario de contacto.
- Cotizador de precios.
- Pedidos de clientes y seguimiento de su estado.
- Panel de administración para ver pedidos y mensajes.

**No incluye:** pagos en línea, facturación electrónica ni aplicación móvil.

**Tecnologías:** Java 17, Spring Boot, Spring Security, Spring Data JPA, Thymeleaf, MySQL y Bootstrap 5.

## 3. Fases y entregables

| Avance | Fase | Entregable |
|---|---|---|
| 1 | Planeación y desarrollo inicial | Repositorio en GitHub, rama `main`, estructura base y este README |
| 2 | Desarrollo con ramas | Cotizador, pedidos y panel de administración, cada uno en su rama |
| 3 | Optimización | Refactorización, documentación final y poda de ramas |

## 4. Roles y responsabilidades
El proyecto es individual. Una sola persona cumple todos los roles.

| Integrante | Rol | Responsabilidad |
|---|---|---|
| [Fabioo] | Líder y desarrollador | Planificar el trabajo y programar el sistema |
| [Fabioo] | Responsable de versiones | Administrar el repositorio, ramas y fusiones |
| [Fabioo] | Documentación | Mantener el README al día |

## 5. Estrategia de ramas (planificada)
- `main`: versión estable. Solo recibe cambios ya probados.
- `develop`: integración de los cambios antes de pasar a `main`.
- `feature/*`: una rama por funcionalidad (por ejemplo `feature/cotizador`).

## 6. Configuración inicial de Git
```bash
git config --global user.name "[Fanta Roja]"
git config --global user.email "[]"
```

## 7. Estructura del repositorio
```
src/main/java/...      Código Java (config, controller, entity, repository, service)
src/main/resources     Plantillas (templates), estilos y scripts (static)
src/test               Pruebas
pom.xml                Dependencias del proyecto
README.md              Documentación
```

## 8. Cómo ejecutarlo
Sin MySQL (base en memoria):
```powershell
$env:SPRING_PROFILES_ACTIVE="local"; .\mvnw.cmd spring-boot:run
```
Abre http://localhost:8080
