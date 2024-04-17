package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

public class Page {
    private String id;
    private String title;
    private String site;
    private String parent;
    private String userCreator;
    private String creationDate;
    private String modificationDate;
    private String modificationUser;

    //Constructor principal para poder crear la clase
    public Page(String id, String title, String site, String parent, String userCreator, String creationDate, String modificationDate, String modificationUser) {
        this.id = id;
        this.title = title;
        this.site = site;
        this.parent = parent;
        this.userCreator = userCreator;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.modificationUser = modificationUser;
    }

    //Constructor Vacio
    public Page() {
    }

    //Constructor para eliminar el sitio web
    public Page(String id) {
        this.id = id;
    }

    //Constructor para modificar la pagina


    public Page(String id, String title) {
        this.id = id;
        this.title = title;
    }

    //Obtener la fecha por si al usuario se le olvida
    public LocalDate obtenerFecha(){
        return LocalDate.now();
    }

    public void createPage(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(String userCreator) {
        this.userCreator = userCreator;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }
}