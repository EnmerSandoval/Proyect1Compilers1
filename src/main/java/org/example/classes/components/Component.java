package org.example.classes.components;
import java.util.List;

public class Component {
    private String idComponent;
    private String page;
    private String classComponent;
    private int flag;


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