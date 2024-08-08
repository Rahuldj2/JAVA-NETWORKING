import java.io.*;
import java.net.*;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        // define port
        int port = 3000;

        try (
                ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                // accept
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // get data
                DataInputStream input = new DataInputStream(socket.getInputStream());
                double radius = input.readDouble();
                double area = Math.PI * radius * radius;

                // send result back
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeDouble(area);

                // close
                input.close();
                output.close();
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}