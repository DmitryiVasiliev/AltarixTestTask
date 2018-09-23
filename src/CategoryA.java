import java.util.Scanner;

public class CategoryA {
    private int select;
    private Scanner scanner;
    public CategoryA(){
         scanner = new Scanner(System.in);
        System.out.println("Задание 1");
        System.out.println("Задание 2");
        System.out.println("Задание 3");
        System.out.println("Задание 4");
        System.out.println("Задание 5");
        select = scanner.nextInt();
    }
    public int NumberSel(){
        return select;
    }
    public boolean Task1(){
        System.out.println("Ax");
        double ax = scanner.nextInt();
        System.out.println("Ay");
        double ay = scanner.nextInt();
        System.out.println("Bx");
        double bx = scanner.nextInt();
        System.out.println("By");
        double by = scanner.nextInt();
        System.out.println("Cx");
        double cx = scanner.nextInt();
        System.out.println("Cy");
        double cy = scanner.nextInt();
        System.out.println("Tx");
        double tx = scanner.nextInt();
        System.out.println("Ty");
        double ty = scanner.nextInt();
           double side1 = RelatMethod(ax,ay,bx,by,tx,ty); // Метод относительности
           double side2 = RelatMethod(bx,by,cx,cy,tx,ty);
           double side3 = RelatMethod(cx,cy,ax,ay,tx,ty);
           if(side1 >= 0 && side2 >= 0 && side3>= 0) return true;
           else return false;
    }
    private double RelatMethod(double Ax,double Ay,double Bx,double By,double Tx,double Ty){
       double result = Tx * (By - Ay) + Ty * (Ax - Bx) + Ay * Bx - Ax * By;
      return result;
    }
    public double Task2(){
        System.out.println("Введите матрицу 3х3: ");
        double [][] Array = new double[3][3];
        for (int i =0;i<Array.length;i++){
            for (int j=0;j<Array.length;j++){
                Array[i][j] = scanner.nextInt(); // задаем матрицу
            }
        }
        double diag1 = 0;
        double diag2 = 0;
        for (int i =0;i<Array.length;i++){

                diag1 += Array[i][i];
                diag2 += Array[i][Array.length-i-1];

        }

         return Math.abs(diag2-diag1);
    }
    public void Task3(){
        System.out.println("Введите число N");
        int num = scanner.nextInt();
        String[] Array = new String[num];
        String str ="";
        for(int i =0;i<num;i++){
          str+="#";
        }
        for(int i =0;i<num;i++){
            Array[num-i-1] = str;
            char[] chars = str.toCharArray();
            chars[i] = ' ';
            str = String.valueOf(chars);
        }
        for(int i =0;i<Array.length;i++){
            System.out.println(Array[i]);
        }
    }
    public void Task4(){
        System.out.print("Введите размер массива: ");
        int sizeArray = scanner.nextInt();
        System.out.println("Введите число K: ");
        int k = scanner.nextInt();
        int[] Array = new int[sizeArray];
        System.out.println("Введите массив: ");
        for(int i=0;i<sizeArray;i++){
            Array[i] = scanner.nextInt();
        }
        int count = 0;
        for(int i=0;i<sizeArray;i++){
            for(int j=i+1;j<sizeArray;j++){
               if((Array[i]+Array[j])% k == 0) count++;
            }
        }

         System.out.println(count);
    }
    public void Task5(){
        System.out.print("Введите N: ");
        int n = scanner.nextInt();
        System.out.print("Введите M: ");
        int m = scanner.nextInt();
        int[] arrayWin = new int[2];
        if(n >= 4 && m >= 4) {
            int[][] array = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            arrayWin[0] = 1;
            arrayWin[1] = 1;
        }
        else{ System.out.println("FAIL");}
       if(n >=4 && m>=4) System.out.println(arrayWin[0]+" "+arrayWin[1]);

    }
}
