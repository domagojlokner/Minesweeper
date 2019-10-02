package hr.home.games.minesweeper.boards;

import java.util.Random;

public class Board {
    private int width;
    private int height;
    private int numOfMines;
    private int field[][];

    public Board(int width, int height, int numOfMines) {
        this.height = height;
        this.width = width;

        this.numOfMines = numOfMines;

        field = new int[height][width];
        createMinefield(numOfMines);

    }

    public void createMinefield(int numOfMines) {
        this.numOfMines = numOfMines;
        emptyField();
        addMines(numOfMines);
    }

    private void addMines(int numOfMines) {
        if (numOfMines == width * height) {
            fill(-1);
            return;
        }
        addMinesRandom(numOfMines);
    }

    private void addMinesRandom(int numOfMines) {
        Random rand = new Random(System.currentTimeMillis());
        int minesSet = 0;

        while (minesSet < numOfMines) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);

            if (field[x][y] != -1) {
                field[x][y] = -1;
                incrementAroundField(x, y);
                minesSet++;
            }
        }
    }

    private void incrementAroundField(int i, int j) {
        int yMin = Math.max(i - 1, 0);
        int xMin = Math.max(j - 1, 0);

        int yMax = Math.min(i + 1, height - 1);
        int xMax = Math.min(j + 1, width - 1);

        for (int n = yMin; n <= yMax; ++n) {
            for (int m = xMin; m <= xMax; ++m) {
                if (i == n && j == m) {
                    continue;
                }

                if (field[n][m] >= 0) {
                    ++field[n][m];
                }
            }
        }
    }

    private void emptyField() {
        fill(0);
    }

    public boolean isMine(int y, int x) {
        if (field[y][x] == -1) {
            return true;
        }
        return false;
    }

    private void fill(int val) {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                field[i][j] = val;
            }
        }
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getNumOfMines() {
        return numOfMines;
    }

    public int[][] getField() {
        return field;
    }

    public void printField() {
        System.out.println("\n ========================================== ");
        for(int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.format("|%2d", field[i][j]);
            }
            System.out.println("|");
        }
        System.out.println(" ========================================== ");
    }
}
