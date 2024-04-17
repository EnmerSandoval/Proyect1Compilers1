package org.example.classes;

import org.example.classes.components.Component;

import java.util.ArrayList;

public class ClassPrincipal {
    private ArrayList<WebSite> webSites;
    private ArrayList<Page> pages;
    private ArrayList<Component> components;

    public ClassPrincipal(ArrayList<WebSite> webSites, ArrayList<Page> pages, ArrayList<Component> components) {
        this.webSites = webSites;
        this.pages = pages;
        this.components = components;
    }

    public ClassPrincipal() {
    }

    public ArrayList<WebSite> getWebSites() {
        return webSites;
    }

    public void setWebSites(ArrayList<WebSite> webSites) {
        this.webSites = webSites;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }
}
