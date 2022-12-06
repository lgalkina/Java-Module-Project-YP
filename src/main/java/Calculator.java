/**
 * Calculator implementation
 */
public class Calculator {

    int split;
    double amountToPay;
    String products = "";

    public Calculator (int split) {
        this.split = split;
    }

    public void addProduct(Product product) {
        this.amountToPay += product.price;
        this.products += product.name + "\n";
        System.out.printf("Товар '%s' был успешно добавлен в калькулятор для дальнейшего подсчета\n", product.name);
    }

    public void printBillProducts() {
        System.out.println("Добавленные товары:\n" + this.products);
    }

    public void printBillPerMan() {
        double splitAmountToPay = this.amountToPay / split;
        System.out.printf("%.2f %s\n", splitAmountToPay, this.currencyFormat(splitAmountToPay));
    }

    private String currencyFormat(double splitAmountToPay) {
        int amount = (int)Math.floor(splitAmountToPay);
        switch (amount) {
            case 1:
                return "рубль";
            case 2|3|4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
