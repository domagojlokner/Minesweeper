package hr.home.games.minesweeper.components.buttons;

public class MineButton extends MinefieldButtonModel {

    public MineButton(int row, int col) {
        super(row, col);
    }

    @Override
    public void accept(MinefieldButtonVisitor v) {
        v.visit(this);
    }

    @Override
    protected void leftClickAction() {
        super.leftClickAction();
        if (isSelected()) {
            setIcons(icons.getActivatedMineIcon(getIconSize()));
            fireMineActivated();
        }
    }

    @Override
    public void reveal() {
        super.reveal();
        if (isSelected()) {
            setIcons(icons.getMineIcon(getIconSize()));
        }
    }

    @Override
    public void restore() {
        super.restore();
    }
}
