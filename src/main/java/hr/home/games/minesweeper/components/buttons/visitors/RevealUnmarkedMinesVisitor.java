package hr.home.games.minesweeper.components.buttons.visitors;

import hr.home.games.minesweeper.components.buttons.MineButton;

public class RevealUnmarkedMinesVisitor extends AbstractMinefieldButtonVisitor {
    @Override
    public void visit(MineButton b) {
        if (b.isMarked() || b.isSelected()) {
            return;
        }
        b.reveal();
    }
}
