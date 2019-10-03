package hr.home.games.minesweeper;

import hr.home.games.minesweeper.boards.MinefieldBoardListener;
import hr.home.games.minesweeper.boards.MinefieldComponent;
import hr.home.games.minesweeper.components.TimerLabel;
import hr.home.games.minesweeper.components.buttons.GameButton;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class MinesweeperComponent extends JComponent {
    private MinefieldComponent minefield;
    private int numberOfMines;
    private int numOfUnmarkedMines;

    private JLabel minesLeft = new JLabel();
    private TimerLabel timer = new TimerLabel();
    private GameButton button = new GameButton();

    private JPanel gameInfoPanel = new JPanel();

    private List<GameListener> gameListeners = new LinkedList<>();

    public static final String EASY = "EASY";
    public static final String MEDIUM = "MEDIUM";
    public static final String HARD = "HARD";

    public MinesweeperComponent(int width, int height, int numOfMines) {
        initComponent(width, height, numOfMines);
    }

    public MinesweeperComponent(String difficulty) {
        switch (difficulty) {
            case EASY:
                initComponent(8, 8, 10);
                break;
            case HARD:
                initComponent(24,24, 99);
                break;
            default:
                initComponent(16, 16, 40);
                break;
        }
    }

    private void initComponent(int width, int height, int numOfMines) {
        this.setLayout(new BorderLayout());

        this.minefield = new MinefieldComponent(width, height, numOfMines);
        this.numberOfMines = this.numOfUnmarkedMines= numOfMines;

        this.minefield.addGameListener(minefieldBoardListener);

        constructGameInfoPanel();

        styleLabel(minesLeft);
        styleLabel(timer);
        setAllComponents();

        button.addActionListener(e -> {
            restart();
        });

        resetGameInfoPanel();
        startGameInfoPanel();
    }

    private JPanel constructGameInfoPanel() {
        gameInfoPanel.setLayout(new GridLayout(1, 0));
        minesLeft.setHorizontalAlignment(SwingConstants.CENTER);
        timer.setHorizontalAlignment(SwingConstants.CENTER);
        gameInfoPanel.add(minesLeft);
        gameInfoPanel.add(button);
        gameInfoPanel.add(timer);
        return gameInfoPanel;
    }

    private void setAllComponents() {
        add(gameInfoPanel, BorderLayout.NORTH);
        add(minefield, BorderLayout.CENTER);
    }

    private void startGameInfoPanel() {
        timer.startTimer();
        minesLeft.setText(Integer.toString(numOfUnmarkedMines));
    }

    private void resetGameInfoPanel() {
        timer.stopTimer();
        timer.restartTimer();
        numOfUnmarkedMines = numberOfMines;
        minesLeft.setText(Integer.toString(numberOfMines));
    }

    private void restart() {
        minefield.removeGameListener(minefieldBoardListener);
        minefield = new MinefieldComponent(
                minefield.getNumberOfRows(),
                minefield.getNumberOfColumns(),
                numberOfMines
        );
        minefield.addGameListener(minefieldBoardListener);
        button.setButtonIcon();
        this.removeAll();
        setAllComponents();
        resetGameInfoPanel();
        startGameInfoPanel();
    }

    private void styleLabel(JLabel label) {
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        label.setFont(new Font("TimesRoman", Font.BOLD, 40));
    }

    private MinefieldBoardListener minefieldBoardListener = new MinefieldBoardListener() {
        @Override
        public void gameOver() {
            timer.stopTimer();
            button.setGameOverIcon();
            fireGameOver();
        }

        @Override
        public void win() {
            timer.stopTimer();
            button.setWinIcon();
            fireWin();
        }

        @Override
        public void fieldMarked(boolean flag) {
            if(flag) {
                numOfUnmarkedMines--;
            } else {
                numOfUnmarkedMines++;
            }
            minesLeft.setText(Integer.toString(numOfUnmarkedMines));
        }
    };

    public void addGameListener(GameListener l) {
        gameListeners.add(l);
    }

    public void removeGameListener(GameListener l) {
        gameListeners.remove(l);
    }

    public void fireGameOver() {
        for (GameListener l : gameListeners) {
            l.gameOver(this);
        }
    }

    public void fireWin() {
        for (GameListener l : gameListeners) {
            l.win(this);
        }
    }

    public int numberOfRows() {
        return this.minefield.getNumberOfRows();
    }

    public int numberOfColumns() {
        return this.minefield.getNumberOfColumns();
    }
}
