package hr.home.games.minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Minesweeper extends JFrame {

    private MinesweeperComponent minesweeper;

    public Minesweeper() {
        setSize(1000, 1300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
    }

    private void initGUI() {
        Container cp = getContentPane();
        minesweeper = new MinesweeperComponent(MinesweeperComponent.HARD);
        cp.add(minesweeper, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Minesweeper().setVisible(true);
        });
    }
}