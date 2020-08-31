package edu.escuelaing.arep.app.App;


import edu.escuelaing.arep.app.App.server.Server;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Server Http, open port 35000
 * @author AndresRamirez
 */
public class App {

    private static Server server;

    /**
     * Start Server http: port 35000
     * @param args n/a
     */
    public static void main( String[] args ) {
        int port = getPort();
        server = new Server(port);

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
        //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}
