

public class App {
    public static void main(String[] args) throws Exception {
        Log Log = new Log("./logs/log.txt");
        Log.info("Probando el log");
        Log.error("Probando los errores de log");
        Log.advertencia("Probando las advertencias de log");
    }
}
