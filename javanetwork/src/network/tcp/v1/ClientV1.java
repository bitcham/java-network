package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class ClientV1 {
    private static final int PORT = 12346;

    public static void main(String[] args) throws IOException {
        log("Client started");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        log("Connected to server: " + socket);

        // Send data to server
        String toSend = "Hello";
        dos.writeUTF(toSend);
        log("client -> server: " + toSend);

        // Receive data from server
        String received = dis.readUTF();
        log("client <- server: " + received);

        // Close resources
        log("Disconnecting from server: " + socket);
        dis.close();
        dos.close();
        socket.close();
    }
}
