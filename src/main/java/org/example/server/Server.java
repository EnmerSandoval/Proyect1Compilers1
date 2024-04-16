package org.example.server;

import java.io.DataInputStream;
import java.net.ServerSocket;

public class Server implements Runnable{

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
            System.out.println("El mensaje es: " + mensajeRecibido);
            serverSocket.accept().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
