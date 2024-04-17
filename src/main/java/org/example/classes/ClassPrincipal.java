package org.example.classes;

import org.example.classes.components.Component;

import java.util.ArrayList;

public class ClassPrincipal {
    private int bandera;
    private ArrayList<WebSite> webSites;
    private ArrayList<Page> pages;
    private ArrayList<Component> components;

    public ClassPrincipal(int bandera, ArrayList<WebSite> webSites, ArrayList<Page> pages, ArrayList<Component> components) {
        this.bandera = bandera;
        this.webSites = webSites;
        this.pages = pages;
        this.components = components;
    }
}
