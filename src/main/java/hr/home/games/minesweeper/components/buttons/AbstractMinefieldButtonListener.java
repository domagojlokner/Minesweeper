package hr.home.games.minesweeper.components.buttons;

public class AbstractMinefieldButtonListener implements MinefieldButtonListener {
    @Override
    public void selected(MinefieldButtonModel b) { }

    @Override
    public void marked(MinefieldButtonModel b, boolean flag) { }

    @Override
    public void mineActivated(MinefieldButtonModel b) { }
}
