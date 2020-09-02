package edu.escuelaing.arep.app.App;
import edu.escuelaing.arep.app.App.microspark.IFuncional;
import edu.escuelaing.arep.app.App.model.BrowserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;



public class ClientRequest implements Runnable {
    private HashMap<Integer, String> users;
    private Socket clientSocket;

    /**
     * Constructor class clientRequest,
     * @param clientSocket socket connection with new client
     * @param  users list with users in database
     */
    public ClientRequest(Socket clientSocket, HashMap<Integer,String> users) {
        this.clientSocket = clientSocket;
        this.users = users;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        BufferedReader in = null;
        try{
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Integer count = 0;
            String[] header = null;
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (count == 0) {
                    header = inputLine.split(" ");
                }
                count++;
                if (!in.ready()) {
                    break;
                }
            }
            if(header[1].contains("/app")){
                IFuncional getA = (request) ->  clientSocket.getOutputStream().write((
                        "HTTP/1.1 400 \r\nAccess-Control-Allow-Origin: *\r\nContent-Type: text/html\r\n\r\n" +
                                "<html><head><title>App</title></head><body><h1>"+ users.toString() +"</h1></body></html>").getBytes());
                getA.response(header[1]);
            } else {
                String path = "src/main/resources/";
                path = path + header[1].substring(1);
                System.out.println("PATH: " + path);
                BrowserService browserService = new BrowserService(path);
                browserService.getFileBrowser(clientSocket);
            }

        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null)
                    in.close();
                clientSocket.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}