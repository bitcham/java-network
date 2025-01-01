package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV3 {
    public static final int PORT = 12346;

    public static void main(String[] args) throws IOException {
        log("Client started");

        Socket socket = new Socket("localhost", PORT);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        log("Connected to server: " + socket);

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("client -> server: ");
            String toSend = scanner.nextLine();
            dos.writeUTF(toSend);
            log("client -> server: " + toSend);

            if(toSend.equals("exit")){
                break;
            }

            String received = dis.readUTF();
            log("client <- server: " + received);
        }

        log("Disconnecting from server: " + socket);
        dis.close();
        dos.close();
        socket.close();
    }
}
