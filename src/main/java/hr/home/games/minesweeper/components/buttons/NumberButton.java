package hr.home.games.minesweeper.components.buttons;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class NumberButton extends MinefieldButtonModel{
    private int number;
    private final int GAP = 20;

    private static Map<Integer, Color> colorMap = new HashMap<>();

    public NumberButton(int number, int row, int col) {
        super(row, col);
        this.number = number;
        initMap();
    }

    @Override
    public void accept(MinefieldButtonVisitor v) {
        v.visit(this);
    }

    private static void initMap() {
        colorMap.put(1, Color.BLUE);
        colorMap.put(2, new Color(0, 153, 0));
        colorMap.put(3, Color.RED);
        colorMap.put(4, new Color(0, 0, 153));
        colorMap.put(5, new Color(153, 0, 0));
        colorMap.put(6, new Color(0, 153, 153));
    }

    public void updateNumber(int number) {
        this.number = number;
    }

    @Override
    public void reveal() {
        super.reveal();
        if (isSelected()) {
            setFont(new Font("Arial", Font.BOLD, getSize().height - GAP));
            setBackground(colorMap.get(number));
            setText(Integer.toString(number));
        }
    }
}
