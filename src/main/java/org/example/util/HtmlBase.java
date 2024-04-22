package org.example.util;

import org.example.classes.Page;
import org.example.classes.WebSite;
import org.example.classes.components.Component;
import org.example.classes.components.ImageComponent;
import org.example.classes.components.TextComponent;
import org.example.classes.components.VideoComponent;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class HtmlBase {

    private String PATH = "src/main/java/org/example/sites/";

    public boolean deleteSite(WebSite webSite){
            return false;
    }

    public String juntarString(Page page){
        StringBuilder createIndex = new StringBuilder();
        createIndex.append(headTemplateHtml(page));
        createIndex.append(htmlTemplate(page));
        if(!page.getComponents().isEmpty()){
            createIndex.append(atributsComponents(page.getComponents()));
        }
        createIndex.append(footTemplateHtml(page));
        return createIndex.toString();
    }

    public String atributsComponents(ArrayList<Component> components){
        StringBuilder c = new StringBuilder();
        for (Component component : components){
            if(component instanceof ImageComponent){
                ImageComponent imageComponent = (ImageComponent) component;
                c.append(componentImage(imageComponent));
            } else if(component instanceof  VideoComponent){
                VideoComponent videoComponent = (VideoComponent) component;
                c.append(componentVideo(videoComponent));
            } else if(component instanceof  TextComponent && component.getClassComponent().equals("PARRAFO")){
                TextComponent textComponent = (TextComponent) component;
                c.append(componentParagraph(textComponent));
            } else if(component instanceof  TextComponent && component.getClassComponent().equals("TITULO")){
                TextComponent textComponent = (TextComponent) component;
                c.append(componentTitle(textComponent));
            }
        }
        return c.toString();
    }

    public String headTemplateHtml(Page page){
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("<title>" + page.getTitle() + "</title>\n");
        return htmlBuilder.toString();
    }
    public String htmlTemplate(Page page){
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("</head>\n");
            htmlBuilder.append("<body>\n");
        return htmlBuilder.toString();
    }

    public String footTemplateHtml(Page page){
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>\n");
        return htmlBuilder.toString();
    }

    public String componentParagraph(TextComponent textComponent){
        StringBuilder htmlBuilder = new StringBuilder();
        if(textComponent.getClassComponent().equals("PARRAFO")){
                    htmlBuilder.append("<p id=\"" + textComponent.getIdComponent() + "\" ");
                    if(textComponent.getColor() != null){
                        htmlBuilder.append("style=\"color: " + textComponent.getColor() + " \" ;");
                    }
                    if(textComponent.getLineUp() != null){
                        htmlBuilder.append(" text-align: " + textComponent.getLineUp() + ";\" >\n");
                    }
                    htmlBuilder.append(textComponent.getText() + "\n");
                    htmlBuilder.append("</p>");
        }
        return htmlBuilder.toString();
    }

    public String componentVideo(VideoComponent videoComponent){
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<img id=\""+ videoComponent.getIdComponent() + "\" src=\"" +
                videoComponent.getOrigin() + "\" style=\" display: block; " +
                "width: " + videoComponent.getWide() + "px; height: "
                + videoComponent.getHeight() + "px; \" > \n");
        return htmlBuilder.toString();
    }
    public String componentImage(ImageComponent imageComponent){
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<img id=\""+ imageComponent.getIdComponent() + "\" src=\"" +
                imageComponent.getOrigin() + "\" style=\" display: block; " +
                "width: " + imageComponent.getWide() + "px; height: "
                + imageComponent.getHeight() + "px; \" > \n");
        return htmlBuilder.toString();
    }

    public String componentTitle(TextComponent textComponent){
        StringBuilder htmlBuilder = new StringBuilder();
        if(textComponent.getClassComponent().equals("TITULO")){
            if(!textComponent.getIdComponent().equals(null)){
                htmlBuilder.append("<h1 id=\"" + textComponent.getIdComponent() + "\" ");
                if(textComponent.getColor() != null){
                    htmlBuilder.append("style=\"color: " + textComponent.getColor() + " \" ;");
                }
                if(textComponent.getLineUp() != null){
                    htmlBuilder.append(" text-align: " + textComponent.getLineUp() + ";\" >\n");
                }
                htmlBuilder.append(textComponent.getText() + "\n");
                htmlBuilder.append("</h1>");
            } else {
                htmlBuilder.append("<h1>" + textComponent.getText() + "</h1>");
            }
        }
        return htmlBuilder.toString();
    }


    public boolean existDirectorySite(String directory){
        File file = new File(directory);
        if (file.exists()){
            return true;
        } else {
            return false;
        }
    }


    public boolean pageDeleted(Page page){
        String path = PATH + page.getSite() + "/" + page.getId() + ".html";
        File file = new File(path);
        File fileXml = new File(pathSiteXml(page));
        if (file.exists()) {
            if(fileXml.exists()){
                if (file.delete()){
                    if (fileXml.delete()){
                        JOptionPane.showMessageDialog(null, "Se ha eliminado la pagina correctamente");
                        return true;
                    }else {
                        JOptionPane.showMessageDialog(null, "Se ha eliminado unicamente el html");
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un erro al querer eliminar la pagina");
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningun archivo de este nombre");
        }
        return  false;
    }

    public boolean siteDeleted(File file){
        if (!file.exists()){
            return false;
        }
        try {
            for (File files : file.listFiles()){
                if(file.isDirectory()){
                    siteDeleted(file);
                } else {
                    if(!files.delete()){
                        System.out.println("Error al querer eliminar el archivo: " + files.getName());
                        return false;
                    }
                }
            }
            if(!file.delete()){
                System.out.println("Error al eliminar la carpeta: " + file.getName());
                return false;
            }
            return true;
        } catch (Exception e){
            System.out.println("No se pueden eliminar archivos");
            e.printStackTrace();
            return false;
        }
    }


    public String pathSiteXml(Page page){
        return PATH + page.getSite() + "/" + page.getId() + ".xml";
    }

    public String searchDirectorySite(WebSite webSite){
        return PATH + webSite.getId();
    }
}
