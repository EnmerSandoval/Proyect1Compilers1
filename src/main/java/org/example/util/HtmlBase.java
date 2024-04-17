package org.example.util;

import org.example.classes.Page;
import org.example.classes.WebSite;

import java.io.File;

public class HtmlBase {

    private String PATH = "src/main/java/org/example/sites/";

    public void htmlTemplate(Page page){
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html>\n");
            htmlBuilder.append("<head>\n");
            htmlBuilder.append("<title>" + page.getTitle());
            htmlBuilder.append("</head>\n");
            htmlBuilder.append("<body>\n");
            htmlBuilder.append("</body>\n");
            htmlBuilder.append("</html>\n");
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
    //Crear metodos en los que se puedan definir por cada componente



    public String searchDirectorySite(Page page){
        return PATH + page.getSite();
    }
}
