package network.tcp.v3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV3 {

    private static final int PORT = 12346;

    public static void main(String[] args) throws IOException {
        log("Server started");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("Listening on port: " + PORT);

        while(true){
            Socket socket = serverSocket.accept(); // blocking
            log("Connected to client: " + socket);

            SessionV3 session = new SessionV3(socket);
            Thread thread = new Thread(session);
            thread.start();
        }

    }

}
