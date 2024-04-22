package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import org.example.classes.Page;
import org.example.classes.WebSite;
import org.example.classes.components.Component;
import org.example.cup.Parser;
import org.example.lexer.Lexer;
import org.example.util.HtmlBase;
import org.example.util.XmlWriter;
import org.example.util.XmlWriterBase;

import javax.swing.*;

public class Server implements Runnable{
    private String PATH = "src/main/java/org/example/sites/";
    ArrayList<WebSite> webSites;
    ArrayList<Page> pages;
    ArrayList<Component> components;
    private XmlWriter xmlWriter = new XmlWriter();
    private XmlWriterBase xmlWriterBase = new XmlWriterBase();
    private HtmlBase htmlBase = new HtmlBase();
    private ArrayList<Page> pagesDeleteComponent = new ArrayList<>();
    
    public static void main(String[] args) {

    }

    public void threadApp(){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try{
            ServerSocket serverSocket = new ServerSocket(8080);
            DataInputStream dataInputStream = new DataInputStream(serverSocket.accept().getInputStream());
            String mensajeRecibido = dataInputStream.readUTF();
            runParser(mensajeRecibido);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void runParser(String text){
        try {
            Lexer lex = new Lexer(new StringReader(text));
            Parser sintax = new Parser(lex); 
            sintax.parse();
            webSites =  sintax.getWebs();
            pages = sintax.getPages();
            components = sintax.getComponents();
            
            if(!webSites.isEmpty()){
                createSites(webSites);
            }

            if(!components.isEmpty() && !pages.isEmpty()){
                System.out.println("Se entro en verification components");
                for (int i = 0; i < pages.size(); i++) {
                     verificationComponents(pages.get(i), components);
                }
            }
            
            if(!pages.isEmpty()){
                 for (int i = 0; i < pages.size(); i++) {
                    if(pages.get(i).getFlag() == 1){
                        xmlWriter.createPage(pages.get(i));
                    } else if(pages.get(i).getFlag() == 2){

                    } else  if(pages.get(i).getFlag() ==3){
                        deleteFilesWithId(pages.get(i).getId());
                    }
                 }
            }
            
            if(!components.isEmpty()){
                for (int i = 0; i < components.size() ; i++) {
                    if (components.get(i).getFlag() == 4){
                        readXmlExist(components.get(i));
                    }
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSites(ArrayList<WebSite> webSitesNews){
        for (int i = 0; i < webSitesNews.size(); i++) {
            if(!webSitesNews.get(i).isDeleteSite()){
                webSitesNews.get(i).createNewSite();
                xmlWriter.createXml(webSites.get(i).getPATH(), webSites.get(i), xmlWriterBase.newSite(webSites.get(i)));
            } else {
                webSitesNews.get(i).searchAndDeleteSite(webSitesNews.get(i));
            }
        }
    }

    public void verificationComponents(Page page, ArrayList<Component> components){
        ArrayList<Component> componentPage = new ArrayList<>();
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getPage().equals(page.getId()) && components.get(i).getFlag() != 4){
                componentPage.add(components.get(i));
            }
        }
        page.setComponents(componentPage);
    }




    public void readXmlExist(Component component){
            if (component.getFlag() == 4){
                 try {
                     File fileDirectory = new File(PATH);
                     String xmlRead = convertXmlToString(xmlWriter.searchForXmlInDirectory(fileDirectory, component.getPage()));

                     Lexer lex = new Lexer(new StringReader(xmlRead));
                     Parser sintax2 = new Parser(lex);
                     sintax2.parse();
                     ArrayList<Component> componentsRead = sintax2.getComponents();
                     ArrayList<Page> pageRead = sintax2.getPages();

                     for (int i = 0; i < pageRead.size(); i++) {
                         verificationComponents(pageRead.get(i), componentsRead);
                     }

                     for (int i = 0; i < pageRead.size(); i++) {
                         if(pageRead.get(i).getComponents().get(i).getIdComponent().equals(component.getIdComponent())){
                             pageRead.get(i).getComponents().remove(i);
                         }
                     }

                     for (int i = 0; i < pageRead.size(); i++) {
                            xmlWriter.createPage(pageRead.get(i));

                     }

                 }catch (Exception e){
                    e.printStackTrace();
                 }
            }
    }


    public String convertXmlToString(String path)throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line).append("\n");
        }
        bufferedReader.close();
        fileReader.close();
        return stringBuilder.toString();
    }

    public boolean deleteFilesWithId(String id) {
        String xmlFilePath = searchForFileInDirectory(new File(PATH), id + ".xml");
        String htmlFilePath = searchForFileInDirectory(new File(PATH), id + ".html");

        boolean xmlDeleted = deleteFile(xmlFilePath);
        boolean htmlDeleted = deleteFile(htmlFilePath);

        return xmlDeleted && htmlDeleted;
    }

    private String searchForFileInDirectory(File directory, String fileName) {
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String result = searchForFileInDirectory(file, fileName);
                        if (result != null) {
                            return result;
                        }
                    } else if (file.isFile() && file.getName().equals(fileName)) {
                        return file.getAbsolutePath();
                    }
                }
            }
        }
        return null;
    }

    private boolean deleteFile(String filePath) {
        if (filePath != null) {
            File fileToDelete = new File(filePath);
            return fileToDelete.delete();
        }
        return false;
    }
}
