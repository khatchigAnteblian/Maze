public class maze {

    static String[][] maze = {{"x", "s", "x", "x", "x", "x", "x", "x", "x", "x"},
                              {"x", " ", "x", "x", " ", " ", " ", " ", " ", "x"},
                              {"x", " ", "x", "f", " ", "x", "x", "x", " ", "x"},
                              {"x", " ", "x", "x", "x", "x", " ", " ", " ", "x"},
                              {"x", " ", " ", " ", " ", " ", "x", "x", " ", "x"},
                              {"x", " ", "x", " ", "x", "x", "x", "x", " ", "x"},
                              {"x", " ", "x", " ", "x", " ", " ", " ", " ", "x"},
                              {"x", " ", "x", " ", "x", " ", "x", "x", " ", "x"},
                              {"x", " ", "x", " ", " ", " ", " ", "x", " ", "x"},
                              {"x", "x", "x", "x", "x", "x", "x", "x", "x", "x"}};
    
    public static void main(String[] args) {
        playMaze(0, 1);
    }

    public static boolean okay(int i, int j) {
        boolean valid = false;

        if ((i>=0 && i<maze.length) && (j>=0 && i<maze.length)) {
            if (maze[i][j].equals(" ") || maze[i][j].equals("s") || maze[i][j].equals("f")) {
                valid = true;
            }
        }

        return valid;
    }

    public static boolean playMaze(int i, int j) {
        boolean done = false;

        if (okay(i, j)) {
            if (maze[i][j].equals("f")) {
                System.out.println("Finished at " + i + ", " + j);
                return true;
            } else {
                maze[i][j] = "*";

                done = playMaze(i+1, j);

                if (!done) {
                    done = playMaze(i, j+1);
                }

                if (!done) {
                    done = playMaze(i-1, j);
                }

                if (!done) {
                    done = playMaze(i, j-1);
                }
            }
        }

        return done;
    }
}
