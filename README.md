# lanyu-ui
Libreria de apoyo para Java swing

## Listado de componentes incluidos

`es.lanyu.ui.iconos`: Es un paquete con iconos
* Iconos: de uso habitual (ok, error, papelera, guardar...). Tienes asociadas las imagenes en la carpeta de recursos.

`es.lanyu.ui.swing`: Paquete de componentes para [Java Swing](https://es.wikipedia.org/wiki/Swing_(biblioteca_gr%C3%A1fica))
* Esta dividido en varias partes:
    * `[root]`: Colección de componentes
        * `Activable`: interface usada para utilizar en componentes que pueden ser activados.
        * `BotonAccion`: especialización de `JButton` que acepta un texto de acción para uso con varios listener controlados por esta clase. Tiene algún aspecto visual personalizado como evitar el cuadro de focus tan molesto de los botones swing.
        * `BotonAccionActivable`: especialización de `BotonAccion` que implementa `Activable`.
        * `SimpleJTable`: especialización de JTable que construye instancias tomando como parámetros una lista de los elementos para las filas, nombres de columnas y las funciones que se usaran para renderizar cada celda.
    * `listener`: Colección de listeners para facilitar ciertas acciones:
        * `ArrastradorListener`: se usa para actualizar posiciones mientras se arrastra (típica herramienta "mover")
        * `AtributoCambiaEvent`: evento que se utiliza para comunicar cambios en atributos.
        * `AtributoCambiaListener`: se usa para reaccionar ante el evento anterior
        * `BuscaArchivoListener`: se usa para trabajar mientras se buscan archivos en carpetas
        * `Delimitable`: interface utilizada para informar sobre si la acción está dentro de los límites del objeto o no
        * `HandScrollListener`: se usa para mover la posición de la vista (típica herramienta "mano")
        * `Util`: clase de utilidades. Se puede usar para abrir en el navegador una URL
    * `render`: Colección de renders personalizados
        * `CondicionalCustomRender`: especialización de `CustomRender` en función de una condición
        * `CustomRender`: especialización de `TableCellRenderer` para facilitar la personalización del renderizado de celdas en una tabla