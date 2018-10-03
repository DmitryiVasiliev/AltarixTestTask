package CategoryC;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {
    private BufferedReader reader;
    private static Controller instance = null;
    private CategoryC categoryC = null;

    private Controller() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        categoryC = new CategoryC();
    }

    public synchronized static Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    public boolean Calc(int n) throws IOException, JAXBException {
        String res = "";

        boolean check = true;
        switch (n) {
            case 1:
                ReadString(View.setEx());
                res = String.valueOf(categoryC.Results(categoryC.Opz(categoryC.getEx().replace(" ", "").split(""))));
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 2:
                ReadString("cos( "+View.setArg()+" )");
                res = String.valueOf(categoryC.Trigon(categoryC.getEx().split(" ")[1], 1));
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 3:
                ReadString("sin( "+View.setArg()+" )");
                res = String.valueOf(categoryC.Trigon(categoryC.getEx().split(" ")[1], 2));
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 4:
                ReadString("tg( "+View.setArg()+" )");
                res = String.valueOf(categoryC.Trigon(categoryC.getEx().split(" ")[1], 3));
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 5:
                ReadString("ctg( "+View.setArg()+" )");
                res = String.valueOf(categoryC.Trigon(categoryC.getEx().split(" ")[1], 4));
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 6:
                ReadString(View.setExSys());
                res = categoryC.SysS(categoryC.getEx());
                categoryC.setRes(res);
                View.Print(res);
                break;
            case 7:
                  View.Print(categoryC.JaxbReader());
                break;
            case 8:
                categoryC.JaxbEx();
                check = false;
                break;
                default:System.out.println("Введите верную цирфу");
        }
        return  check;

    }


    public void ReadString(String opz) {
        categoryC.setEx(opz);
    }

}
