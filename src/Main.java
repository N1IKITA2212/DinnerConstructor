import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DinnerConstructor dinnerConstructor = new DinnerConstructor();

    public static void main(String[] args) {
        printMenu();
        int cmd = scanner.nextInt();
        scanner.nextLine();
        while (cmd != 4) {
            if (cmd == 1) {
                addDish();
            } else if (cmd == 2) {
                makeCombo();
            } else if (cmd == 3) {
                dinnerConstructor.printDishes();
            } else {
                System.out.println("Такой команды нет, введите от 1 до 4");
            }
            printMenu();
            cmd = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public static void printMenu() {
        System.out.println("-".repeat(20));
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Вывести все введенные блюда");
        System.out.println("4 - Выход");
        System.out.println("-".repeat(20));
    }

    public static ArrayList<String> makeListOfTypes() {
        ArrayList<String> typesOfDishesForCombo = new ArrayList<>();

        System.out.println("Вводите типы блюд, каждый новый тип с новой строки. Для завершения ввода " +
                "введите пустую строку.");
        String typeOfDish = scanner.nextLine();
        while (!typeOfDish.isEmpty()) {
            if (dinnerConstructor.hasType(typeOfDish)) {
                typesOfDishesForCombo.add(typeOfDish);
            } else {
                System.out.println("Такого типа блюд нет, введите одно из этих: " + dinnerConstructor.getSet());
            }
            typeOfDish = scanner.nextLine();
        }
        return typesOfDishesForCombo;
    }

    public static void addDish() {
        System.out.print("Введите тип блюда: ");
        String type = scanner.nextLine();
        System.out.print("Введите название блюда: ");
        String dish = scanner.nextLine();
        dinnerConstructor.addDish(type, dish);
    }

    public static void makeCombo() {
        if (dinnerConstructor.isEmpty()) {
            System.out.println("Вы не ввели ни одного блюда");
            return;
        }
        System.out.println("Начинаем создание комбинаций...");
        System.out.print("Введите количество комбинаций: ");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> typesOfDishesForCombo = makeListOfTypes();
        for (int i = 1; i <= numberOfCombos; i++) {
            System.out.println("Комбо " + i);
            System.out.println(dinnerConstructor.makeCombo(typesOfDishesForCombo));
        }
    }
}
