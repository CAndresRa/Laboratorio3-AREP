# Clientes y Servicios
### Autor: Carlos Andrés Ramírez Torres
### Fecha: Miercoles, 2 de Septiembre del 2020


## Link a Heroku

[Heroku](https://labarep3.herokuapp.com/index.html)

## Uso 

Para el desarrollo del proyecto se utilizo **Maven** como una herramienta para la construccion y gestion del mismo, el codigo fue desarrollado con el lenguaje de programación **Java**.

Utilizar `mvn package` para la generacion del fichero .jar con los .class compilados.

![](https://github.com/CAndresRa/ARSW-CuartoLaboratorio/blob/master/imgReadme/mvn%20package.png)

Una vez realizado el `mvn package` el codigo estara listo para ser utilizado bajo la siguiente estructura.

Para ejecutar el programa se utilizara desde la terminal el siguiente comando en terminal dando inicio al servidor web:

`java -cp target/classes edu.escuelaing.arsw.app.App.App`
 
por ejemplo:

![Texto alternativo](https://github.com/CAndresRa/ARSW-CuartoLaboratorio/blob/master/imgReadme/uso.png)

Como se puede observar el servidor web inicia y se muestra un mensaje que indica que esta esuchando por el **puerto 35000**:

A continuacion se puede proceder a la utilizacion mediante el browser, para esto, se debe poner la siguiente URL para solicitar diferentes archivos desde el cliente al servidor:

`http://127.0.0.1:3500/<path del archivo solicitado>`

Los archivos a los cuales el servidor responde tienen las siguientes extensiones:

* Javascript `.js`
* HTML `.html`
* CSS `.css`
* PNG `.png`
* JPG `.jpg`
* JPEG `.jpeg`
* SVG `.svg`

Algunos de los archivos de los que dispone el servidor son:

* `http://127.0.0.1:3500/index.html`
* `http://127.0.0.1:3500/pngfile.png`
* `http://127.0.0.1:3500/jpgfile.jpg`

Por ejemplo:

![Texto alternativo](https://github.com/CAndresRa/ARSW-CuartoLaboratorio/blob/master/imgReadme/browser1.png)

![Texto alternativo](https://github.com/CAndresRa/ARSW-CuartoLaboratorio/blob/master/imgReadme/browser2.png)

Cuando el **PATH** ingresado por el usuario es incorrecto debido a que el archivo no existe se enviara un mensaje de error **404** como se muestra a continuacion:

![Texto alternativo](https://github.com/CAndresRa/ARSW-CuartoLaboratorio/blob/master/imgReadme/Error%20404.png)


## Arquitectura


## Pruebas 

Se han realizado un **total de 5 JUnit test** con el fin de garantizar que el servidor encuentre y retorne los diferentes archivos solicitados mediante la **URL** adicionalmente mediante **JMeter** se realizaron **Pruebas de carga** sobre el servidor que buscan verificar la respuesta concurrente del mismo, las pruebas se explicaran a continuacion.

* Lectura de archivos existentes.
* Lectura de archivos no encontrados.
* Pruebas de carga sobre el servidor.

### Pruebas implementadas

![]()

### Utilizando el comando de `mvn test`

![]()


