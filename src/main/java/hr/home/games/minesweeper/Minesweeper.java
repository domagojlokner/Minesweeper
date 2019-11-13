package hr.home.games.minesweeper;

import javax.swing.*;
import java.awt.*;

public class Minesweeper extends JFrame {

    private MinesweeperComponent minesweeper;

    public Minesweeper() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
    }

    private void initGUI() {
        Container cp = getContentPane();
        minesweeper = new MinesweeperComponent(MinesweeperComponent.EASY);
        adaptWindowSize();
        cp.add(minesweeper, 0);
    }

    private void adaptWindowSize() {
        int height = 80 * minesweeper.numberOfRows();
        int width = 70 * minesweeper.numberOfColumns();
        setSize(width, height);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Minesweeper().setVisible(true);
        });
    }
}