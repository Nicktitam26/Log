import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Log {
    private BufferedWriter buffered;
    private String ruta;
    private void open(boolean append) throws IOException{
        this.buffered = new BufferedWriter(new FileWriter(this.ruta,append));
    }
    public void addLine(String line) throws IOException{
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String Fecha = DateFormat.format(new Date());
        this.open(true);
        this.buffered.write("["+Fecha+"]" + line + "\n");
        this.close();
    }
    public void resetLog() throws IOException {
        this.open(false);
        this.close();
    }
    private void close() throws IOException{
        this.buffered.close();
    }
}
