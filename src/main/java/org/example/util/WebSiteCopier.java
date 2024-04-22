package org.example.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class WebSiteCopier {
    private final String sitesDir;
    private final String webRoot;

    public WebSiteCopier(String sitesDir, String webRoot) {
        this.sitesDir = sitesDir;
        this.webRoot = webRoot;
    }

    public void copyWebsites() {
        File sitesDirectory = new File(sitesDir);
        if (!sitesDirectory.exists() || !sitesDirectory.isDirectory()) {
            System.out.println("El directorio de sitios no existe o no es un directorio válido.");
            return;
        }

        for (File site : sitesDirectory.listFiles(File::isDirectory)) {
            String siteName = site.getName();
            File[] htmlFiles = site.listFiles((dir, name) -> name.endsWith(".html"));
            if (htmlFiles == null || htmlFiles.length == 0) {
                System.out.println("No hay archivos HTML en el sitio " + siteName + ". Saltando este sitio.");
                continue;
            }

            File siteRootDir = new File(webRoot, siteName);
            if (siteRootDir.canWrite()) {
                System.out.println("El directorio " + siteRootDir + " tiene permisos de escritura.");
            } else {
                System.out.println("El directorio " + siteRootDir + " NO tiene permisos de escritura.");
            }
            if (!siteRootDir.exists() && !siteRootDir.mkdirs()) {
                System.out.println("No se pudo crear el directorio del sitio " + siteName + " en el servidor web.");
                continue;
            }



            for (File htmlFile : htmlFiles) {
                String htmlFileName = htmlFile.getName();
                String pageName = htmlFileName.substring(0, htmlFileName.lastIndexOf('.'));
                File pageDir = new File(siteRootDir, pageName);
                if (!pageDir.exists() && !pageDir.mkdirs()) {
                    System.out.println("No se pudo crear el directorio de la página " + pageName + " en el servidor web.");
                    continue;
                }
                try {
                    Files.copy(htmlFile.toPath(), new File(pageDir, "index.html").toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("Error al copiar el archivo HTML " + htmlFileName + " al servidor web.");
                    e.printStackTrace();
                }
            }

            File xmlFilesDir = new File(site, "xmlFiles");
            if (xmlFilesDir.exists() && xmlFilesDir.isDirectory()) {
                File siteXmlDir = new File(siteRootDir, "xmlFiles");
                if (!siteXmlDir.exists() && !siteXmlDir.mkdirs()) {
                    System.out.println("No se pudo crear el directorio xmlFiles en el servidor web para el sitio " + siteName);
                    continue;
                }
                for (File xmlFile : xmlFilesDir.listFiles((dir, name) -> name.endsWith(".xml"))) {
                    try {
                        Files.copy(xmlFile.toPath(), new File(siteXmlDir, xmlFile.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.out.println("Error al copiar el archivo XML " + xmlFile.getName() + " al servidor web.");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
