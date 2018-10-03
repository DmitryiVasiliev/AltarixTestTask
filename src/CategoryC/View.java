package CategoryC;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class View { // Интерфейс пользователя
    private static View instance = null;
    private static Scanner scanner;
    private static BufferedReader reader;
    Controller controller;

    private View() {
        controller = Controller.getInstance();
        scanner = new Scanner(System.in);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public synchronized static View getInstance() { // паттерн проектирования singleton
        if (instance == null)
            instance = new View();
        return instance;
    }

    public void getSelect() throws IOException, JAXBException {
        boolean check = true;
        while (check) {
            System.out.println("1.Скобочное выражение ");
            System.out.println("2.Найти cos ");
            System.out.println("3.Найти sin ");
            System.out.println("4.Найти tg ");
            System.out.println("5.Найти ctg ");
            System.out.println("6.Системы счисления");
            System.out.println("7.Просмотр сохраненных выражений");
            System.out.println("8.Выход ");

            check = controller.Calc(scanner.nextInt());
        }
    }

    public static String setArg() throws IOException {
        System.out.print("Введите аргумент: ");
        return reader.readLine();
    }

    public static String setEx() throws IOException {
        System.out.print("Введите выражение: ");
        return reader.readLine();
    }

    public static String setExSys() throws IOException {
        System.out.print("Введите выражение: из число в. Пример: 10 2 2: ");
        return reader.readLine();
    }

    public static void Print(double res) {

        System.out.println("Ответ: " + res);
    }

    public static void Print(String res) {

        System.out.println("Ответ: " + res);
    }

    public static void Print(Datalist datalist) {
        if (datalist != null) {
            for (Data data : datalist.getDatalist()
            ) {
                System.out.println("Example: " + data.getExample() + " = " + data.getResult());
            }
        } else System.out.println("Вы еще ничего не сохранили");
    }


}
