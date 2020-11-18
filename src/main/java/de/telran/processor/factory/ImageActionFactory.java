package de.telran.processor.factory;

import de.telran.processor.action.DefaultImageAction;
import de.telran.processor.action.GrayscaleImageAction;
import de.telran.processor.action.ImageAction;
import de.telran.processor.action.PreviewImageAction;

public class ImageActionFactory {
    public ImageAction getAction(String actionName){
        switch (actionName){
            case "PREVIEW":
                return new PreviewImageAction();
            case "GRAYSCALE":
                return new GrayscaleImageAction();
            default:
                return new DefaultImageAction();
        }
    }
}
