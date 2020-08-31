package edu.escuelaing.arep.app.App.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int counterConnections = 0;
    private ServerSocket serverSocket = null;
    private ExecutorService executorService = Executors.newFixedThreadPool(13);


    public Server(int port){
        startServer(port);
    }

    public void startServer(int port){
        try{
            if (serverSocket == null) {
                serverSocket = new ServerSocket(port);
            }
            System.out.println("Servidor esperando solicitudes al puerto 35000");
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado");
                ClientRequest clientRequest = new ClientRequest(clientSocket);
                executorService.execute(clientRequest);
                counterConnections++;
                System.out.println(counterConnections);
            }
        } catch (IOException e){
            System.err.println("Could not listen on port: 35000");
            System.exit(1);
        }
    }




}
