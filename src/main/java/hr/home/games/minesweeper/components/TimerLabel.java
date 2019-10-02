package hr.home.games.minesweeper.components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TimerLabel extends JLabel {
    private Timer timer = new Timer(1000, null);
    private int currentValue = 0;

    public TimerLabel() {
        setText("0");
        timer.addActionListener(timerTextSetter);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void restartTimer() {
        timer.restart();
    }

    public int getCurrentTime() {
        return currentValue;
    }

    private ActionListener timerTextSetter = (e) -> {
        currentValue++;
        setText(Integer.toString(currentValue));
    };
}
