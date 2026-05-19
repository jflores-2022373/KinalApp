#  KinalApp

Sistema web desarrollado con **Spring Boot** para la administración y gestión de:

- Clientes
- Productos
- Usuarios
- Ventas
- Detalle de Ventas

El sistema implementa autenticación, roles de usuario y seguridad con Spring Security.

---

#  Descripción del Proyecto

KinalApp es una aplicación web CRUD desarrollada como proyecto académico utilizando tecnologías modernas de Java Enterprise.

El objetivo principal del sistema es administrar procesos de ventas mediante una interfaz dinámica, segura y responsiva.

---

#  Tecnologías Utilizadas

| Tecnología | Descripción |
|---|---|
| Java 21 | Lenguaje principal |
| Spring Boot | Framework Backend |
| Spring Security | Seguridad y autenticación |
| Spring Data JPA | Persistencia de datos |
| Thymeleaf | Motor de plantillas |
| Bootstrap 5 | Diseño responsivo |
| MySQL | Base de datos |
| Maven | Gestión de dependencias |
| Hibernate | ORM para base de datos |

---

#  Funcionalidades del Sistema

##  Módulo Clientes

- Registrar clientes
- Listar clientes
- Editar clientes
- Eliminar clientes

---

##  Módulo Productos

- Registrar productos
- Listar productos
- Actualizar productos
- Eliminar productos

---

##  Módulo Usuarios

- Registrar usuarios
- Administración de roles
- Gestión de accesos

---

##  Módulo Ventas

- Registrar ventas
- Asociar clientes
- Asociar usuarios
- Control de total de ventas

---

##  Módulo Detalle de Ventas

- Registrar productos vendidos
- Control de cantidades
- Cálculo de subtotales

---

#  Seguridad del Sistema

El proyecto implementa seguridad mediante:

- Spring Security
- Login personalizado
- Restricción de rutas
- Roles de usuario
- Protección de accesos

---

#  Roles del Sistema

##  ADMIN

El administrador tiene acceso completo al sistema.

### Puede:

 Ver registros  
 Crear registros  
 Editar registros  
 Eliminar registros  
 Acceder a módulos administrativos

---

## 🔵 USER

El usuario tiene acceso limitado.

### Puede:

 Ver información  
 Registrar información

### No puede:

 Editar registros  
 Eliminar registros  
 Acceder a rutas administrativas

---

#  Usuarios de Prueba

##  ADMIN

### Usuario

```text
admin
