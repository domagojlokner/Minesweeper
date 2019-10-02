package hr.home.games.minesweeper.components.buttons.visitors;

import hr.home.games.minesweeper.components.buttons.EmptyButton;
import hr.home.games.minesweeper.components.buttons.MineButton;
import hr.home.games.minesweeper.components.buttons.MinefieldButtonVisitor;
import hr.home.games.minesweeper.components.buttons.NumberButton;

public class GameWinCheckVisitor implements MinefieldButtonVisitor {
    private boolean win = true;

    public boolean getStatus() {
        return win;
    }

    public void reset() {
        win =  true;
    }

    @Override
    public void visit(MineButton b) {
        win = win && b.isMarked();
    }

    @Override
    public void visit(NumberButton b) {
        win = win && b.isSelected() && !b.isMarked();
    }

    @Override
    public void visit(EmptyButton b) {
        win = win && b.isSelected() && !b.isMarked();
    }
}
