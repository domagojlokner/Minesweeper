package hr.home.games.minesweeper.components.buttons;

public interface MinefieldButtonListener {
    void selected(MinefieldButtonModel b);
    void marked(MinefieldButtonModel b, boolean flag);
    void mineActivated(MinefieldButtonModel b);
}
