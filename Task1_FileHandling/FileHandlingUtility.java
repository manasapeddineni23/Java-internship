import java.io.*;

/*
 * Task 1: File Handling Utility
 * This program demonstrates how to create, write, read,
 * and modify a text file using Java File Handling concepts.
 */

public class FileHandlingUtility {

    // Method to write data into a file
    public static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File created and data written successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read data from a file
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nReading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to append (modify) data in a file
    public static void appendToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            writer.write(content);
            System.out.println("\nFile modified successfully (data appended).");
        } catch (IOException e) {
            System.out.println("Error while modifying the file.");
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {

        String fileName = "sample.txt";

        // Writing data to file
        writeToFile(fileName,
                "Hello, this is Task 1 - File Handling Utility.\n"
              + "This file is created using Java.");

        // Reading data from file
        readFromFile(fileName);

        // Modifying (appending) data to file
        appendToFile(fileName,
                "This line is added later to demonstrate file modification.");

        // Reading file again after modification
        readFromFile(fileName);
    }
}
