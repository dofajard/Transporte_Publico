
# Sistema de Gestión para Cooperativa de Transporte de Buses

## Descripción del Proyecto

Sistema integral desarrollado en Java para la administración y gestión de una cooperativa de transporte de buses. La aplicación permite el control completo de buses, conductores, pasajeros, rutas y transacciones comerciales a través de una interfaz de consola interactiva.

## Tabla de Contenidos

1. [Conceptos Utilizados](#conceptos-utilizados)
2. [UML](#uml)
3. [Características del Sistema](#características-del-sistema)
4. [Flujo Principal de Operación](#flujo-principal-de-operación)
5. [Validaciones Implementadas](#validaciones-implementadas)
6. [Estructura del Proyecto](#estructura-del-proyecto)
7. [Conclusión](#conclusión)


## Conceptos Utilizados

- **Programación Orientada a Objetos**: Encapsulamiento, herencia, polimorfismo
- **Interfaces específicas**: Interfaces para comportamientos específicos `Pagable`, `Reservable`
- **Manejo de Excepciones**: Control de errores de dominio específicos

## UML

```
@startuml
abstract class Persona {
  - nombre : String
  - cedula : String
}

Persona <|-- Conductor
Persona <|-- Pasajero

class Conductor {
  - ruta : Ruta = null
  - tipoLicencia : String
  - experienciaAños : int
  - licenciasValidas : ArrayList<String>
}

class Pasajero {
  - boleto : Boleto = null
  - tipo : String
}

class Bus {
  - capacidadMaxima : int = 20
  - ruta : Ruta = null
  - placa : String
  - nPasajeros : int
}

class Boleto {
  - ruta : Ruta = null
  - pasajero : Pasajero = null
  - precio : double
  - fechaCompra : LocalDate
}

class Ruta {
  - distancia : double
  - activa : boolean = false
  - origen : String
  - paradas : String
  - destino : String
  + listar() : String
}

interface Reservable {
  + verificarCapacidad() : boolean
}

interface Pagable {
  + calcularPrecio(Ruta) : double
}

Bus ..|> Reservable
Boleto ..|> Pagable

class Cooperativa {
  - nombre : String
  - listaBuses : ArrayList<Bus>
  - listaConductores : ArrayList<Conductor>
  - listaPasajeros : ArrayList<Pasajero>
  - listaRutas : ArrayList<Ruta>
  - listaBoletos : ArrayList<Boleto>
  - pedirIndiceValido(Scanner sc, int max, String mensaje): int
  + menu() : void
  + menuRegistrarConductor() : void
  + menuRegistrarPasajero() : void
  + menuBus() : void
  + menuCrearRuta() : void
  + menuAsignarConductor() : void
  + menuListarRutaDisponible() : void
  + menuRegistrarVentaBoleto() : void
  + menuMostrarBoletos() : void
  + menuConsultarIngresos() : void
  + menuReporte() : void
  + menuListar() : void
}
@enduml
```

## Características del Sistema

### Módulo de Gestión de Personal
- **Sistema de Herencia**: Implementación de clase abstracta `Persona` con especializaciones en `Conductor` y `Pasajero`
- **Validación de Identificación**: Control de cédula de identidad (10 dígitos exactos)
- **Gestión de Licencias**: Validación de tipos de licencia vehicular (A, B, C, D, E, y especializaciones)
- **Control de Experiencia**: Registro y validación de años de experiencia de conductores

### Módulo de Gestión Vehicular
- **Administración de Buses**: Registro de vehículos con control de capacidad máxima
- **Validación de Placas**: Formato estandarizado (ABC-1234)
- **Sistema de Reservas**: Interface `Reservable` para control de capacidad en tiempo real
- **Asignación de Recursos**: Vinculación buses-rutas-conductores

### Módulo de Gestión de Rutas y Tarifas
- **Configuración de Rutas**: Origen, destino, paradas intermedias y distancias
- **Sistema Tarifario Automático**: Cálculo basado en distancia ($0.20 por kilómetro)
- **Política de precios**: Implementación de Interface `Pagable` 

### Módulo Transaccional y Reportes
- **Venta de Boletos**: Proceso completo con validaciones de negocio
- **Control de Venta**: Prevención de sobreventa mediante sistema de capacidad
- **Reportes**:
  - Boletos vendidos por ruta
  - Ingresos diarios desglosados
  - Análisis de rutas más demandadas

## Flujo Principal de Operación

### 1. Inicio del Sistema
Al ejecutar la aplicación, se presenta un menú interactivo con 12 opciones numeradas.

### 2. Opciones del Menú Principal

| Opción | Función | Descripción Técnica |
|--------|---------|---------------------|
| a | Registrar Conductor | Crea instancias de `Conductor` con validación de licencias |
| b | Registrar Pasajero | Instancia objetos `Pasajero` con validación de cédula |
| c | Registrar Bus | Crea objetos `Bus` con control de capacidad y placa |
| d | Crear Ruta | Configura objetos `Ruta` con paradas intermedias |
| e | Asignar Recursos | Vincula buses y conductores a rutas específicas |
| f | Listar Rutas | Muestra todas las rutas configuradas en el sistema |
| g | Venta de Boleto | Proceso transaccional completo con validaciones |
| h | Boletos por Ruta | Reporte cuantitativo de ventas por ruta |
| i | Ingresos Diarios | Consulta financiera por fecha específica |
| j | Rutas Populares | Análisis de la demanda |
| k | Recursos Disponibles | Inventario de buses/conductores sin asignar |
| l | Salir del Sistema | Cierre controlado de la aplicación |

### 3. Proceso de Venta de Boletos (Opción g)
1. Selección de ruta con validación de existencia
2. Verificación de asignación de bus y conductor
3. Control de capacidad disponible
4. Selección de pasajero registrado
5. Prevención de duplicidad de boletos
6. Cálculo automático de tarifa
7. Confirmación y registro de la transacción


## Validaciones Implementadas

### Validaciones de Datos Personales
- **Formato de Cédula**: 10 caracteres numéricos
- **Nombres Válidos**: Rechazo de entrada numérica en campos de texto
- **Licencias Vehiculares**: Catálogo predefinido de tipos válidos

### Validaciones de Negocio
- **Capacidad Máxima**: Control de límites de pasajeros por bus
- **Integridad Referencial**: Verificación de existencia de entidades relacionadas
- **Unicidad**: Prevención de asignaciones duplicadas
- **Consistencia Temporal**: Validación de fechas en transacciones

### Validaciones de Formato
- **Placas Vehiculares**: Patrón [A-Z]{3}-\\d{4}
- **Fechas**: Formato (AAAA-MM-DD)
- **Distancias**: Valores numéricos positivos

## Estructura del Proyecto

```
proyecto_buses/
├── Proyecto_Buses.java          # Punto de entrada de la aplicación
├── Cooperativa.java             # Lógica principal y menú
├── Persona.java                 # Clase base abstracta
├── Conductor.java              # Especialización con licencias
├── Pasajero.java               # Especialización para clientes
├── Bus.java                    # Gestión vehicular
├── Ruta.java                   # Configuración de rutas
├── Boleto.java                 # Gestión transaccional
├── Pagable.java                # Contrato para cálculos
├── Reservable.java             # Contrato para capacidad
├── CapacidadExcedida.java      # Excepción de negocio
├── ChoferOcupado.java          # Excepción de negocio
├── RutaSinBus.java             # Excepción de negocio
├── RutaInexistente.java        # Excepción de negocio
├── PasajeroInexistente.java    # Excepción de negocio
└── BoletoDuplicado.java        # Excepción de negocio
```

## Conclusión

Este programa representa eficientemente un sistema para la gestión de cooperativas de transporte. La arquitectura orientada a objetos permite fácil extensibilidad para futuras funcionalidades, mientras que el sistema de validaciones garantiza la integridad de los datos y las reglas de negocio.

### Principales Logros Técnicos
- Diseño modular con bajo acoplamiento
- Sistema con validaciones comprehensivas
- Manejo de casos excepcionales
- Interfaz de usuario intuitiva
- Código mantenible y documentado

---

**Programación Orientada a Objetos**
**- ESPOL -**
**II PAO 2025**
