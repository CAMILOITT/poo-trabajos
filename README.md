# poo-trabajos

Este repositorio se va a utilizar para realizar los trabajos grupales de programación 3, de todo el semestre.

## Indice

1. [Instalaciones del repositorio](#instalaciones-del-repositorio)
2. [Formas de trabajo]()

## Instalaciones del repositorio

Como primer paso debes de tener instalado git y gh, para conocer si lo tienes instalado correctamente puedes ejecutar el comando.

```bash
-> program3 git:(main) x  gh version
gh version 2.46.0 (2026-06-18 Ubuntu 2.46.0-4ubuntu0.26.04.1~esm1)
https://github.com/cli/cli/releases/tag/v2.46.0

-> program3 git:(main) x git -v
git version 2.53.0
```

## Comandos básicos

Para la utilizacion de github se va a utilizar una serie de comandos fundamentales para la interaccion con este programa, no es necesario aprender o utilizar esto, puesto que existe herramientas fuera y dentro del IDE que se utilize, sin embargo es importante familiarizarse con estos comandos, en caso de que estas herramientas no las tengamos a mano.

### 1. Clonar el repositorio

Para clonar un repositorio se sigue la siguiente estructura: `git clone [url del repositorio]`, es el comando mas basico que se puede utilizar sin embargo se puede utilizar otros metodos, como se puede ver en el siguiente ejemplo:

```bash
-> program3 git:(main) x  git clone https://github.com/CAMILOITT/poo-trabajos.git

#  ---- o -----


-> program3 git:(main) x  gh repo clone CAMILOITT/poo-trabajos

```

> [!NOTE]
> En este ejemplo se ha insertado la url del repositorio para que puedan simplemente copiar y pegar.

### 2. Introduccion a ramas

Las ramas en GITHUB son muy importantes puesto a que son utilizadas para trabajar en distintas partes del programa, sin romper el programa principal. ahora bien como primer paso se debe entender que existe 2 entornos de desarrollo, el entorno local y remoto. Cuando ejecutamos cualquier comando de git estos cambios solo se aplica al entorno local, es decir que no se vera los cambios en github. Por lo cual al crear nuestra primera rama con `git branch [nombre de la rama]`, la rama se creara en nuestra pc como se ve en el ejemplo.

```bash
-> program3 git:(main) x git branch deber1
-> program3 git:(main) x git branch
  deber1
* main
-> program3 git:(main) x git branch -r
  origin/main
```

Como se puede apreciar en el ejemplo se crear una rama con `git branch`, sin embargo al revisar las ramas del repositorio, se observa que solo existe la rama `origin/main`

> [!NOTE]
> como se ve en el ejemplo el comando branch tiene varias funcionalidades las cuales son:
>
> - git branch: muestra las ramas que tiene en local
> - git branch [rama]: crea una nueva rama en local
> - git branch -r: muestra las ramas remotas
> - git branch [rama] -d: elimina una rama en local

### Cambiar de rama

en github existe dos formas de cambiar de rama, utilizando el comando `git checkout [rama]` o `git switch [rama]`, las dos son similares, asi que no importa cual utilizes realmente.

> [!WARNING]
> Ten en cuenta que para cambiar de rama no debes de tener cambios sin subir en tu rama local, caso contrario no te permitira el cambio, para solucionar esto existe dos opciones:
>
> 1. subir tus cambios a la rama [mas informacion](#subir-cambios)
> 2. guardar temporalmente los cambios en local, para ello se utiliza el comando `git stash`.

## Subir Cambios

github cuenta

> [!IMPORTANT]
> Ten en cuenta que es posible que te pidan cierta configuraciones antes de poder participar en el proyecto. en caso de que tengas algun error al hacer un push verifica si tienes configurado el global.email y global.username de git en local para que puedas subir los cambios.

## Formas de trabajar en el repositorio

Para mantener una misma estructura entre todo el repositorio se recomienda trabajar de la siguiente manera:

```txt
poo-trabajos
|
|--[clase|deber][Tema]
|     |
|     |--[archivo Dia]
|     |--demas-archivos-java...
demas-directorios.....
```

### Practicas de codigo y UML en java

Para mantener una coherencia del desarrollo de estas aplicaciones se sugiere seguir la siguiente nomenclatura:

|tipo de dato|nomenclatura|ejemplo|
|--|--|--|
|Clases e Interfaces|PascalCase|UserProfileManager, PaymentRepository|
|Métodos y Variables|camelCase|calculateTotal(), userEmail|
|Constantes|UPPER_SNAKE_CASE|MAX_RETRY_ATTEMPTS|
|Paquetes|Minúsculas contiguas|com.empresa.proyecto.service|
