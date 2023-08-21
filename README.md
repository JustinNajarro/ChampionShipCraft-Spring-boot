#CHAMPIONSHIPCRAFT
## Introducción:
En el apasionante mundo del fútbol, la organización y administración de campeonatos y torneos ha sido un desafío constante para los amantes de este deporte. La necesidad de una plataforma eficiente y práctica para gestionar de manera integral los diferentes aspectos de un campeonato ha llevado a la creación de ChampionShipCraft. Este proyecto nace con la firme intención de revolucionar la forma en que se planifican, ejecutan y siguen los torneos de fútbol, brindando a los administradores una herramienta poderosa y versátil para llevar a cabo sus competiciones de manera fluida y organizada.

## Problema:
El proceso manual de gestionar campeonatos de fútbol ha sido una fuente constante de demoras y desafíos. Desde la creación y planificación de torneos hasta la asignación de fechas y horarios, y la comunicación de resultados, cada paso ha requerido una inversión significativa de tiempo y esfuerzo. Esta aproximación manual ha resultado en retrasos en la programación, errores en los registros y una comunicación ineficiente de los resultados. Además, mantener actualizada la información en tiempo real ha sido una tarea compleja y propensa a errores, lo que ha restado eficiencia a la experiencia de los equipos y aficionados.

## Solución:
ChampionShipCraft tiene como objetivo resolver estos problemas al introducir una plataforma digital altamente automatizada. Al eliminar las tareas manuales tediosas y propensas a errores, esta plataforma permitirá a los organizadores centrarse en la esencia del torneo: la emoción del juego y la competición. La creación de torneos se convertirá en un proceso rápido y eficiente, la programación de partidos se realizará de manera fluida, los resultados se registrarán y comunicarán en tiempo real, y las tablas de posiciones estarán siempre actualizadas.

## Tecnologías Utilizadas

- Java, Spring Boot.
- Javascript.
- Thymeleaf.
- Mysql.
- ApacheReports.


## Instalación:
### Paso 1
- Crear una carpeta ingresar a gitbash y ejecutar.
- git clone link del repository.
### Paso 2
- Crear una base de datos en Mysql con el nombre **bd_championShipCraft**.
- Luego restaurar el archivo de la base de datos **BD_CHAMPION.sql**.
### Paso 3
- Configurar tu user de mysql en el archivo **properties** de spring boot.
- Configurar tu password de mysql en el archivo **properties** de spring boot.

## Definición y especificación de requerimientos
### Módulo de Usuarios
- Registrar Usuarios: Los usuarios pueden crear cuentas de usuario proporcionando información como nombre, dirección de correo electrónico y contraseña segura.
- Iniciar Sesión (Logear Usuarios): Los usuarios registrados pueden acceder a la plataforma utilizando sus credenciales de inicio de sesión.
### Módulo de Torneos
- Registrar Torneos: Los administradores pueden crear nuevos torneos, asignándoles un nombre, modadlidad, organizador, etc.
- Mostrar Torneos: Los administradores pueden ver la lista de sus  torneos creados, incluyendo detalles como el nombre, la descripción, etc.
- Seguir Torneos: Los usuarios, jugadores o aficionados de algun torneo podran revisar como va el avance del torneo en el apartado de Seguir Torneo.
### Módulo de Equipos
- Registrar Equipos: Los administradores pueden registrar equipos que van a  participar en los torneos. Se proporciona información sobre el nombre del equipo, organizador, etc.
- Listar Equipos: Los usuarios pueden explorar la lista de equipos registrados, accediendo a detalles como el nombre del equipo.
### Módulo de Jugadores
- Registrar Jugadores: Los administradores pueden agregar jugadores a los equipos, incluyendo detalles como el nombre, la posición en el campo, numero de camiseta y otra información relevante.
- Listar Jugadores: Los usuarios pueden consultar la lista de jugadores inscritos en cada equipo.
### Módulo de Fixture
- Generar Fixture: Los administradores pueden crear el calendario de partidos para el torneo, definiendo las fechas, horarios y equipos involucrados en cada partido.
- Reporte de Fixture: Los usuarios pueden acceder al calendario de partidos, visualizando los detalles de cada encuentro.
### Módulo de Tabla de Posiciones:
- Actualizar Tabla de Posiciones: La tabla de posiciones se actualiza automáticamente a medida que se registran los resultados de los partidos. Los puntos y la clasificación de los equipos se ajustan en consecuencia.
### Módulo de Pagos:
- Planes de Pago con PayPal: Los usuarios pueden seleccionar diferentes planes de pago para acceder a la funcionalidad de la página. La plataforma debe integrarse con PayPal para procesar los pagos de manera segura.

## Arquitectura del Sistema
El sistema fue construido en la arquitectura Modelo-Vista-Controlador(MVC) es un patrón de ampliamente utilizado para desarrollar aplicaciones web. 
### Dependecias externas
- com.paypal.sdk
- org.apache.pdfbox

#### Capa de Modelo (Entidades):
- Entidad Usuario
- Entidad Torneo
- Entidad Organizador
- Entidad Equipo
- Entidad Delegado
- Entidad Jugador
- Entidad Fixture
- Entidad Jornada
- Entidad Encuentro
- Entidad TablaPosiciones
- Entidad Orden
#### Capa de Persistencia  (Repositorios):
- Repositorio Delegado
- Repositorio Encuentro
- Repositorio Equipo
- Repositorio Fixture
- Repositorio Jornada
- Repositorio Jugador
- Repositorio Organizador
- Repositorio TablaPosciones
- Repositorio Torneo
- Repositorio Usuario
#### Capa de Servicio   (Servicios):
- Servicio Delgado
- Servicio EmailSender
- Servicio Encuentro
- Service Equipo
- Servicio Fixture
- Servicio Jornada
- Servicio Jugador
- Servicio Organizador
- Servicio PayPal
- Servicio TablaPosiciones
- Servicio Torneo
- Servicio Usuario
#### Capa de Presentación (Controladores y Vistas):
- Controlador Equipo
- Controlador Fixture
- Controlador Home
- Controlador Jugador
- Controlador Login
- Controlador PayPal
- Controlador Pdf
- Controlador Torneo
#### Capa de Seguridad:
- UsuarioSecurity
- WebSecurityConfig
- Servicio SecurityUserDetails
### Base de datos y almacenamiento
**Tabla Usuario:**
- ID_Usuario
- Nombre
- Apellidos
- Correo
- Username
- Contraseña

**Tabla Organizador:**
- ID_Organizador
- Nombre_Org
- Tipo_Documento
- Num_Documento
- Telefono

**Tabla Torneo:**
- ID_Torneo
- ID_Organizador
- Nombre_Torneo
- Direccion
- Tipo_Torneo
- Cantidad_Equipos
- Monto_Premio
- Estado
- ID_Usuario

**Tabla Delegado:**
- ID_Delegado
- Nombre
- Apellidos
- Tipo_Documento
- Num_Documento)
- Telefono

**Tabla Equipo:**
- ID_Equipo
- ID_Delegado
- Nombre_Equipo
- Nombre_corto
- Ciudad
- ID_Torneo
- FOREIGN KEY (ID_Torneo) REFERENCES TORNEO(ID_Torneo),
- FOREIGN KEY (ID_Delegado) REFERENCES DELEGADO(ID_Delegado)

**Tabla Jugador:**
- ID_Jugador
- Nombre
- Apellidos
- Num_Documento
- Num_Camiseta
- Posicion
- ID_Equipo
- FOREIGN KEY (ID_Equipo) REFERENCES EQUIPO(ID_Equipo)

**Tabla Fixture:**
- ID_Fixture
- ID_Torneo
- Cant_Jornadas
- FOREIGN KEY (ID_Torneo) REFERENCES Torneo(ID_Torneo)

**Tabla Jornada:**
- ID_Jornada INT AUTO_INCREMENT PRIMARY KEY,
- ID_Fixture INT,
- Num_Fecha INT,
- Cant_Encuentros INT,
- FOREIGN KEY (ID_Fixture) REFERENCES Fixture(ID_Fixture)

**Tabla Encuentro:**
- ID_Encuentro
- ID_Equipo_Local
- ID_Equipo_Visita 
- Equipo_Local 
- Equipo_Visita 
- Goles_Local 
- Goles_Visita 
- Fecha_Encuentro 
- Estado 
- ID_Jornada 
- FOREIGN KEY (ID_Equipo_Local) REFERENCES Equipo(ID_Equipo),
- FOREIGN KEY (ID_Equipo_Visita) REFERENCES Equipo(ID_Equipo),
- FOREIGN KEY (ID_Jornada) REFERENCES Jornada(ID_Jornada)

## Guia de Usuario
### Registrarse como Usuario
Al dirigirnos a la pagina web tendremos 2 opciones, Iniciar sesión por si ya tenemos una cuenta creada o registrar usuario. Si en caso no tienes una cuenta deberas crearte uno con datos como Nombre, NameUser, Correo y password. Al registrarte te redirigira a otra pagina donde se te dara la bienvenida a la pagina web. Si ya tienes una cuenta es tan simple como colocar tu nameUser y tu passworde de manera correcta para que ingreses al sitioweb.
### Crear un Torneo
Para crear un torneo deberar dirigirte al apartado de Torneos, se te abrira un pagina con todo los torneos que creaste o en caso eres nuevo tendras que crear uno. Crear un torneo es totalmente facil, deberas colocar datos como el nombre del torneo, cantidad de equipos, modadlidad, Nombre de la organizacion, tipo de documento, Lugar donde se jugaran los partidos y el monto del premio.
### Crear un Equipo
Para crear un equipo deberas primero escoger al torneo donde quieres registrar ese equipo por eso en el apartado de mis torneos tendras una columnas de acciones donde podras ingresar para poder registrar a los equipos en los torneos brindando datos como el nombre del delegado y el los datos del equipo.
### Registrar un Jugador
Para registrar un jugador deberas primero esciger al equipo donde quieres registrar el jugador, en las acciones de equipo tendras una opcion de registrar jugadores donde te redirigira a una pagina donde podra registrar tu jugadores brindando datos como el nombre completo, dni, numero de camiseta y posición. Ojo existe validaciones como que no puede registrar a un jugador por medio del dni en el mismo torneo o en el mismo equipo, tampoco se puede repetir los numeros de camiseta en un mismo equipo.
### Generar un Fixture
Para generar el fixture debes estar 100% seguro de que quieres iniciar tu torneo, te rediriges al apartado de Fixture y tendras un boton para genera el fixture, al darle click automaticamente se realizara la repartición de equipos y se dividiran los encuentros por jornadas que las podras seleccionar por medio de un combobox. Los encuentros tendran funciones como guardar el resultado del encuentro colocando los goles de los equipos, tambien puedes registrar la fecha y hora del encuentro. Esto para que en el apartado de seguir torneo tus seguidores puedan ver las fechas de los partidos o saber si ya esta por jugar o ya esta terminado.
### Ver Tabla de Posiciones
Para ver la tabla de posiciones deberas dirigirte al apartado posiciones donde segun se registren los encuentros podras ver tu tabla de posiciones actualizada. Tus seguidores tambien en el apartado de Seguir Torneo tus seguidores o juagadores podran vizualizar tu tabla de posiciones para enterarse de como van los encuentros o como va su equipo.
### Reporte de Fixture
Para generar el reporte de fixture tienes que estar en la vista de fixture y al generar el fixture tendras un boton que te generara un archivo pdf de todo el fixture con sus jornadas y encuentros.

## Team Developer
- Najarro Villagaray, Justin Najarro.(Base de datos y Backend)
- Lazaro Zubilllaga, Mauricio.(Backend y Frontend)
- Arias Hinostroza, Yostin Yirac.(Backend y Frontend)

## Conclusiones
ChampionShipCraft ha sido concebido con la visión de transformar la gestión de campeonatos de fútbol, abordando los desafíos persistentes que los organizadores han enfrentado durante años. La pasión por el fútbol y el reconocimiento de la necesidad de una solución más eficiente y automatizada han impulsado este proyecto desde su inicio hasta su implementación.

En respuesta al problema arraigado de la gestión manual de campeonatos, ChampionShipCraft ofrece una solución que agiliza cada aspecto del proceso, desde la creación de torneos hasta la generación de fixtures, el seguimiento de resultados y la presentación de tablas de posiciones. Mediante la adopción de tecnologías avanzadas como Java Spring Boot, JavaScript y Thymeleaf, hemos logrado crear una plataforma que unifica y simplifica todas estas tareas, liberando a los administradores y participantes de la carga de trabajo tediosa y propensa a errores.

La estructura en capas de nuestra arquitectura garantiza la modularidad y la escalabilidad de ChampionShipCraft. Cada componente tiene un propósito específico, desde la capa de presentación que interactúa con los usuarios, hasta la capa de persistencia que administra los datos en la base de datos. Esta división organizada permite un desarrollo más eficiente y un mantenimiento simplificado a medida que la plataforma crece y evoluciona.

La guía de usuario proporciona claridad sobre cómo interactuar con la plataforma, desde la creación de usuarios y la gestión de torneos hasta la generación de fixtures y la visualización de tablas de posiciones. Hemos buscado crear una experiencia intuitiva y accesible para todos los usuarios, desde los administradores hasta los seguidores y jugadores.

Al mirar hacia atrás en este viaje de desarrollo, estamos orgullosos de haber creado una solución que responde a una necesidad genuina en la comunidad del fútbol. Con ChampionShipCraft, hemos logrado simplificar y mejorar la forma en que se gestionan los torneos, promoviendo una experiencia más emocionante y sin complicaciones tanto para los organizadores como para los participantes. Este proyecto es más que tecnología; es una pasión por el deporte y un deseo de brindar soluciones efectivas a desafíos arraigados. En última instancia, ChampionShipCraft no solo representa una herramienta, sino también una contribución al mundo del fútbol y a la satisfacción de todos los que participan en él.



