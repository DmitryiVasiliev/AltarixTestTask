package CategoryC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {
    private BufferedReader reader;
    private static Controller instance = null;
    private CategoryC categoryC = null;

    private Controller() {
        System.out.println("Что умеет делать кальк");
        reader = new BufferedReader(new InputStreamReader(System.in));
        categoryC = new CategoryC();
    }

    public synchronized static Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    public void Calc(int n) throws IOException {
        double res = 0;
        String resSys = "";
        switch (n) {
            case 1:
                ReadString(View.setEx());
                res = categoryC.Results(categoryC.Opz(categoryC.getEx().replace(" ", "").split("")));
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 2:
                ReadString(View.setArg());
                res = categoryC.Trigon(categoryC.getEx(), 1);
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 3:
                ReadString(View.setArg());
                res = categoryC.Trigon(categoryC.getEx(), 2);
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 4:
                ReadString(View.setArg());
                res = categoryC.Trigon(categoryC.getEx(), 3);
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 5:
                ReadString(View.setArg());
                res = categoryC.Trigon(categoryC.getEx(), 4);
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 6:
                ReadString(View.setExSys());
                resSys = categoryC.SysS(categoryC.getEx());
                categoryC.setRes(Integer.parseInt(resSys));
                View.Print(resSys);
                break;
            case 7:

                break;
        }

    }

    public void ReadString(String opz) {
        categoryC.setEx(opz);
    }

}
