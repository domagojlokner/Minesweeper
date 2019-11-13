package hr.home.games.minesweeper.boards;

import hr.home.games.minesweeper.components.buttons.*;

import javax.swing.*;
import java.awt.*;

public class ButtonsBoard extends JPanel {
    protected int width;
    protected int height;
    protected int numOfMines;

    protected Board board;
    protected MinefieldButtonModel[][] field;

    public ButtonsBoard(Board board) {
        this.width = board.getWidth();
        this.height = board.getHeight();
        this.numOfMines = board.getNumOfMines();

        this.board = board;
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
                        field[i][j] = new EmptyButton(i, j);
                        break;
                    case -1:
                        field[i][j] = new MineButton(i, j);
                        break;
                    default:
                        field[i][j] = new NumberButton(numericField[i][j], i, j);
                }
            }
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getNumOfMines() {
        return numOfMines;
    }

    public Board getBoard() {
        return board;
    }

    public MinefieldButtonModel[][] getButtons() {
        return field;
    }

    public MinefieldButtonModel[][] getButtonsCopy() {
        MinefieldButtonModel[][] fieldCopy = new MinefieldButtonModel[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                fieldCopy[i][j] = field[i][j];
            }
        }
        return fieldCopy;
    }

}
