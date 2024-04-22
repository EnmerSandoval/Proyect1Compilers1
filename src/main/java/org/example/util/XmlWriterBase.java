package org.example.util;

import org.example.classes.Page;
import org.example.classes.WebSite;
import org.example.classes.components.Component;
import org.example.classes.components.ImageComponent;
import org.example.classes.components.TextComponent;
import org.example.classes.components.VideoComponent;

import java.util.ArrayList;

public class XmlWriterBase {

    public XmlWriterBase() {
    }

    public String newSite(WebSite webSite){
        StringBuilder creationDoc = new StringBuilder();
        creationDoc.append("<accion nombre=\"NUEVO_SITIO_WEB\">\n");
        creationDoc.append("<parametros>");
        creationDoc.append("<parametro nombre=\"ID\">\n");
        creationDoc.append("[" + webSite.getId() + "]");
        creationDoc.append("</parametro>\n");
        creationDoc.append("<parametro nombre=\"USUARIO_CREACION\">\n");
        creationDoc.append("["+webSite.getUserCreator()+"]");
        creationDoc.append("</parametro>\n");
        creationDoc.append("<parametro nombre=\"FECHA_CREACION\">\n");
        creationDoc.append("["+ webSite.getCreationDate() +"]");
        creationDoc.append("</parametro>\n");
        creationDoc.append("<parametro nombre=\"FECHA_MODIFICACION\">\n");
        creationDoc.append("["+ webSite.getModificationDate() +"]");
        creationDoc.append("</parametro>\n");
        creationDoc.append("<parametro nombre=\"USUARIO_MODIFICACION\">\n");
        creationDoc.append("["+ webSite.getUserModification()+"]");
        creationDoc.append("</parametro>\n");
        creationDoc.append("</parametros>\n");
        creationDoc.append("</accion>\n");
        return creationDoc.toString();
    }

    public String newPage(Page page){
        StringBuilder c = new StringBuilder();
        c.append(initActions());
        c.append(headPage(page));
        for (int i = 0; i < page.getComponents().size(); i++) {
            System.out.println(page.getComponents().get(i).getClassComponent());
        }
        if(!page.getComponents().isEmpty()){
            c.append(atributNewPage(page.getComponents()));
        }
        c.append(endActions());
        return c.toString();
    }

    public String onlyComponent(Component component){
        StringBuilder c = new StringBuilder();
        c.append(verifyComponent(component));
        return c.toString();
    }

    public String headPage(Page page){
        StringBuilder s = new StringBuilder();
        s.append("<accion nombre=\"NUEVA_PAGINA\">\n");
        s.append("<parametros>\n");
        s.append("<parametro nombre=\"ID\">\n");
        s.append("[").append(page.getId()).append("]\n");
        s.append("</parametro>\n");
        s.append("<parametro nombre=\"TITULO\">\n");
        s.append("[").append(page.getTitle()).append("]\n");
        s.append("</parametro>\n");
        s.append("<parametro nombre=\"SITIO\">\n");
        s.append("[").append(page.getSite()).append("]\n");
        s.append("</parametro>\n");
        if (page.getParent() != null && !page.getParent().isEmpty()) {
            s.append("<parametro nombre=\"PADRE\">\n");
            s.append("[").append(page.getParent()).append("]\n");
            s.append("</parametro>\n");
        }
        s.append("<parametro nombre=\"USUARIO_CREACION\">\n");
        s.append("[").append(page.getUserCreator()).append("]\n");
        s.append("</parametro>\n");
        s.append("<parametro nombre=\"FECHA_CREACION\">\n");
        s.append("[").append(page.getCreationDate()).append("]\n");
        s.append("</parametro>\n");
        s.append("<parametro nombre=\"FECHA_MODIFICACION\">\n");
        s.append("[").append(page.getModificationDate()).append("]\n");
        s.append("</parametro>\n");
        s.append("<parametro nombre=\"USUARIO_MODIFICACION\">\n");
        s.append("[").append(page.getModificationUser()).append("]\n");
        s.append("</parametro>\n");
        s.append("</parametros>\n");
        s.append("</accion>\n");
        return s.toString();
    }

    public String atributNewPage(ArrayList<Component> componentPage){
        StringBuilder s = new StringBuilder();
            for (Component component : componentPage){
                s.append(verifyComponent(component));
            }
        return s.toString();
    }

    public String verifyComponent(Component component){
        StringBuilder s = new StringBuilder();
        s.append(addComponent());
        if (component instanceof ImageComponent){
            ImageComponent imageComponent = (ImageComponent) component;
            s.append(headComponents(imageComponent));
            s.append(atributsImageComponents(imageComponent));
        } else if(component instanceof TextComponent){
            TextComponent textComponent = (TextComponent) component;
            s.append(headComponents(textComponent));
            s.append(atributsTextComponents(textComponent));
        } else if (component instanceof VideoComponent){
            VideoComponent videoComponent = (VideoComponent) component;
            s.append(headComponents(videoComponent));
            s.append(atributsVideoComponent(videoComponent));
        } else {
            System.out.println("Aca no entro a nada");
        }
        s.append(endAction());
        return s.toString();
    }

    public String headComponents(Component component){
        return "<parametros>\n" +
                "<parametro nombre=\"ID\">\n" +
                "["+component.getIdComponent()+"]\n" +
                "</parametro>\n" +
                "<parametro nombre=\"PAGINA\">\n" +
                "["+component.getPage()+"]\n" +
                "</parametro>\n" +
                "<parametro nombre=\"CLASE\">\n" +
                "["+component.getClassComponent()+"]\n" +
                "</parametro>\n" +
                "</parametros>\n"
                ;
    }

    public String atributsImageComponents(ImageComponent imageComponent){
        StringBuilder s = new StringBuilder();
        s.append("<atributos>\n");
        s.append("<atributo nombre=\"ORIGEN\">\n");
        s.append("[").append(imageComponent.getOrigin()).append("]\n");
        s.append("</atributo>\n");
        if(imageComponent.getLineUp() != null){
            s.append("<atributo nombre=\"ALINEACION\">\n");
            s.append("[").append(imageComponent.getLineUp()).append("]\n");
            s.append("</atributo>\n");
        }
        s.append("<atributo nombre=\"ALTURA\">\n");
        s.append("[").append(imageComponent.getHeight()).append("]\n");
        s.append("</atributo>\n");
        s.append("<atributo nombre=\"ANCHO\">\n");
        s.append("[").append(imageComponent.getWide()).append("]\n");
        s.append("</atributo>\n");
        s.append("</atributos>\n");
        return s.toString();
    }

    public String atributsTextComponents(TextComponent textComponent){
        StringBuilder s = new StringBuilder();
        s.append("<atributos>\n");
        s.append("<atributo nombre=\"TEXTO\">\n");
        s.append("[").append(textComponent.getText()).append("]\n");
        s.append("</atributo>\n");
        if (textComponent.getLineUp() != null) {
            s.append("<atributo nombre=\"ALINEACION\">\n");
            s.append("[").append(textComponent.getLineUp()).append("]\n");
            s.append("</atributo>\n");
        }
        if (textComponent.getColor() != null) {
            s.append("<atributo nombre=\"COLOR\">\n");
            s.append("[").append(textComponent.getColor()).append("]\n");
            s.append("</atributo>\n");
        }
        s.append("</atributos>\n");
        return s.toString();
    }

    public String atributsVideoComponent(VideoComponent videoComponent){
        StringBuilder s = new StringBuilder();
        s.append("<atributos>\n");
        s.append("<atributo nombre=\"ORIGEN\">\n");
        s.append("[").append(videoComponent.getOrigin()).append("]\n");
        s.append("</atributo>\n");
        s.append("<atributo nombre=\"ALTURA\">\n");
        s.append("[").append(videoComponent.getHeight()).append("]\n");
        s.append("</atributo>\n");
        s.append("<atributo nombre=\"ANCHO\">\n");
        s.append("[").append(videoComponent.getWide()).append("]\n");
        s.append("</atributo>\n");
        s.append("</atributos>\n");
        return s.toString();
    }



   // public String deleteComponentByText(Page page, String );

    public String addComponent(){
        return "<accion nombre=\"AGREGAR_COMPONENTE\">";
    }

    public String endAction(){
        return "</accion>";
    }

    public String initActions(){
        return "<acciones>";
    }

    public String endActions(){
        return "</acciones>";
    }


}