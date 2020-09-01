package edu.escuelaing.arep.app.App.ejercicios.pow;
import java.io.*;
import java.net.*;
public class EchoClientPow {
    /**
     * Server for the client
     * @param args n/a
     * @throws IOException because of the libraries used in the implementation of sockets
     */
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            System.out.println("Se establecio conexion por puerto 35000");
            System.out.println("Para finalizar la conexion ingrese: salir");
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for " + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}