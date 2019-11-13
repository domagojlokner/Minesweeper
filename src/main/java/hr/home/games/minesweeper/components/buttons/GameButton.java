package hr.home.games.minesweeper.components.buttons;

import hr.home.games.minesweeper.components.Icons;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {

    private Icons icons = new Icons();

    private final Dimension dimension = new Dimension(150, 150);

    private ImageIcon button = icons.getButtonIcon(dimension);
    private ImageIcon gameOver = icons.getButtonIconGameOver(dimension);
    private ImageIcon win = icons.getButtonIconWin(dimension);

    public GameButton() {
        setIcon(button);
    }

    public void setGameOverIcon() {
        setIcon(gameOver);
    }

    public void setWinIcon() {
        setIcon(win);
    }

    public void setButtonIcon() {
        setIcon(button);
    }
}
