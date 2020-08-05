package com.posrocket.assesment.utils;

import java.nio.file.Path;

public class FileUtil {
    private FileUtil() {
    }

    public static String getFileExtension(Path file) {
        String fileName = file.toString();
        int idx = fileName.lastIndexOf('.') + 1;
        return fileName.substring(idx);
    }
}
