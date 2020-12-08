package de.telran.processor.service;

import de.telran.processor.action.ImageAction;
import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.factory.ImageActionFactory;

import java.awt.image.BufferedImage;

public class ImageService {
    private ImageActionFactory factory;

    public ImageService(ImageActionFactory factory) {
        this.factory = factory;
    }

    public DownloadedImage processImage(DownloadedImage image){
        ImageAction action = factory.getAction(image.getDescriptor().getActionName());
        try {
            BufferedImage result = action.doAction(image.getImage());
            return new DownloadedImage(result, true, image.getDescriptor());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
