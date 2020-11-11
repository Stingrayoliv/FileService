package entity;

import java.awt.image.BufferedImage;

public class DownloadedImage {
    private BufferedImage image;
    private boolean isSucсessful;
    private ImageDescriptor descriptor;

    public DownloadedImage(BufferedImage image, boolean isSucсessful, ImageDescriptor descriptor) {
        this.image = image;
        this.isSucсessful = isSucсessful;
        this.descriptor=descriptor;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSucсessful() {
        return isSucсessful;
    }

    public ImageDescriptor getDescriptor() {
        return descriptor;
    }
}
