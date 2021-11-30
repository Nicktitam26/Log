
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
    private String nombre;
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
    
    private void open(boolean append) throws IOException {
            this.buffered = new BufferedWriter(new FileWriter(this.ruta,append));
        }
        
    private void addLine(String line, String tipo) throws IOException{
            SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            String Fecha = DateFormat.format(new Date());
            this.open(true);
            this.buffered.write("["+Fecha+"]" + "["+tipo+"]: "+ line + "\n");
            this.close();
    }
    public void info(String linea) throws IOException{
        this.addLine(linea,"INFO");
    }
    public void error(String linea) throws IOException{
        this.addLine(linea, "ERROR");
    }
    public void advertencia(String linea) throws IOException{
        this.addLine(linea, "ADVERTENCIA");
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
    

