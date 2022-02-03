import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 7777;

        try (ServerSocket serverSocket = new ServerSocket(port);) {// порт в доступном диапазоне 0-65536. рекомендуем использовать около 8080
            System.out.println("Server started");
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

                    System.out.println("New connection accepted. Port - " + clientSocket.getPort());
                    final String name = in.readLine(); // ждем что напишет клиент
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

                }
            }
        }

    }
}
