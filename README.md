

[translation (english)](README-en.md)


# Aplicación que utiliza el patrón de diseño MVP para consumir datos de Firebase en la plataforma Android

Este proyecto tiene las siguientes caracteristicas

* Proyecto separado en paquetes para mejor identificación de cada elemento
* Uso de Cloud Firestore en lugar de Realtime database por su eficiencia y facilidad
* Uso eficiente de recursos ya que solo se actualiza y notifica el elemento modificado

# ¿Qué es el patrón de diseño MVP?

MVP por sus siglas Model View Presenter es una derivación del conocido patrón MVC (Modelo Vista Controlador) donde se implementa interfaces para notificar de los cambios que se estan realizando en la vista (View) mendiante el presentador (Presenter), o viceversa, teniendo como datos en común al modelo (Model), existen diferentes aproximaciones a este patron de diseño, en este proyecto se hace uso de una interfaz principal <b>Contract</b> que define las interfaces de la vista y del presentador, y se hace uso de clase denominada <b>Interactor</b> la cual es la que realiza los procesos principales de escucha de evento en firebase.
