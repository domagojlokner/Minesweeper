package hr.home.games.minesweeper.components.buttons;

import hr.home.games.minesweeper.components.Icons;

import javax.swing.*;

public class GameButton extends JButton {
    private Icons icons = new Icons();

    public GameButton() {
        setIcon(icons.getButtonIcon());
    }

    public void setGameOverIcon() {
        setIcon(icons.getButtonIconGameOver(getSize()));
    }

    public void setWinIcon() {
        setIcon(icons.getButtonIconWin(getSize()));
    }

    public void setButtonIcon() {
        setIcon(icons.getButtonIcon(getSize()));
    }
}
