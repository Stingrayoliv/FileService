package de.telran.processor.service;

import de.telran.processor.entity.ImageDescriptor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
    //the second step: parsing each String into ImageDescriptor
    public List<ImageDescriptor> readImageDescriptors(String fileName) throws IOException {
        List<ImageDescriptor> list = new ArrayList<>();
        List<String> listTemp = readFileIntoList(fileName);
        for (String str : listTemp) {
            String[] array = str.split(":");
            list.add(new ImageDescriptor(array[0], array[1]));
        }
        return list;
    }

    //the first step: reading a file into a list of Strings
    public static List<String> readFileIntoList(String fileName) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines.collect(Collectors.toList());
        }
        return result;
    }
}
