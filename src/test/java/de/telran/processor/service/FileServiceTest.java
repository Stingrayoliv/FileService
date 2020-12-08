package de.telran.processor.service;

import de.telran.processor.entity.ImageDescriptor;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class FileServiceTest {
    @Test
    public void generateImageNameTest() throws Exception {
        ImageDescriptor descriptor = new ImageDescriptor("https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/1a.jpg", "GRAYSCALE");
        String expected="GRAYSCALE_lukaroundimg_beelitz2017_1a.jpg";

        FileService service = new FileService(new FileConfigService());
        String actual = service.generateImageName(descriptor);
        assertEquals(expected, actual);
    }
}
