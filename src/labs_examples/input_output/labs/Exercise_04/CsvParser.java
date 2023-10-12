package labs_examples.input_output.labs.Exercise_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvParser {
    static ArrayList<Transaction> csvReader(String csvFile) {

        String line;
        ArrayList<Transaction> transactions = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                transactions.add(parseToTransactionObject(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    private static Transaction parseToTransactionObject(String transaction) {
        Transaction transactionObject = new Transaction();

        String[] transactionDetails = transaction.split(",");

        transactionObject.setFirstName(transactionDetails[0]);
        transactionObject.setLastName(transactionDetails[1]);
        transactionObject.setEmail(transactionDetails[2]);
        transactionObject.setPaymentMethod(transactionDetails[3]);
        transactionObject.setPurchaseAmount(Double.parseDouble(transactionDetails[4]));
        transactionObject.setCurrency(transactionDetails[5]);

        return transactionObject;
    }
}
