package com.newgen.app;

import java.io.IOException;

public class ZipFolderWith7z {
    public static void main(String[] args) {
        String folderPath = "path/to/your/folder";
        String zipFilePath = "path/to/your/output.zip";

        try {
            // Build the 7z command
            ProcessBuilder processBuilder = new ProcessBuilder("7z", "a", zipFilePath, folderPath);

            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to finish
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Folder zipped successfully.");
            } else {
                System.out.println("Failed to zip the folder. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

