package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SessionV3 implements Runnable{

    private final Socket socket;

    public SessionV3(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while(true){
                // Receive data from client
                String received = dis.readUTF();
                System.out.println("server <- client: " + received);

                if(received.equals("exit")){
                    break;
                }

                // Send data to client
                String toSend =  received + " World!";
                dos.writeUTF(toSend);
                System.out.println("server -> client: " + toSend);
            }
            // Close resources
            System.out.println("Disconnecting from client: " + socket);
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
