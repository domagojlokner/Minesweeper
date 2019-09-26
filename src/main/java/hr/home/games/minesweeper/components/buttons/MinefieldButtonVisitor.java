package hr.home.games.minesweeper.components.buttons;

public interface MinefieldButtonVisitor {
    void visit(MineButton b);
    void visit(NumberButton b);
    void visit(EmptyButton b);
}
