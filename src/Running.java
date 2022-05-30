
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.nio.file.Path;

public class Running {
    public String[][] KeepLab(String directory) throws IOException {
        int contCol = 0;
        String dataPath = new File("").getAbsolutePath();
        String path = dataPath +"/"+ directory;
        FileReader dir = new FileReader(path);
        Path cam = Paths.get(path);
        BufferedReader readData = new BufferedReader(dir);
        String line = readData.readLine();
        String[][] response = new String[(int)Files.lines(cam).count()][line.length()];
        do {
            for(int i = 0; i < line.length(); i++)
            {
                response[contCol][i] = String.valueOf(line.charAt(i));
            }
            contCol += 1;
            line = readData.readLine();
        } while (line != null);
        return response;
    }
}
