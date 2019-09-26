package hr.home.games.minesweeper.components.buttons;

public class MineButton extends MinefieldButtonModel {
    private boolean revealed = false;

    @Override
    public void accept(MinefieldButtonVisitor v) {
        v.visit(this);
    }

    @Override
    protected void leftClickAction() {
        super.leftClickAction();
        if (isSelected() && !revealed) {
            setIcons(icons.getActivatedMineIcon(getIconSize()));
            fireMineActivated();
        }
    }

    @Override
    public void reveal() {
        setSelected(true);
        setEnabled(false);
        revealed = true;
        setIcons(icons.getMineIcon(getIconSize()));
    }

    @Override
    public void restore() {
        super.restore();
        revealed = false;
    }
}
