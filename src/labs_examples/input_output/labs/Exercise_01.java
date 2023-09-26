package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */

class Example {
    public static void main(String[] args) {
        String fileName = "src/labs_examples/input_output/labs/some_bytes";
        String otherFile = "src/labs_examples/input_output/labs/some_bytes_copied";

        try (
                BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(fileName));
                BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(otherFile))
        ) {
            int bytesRead;
            byte[] buffer = new byte[5];
            while ((bytesRead = buffIn.read(buffer)) != -1) {
                buffOut.write(buffer, 0, bytesRead);
            }
            System.out.println("File read and copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}