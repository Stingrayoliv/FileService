package de.telran.processor.service;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class FileService {
    private static  String CSV_SEPARATOR=":";
    private FileConfigService configService;

    public FileService(FileConfigService configService) {
        this.configService = configService;
    }

    public List<ImageDescriptor> readImageDescriptors(String fileName) {
//        try {
//            return File
//                    .line(Path.get)
//
//        }catch (Exception ex){
//
//        }

        return Collections.EMPTY_LIST;
    }

    public void saveImageAsFile(DownloadedImage imageToSave) {
        try {
            ImageIO.write(imageToSave.getImage(),
                    "jpg",
                    new File(configService.getPathToSavedImages("path_to_saves_images"),
                            generateImageName(imageToSave.getDescriptor())));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String generateImageName(ImageDescriptor descriptor) throws Exception {
        String imageURL = descriptor.getImageURL();
        String actionName = descriptor.getActionName();
        String path = new URL(imageURL).getPath();//
        File file = new File(path);
        String fileName = actionName + file.getAbsolutePath().replace("/", "_");
        return fileName;
    }
}
