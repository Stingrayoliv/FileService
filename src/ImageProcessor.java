import entity.DownloadedImage;
import entity.ImageDescriptor;
import service.DownloadService;
import service.FileService;

import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private FileService fileService;
    private DownloadService downloadService;

    public static void main(String[] args) {
        String csvFile = "images.csv";
        FileService fs = new FileService();
        DownloadService ds = new DownloadService();

        ImageProcessor processor = new ImageProcessor(fs, ds);
        processor.process(csvFile);

    }

    public ImageProcessor(FileService fileService, DownloadService downloadService) {
        this.fileService = fileService;
        this.downloadService = downloadService;
    }

    public void process(String fileName) {

        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptors(fileName);
        // List успешных
        List<DownloadedImage> downloadedImages = downloadService.downloadImages(imageDescriptors);
        List<DownloadedImage> s=downloadedImages.stream().filter(DownloadedImage::isSucсessful).collect(Collectors.toList());

    }
}
