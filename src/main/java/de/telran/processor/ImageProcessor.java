package de.telran.processor;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.service.DownloadService;
import de.telran.processor.service.FileService;

import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private FileService fileService;
    private DownloadService downloadService;

    public static void main(String[] args) {
        String csvFile = "images.csv";
        FileService fs = new FileService();
        //DownloadService ds = new DownloadService();

        //ImageProcessor processor = new ImageProcessor(fs, ds);
        //processor.process(csvFile);

    }

    public ImageProcessor(FileService fileService, DownloadService downloadService) {
        this.fileService = fileService;
        this.downloadService = downloadService;
    }


    public void process(String fileName) {
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptors(fileName);
        List<DownloadedImage> downloadedImages = downloadService.downloadImages(imageDescriptors);

        List<DownloadedImage> successfullyDownloadedImages = downloadedImages.stream()
                .filter(DownloadedImage::isSucсessful).collect(Collectors.toList());
    }
}
