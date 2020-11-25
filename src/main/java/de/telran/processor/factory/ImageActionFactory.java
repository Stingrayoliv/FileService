package de.telran.processor.factory;
import de.telran.processor.action.ImageAction;
import de.telran.processor.service.ActionsConfigService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageActionFactory {
    private ActionsConfigService actionsConfigService;
    private Map<String, ImageAction> imageActionMap = new HashMap<>();

    public ImageActionFactory(ActionsConfigService actionsConfigService) throws Exception {
        this.actionsConfigService = actionsConfigService;

        List<String> actionClassNames = actionsConfigService.getActionClassNames();
        String actionPackage = actionsConfigService.getActionPackage();
        for (String actionClassName : actionClassNames) {
            ImageAction imageAction = (ImageAction) Class.forName(actionPackage + "." + actionClassName)
                    .getConstructor().newInstance();
            imageActionMap.put(imageAction.getName(), imageAction);
        }
    }

    public ImageAction getAction(String actionName) {
        return imageActionMap.get(actionName);
    }

    public static void main(String[] args) throws Exception {
        ImageActionFactory imageActionFactory = new ImageActionFactory(new ActionsConfigService());
        ImageAction preview = imageActionFactory.getAction("PREVIEW");
        preview.doAction(null);

        ImageAction default1 = imageActionFactory.getAction("DEFAULT");
        default1.doAction(null);
    }
}
