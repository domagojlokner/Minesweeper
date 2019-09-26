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

    private ImageIcon flagIcon;
    private ImageIcon mineIcon;
    private ImageIcon activatedMineIcon;

    public Icons() {
        this.flagIcon = loadFlagIcon();
        this.mineIcon = loadMineIcon();
        this.activatedMineIcon = loadActivatedMineIcon();
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

    public ImageIcon getFlagIcon(Dimension d) {
        return scaleIcon(flagIcon, d);
    }

    public ImageIcon getMineIcon(Dimension d) {
        return scaleIcon(mineIcon, d);
    }

    public ImageIcon getActivatedMineIcon(Dimension d) {
        return scaleIcon(activatedMineIcon, d);
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
