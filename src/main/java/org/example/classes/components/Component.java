package org.example.classes.components;
import java.util.List;

public class Component {
    private String idComponent;
    private String page;
    private String classComponent;

    /*Agregar TODOS LOS ATRIBUTOS
            podes hacer un componente que tenga todos los ATRUUTOS QUE SE VAYAN A USAR
                - texto
                - alineacion
                - color
                - alto
                - ancho
                - src
                - padre
                - etiquetas
                y que incluya un tipo
            O haces un componente que extienda a tipos de componentes
                - imgCompo
                - vidComp
                - TittleComp
                - ParComp
                - menuComp

           entonces en el cup, seteas el tipo segun sea la gramatica que lo devuelve
           seteas los atributos que va a usar con un constructor
           y devolves el objeto componente

           por lo tanto tus paginas y sitios estarian formadas por
            - id
            --- parametros- ---
            arraylist<componente> componentes

           entonces en la creacion en medio del body, antes del footer, listarias todos los componentes
           los generarias por tipo
           y lo agregarias al stringbuilder de la pagina o sitio que estas cosntruyendo
           antes de cerrar body y html



    */
    //Constructor para crear y editar componente
    public Component(String idComponent, String page, String classComponent) {
        this.idComponent = idComponent;
        this.page = page;
        this.classComponent = classComponent;

    }

    public Component(String idComponent) {
        this.idComponent = idComponent;
    }

    public Component() {
    }
}