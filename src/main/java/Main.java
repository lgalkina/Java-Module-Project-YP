public class Main {

    public static void main(String[] args) {
        UserHelper userHelper = new UserHelper();
        Calculator calculator = new Calculator(userHelper.getNumberOfPeopleToSplitTheBill());

        do {
            calculator.addProduct(userHelper.getProduct());
        } while (userHelper.doAddNewProduct());

        calculator.printBillProducts();
        calculator.printBillPerMan();
    }
}