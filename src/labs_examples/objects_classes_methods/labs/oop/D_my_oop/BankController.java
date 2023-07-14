package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class BankController {
    public static void main(String[] args){

        Card myCard = new Card(1678787878, "01/01/26");
        Merchant myMerchant = new Merchant("H&M");
        BankInformation myAccount = new BankInformation("Lloyds Bank", 500, myCard);
        CustomerProfile myCustomer = new CustomerProfile("David Bremner", "05/10/88",
                "4 Marwood Court", myAccount);

    }
}
