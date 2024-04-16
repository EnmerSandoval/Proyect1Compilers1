package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private String id;
    private String title;
    private String site;
    private String parent;
    private String userCreator;
    private String creationDate;
    private String modificationDate;
    private String modificationUser;

    public void createPage(){

    }

}