package org.example.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WebSite {
    private String id;
    private String userCreator;
    private String creationDate;
    private String modificationDate;
    private String userModification;

    public WebSite(String id, String userCreator, String creationDate, String modificationDate, String userModification) {
        this.id = id;
        this.userCreator = userCreator;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.userModification = userModification;
    }

    public WebSite(String id) {
        this.id = id;
    }



    public boolean createNewSite(){
        String directory = "src/main/java/org/example/sites/" + this.getId();
        String directoryXML = "src/main/java/org/example/sites/" + this.getId() + "/xmlFiles";
        if(createDirectory(directory) && createDirectory(directoryXML)){
            createIndex(directory);
            return true;
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
}