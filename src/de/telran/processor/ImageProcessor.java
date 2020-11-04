package de.telran.processor;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.service.FileService;
import java.io.IOException;
import java.util.List;

public class ImageProcessor {
    private FileService fileService;

    public static void main(String[] args) throws IOException {
        String csvFile = "test1.csv";

        FileService fs = new FileService();
        ImageProcessor processor = new ImageProcessor(fs);

        try {
            processor.process(csvFile);
        } catch (IOException ex){
            System.out.println("file scv not found");
        }
    }

    public ImageProcessor(FileService fileService) {
        this.fileService = fileService;
    }

    public void process(String fileName) throws IOException {
        // main logic is here
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptors(fileName);
        System.out.println(imageDescriptors);
    }
}
