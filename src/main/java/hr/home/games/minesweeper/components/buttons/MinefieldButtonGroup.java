package hr.home.games.minesweeper.components.buttons;

import java.util.LinkedList;
import java.util.List;

public class MinefieldButtonGroup {
    private List<MinefieldButtonModel> buttons = new LinkedList<>();

    public void add(MinefieldButtonModel b) {
        buttons.add(b);
    }

    public void remove(MinefieldButtonModel b) {
        buttons.remove(b);
    }

    public void addListener(MinefieldButtonListener l) {
        for (MinefieldButtonModel b : buttons) {
            b.addMinefieldButtonListener(l);
        }
    }

    public void removeListener(MinefieldButtonListener l) {
        for (MinefieldButtonModel b : buttons) {
            b.removeMinefieldButtonListener(l);
        }
    }
}
