import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 7777;
        while (true) {
            ServerSocket serverSocket = new ServerSocket(port); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted. Port - " + clientSocket.getPort());

            final String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            serverSocket.close();
        }
    }
}
