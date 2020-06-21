package main.lab1.copyfiles;

import java.io.*;

class CopyFiles {
    private static final int BUFFER_SIZE = 1024;

    void copyfile(File input, File output) throws IOException {
        try (
            InputStream inputFile = new FileInputStream(input);
            OutputStream outputFile = new FileOutputStream(output)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int len;
            while ((len = inputFile.read(buffer)) > 0) {
                outputFile.write(buffer, 0, len);
            }
        }
    }
}