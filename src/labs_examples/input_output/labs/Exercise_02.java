package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 2: File encryption
 *
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files.
 *
 *      Then, read back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */
class Exercise_02 {
    public static void main(String[] args) {
        String file = "src/labs_examples/input_output/labs/ex_02_text_og";
        String newFile = "src/labs_examples/input_output/labs/ex_02_text_copy";
        System.out.println("Writing:");
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile))) {
            int character;
            while ((character = bufferedReader.read()) != -1) {
                bufferedWriter.write(encryptCharacter(character));
                System.out.print((char)character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nEncrypted Reading:");
        try (BufferedReader encryptedReader = new BufferedReader(new FileReader(newFile))) {
            int character;
            while ((character = encryptedReader.read()) != -1) {
                System.out.print((char)character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nDecrypted Reading:");
        try (BufferedReader anotherBufferedReader = new BufferedReader(new FileReader(newFile))) {
            int character;
            while ((character = anotherBufferedReader.read()) != -1) {
                System.out.print((char)decryptCharacter(character));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int encryptCharacter(int character) {
        if (character == 'a') {
            return '-';
        } else if (character == 'e') {
            return '~';
        } else {
            return character;
        }
    }

    private static int decryptCharacter(int character) {
        if (character == '-') {
            return 'a';
        } else if (character == '~') {
            return 'e';
        } else {
            return character;
        }
    }
}
