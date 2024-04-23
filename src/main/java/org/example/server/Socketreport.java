package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Socketreport implements Runnable {

    private Map<String, Integer> contadorPorPagina = new HashMap<>();
    @Override
    public void run() {

    int puerto = 8000;
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto + "...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handleClient(Socket clientSocket) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);
            String solicitud = entrada.readLine();

            contadorPorPagina.put(solicitud, contadorPorPagina.getOrDefault(solicitud, 0) + 1);

            File pagina = new File("/var/www/html/" + solicitud);
            if (pagina.exists() && pagina.isFile()) {
                BufferedReader reader = new BufferedReader(new FileReader(pagina));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    salida.println(linea);
                }
                reader.close();
            }

            salida.close();
            entrada.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getContadorPorPagina() {
        return contadorPorPagina;
    }

    public void setContadorPorPagina(Map<String, Integer> contadorPorPagina) {
        this.contadorPorPagina = contadorPorPagina;
    }
}
