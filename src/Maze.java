
import java.util.Scanner;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Maze {

    Scanner scan = new Scanner(System.in);
    Queue q = new Queue(50);
    Queue moveQueue = new Queue(50);
    int addCount = 0;
    private boolean win = false;
    private String[][] keep;
    private int[] current = new int[2];
    public Maze(String[][] keep) {
        this.keep = keep;
    }

    public void printMaze() {

        for (int l = 0; l < keep.length; l++) {
            for (int c = 0; c < keep[0].length; c++) {
                System.out.print(keep[l][c] + " ");
            }
            System.out.println(" ");
        }
    }

    public void fillPos(int line, int column) throws InterruptedException {

        if (!(keep[line][column].equals("-")) && !(keep[line][column].equals("A"))) {
            if (keep[line][column].equals("B"))
                System.out.println("\nCongrats! you won\n");
            else
                keep[line][column] = "#";
            printMaze();
            MILLISECONDS.sleep(1500);

        } else if (keep[line][column].equals("A")) {
            System.out.println("\nInvalid move, disregarding\n");
        }
        else {
            System.err.println("\nImpossible move, Shutting down");
        }
    }

    public void cleanMaze() {
        for (int l = 0; l < keep.length; l++) {
            for (int c = 0; c < keep[0].length; c++) {
                if (keep[l][c].equals("?")) {
                    keep[l][c] = " ";
                }
            }
        }
        q.outQueue();
    }

    public void printCm() {
        System.out.println("\nStart\n\n");
        printMaze();
        System.out.println("\n\nObjective: Go from point A to point B");
        System.out.println("Queue count: " + q.size());
        System.out.println("\n---Chose one of below options---\n");
        System.out.println("-> Right [Type R]");
        System.out.println("-> Left [Type L]");
        System.out.println("-> Up [Type U]");
        System.out.println("-> Down [Type D]");
        System.out.println("-> Start [Type S]");
        System.out.println("-> Restart [Type Re]\n");
    }

    public void StartMaze() throws InterruptedException {
        this.current[0] = 1;
        this.current[1] = 1;
        do{
            printCm();
            System.out.println("");
            String option = scan.next();
            move(option);
        } while (win == false);
        if (win == true)
            System.out.println("Success!");
    }

    public void move(String play) throws InterruptedException {

        switch (play) {
            case "R":
                current[1] = current[1] + 1;
                q.inQueue(Integer.toString(current[0]) + "," + Integer.toString(current[1]));
                moveQueue.inQueue("Right");
                break;

            case "L":
                current[1] = current[1] - 1;
                q.inQueue(Integer.toString(current[0]) + "," + Integer.toString(current[1]));
                moveQueue.inQueue("Left");
                break;

            case "U":
                current[0] = current[0] - 1;
                q.inQueue(Integer.toString(current[0]) + "," + Integer.toString(current[1]));
                moveQueue.inQueue("Up");
                break;

            case "D":
                current[0] = current[0] + 1;
                q.inQueue(Integer.toString(current[0]) + "," + Integer.toString(current[1]));
                moveQueue.inQueue("Down");
                break;

            case "S":
                while (!q.empty()) {
                    String[] auxValores = q.doCheck().split(",");
                    int line = Integer.parseInt(auxValores[0]);
                    int column = Integer.parseInt(auxValores[1]);
                    addCount++;
                    System.out.println("\nAction " + addCount + ": " + moveQueue.doCheck() + "\n");
                    fillPos(line, column);
                    moveQueue.outQueue();
                    q.outQueue();
                }
                break;
            case "Re":
                while (!q.empty()) {
                    cleanMaze();
                }
                break;
            default:
                System.err.println("Error, please try again");
        }
    }
}
