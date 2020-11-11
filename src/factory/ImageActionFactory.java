package factory;

import action.DefaultImageAction;
import action.GrayscaleImageAction;
import action.ImageAction;
import action.PreviewImageAction;

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
