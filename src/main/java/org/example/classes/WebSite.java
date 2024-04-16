package org.example.classes;


import lombok.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebSite {
    private String id;
    private String userCreator;
    private String creationDate;
    private String modificationDate;
    private String userModification;

    public boolean createNewSite(){
        String directory = "src/main/java/org/example/sites/" + this.getId();
        if(createDirectory(directory)){
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
}
