

public class App {
    public static void main(String[] args) throws Exception {
        Log Log = new Log("./logs/","Pruebas-logs");
        Log.info("Probando cosas");
        Log.advertencia("Probando cosas");
        Log.error("Probando cosas");
    }
}
