package org.example.classes;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WebSite {
    private String PATH = "src/main/java/org/example/sites/";
    private String id;
    private String userCreator;
    private String creationDate;
    private String modificationDate;
    private String userModification;
    private boolean deleteSite = false;

    public WebSite(String id, String userCreator, String creationDate, String modificationDate, String userModification, boolean deleteSite) {
        this.id = id;
        this.userCreator = userCreator;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.userModification = userModification;
        this.deleteSite = deleteSite;
    }


    public WebSite(String id, boolean deleteSite) {
        this.id = id;
        this.deleteSite = deleteSite;
    }

    public WebSite() {
    }


    public boolean createNewSite(){
        String directory = PATH + this.getId();
        String directoryXML = PATH + this.getId() + "/xmlFiles";
        if(!checkDuplicateSiteName(this.getId())){
            if(createDirectory(directory) && createDirectory(directoryXML)){
                createIndex(directory);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void createIndex(String path){
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>\n");
        writeIndex(htmlBuilder, path);
    }

    public void writeIndex(StringBuilder htmlBuilder, String path){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/index.html"));
                writer.write(htmlBuilder.toString());
                writer.close();
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public boolean createDirectory(String path){
        File file = new File(path);
        if (!file.exists()){
            return file.mkdirs();
        }
        return false;
    }

    public String searchFolder(WebSite webSite){
        return PATH + webSite.getId();
    }

    public boolean existDirectorySite(String path){
        File file = new File(path);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean searchAndDeleteSite(WebSite webSite){
        if(existDirectorySite(searchFolder(webSite))){
            File fileFolder = new File(searchFolder(webSite));
            if(deleteFolder(fileFolder)){
                System.out.println("Todo ha sido eliminado");
                return true;
            } else {
                System.out.println("No se pudo eliminar");
            }
        }
        return false;
    }

    public boolean deleteFolder(File folder) {
        if (!folder.exists()) {
            JOptionPane.showMessageDialog(null, "No existe el sitio web: " + folder.getName());
            return false;
        }

        try {
            for (File file : folder.listFiles()) {
                if (file.isDirectory()) {
                    if (!deleteFolder(file)) {
                        return false;
                    }
                } else {
                    if (!file.delete()) {
                        System.out.println("Error al eliminar el archivo: " + file.getName());
                        return false;
                    }
                }
            }
            if (!folder.delete()) {
                System.out.println("Error al eliminar la carpeta: " + folder.getName());
                return false;
            }
            return true;
        } catch (SecurityException e) {
            System.out.println("Permiso denegado para eliminar archivos o carpetas.");
            return false;
        }
    }

    public boolean checkDuplicateSiteName(String identificator) {
        File directory = new File(PATH);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory() && file.getName().equals(identificator)) {
                        JOptionPane.showMessageDialog(null, "Ya existe un sitio de ese nombre");
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getUserModification() {
        return userModification;
    }

    public void setUserModification(String userModification) {
        this.userModification = userModification;
    }

    public boolean isDeleteSite() {
        return deleteSite;
    }

    public void setDeleteSite(boolean deleteSite) {
        this.deleteSite = deleteSite;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }
}