# Petagram
Versión adaptada. IMPORTANTE: Esta versión no corresponde fielmente con ninguna de las actividades semanales, sino que surge de realizarle modificaciones a la actividad Petagram del curso 3.
# Descripción
En base a Material Design se eligen los colores Primary Dark, Primary, y Accent que formaran parte de la app. Se crea una app bar personalizada, que cumple con los estandares de Material Design (color, elevacion, height) dando soporte a versiones anteriores a la API 16. 

Se crea un ActionView en la app bar que permite acceder a un activity donde se almacenan las 5 mascotas favoritas, para los fines de este ejercicio los datos de favoritos son Dummy. La activity permite regresar a su clase padre mediante una flecha de subir en la actionBar, y la indicación de parentezco en el manifiesto.

En un RecyclerView se presenta una lista con las distintas mascotas. En CardView se arma el modelo que ira al RecyclerView. Se utiliza Adapter y método ViewHolder para llevarlo a cabo.
Mediante un corazón se indica "like" a una mascota.

Se crea un menú de opciones con los items "Contacto" y "Acerca de". El item "Contacto" lleva a un activity donde se encuentra un formulario que permite ingresar un asunto y un mensaje para mandar a la aplicación. Se utiliza la librería JavaMail para poder realizar el envío.
El item "Acerca de" incluye mis datos. 

Se modulariza en fragments para mostrar la información en ViewPager. Un fragment corresponde al Inicio, otro al perfil de la mascota y el último al Instagram de la misma.
Por último se genera persistencia de likes.
