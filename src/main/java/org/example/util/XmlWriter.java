/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.util;

import org.example.classes.Page;
import org.example.classes.WebSite;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author enmer
 */
public class XmlWriter {
    private String PATH = "src/main/java/org/example/sites/";
    private XmlWriterBase xmlWriterBase = new XmlWriterBase();
    private HtmlBase htmlBase = new HtmlBase();

    public void createXml(String route, WebSite webSite, String text){
        String directory = route + webSite.getId() + "/xmlFiles/"+webSite.getId()+".xml";
        try{
            FileWriter fileWriter = new FileWriter(directory);
            fileWriter.write(text);
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "Se ha registrado tu sitio correctamente");
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public void createPage(Page page){
        String path = PATH + page.getSite() + "/xmlFiles/"+page.getId() + ".xml";
        String pathHtml = PATH + page.getSite() + "/";
        if(page.getFlag() != 3){
            try{
                FileWriter fileWriter = new FileWriter(path);
                fileWriter.write(xmlWriterBase.newPage(page));
                fileWriter.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(pathHtml + page.getId() +".html"));
                writer.write(htmlBase.juntarString(page).toString());
                writer.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }



    public boolean rewriteXml(Page page){
        String path = PATH + page.getSite() + "/";
        String pathHtml = PATH + page.getSite() + "/";
        try{
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(xmlWriterBase.newPage(page));
            fileWriter.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathHtml + page.getId() +".html"));
            writer.write(htmlBase.juntarString(page).toString());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkDuplicatePage(String pageName) {
        File sitesDirectory = new File(PATH);
        return searchForPageInDirectory(sitesDirectory, pageName);
    }

    private boolean searchForPageInDirectory(File directory, String pageName) {
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        if (searchForPageInDirectory(file, pageName)) {
                            return true;
                        }
                    } else if (file.isFile() && (file.getName().equals(pageName + ".html") || file.getName().equals(pageName + ".xml"))) {
                        JOptionPane.showMessageDialog(null, "Ya existe una página con el nombre '" + pageName + "' en la carpeta '" + directory.getName() + "'.");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String searchForXmlInDirectory(File directory, String fileName) {
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String result = searchForXmlInDirectory(file, fileName);
                        if (result != null) {
                            return result;
                        }
                    } else if (file.isFile() && file.getName().equals(fileName + ".xml")) {
                        return file.getAbsolutePath();
                    }
                }
            }
        }
        return null;
    }

}
