import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Processor extends Thread {

    private Socket socket;
    private String dir;

    public Processor(Socket socket, String dir) {
        this.socket = socket;
        this.dir = dir;
    }

    @Override
    public void run() {
        try (PrintWriter output = new PrintWriter(this.socket.getOutputStream())) {
            String url = getReguestURL(this.socket.getInputStream());
            Path filePath = Paths.get(dir + url);
            if (Files.exists(filePath)) {
                output.println("HTTP/1.1 200 OK");
                output.println("Content-Type:text/html; charset=UTF-8");
                output.println();
                File file = new File(String.valueOf(filePath));
                File[] files = file.listFiles();
                for (File value : files) {
                    output.println(value.getName() + "<br>");
                }
                output.flush();
            } else {
                output.println("HTTP/1.1 200 OK");
                output.println("Content-Type:text/html; charset=UTF-8");
                output.println();
                output.println("<p>404 NOT FOUND</p>");
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getReguestURL(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\r\n");
        String currentURL = "";
        String bufferURL;
        String firstURL = "";
        String url = scanner.next();
        String[] newString = url.split(" ", 0)[1].split("%20", 0);
        if(newString.length == 1){
            return newString[0];
        } else {
            for (int n = 1; n < newString.length ; n++){
                firstURL = newString[0];
                bufferURL = newString[n];
                currentURL =  currentURL + " " + bufferURL;
            }
            return firstURL + currentURL;
        }
    }
}
