package hr.home.games.minesweeper;

public interface GameListener {
    void win(MinesweeperComponent m);
    void gameOver(MinesweeperComponent m);
}
