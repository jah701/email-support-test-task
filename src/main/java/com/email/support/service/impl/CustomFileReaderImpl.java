package com.email.support.service.impl;

import com.email.support.service.CustomFileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReaderImpl implements CustomFileReader {
    @Override
    public List<String> readFile(String path) {
        List<String> result = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String rejectedLine = reader.readLine(); // Rejecting first line
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Wrong file path: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed while reading the file: " + path, e);
        }
        return result;
    }
}
