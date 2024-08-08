import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 3000;

        try (Socket socket = new Socket(hostname, port)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeDouble(76.0);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            double area = input.readDouble();
            System.out.println("The area received from the server is " + area);

            input.close();
            output.close();
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
