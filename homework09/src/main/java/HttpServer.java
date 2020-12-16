import java.io.*;
import java.net.*;

public class HttpServer {

    private String dir;
    private Integer SERVER_PORT;

    public HttpServer(Integer SERVER_PORT, String dir) {
        this.SERVER_PORT = SERVER_PORT;
        this.dir = dir;
    }

    void begin() {
        try (ServerSocket serverSocket = new ServerSocket(this.SERVER_PORT)) {
            System.out.println("Сервер стартовал...");
            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Processor(socket, this.dir);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

