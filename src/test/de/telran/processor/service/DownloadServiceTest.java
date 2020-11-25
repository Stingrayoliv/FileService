package de.telran.processor.service;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DownloadServiceTest {
    @Test
    public void downloadedImages() {
        ImageDescriptor d1 = new ImageDescriptor("URL1", "make1");
        ImageDescriptor d2 = new ImageDescriptor("URL2", "make2");
        ImageDescriptor d3 = new ImageDescriptor("URL3", "make3");

        List<ImageDescriptor> descList = Arrays.asList(d1, d2, d3);
        DownloadService service = new DownloadService();
        List<DownloadedImage> imageList = service.downloadedImages(descList);
        assertEquals(3, imageList.size());
    }
}
