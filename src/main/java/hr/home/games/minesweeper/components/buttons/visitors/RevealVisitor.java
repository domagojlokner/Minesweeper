package hr.home.games.minesweeper.components.buttons.visitors;

import hr.home.games.minesweeper.components.buttons.EmptyButton;
import hr.home.games.minesweeper.components.buttons.MineButton;
import hr.home.games.minesweeper.components.buttons.MinefieldButtonVisitor;
import hr.home.games.minesweeper.components.buttons.NumberButton;

public class RevealVisitor implements MinefieldButtonVisitor {
    @Override
    public void visit(MineButton b) {
        b.reveal();
    }

    @Override
    public void visit(NumberButton b) {
        b.reveal();
    }

    @Override
    public void visit(EmptyButton b) {
        b.reveal();
    }
}