package domein;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZooServer {
    private final static int PORT = 3456;
    private final Zoo zoo;
    private final VerzoekLogger verzoekLogger;
    private ServerSocket serverSocket;
    private final ExecutorService pool;

    public ZooServer(Zoo repo) {
        zoo = repo;
        verzoekLogger = new VerzoekLogger();
        pool = Executors.newCachedThreadPool();
        initServer();
    }

    private void initServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server opgestart");
        } catch (IOException ex) {
            Logger.getLogger(ZooServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
   //TODO 
   
   
    }
    
}
