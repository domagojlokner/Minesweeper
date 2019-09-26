package hr.home.games.minesweeper.components.buttons;

import hr.home.games.minesweeper.components.Icons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public abstract class MinefieldButtonModel extends JToggleButton {
    protected boolean flag;
    protected Icons icons;
    private int ICON_GAP = 15;

    private List<MinefieldButtonListener> listeners = new LinkedList<>();

    public MinefieldButtonModel() {
        this.icons = new Icons();

        addMouseListener(rightClickActionListener);
        addMouseListener(leftClickActionListener);
    }

    public abstract void accept(MinefieldButtonVisitor v);

    protected MouseAdapter rightClickActionListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!MinefieldButtonModel.this.isSelected()) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    MinefieldButtonModel.this.rightClickAction();
                }
            }
        }
    };

    protected MouseAdapter leftClickActionListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON3) {
                MinefieldButtonModel.this.leftClickAction();
            }
        }
    };

    protected void rightClickAction() {
        setSelected(false);
        flag = !flag;
        setIcons(flag ? icons.getFlagIcon(getIconSize()) : null);
        setEnabled(!flag);
        fireMarked(flag);
    }

    protected void leftClickAction() {
        if(!flag) {
            setSelected(true);
            setEnabled(false);
            fireSelected();
        } else {
            setSelected(false);
        }
    }

    public void reveal() {
        flag = false;
        leftClickAction();
    }

    public void restore() {
        flag = false;
        setEnabled(true);
        setSelected(false);
        setIcons(null);
    }

    public boolean isMarked() {
        return flag;
    }

    public void addMinefieldButtonListener(MinefieldButtonListener l) {
        listeners.add(l);
    }

    public void removeMinefieldButtonListener(MinefieldButtonListener l) {
        listeners.remove(l);
    }

    public void fireSelected() {
        for (MinefieldButtonListener l : listeners) {
            l.selected(this);
        }
    }

    public void fireMarked(boolean f) {
        for (MinefieldButtonListener l : listeners) {
            l.marked(this, f);
        }
    }

    public void fireMineActivated() {
        for (MinefieldButtonListener l : listeners) {
            l.mineActivated(this);
        }
    }

    protected void setIcons(Icon icon) {
        setDisabledIcon(icon);
        setIcon(icon);
    }

    protected Dimension getIconSize() {
        Dimension size = getSize();
        return new Dimension(size.width - ICON_GAP, size.height - ICON_GAP);
    }
}
