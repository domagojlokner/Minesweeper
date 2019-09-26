package hr.home.games.minesweeper;

import hr.home.games.minesweeper.boards.MinesweeperComponent;
import hr.home.games.minesweeper.components.buttons.visitors.RevealVisitor;

import javax.swing.*;
import java.awt.*;

public class Minesweeper extends JFrame {

    static MinesweeperComponent board = new MinesweeperComponent(24, 24, 99);

    public Minesweeper() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
    }

    private void initGUI() {
        Container cp = getContentPane();
        cp.add(board);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Minesweeper().setVisible(true);
            board.visitAllFields(new RevealVisitor());
//            board.visitAllFields(new RevealUnmarkedMineVisitor());
        });
    }
}