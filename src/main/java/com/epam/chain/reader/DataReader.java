package com.epam.chain.reader;

import com.epam.chain.exception.ReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class DataReader {
    public static final Logger logger = LogManager.getLogger(DataReader.class);
    private static final String PATH = "src/main/resources/data/data.txt";

    public String readShopFromFile(String path) throws ReaderException {
        Stream<String> fileData;
        try {
            try {
                fileData = (Files.lines(Path.of(path), StandardCharsets.UTF_8));
            } catch (FileNotFoundException| NoSuchFileException e){
                fileData = (Files.lines(Path.of(PATH), StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new ReaderException(e);
        }
        StringBuilder sb = new StringBuilder();
        fileData.forEach(sb::append);
        return String.valueOf(sb).trim();
    }
}
