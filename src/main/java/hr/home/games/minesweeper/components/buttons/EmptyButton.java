package hr.home.games.minesweeper.components.buttons;

public class EmptyButton extends MinefieldButtonModel {
    @Override
    public void accept(MinefieldButtonVisitor v) {
        v.visit(this);
    }
}
