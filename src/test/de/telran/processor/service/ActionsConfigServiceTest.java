package de.telran.processor.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActionsConfigServiceTest {
    ActionsConfigService service = new ActionsConfigService();

    ActionsConfigServiceTest() throws IOException {
    }

    @Test
    public void getActionPackage() {
        String answer = service.getActionPackage();
        assertEquals("de.telran.processor.action", answer);
    }

//    @Test
//    public void getActionClassNames() {
//        List<String> list = service.getActionClassNames();
//        assertEquals(Arrays.asList("Grayscale", "ImageAction", "DefaultImageAction", "PreviewImageAction"), list);
//    }

}