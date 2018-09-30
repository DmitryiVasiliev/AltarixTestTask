import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CategoryB {
    private Scanner scanner;
    private int select;

    public CategoryB() {
        scanner = new Scanner(System.in);
        System.out.println("Задание 1");
        System.out.println("Задание 2");
        System.out.println("Задание 3");
        select = scanner.nextInt();
    }

    public int getSelect() {
        return select;
    }

    public String task1() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String skob = "";
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        System.out.println("Введите скобочное выражение ");
        try {
            skob = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        skob.replace(" ", "");

        for (int i = 0; i < skob.length(); i++) {
            if (skob.charAt(i) == '(' || skob.charAt(i) == '{' || skob.charAt(i) == '[')
                stack.push(skob.charAt(i));

            else if (skob.charAt(i) == ')') {
                if (stack.peek().equals('(')) stack.pop();
                else {
                    flag = false;
                    break;
                }

            } else if (skob.charAt(i) == '}') {
                if (stack.peek().equals('{')) stack.pop();
                else {
                    flag = false;
                    break;
                }

            } else if (skob.charAt(i) == ']') {
                if (stack.peek().equals('[')) stack.pop();
                else {
                    flag = false;
                    break;
                }

            }


        }

        if (flag) return "SUCCESS";
        else return "FAIL";

    }

    public void task2() {
        System.out.println("Введите N");
        int n = scanner.nextInt();
        //  int[] source = new int[n*n];
        int[][] array = new int[n][n];
        ArrayList<Integer> source = new ArrayList<>();
        System.out.println("Введите числа: ");
        for (int i = 0; i < n * n; i++) {
            source.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = -1;
            }
        }
        quickSort(source, 0, source.size() - 1);
        int j = 0;
        int k = 0;
        do {
            for (int i = j; i < n - 1; i++) {
                array[j][i] = source.get(0);
                source.remove(0);
                k++;
            }
            if (source.size() == 0) break;
            for (int i = j; i < n - 1; i++) {
                array[i][n - 1] = source.get(0);
                source.remove(0);
                k++;
            }
            if (source.size() == 0) break;
            for (int i = 0; i < n - 1 - j; i++) {
                array[n - 1][n - 1 - i] = source.get(0);
                source.remove(0);
                k++;
            }
            if (source.size() == 0) break;
            for (int i = 0; i < n - 1 - j; i++) {
                if (source.size() > 0) {
                    array[n - i - 1][j] = source.get(0);
                    source.remove(0);
                    k++;
                }
            }
            j++;
            n--;
        } while (source.size() > 1);
        for (int i = 0; i < n; i++) {
            for (int e = 0; e < n; e++) {
                if (array[i][e] == -1) {
                    array[i][e] = source.get(0);
                    source.remove(0);
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int t = 0; t < array.length; t++) {
                System.out.print(array[i][t] + " ");
            }
            System.out.println("");
        }

    }

    public void task3() {             // За основу взят волновой алгоритм
        System.out.println("Введите N");
        int n = scanner.nextInt();
        String[][] arrayout = new String[n][n];

        int[][] array = new int[n][n];
        int[][] arrayh = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (0 + Math.random() * 99);
                arrayout[i][j] = Integer.toString(array[i][j]);
                arrayh[i][j] = -1;
            }
        }
        arrayh[0][0] = 0;
        arrayout[0][0] = "A";
        arrayout[n - 1][n - 1] = "B";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n && j + 1 < n) {
                    if (arrayh[i][j + 1] == -1)
                        arrayh[i][j + 1] = arrayh[i][j] + array[i][j + 1];
                    else if (arrayh[i][j + 1] > arrayh[i][j] + array[i][j + 1])
                        arrayh[i][j + 1] = arrayh[i][j] + array[i][j + 1];
                    if (arrayh[i + 1][j] == -1)
                        arrayh[i + 1][j] = arrayh[i][j] + array[i + 1][j];
                    else if (arrayh[i + 1][j] > arrayh[i][j] + array[i + 1][j])
                        arrayh[i + 1][j] = arrayh[i][j] + array[i + 1][j];
                } else if (i + 1 == n && j != n - 1) {
                    if (arrayh[i][j + 1] == -1)
                        arrayh[i][j + 1] = arrayh[i][j] + array[i][j + 1];
                    else if (arrayh[i][j + 1] > arrayh[i][j] + array[i][j + 1])
                        arrayh[i][j + 1] = arrayh[i][j] + array[i][j + 1];
                } else if (j + 1 == n && i != n - 1) {
                    if (arrayh[i + 1][j] == -1)
                        arrayh[i + 1][j] = arrayh[i][j] + array[i + 1][j];
                    else if (arrayh[i + 1][j] > arrayh[i][j] + array[i + 1][j])
                        arrayh[i + 1][j] = arrayh[i][j] + array[i + 1][j];
                }

            }
        }
        int j = n - 1;
        int i = n - 1;
        do {         // восстановление пути

            if (j != 0 && i != 0) {
                if (arrayh[i][j - 1] > arrayh[i - 1][j]) {
                    i--;
                    arrayout[i][j] = "*";
                } else {
                    j--;
                    arrayout[i][j] = "*";
                }
            } else if (i == 0) {
                if (arrayout[i][j - 1].equals("A")) break;
                j--;
                arrayout[i][j] = "*";
            } else if (j == 0) {
                if (arrayout[i - 1][j].equals("A")) break;
                i--;
                arrayout[i][j] = "*";
            }

        } while (true);
        System.out.println("начальная точка А, конечная B, трассировка пути символом «*»");
        for (int k = 0; k < n; k++) {
            for (int e = 0; e < n; e++) {
                System.out.print(arrayout[k][e] + " ");
            }
            System.out.println("");
        }


    }

    public static void quickSort(ArrayList<Integer> array, int low, int high) {
        if (array.size() == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array.get(i) < opora) {
                i++;
            }

            while (array.get(j) > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
