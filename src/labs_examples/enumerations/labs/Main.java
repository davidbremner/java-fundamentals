package labs_examples.enumerations.labs;

enum PizzaStatus {
    //ADD THE STATUSES
    ORDERED,
    MAKING,
    READY,
    DELIVERED;
}


class Pizza {
    private PizzaStatus status;

    public boolean isDeliverable() {
        // COMPLETE SO THAT THIS RETURNS TRUE WHEN STATUS IS READY
        return status.equals(PizzaStatus.READY);
    }

    public void setStatus(PizzaStatus status){
        this.status = status;
    }

    public PizzaStatus getStatus(){
        return this.status;
    }

}

public class Main {
    public static void main(String[] args){
        Pizza myPizza = new Pizza();
        myPizza.setStatus(PizzaStatus.MAKING);
        System.out.println(myPizza.getStatus());
        System.out.println(myPizza.isDeliverable());
        myPizza.setStatus(PizzaStatus.READY);
        System.out.println(myPizza.getStatus());
        System.out.println(myPizza.isDeliverable());
    }
}