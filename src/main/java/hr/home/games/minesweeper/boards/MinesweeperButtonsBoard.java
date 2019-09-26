package hr.home.games.minesweeper.boards;

import hr.home.games.minesweeper.components.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MinesweeperButtonsBoard extends JPanel {
    protected int width;
    protected int height;
    protected int numOfMines;

    protected MinefieldBoard board;
    protected MinefieldButtonModel[][] field;

    public MinesweeperButtonsBoard(int width, int height, int numOfMines) {
        this.width = width;
        this.height = height;
        this.numOfMines = numOfMines;

        this.board = new MinefieldBoard(width, height, numOfMines);
        this.field = new MinefieldButtonModel[height][width];

        initField();

        setLayout(new GridLayout(height, width));
        addButtonsToComp();
    }

    private void addButtonsToComp() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                add(field[i][j]);
            }
        }
    }

    private void initField() {
        int[][] numericField = board.getField();

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                switch (numericField[i][j]) {
                    case 0:
                        field[i][j] = new EmptyButton();
                        break;
                    case -1:
                        field[i][j] = new MineButton();
                        break;
                    default:
                        field[i][j] = new NumberButton(numericField[i][j]);
                }
            }
        }
    }

    private List<MinefieldButtonGroup> createEmptyButtonGroups() {
        List<MinefieldButtonGroup> group = new LinkedList<>();

        return group;
    }
}
