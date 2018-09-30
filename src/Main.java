import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Категория А");
        System.out.println("2.Категория В");
        System.out.println("3.Категория С");
        int cat = scanner.nextInt();
        switch (cat) {
            case 1:
                CategoryA categoryA = new CategoryA();
                switch (categoryA.NumberSel()) {
                    case 1:
                        if (categoryA.Task1()) System.out.println("IN");
                        else System.out.println("OUT");
                        break;
                    case 2:
                        System.out.println(categoryA.Task2());
                        break;
                    case 3:
                        categoryA.Task3();
                        break;
                    case 4:
                        categoryA.Task4();
                        break;
                    case 5:
                        categoryA.Task5();
                        break;
                    default:
                        System.out.println("Введите верную цифру");
                        break;
                }


                break;
            case 2:
                CategoryB categoryB = new CategoryB();
                switch (categoryB.getSelect()) {
                    case 1:
                        System.out.println(categoryB.task1());
                        break;
                    case 2:
                        categoryB.task2();
                        break;
                    case 3:
                        categoryB.task3();
                        break;
                }
                break;
            case 3:
                break;
            default:
                break;
        }


    }
}
