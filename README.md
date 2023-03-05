Proyecto realizado con SpringBoot y base de datos h2

Realiza una busca de precios dado los identificadores de producto, marca y fecha de aplicación

-Scripts de esquema y datos para la carga de la información en la base de datos h2.
- El proyecto se ejecuta en el puerto 8080
- Para las pruebas unitarias no hay puerto definido, la aplicación asigna uno.
- Se incluye una prueba unitaria adicional para el caso en que no se encuentre un precio. additionalTest()


Nota: Haciendo uso del formato de fecha en el ejercicio yyyy-MM-dd-HH.mm.ss, se configura el sistema para guardar en base de datos y recibir por parámetro en la API.
