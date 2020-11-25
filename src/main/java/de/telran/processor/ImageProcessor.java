package de.telran.processor;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.service.DownloadService;
import de.telran.processor.service.FileService;
import de.telran.processor.service.ImageService;

import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private FileService fileService;
    private DownloadService downloadService;
    private ImageService imageService;

    public static void main(String[] args) {
        String csvFile = "images.csv";
        FileService fs = new FileService(new ImageReadingService());
        DownloadService ds = new DownloadService();

        //ImageProcessor processor = new ImageProcessor(fs, ds);
        //processor.process(csvFile);

    }

    public ImageProcessor(FileService fileService, DownloadService downloadService, ImageService imageService) {
        this.fileService = fileService;
        this.downloadService = downloadService;
        this.imageService=imageService;
    }

    public void process(String fileName) {
        //main logic is here

        // reading CSV file to get image data like URLS and actions
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptors(fileName);
        // download images
        List<DownloadedImage> downloadedImages = downloadService.downloadedImages(imageDescriptors);

        //filter successfully downloaded images
        List<DownloadedImage> successfulDownloadedImages=downloadedImages
                .stream()
                .filter(DownloadedImage::isSucсessful)
                .collect(Collectors.toList());

        //apply action to every downloaded image
//        List<DownloadedImage> processedImages = successfulDownloadedImages
//                .stream().map(di -> imageService.processImage(di))
//                .collect(Collectors.toList());

        //save transformed images to disk
//processedImages
//.stream()
//        .forEach(f->fileService.saveImageAsFile(f));
        //where do we save an image?-use some config service-FileConfigService


        //generate a file name. how?
        //file naming strategy: 1. action_name+random.jpg->witch target format to use?
                                //2. use a file name from original URL.
    }
}
