import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 7777;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Клиент!");
            String resp = in.readLine();
            System.out.println(resp);

        } catch (Exception err) {
            System.out.println(err);
        }

    }
}
