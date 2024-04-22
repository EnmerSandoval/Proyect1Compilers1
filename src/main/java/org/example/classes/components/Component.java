package org.example.classes.components;
import java.util.List;

public class Component {
    private String idComponent;
    private String page;
    private String classComponent;
    private int flag;

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
    public Component(String idComponent, String page, String classComponent, int flag) {
        this.idComponent = idComponent;
        this.page = page;
        this.classComponent = classComponent;
        this.flag = flag;
    }

    public Component(String idComponent, String classComponent, int flag) {
        this.idComponent = idComponent;
        this.classComponent = classComponent;
        this.flag = flag;
    }

    public Component(int flag) {
        this.flag = flag;
    }

    public Component(String idComponent) {
        this.idComponent = idComponent;
    }

    public Component() {
    }

    public String getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(String idComponent) {
        this.idComponent = idComponent;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getClassComponent() {
        return classComponent;
    }

    public void setClassComponent(String classComponent) {
        this.classComponent = classComponent;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}