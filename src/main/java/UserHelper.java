import java.util.Locale;
import java.util.Scanner;

/**
 * Helper class to interact with users
 */
public class UserHelper {

    Scanner scanner;

    public UserHelper() {
        // locale is set to scan double with a dot . instead of comma ,
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    public int getNumberOfPeopleToSplitTheBill() {
        System.out.print("Введите количество человек на которых необходимо разделить счёт: ");
        while(true) {
            String numStr = this.scanner.next().trim();
            if (numStr.isEmpty()) {
                System.out.print("Некорректное значение для подсчёта, значение не может быть пустым. " +
                        "Попробуйе еще раз: ");
                continue;
            }
            int num;
            try {
                num = Integer.parseInt(numStr);
            } catch(NumberFormatException ex) {
                System.out.print("Некорректное значение для подсчёта, значение должно быть целым числом. " +
                        "Попробуйе еще раз: ");
                continue;
            }
            if (num > 1) {
                return num;
            }
            System.out.print("Некорректное значение для подсчёта, необходимо указать количество > 1. " +
                    "Попробуйе еще раз: ");
        }
    }

    // check if user wants to add new product
    public boolean doAddNewProduct() {
        System.out.print("Хотите ли Вы добавить ещё один товар?");
        String command = this.scanner.next().trim();
        return !command.equalsIgnoreCase("Завершить");
    }

    public Product getProduct() {
        return new Product(getProductName(), getProductPrice());
    }

    public String getProductName() {
        System.out.print("Введите название товара: ");
        while (true) {
            String name = this.scanner.next().trim();
            if (name.isEmpty()) {
                System.out.print("Некорректное значение названия товара, название не может быть пустым. " +
                        "Попробуйе еще раз: ");
                continue;
            }
            return name;
        }
    }

    public double getProductPrice() {
        System.out.print("Введите стоимость товара (в формате рубли.копейки): ");
        while (true) {
            String priceStr = this.scanner.next().trim();
            if (priceStr.isEmpty()) {
                System.out.print("Некорректное значение цены товара, значение не может быть пустым. " +
                        "Попробуйе еще раз: ");
                continue;
            }
            if (!priceStr.matches("^[0-9]+\\.[0-9]{2}$")) {
                System.out.print("Некорректное значение цены товара, " +
                        "цена должны быть в формате рубли.копейки (копейки < 100). " +
                        "Попробуйе еще раз: ");
                continue;
            }
            double price;
            try {
                price = Double.parseDouble(priceStr);
            } catch(NumberFormatException ex) {
                System.out.print("Некорректное значение для подсчёта, значение должно быть числом. " +
                        "Попробуйе еще раз: ");
                continue;
            }
            if (price <= 0) {
                System.out.print("Некорректное значение цены товара, цена должна быть > 0. " +
                        "Попробуйе еще раз: ");
                continue;
            }
            return price;
        }
    }
}