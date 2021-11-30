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

    public Log(String ruta) throws IOException {
        this.ruta = ruta;
        this.open(true);
    }

    public Log(String ruta, boolean reset) throws IOException {
        this.ruta = ruta;
        this.open(!reset);
    }

    private void open(boolean b) {
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
}
    

