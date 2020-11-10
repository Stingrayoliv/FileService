package entity;

import java.awt.image.BufferedImage;

public class DownloadedImage {
    private BufferedImage image;
    private boolean isSucсessful;

    public DownloadedImage(BufferedImage image, boolean isSucсessful) {
        this.image = image;
        this.isSucсessful = isSucсessful;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSucсessful() {
        return isSucсessful;
    }
}
