package org.example;

import org.example.server.Server;
import org.example.server.Socketreport;

import java.net.ServerSocket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.threadApp();
        Socketreport socketreport = new Socketreport();
        Thread servidor = new Thread(socketreport);
        servidor.start();
    }
}