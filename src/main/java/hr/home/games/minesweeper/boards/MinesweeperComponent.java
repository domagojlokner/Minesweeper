package hr.home.games.minesweeper.boards;

import hr.home.games.minesweeper.components.buttons.*;

public class MinesweeperComponent extends MinesweeperButtonsBoard {

    public MinesweeperComponent(int width, int height, int numOfMines) {
        super(width, height, numOfMines);
    }

    public void visitAllFields(MinefieldButtonVisitor visitor) {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                field[i][j].accept(visitor);
            }
        }
    }

//    private List<MinefieldButtonGroup> splitToGroups() {
//        MinefieldButtonModel[][] minefield = copyButtonField();
//
//    }

    private MinefieldButtonModel[][] copyButtonField() {
        MinefieldButtonModel[][] fieldCopy = new MinefieldButtonModel[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                fieldCopy[i][j] = field[i][j];
            }
        }
        return fieldCopy;
    }
}