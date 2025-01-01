package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV2 {

    private static final int PORT = 12346;

    public static void main(String[] args) throws IOException {
        log("Server started");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("Listening on port: " + PORT);

        Socket socket = serverSocket.accept();
        log("Connected to client: " + socket);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while(true){
            // Receive data from client
            String received = dis.readUTF();
            log("server <- client: " + received);

            if(received.equals("exit")){
                break;
            }

            // Send data to client
            String toSend =  received + " World!";
            dos.writeUTF(toSend);
            log("server -> client: " + toSend);
        }
        // Close resources
        log("Disconnecting from client: " + socket);
        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();

    }
}
