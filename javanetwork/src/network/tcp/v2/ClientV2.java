package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV2 {

    private static final int PORT = 12346;

    public static void main(String[] args) throws IOException {
        log("Client started");

        Socket socket = new Socket("localhost", PORT);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        log("Connected to server: " + socket);

        // Send data to server
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("client -> server: ");
            String toSend = scanner.nextLine();
            dos.writeUTF(toSend);
            log("client -> server: " + toSend);

            if(toSend.equals("exit")){
                break;
            }

            // Receive data from server
            String received = dis.readUTF();
            log("client <- server: " + received);
        }

        // Close resources
        log("Disconnecting from server: " + socket);
        dis.close();
        dos.close();
        socket.close();
    }
}
