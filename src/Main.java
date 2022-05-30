
//import Utils.ReadFile;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Running readLab = new Running();
        String[][] aux = readLab.KeepLab("/src/Maze.txt");
        Maze maze = new Maze(aux);

        maze.StartMaze();
    }
}
