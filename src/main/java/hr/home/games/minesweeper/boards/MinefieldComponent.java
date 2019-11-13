package hr.home.games.minesweeper.boards;

import hr.home.games.minesweeper.components.buttons.*;
import hr.home.games.minesweeper.components.buttons.visitors.GameWinCheckVisitor;
import hr.home.games.minesweeper.components.buttons.visitors.RevealUnmarkedMinesVisitor;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class MinefieldComponent extends JPanel {
    private Board board;
    private ButtonsBoard buttonsBoard;
    private MinefieldButtonModel[][] buttons;

    private List<MinefieldBoardListener> listeners = new LinkedList<>();

    public MinefieldComponent(int width, int height, int numOfMines) {
        board = new Board(width, height, numOfMines);
        buttonsBoard = new ButtonsBoard(board);
        buttons = buttonsBoard.getButtons();

        setListenerToAllButtons(buttonListener);
        addAllButtonsToPane();
    }

    public MinefieldComponent(ButtonsBoard buttonsBoard) {
        this.board = buttonsBoard.getBoard();
        this.buttonsBoard = buttonsBoard;
        this.buttons = buttonsBoard.getButtons();

        setListenerToAllButtons(buttonListener);
        addAllButtonsToPane();
    }

    private void setListenerToAllButtons(MinefieldButtonListener l) {
        for (int i = 0; i < buttonsBoard.height; ++i) {
            for (int j = 0; j < buttonsBoard.width; ++j) {
                buttons[i][j].addMinefieldButtonListener(l);
            }
        }
    }

    private void addAllButtonsToPane() {
        setLayout(new GridLayout(buttonsBoard.getHeight(), buttonsBoard.getWidth()));
        for (int i = 0; i < buttonsBoard.height; ++i) {
            for (int j = 0; j < buttonsBoard.width; ++j) {
                add(buttons[i][j]);
            }
        }
    }

    public void addGameListener(MinefieldBoardListener l) {
        listeners.add(l);
    }

    public void removeGameListener(MinefieldBoardListener l) {
        listeners.remove(l);
    }

    public void fireWin() {
        for (MinefieldBoardListener l : listeners) {
            l.win();
        }
    }

    public void fireGameOver() {
        for (MinefieldBoardListener l : listeners) {
            l.gameOver();
        }
    }

    public void fireFieldMarked(boolean flag) {
        for (MinefieldBoardListener l : listeners) {
            l.fieldMarked(flag);
        }
    }

    private MinefieldButtonListener buttonListener = new MinefieldButtonListener() {
        private GameWinCheckVisitor win = new GameWinCheckVisitor();

        @Override
        public void selected(MinefieldButtonModel b) {
            b.accept(selectedVisitor);
            checkWin();
        }

        @Override
        public void marked(MinefieldButtonModel b, boolean flag) {
            fireFieldMarked(flag);
            checkWin();
        }

        @Override
        public void mineActivated(MinefieldButtonModel b) {
            fireGameOver();
        }

        private void checkWin() {
            if (gameCompleted()) {
                fireWin();
            }
        }

        private boolean gameCompleted() {
            visitAllButtons(win);
            boolean status = win.getStatus();
            win.reset();
            return status;
        }
    };

    private MinefieldButtonVisitor selectedVisitor = new MinefieldButtonVisitor() {
        @Override
        public void visit(MineButton b) {
            visitAllButtons(new RevealUnmarkedMinesVisitor());
        }

        @Override
        public void visit(NumberButton b) {
            b.reveal();
        }

        @Override
        public void visit(EmptyButton b) {
            b.reveal();
            visitNeighbourButtons(b.row, b.col);
        }

        private void visitNeighbourButtons(int row, int col) {
            int yMin = Math.max(row - 1, 0);
            int xMin = Math.max(col - 1, 0);

            int yMax = Math.min(row + 1, buttonsBoard.height - 1);
            int xMax = Math.min(col + 1, buttonsBoard.width - 1);

            for (int i = yMin; i <= yMax; ++i) {
                for (int j = xMin; j <= xMax; ++j) {
                    if (i == row && j == col) {
                        continue;
                    }
                    visitUnselected(buttons[i][j]);
                }
            }
        }

        public void visitUnselected(MinefieldButtonModel b) {
            if (!b.isSelected()) {
                b.accept(this);
            }
        }
    };

    public void visitAllButtons(MinefieldButtonVisitor visitor) {
        for (int i = 0; i < buttonsBoard.height; ++i) {
            for (int j = 0; j < buttonsBoard.width; ++j) {
                buttons[i][j].accept(visitor);
            }
        }
    }

    public int getNumberOfRows() {
       return board.getHeight();
    }

    public int getNumberOfColumns() {
        return board.getHeight();
    }

}