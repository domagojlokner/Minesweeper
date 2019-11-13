package hr.home.games.minesweeper.boards;

public interface MinefieldBoardListener {
    void gameOver();
    void win();
    void fieldMarked(boolean flag);
}
