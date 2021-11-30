
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
public class Log {
    private BufferedWriter buffered;
    private String ruta;
    private String nombre;
    private int date;
    private int date2;
    public Log(String ruta, String nombre) throws IOException {
        this.ruta = ruta;
        this.nombre = nombre;
        this.open(true);
    }
    
    public Log(String ruta,String nombre, boolean reset) throws IOException {
        this.ruta = ruta;
        this.nombre=nombre;
        this.open(!reset);
    }
    private void CreateLogsFolder() throws IOException{
        File logs = new File(this.ruta);
        if (!logs.exists()){
            logs.mkdir();
            this.info("Se creo la carpeta logs");
        }
    }
    private void open(boolean append) throws IOException {
        SimpleDateFormat DateFormat = new SimpleDateFormat("d-M-y");
        String Fecha = DateFormat.format(new Date());
        String dir = this.ruta+"["+Fecha+"] "+this.nombre+".log";
        this.CreateLogsFolder();
        this.buffered = new BufferedWriter(new FileWriter(dir,append));
    }
        
    private void addLine(String tipo, String line) throws IOException{
        SimpleDateFormat DateFormat = new SimpleDateFormat("HH:mm:ss");
        String Fecha = DateFormat.format(new Date());
        this.open(true);
        this.buffered.write("["+Fecha+"]" + "["+tipo+"]: "+ line + "\n");
        this.close();
    }
    public void info(String linea) throws IOException{
        this.addLine("INFO",linea);
    }
    public void error(String linea) throws IOException{
        this.addLine("ERROR",linea);
    }
    public void advertencia(String linea) throws IOException{
        this.addLine("WARN",linea);
    }
    public String[] getLines() throws FileNotFoundException, IOException {  
        ArrayList <String> linesFile = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(this.ruta));
        
        String line;
        while ((line = br.readLine()) != null) {
            linesFile.add(line);
    }

    br.close();

    String[] lines = new String[linesFile.size()];

    for (int i = 0; i < linesFile.size(); i++) {
        lines[i] = linesFile.get(i);
    }

    return lines;
    }
    public void resetLog() throws IOException {
        this.open(false);
        this.close();
    }
    private void close() throws IOException{
        this.buffered.close();
    }
}
    

