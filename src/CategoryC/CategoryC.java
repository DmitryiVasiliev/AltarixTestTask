package CategoryC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.

public class CategoryC {
    private BufferedReader reader;
    private String number = "0123456789";
    private String mathsymb = "*/+-()^";
    private ArrayList<String> example;
    private ArrayList<Double> result;
    private String opz = "";
    private double arg;
    private Stack<Double> stnumb;

    public CategoryC() {
        stnumb = new Stack<>();
        example = new ArrayList<>();
        result = new ArrayList<>();
    }

    public void setEx(String example) {
        this.example.add(example);
    }

    public void setRes(double res) {
        this.result.add(res);
    }

    public String getEx() {
        return example.get(example.size() - 1);
    }

    public Double getRes() {
        return result.get(result.size() - 1);
    }

    public int Prioritet(String i) {
        if (i.equals("*")) return 3;
        if (i.equals("/")) return 3;
        if (i.equals("^")) return 3;
        if (i.equals("+")) return 2;
        if (i.equals("-")) return 2;
        if (i.equals("(")) return 1;
        if (i.equals(")")) return 1;

        return 0;
    }


    public String Opz(String[] array) {
        String opz1 = "";

        Stack<String> stmath = new Stack<>();
        char c;
        for (int i = 0; i < array.length; i++) {
            if (number.indexOf(array[i]) != -1 || array[i].equals(".")) {
                int j = i;
                while (number.indexOf(array[j]) != -1 || array[j].equals(".")) {


                    opz1 += array[j];
                    j++;
                    if (j == array.length)
                        break;
                }
                j--;
                opz1 += " ";
                i = j;
            } else if (mathsymb.indexOf(array[i]) != -1) {
                if (array[i].equals("(")) {
                    stmath.push(array[i]);
                } else if (array[i].equals(")")) {
                    while (!stmath.peek().equals("(")) {
                        opz1 += stmath.pop();
                        opz1 += " ";

                    }
                    stmath.pop();
                } else {
                    if (i == 0 && array[i].equals("-"))
                        opz1 += array[i];
                    else if (array[i - 1].equals("(") && array[i].equals("-"))
                        opz1 += array[i];
                    else if (!stmath.empty()) {
                        if (Prioritet(stmath.peek()) >= Prioritet(array[i]) && !stmath.empty())
                            while (!stmath.empty()) {
                                if (Prioritet(stmath.peek()) >= Prioritet(array[i])) {
                                    opz1 += stmath.pop();
                                    opz1 += " ";
                                } else
                                    break;
                            }
                        if (stmath.empty() || Prioritet(stmath.peek()) < Prioritet(array[i])) {
                            stmath.push(array[i]);
                        }
                    } else
                        stmath.push(array[i]);
                }
            }
        }
        while (!stmath.empty()) {
            opz1 += stmath.pop();
            if (stmath.size() >= 1)
                opz1 += " ";
            // stmath.pop();
        }


        return opz1;
    }

    public double Results(String opz) {
        double result = 0;
        String[] vecnm = opz.split(" ");

        for (int i = 0; i < vecnm.length; i++) {
            if (vecnm[i].length() == 1 && mathsymb.indexOf(vecnm[i]) != -1) {
                double b = stnumb.pop();
                //   stnumb.pop();
                double a = stnumb.pop();
                //  stnumb.pop();

                if (vecnm[i].equals("+")) result = a + b;
                if (vecnm[i].equals("-")) result = a - b;
                if (vecnm[i].equals("*")) result = a * b;
                if (vecnm[i].equals("/")) result = a / b;
                if (vecnm[i].equals("^")) result = Math.pow(a, b);

                stnumb.push(result);
            } else {
                stnumb.push(Double.parseDouble(vecnm[i]));
            }
        }

        return result;
    }

    public double Trigon(String ex, int i) {
        double res = 0;
        switch (i) {
            case 1:
                res = Math.cos(Double.parseDouble(ex));
                break;
            case 2:
                res = Math.sin(Double.parseDouble(ex));
                break;
            case 3:
                res = Math.sin(Double.parseDouble(ex)) / Math.cos(Double.parseDouble(ex));
                break;
            case 4:
                res = Math.cos(Double.parseDouble(ex)) / Math.sin(Double.parseDouble(ex));
                break;
            default:
                break;

        }
        return res;
    }

    public String SysS(String ex) {
        String res = "";
        String[] array = ex.split(" ");
        if (array[0].equals("10")) {
            if (array[2].equals("2")) res = Integer.toBinaryString(Integer.parseInt(array[1]));
            if (array[2].equals("8")) res = Integer.toOctalString(Integer.parseInt(array[1]));
            if (array[2].equals("16")) res = Integer.toHexString(Integer.parseInt(array[1]));
        } else {
            if (array[0].equals("2")) res = String.valueOf(Integer.parseInt(array[1], 2));
            if (array[0].equals("8")) res = String.valueOf(Integer.parseInt(array[1], 8));
            if (array[0].equals("16")) res = String.valueOf(Integer.parseInt(array[1], 16));

        }
        return res;
    }
    public void JaxbEx(){
    }


}
