public class Main {
    public static void main(String[] args) {
        String dir = "C:/Users/Valiev/Desktop/innopolis";
        Integer SERVER_PORT = 8080;
        new HttpServer(SERVER_PORT, dir).begin();
    }
}
