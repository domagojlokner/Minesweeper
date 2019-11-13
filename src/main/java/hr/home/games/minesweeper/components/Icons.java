package hr.home.games.minesweeper.components;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Icons {
    public static final String flagIconPath = "icons/flag.png";
    public static final String mineIconPath = "icons/mine.png";
    public static final String activatedMinePath = "icons/activated_mine.png";

    public static final String buttonIconPath = "icons/button.png";
    public static final String buttonIconWinPath = "icons/button_win.png";
    public static final String buttonIconGameOverPath = "icons/button_gameover.png";

    private ImageIcon flagIcon;
    private ImageIcon mineIcon;
    private ImageIcon activatedMineIcon;

    private ImageIcon buttonIcon;
    private ImageIcon buttonIconWin;
    private ImageIcon buttonIconGameOver;

    public Icons() {
        this.flagIcon = loadFlagIcon();
        this.mineIcon = loadMineIcon();
        this.activatedMineIcon = loadActivatedMineIcon();

        this.buttonIcon = loadButtonIcon();
        this.buttonIconGameOver = loadButtonIconGameOver();
        this.buttonIconWin = loadButtonIconWin();
    }


    public ImageIcon getFlagIcon() {
        return flagIcon;
    }

    public ImageIcon getMineIcon() {
        return mineIcon;
    }

    public ImageIcon getActivatedMineIcon() {
        return activatedMineIcon;
    }

    public ImageIcon getButtonIcon() {
        return buttonIcon;
    }

    public ImageIcon getButtonIconWin() {
        return buttonIconWin;
    }

    public ImageIcon getButtonIconGameOver() {
        return buttonIconGameOver;
    }


    public ImageIcon getFlagIcon(Dimension d) {
        return scaleIcon(flagIcon, d);
    }

    public ImageIcon getMineIcon(Dimension d) {
        return scaleIcon(mineIcon, d);
    }

    public ImageIcon getActivatedMineIcon(Dimension d) {
        return scaleIcon(activatedMineIcon, d);
    }

    public ImageIcon getButtonIcon(Dimension d) {
        return scaleIcon(buttonIcon, d);
    }

    public ImageIcon getButtonIconWin(Dimension d) {
        return scaleIcon(buttonIconWin, d);
    }

    public ImageIcon getButtonIconGameOver(Dimension d) {
        return scaleIcon(buttonIconGameOver, d);
    }


    private ImageIcon loadFlagIcon() {
        return loadIcon(flagIconPath);
    }

    private ImageIcon loadMineIcon() {
        return loadIcon(mineIconPath);
    }

    private ImageIcon loadActivatedMineIcon() {
        return loadIcon(activatedMinePath);
    }

    private ImageIcon loadButtonIcon() {
        return loadIcon(buttonIconPath);
    }

    private ImageIcon loadButtonIconWin() {
        return loadIcon(buttonIconWinPath);
    }

    private ImageIcon loadButtonIconGameOver() {
        return loadIcon(buttonIconGameOverPath);
    }


    private ImageIcon loadIcon(String path) {
        byte[] bytesIcon;
        try(InputStream is = getClass().getResourceAsStream(path)) {
            if (Objects.isNull(is)) {
                return null;
            }
            bytesIcon = is.readAllBytes();
        } catch (IOException | NullPointerException e) {
            return null;
        }
        return new ImageIcon(bytesIcon);
    }

    public ImageIcon scaleIcon(ImageIcon img, Dimension size) {
        if (img == null) {
            return null;
        }

        size = checkSize(size);

        Image image = img.getImage();
        image = image.getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);
        return new ImageIcon(image);
    }

    private Dimension checkSize(Dimension size) {
        size.height = size.height <= 0 ? 1: size.height;
        size.width = size.width <= 0 ? 1: size.width;
        return size;
    }
}
