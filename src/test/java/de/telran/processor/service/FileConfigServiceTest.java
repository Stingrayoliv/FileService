package de.telran.processor.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileConfigServiceTest {
    @Test
    public void getPathToSavedImages() throws Exception {
        FileConfigService service = new FileConfigService();
        String answer = service.getPathToSavedImages("path_to_saves_images");
        assertEquals("~/Downloads/images/", answer);
    }
}