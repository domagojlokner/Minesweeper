package hr.home.games.minesweeper.components.buttons;

public class EmptyButton extends MinefieldButtonModel {

    public EmptyButton(int row, int col) {
        super(row, col);
    }

    @Override
    public void accept(MinefieldButtonVisitor v) {
        v.visit(this);
    }
}
