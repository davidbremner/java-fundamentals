package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 3: variety
 *
 *    1) Demonstrate the usage of at least two additional Byte Streams
 *    2) Demonstrate the usage of at least two additional Character Streams
 *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
 *    4) Demonstrate the use of the DataInputStream and DataOutputStream
 *
 */

class Exercise_03 {
    public static void main (String[] args) {
        // Task 1:
        String inputFileOne = "src/labs_examples/input_output/labs/ex_03_byte_stream_read01";
        String outputFileOne = "src/labs_examples/input_output/labs/ex_03_byte_stream_write01";
        byteWriter(inputFileOne, outputFileOne);
        String inputFileTwo = "src/labs_examples/input_output/labs/ex_03_byte_stream_read02";
        byteEncryptor(inputFileTwo); // updated for task 3 - using buffer on Byte Streams to encrypt
        byteDecryptor(inputFileTwo + "_ENCRYPTED");
        // Task 2:
        String inputFileThree = "src/labs_examples/input_output/labs/ex_03_character_stream_read01";
        vowelCounter(inputFileThree);
        lineCounter(inputFileThree);
        // Task 3:
        // updated encryptor above for byte stream buffer (under Task 1)
        lineCounter(inputFileThree, "Karma Chameleon");
        // Task 4:
        String outputFileTwo = "src/labs_examples/input_output/labs/ex_o3_data_stream";
        dataParser(outputFileTwo);
    }

    private static void byteWriter(String inputFile, String outputFile) {
        try (FileInputStream byteStreamOneInput = new FileInputStream(inputFile);
             FileOutputStream byteStreamOneOutput = new FileOutputStream(outputFile)) {
            int nextByte;
            while ((nextByte = byteStreamOneInput.read()) != -1) {
                byteStreamOneOutput.write(nextByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Encrypts the content of the input file and writes it to the output file.
     *
     * @param inputFile  The path of the input file to be encrypted.
     */

    private static void byteEncryptor(String inputFile) {
        final int ENCRYPTION_OFFSET = 1;
        final char NEXT_LINE = '\n';
        final int BUFFER_SIZE = 100;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(new FileOutputStream(inputFile + "_ENCRYPTED"))) {
            int bytesRead;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                for (int index = 0; index < buffer.length; index++) {
                    if (buffer[index] != NEXT_LINE) {
                        buffer[index] = (byte) (buffer[index] + ENCRYPTION_OFFSET);
                    }
                }
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Encountered error during encryption:");
            e.printStackTrace();
        }
    }

    /**
     * Decrypts the content of the input file and prints it to the console.
     *
     * @param inputFile The path of the input file containing encrypted content.
     */

    private static void byteDecryptor(String inputFile) {
        final int ENCRYPTION_OFFSET = 1;
        final char nextLine = '\n';
        try (FileInputStream fileInputStream = new FileInputStream(inputFile)) {
            int nextByte;
            while ((nextByte = fileInputStream.read()) != -1) {
                if (nextByte == nextLine) {
                    System.out.print((char)nextByte);
                } else {
                    System.out.print((char)(nextByte - ENCRYPTION_OFFSET));
                }
            }
        } catch (IOException e) {
            System.err.println("Encountered error during decryption:");
            e.printStackTrace();
        }
    }

    /**
     * Reads each character in the inputFile and calculates the total sum of vowels in the song lyrics,
     * printing the result to the console.
     *
     * @param inputFile The path to the input file to be analysed.
     */
    private static void vowelCounter(String inputFile) {
        final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
        int vowelCount = 0;
        try (FileReader fileReader = new FileReader(inputFile)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                for (char vowel : VOWELS) {
                    if (character == vowel) {
                        vowelCount++;
                    }
                }
            }
            System.out.println("\nTotal vowels in the song lyrics: " + vowelCount);
        } catch (IOException e) {
            System.err.println("Encountered error in characterWriter:");
            e.printStackTrace();
        }
    }

    /**
     * Reads each character in the inputFile and calculates the total sum of lines in the inputFile by checking the
     * new paragraph character, finally printing the result to the console.
     * @param inputFile The path to the input file to be analysed.
     */
    private static void lineCounter(String inputFile) {
        final char PARAGRAPH = '\n'; // The character used to identify line breaks
        int lineCount = 0;
        try (FileReader fileReader =new FileReader(inputFile)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                if (character == PARAGRAPH) {
                    lineCount++;
                }
            }
            // Print the total number of lines, adding 1 to account for the last line
            System.out.println("Total number of lines in the song lyrics: " + (lineCount + 1));
        } catch (IOException e) {
            System.err.println("Encountered error in lineCounter:");
            e.printStackTrace();
        }
    }

    /**
     * Reads each line of the lyrics of a song, increments the counter for each line and finally outputs the result
     * to the console.
     * @param inputFile The path to the input file to be analysed.
     * @param songTitle The title of the song passed to the method for output purposes.
     */
    private static void lineCounter(String inputFile, String songTitle) {
        int lineCounter = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            while ((bufferedReader.readLine()) != null) {
                lineCounter++;
            }
        } catch (IOException ioException) {
            System.err.println("Encountered error in lineCounterBuffed:");
            ioException.printStackTrace();
        }
        System.out.println("\nTotal lines in the song " + songTitle + ": " + lineCounter + ".");
    }

    /**
     * Demonstrates the usage of DataInputStream and DataOutputStream to read and write binary data
     * to/from a specified file.
     *
     * @param outputFile The name of the file to write and read data. It should include the desired file
     *                   extension and be accessible for read and write operations.
     */
    private static void dataParser(String outputFile) {
    try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outputFile));
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(outputFile))) {
        // Writing data
        int number = 55;
        double decimal = 12.44;
        char letter = 'd';
        dataOutputStream.writeInt(number);
        dataOutputStream.writeDouble(decimal);
        dataOutputStream.writeChar(letter);
        // Reading data
        System.out.println("\nUse of the DataInputStream and DataOutputStream:");
        System.out.println("Int: " + dataInputStream.readInt());
        System.out.println("Double: " + dataInputStream.readDouble());
        System.out.println("Char: " + dataInputStream.readChar());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
