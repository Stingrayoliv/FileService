package de.telran.processor.factory;

import de.telran.processor.action.ImageAction;
import de.telran.processor.service.ActionsConfigService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageActionFactory {
    private ActionsConfigService configService;
    private Map<String, ImageAction> imageActionMap = new HashMap<>();

    public ImageActionFactory(ActionsConfigService configService) throws Exception {
        this.configService = configService;

        List<String> actionClassNames = configService.getActionClassNames();
        String actionPackage = configService.getActionPackage();

        for (String actionClassName : actionClassNames) {
            //Reflection
            ImageAction imageAction = (ImageAction) Class.forName(actionPackage + "." + actionClassName)
                    .getConstructor()
                    .newInstance();
            imageActionMap.put(imageAction.getName(), imageAction);
        }
    }

    public ImageAction getAction(String actionName) {
        return imageActionMap.get(actionName);
    }

    public static void main(String[] args) throws Exception {
        ImageActionFactory imageActionFactory=new ImageActionFactory(new ActionsConfigService());
        ImageAction preview = imageActionFactory.getAction("PREVIEW");
        preview.doAction(null);

        ImageAction grayscale=imageActionFactory.getAction("GRAYSCALE");
        grayscale.doAction(null);

        ImageAction default1=imageActionFactory.getAction("DEFAULT");
        default1.doAction(null);

        ImageAction newAction = imageActionFactory.getAction("NEW ACTION");
        newAction.doAction(null);
    }
}
