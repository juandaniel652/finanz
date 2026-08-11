# Proyecto Android — Finanz

Construí una aplicación Android nativa llamada **Finanz**, cuyo objetivo es permitir registrar y consultar movimientos financieros personales de forma simple, profesional y minimalista.

## 1. Objetivo

Quiero aprender desarrollo Android moderno construyendo una mini aplicación funcional.

La aplicación debe estar completamente ejecutable y generar un APK.

**No quiero pseudocódigo ni fragmentos incompletos. Entregá archivos completos.**

## 2. Stack obligatorio

- Kotlin
- Jetpack Compose
- Material 3
- Android SDK
- Gradle
- Room
- SQLite
- ViewModel
- Kotlin Coroutines
- Flow
- Navigation Compose

No utilizar XML para las interfaces.

No agregar frameworks o librerías innecesarias.

El proyecto debe ser razonable para una computadora con **8 GB RAM y CPU Celeron 1.60 GHz**.

## 3. Arquitectura

Utilizar una arquitectura simple y clara:

```text
UI / Compose
    ↓
ViewModel
    ↓
Repository
    ↓
Room
    ↓
SQLite
```

Estructura aproximada:

```text
app/
└── src/main/java/com/example/finanz/
    ├── MainActivity.kt
    ├── data/
    │   ├── local/
    │   │   ├── AppDatabase.kt
    │   │   ├── MovementDao.kt
    │   │   ├── CategoryDao.kt
    │   │   ├── MovementEntity.kt
    │   │   └── CategoryEntity.kt
    │   └── repository/
    │       └── FinanceRepository.kt
    ├── model/
    ├── ui/
    │   ├── navigation/
    │   ├── screens/
    │   │   ├── HomeScreen.kt
    │   │   ├── MovementsScreen.kt
    │   │   ├── CategoriesScreen.kt
    │   │   ├── AddMovementScreen.kt
    │   │   └── MovementDetailScreen.kt
    │   ├── components/
    │   └── theme/
    └── viewmodel/
        └── FinanceViewModel.kt
```

Podés modificar la estructura si existe una razón técnica clara, pero mantenela simple.

## 4. Identidad visual

La aplicación debe verse como una herramienta financiera seria, no como una demo generada automáticamente.

Estilo:

- minimalista
- limpio
- profesional
- buena jerarquía visual
- mucho espacio en blanco
- componentes Material 3
- sin gradientes
- sin glassmorphism
- sin sombras exageradas
- sin animaciones innecesarias
- sin emojis como decoración

Color principal obligatorio:

```text
#059669
```

Verde esmeralda profesional.

Definí la paleta mediante constantes/tokens de Material Theme y no mediante colores escritos arbitrariamente dentro de cada componente.

Utilizar:

- `#059669` como primary.
- Un rojo sobrio para gastos.
- Neutros para fondos y superficies.
- Contraste suficiente para accesibilidad.

No inventes colores diferentes para cada pantalla.

## 5. Navegación

La navegación inferior tendrá exactamente:

```text
Inicio | Movimientos | Categorías
```

No crear sección "Más".

### Inicio

Debe mostrar:

1. Saldo grande en la parte superior.
2. Ingresos.
3. Gastos.
4. Ahorro.
5. Lista de movimientos recientes.
6. FAB `+`.

El saldo debe tener la mayor jerarquía visual.

La disposición debe recordar a una app financiera moderna, con una jerarquía similar a Mercado Pago, pero sin copiar su diseño.

### Movimientos

Mostrar todos los movimientos.

Cada movimiento debe mostrar:

- icono
- descripción
- categoría
- fecha
- importe
- signo `+` o `−`

Los ingresos deben diferenciarse mediante:

- icono
- importe verde

Los gastos mediante:

- icono
- importe rojo

Debe existir:

- búsqueda
- filtro por tipo
- filtro por categoría
- filtro por fecha/período
- ordenamiento

Cada movimiento debe permitir:

- ver detalle
- editar
- eliminar

Al eliminar, mostrar siempre una confirmación.

### Categorías

Mostrar categorías financieras predefinidas.

Usar categorías iniciales razonables, por ejemplo:

- Alimentación
- Vivienda
- Transporte
- Servicios
- Salud
- Educación
- Ocio
- Compras
- Ahorro
- Trabajo
- Otros

Debe ser posible crear categorías personalizadas.

No permitir categorías duplicadas.

## 6. Modelo de movimiento

Un movimiento debe contener como mínimo:

```text
id
type
amount
categoryId
description
date
notes
```

Tipo:

```text
INCOME
EXPENSE
```

Campos obligatorios al crear:

- tipo
- importe
- categoría

Campos opcionales:

- descripción
- notas

La fecha debe tener como valor inicial la fecha actual, pero debe poder modificarse.

Utilizar tipos adecuados de Kotlin/Room.

Evitar representar el dinero internamente mediante `Double` si existe una alternativa segura y sencilla. Preferir almacenar importes como unidades enteras mínimas, por ejemplo centavos, y convertir únicamente para presentación.

## 7. Formulario de alta

El botón FAB `+` debe abrir directamente el formulario completo.

Campos:

```text
Tipo
Importe
Categoría
Descripción
Fecha
Notas
```

Validaciones:

- tipo obligatorio
- importe obligatorio
- importe > 0
- categoría obligatoria

El botón Guardar debe permanecer deshabilitado si faltan campos obligatorios.

Mostrar errores de validación de forma clara.

Después de guardar:

```text
guardar → actualizar Room → actualizar Flow → actualizar UI
```

No utilizar datos falsos para simular persistencia.

## 8. Detalle

Al seleccionar un movimiento, mostrar todos sus datos:

- tipo
- importe
- categoría
- descripción
- fecha
- notas

Permitir editar y eliminar.

## 9. Resumen financiero

En Inicio calcular:

```text
Saldo = ingresos - gastos
Ahorro = ingresos - gastos
```

Mostrar:

```text
Saldo
Ingresos
Gastos
Ahorro
```

No agregar gráficos ni análisis avanzados en este MVP.

Los valores deben calcularse a partir de los movimientos almacenados en Room.

No hardcodear resultados.

## 10. Estados de UI

Implementar correctamente:

- lista vacía
- lista con datos
- carga
- error
- formulario inválido

Cuando no existan movimientos, mostrar un estado vacío profesional, por ejemplo:

```text
No hay movimientos todavía

Registrá tu primer movimiento
para comenzar a analizar tus finanzas.
```

Incluir una acción clara para agregar el primero.

## 11. Room

Crear:

- Entity de movimientos.
- Entity de categorías.
- DAO para movimientos.
- DAO para categorías.
- Database.
- Repository.

Los movimientos deben persistir después de cerrar y volver a abrir la aplicación.

Utilizar `Flow` para observar cambios.

No usar una lista mutable global como fuente de verdad.

## 12. ViewModel

El ViewModel debe ser responsable del estado de la pantalla y de las operaciones:

- cargar movimientos
- agregar
- editar
- eliminar
- filtrar
- calcular resumen
- gestionar categorías

La UI no debe contener lógica de negocio importante.

## 13. Compose

Usar componentes Compose apropiados:

- Scaffold
- NavigationBar
- NavigationBarItem
- FloatingActionButton
- LazyColumn
- Card cuando aporte valor
- Text
- TextField / OutlinedTextField
- Button
- IconButton
- AlertDialog
- DropdownMenu o equivalente Material 3
- DatePicker cuando sea compatible con la implementación elegida

Usar `Modifier` correctamente.

Evitar composables gigantes.

Extraer componentes reutilizables.

## 14. Responsive mobile

La aplicación está diseñada principalmente para teléfonos.

No crear tablas de escritorio.

La sección de gastos debe utilizar una **lista detallada adaptada a móvil**, manteniendo todos los datos disponibles mediante una jerarquía clara.

No comprimir demasiadas columnas horizontalmente.

## 15. Accesibilidad

- contenido textual legible
- contraste adecuado
- botones suficientemente grandes
- content descriptions para iconos relevantes
- no depender exclusivamente del color para comunicar información
- navegación coherente

## 16. Datos iniciales

La primera instalación puede incluir categorías predeterminadas.

No insertar movimientos ficticios automáticamente.

El usuario debe comenzar con una lista de movimientos vacía.

## 17. Rendimiento

La aplicación debe ser deliberadamente sencilla.

No agregar:

- Firebase
- Retrofit
- Hilt
- Koin
- gráficos
- analytics
- autenticación
- backend
- publicidad
- dependencias innecesarias

Estas funcionalidades podrán agregarse posteriormente.

## 18. Entrega

Quiero que generes el **proyecto completo**, no ejemplos parciales.

Entregá:

1. Todos los archivos necesarios.
2. `settings.gradle.kts`
3. `build.gradle.kts`
4. `app/build.gradle.kts`
5. `AndroidManifest.xml`
6. todos los archivos Kotlin
7. recursos necesarios
8. theme
9. Room
10. navegación
11. ViewModel
12. Repository
13. DAOs
14. Entities

Cada archivo debe aparecer completo con su ruta.

No uses:

```text
// resto del código...
// implementar aquí...
// etc.
```

No omitas código necesario.

## 19. Compatibilidad

Antes de generar los archivos, elegí un conjunto coherente de versiones de:

- Android Gradle Plugin
- Gradle
- Kotlin
- Compose
- Room
- Navigation Compose

No mezcles versiones incompatibles.

Priorizá estabilidad y compatibilidad sobre utilizar versiones experimentales.

## 20. Compilación

Al final proporcioná instrucciones exactas para:

```bash
./gradlew assembleDebug
```

y para instalar el APK en un teléfono Android mediante ADB.

También indicar dónde queda el APK generado.

Si detectás algún problema de compatibilidad durante la implementación, corregilo antes de entregar.

## 21. Regla fundamental

No agregues funcionalidades que no fueron solicitadas.

No conviertas el proyecto en una arquitectura empresarial.

El objetivo es obtener una aplicación pequeña, funcional, profesional y ejecutable que sirva para aprender:

```text
Kotlin
↓
Compose
↓
Estado
↓
ViewModel
↓
Repository
↓
Room
↓
SQLite
```

Generá ahora el proyecto completo.
