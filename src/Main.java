import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alex on 17.04.2017.
 */
public class Main {
    public static void main(String[] args){
        Solver solver = new Solver();
        Route[] routes = new Route[5];
        Random r = new Random();
        for(int i = 0; i<routes.length; i++){
            String s = "";
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int j = 0; j < 7; j++) {
                s = s +  alphabet.charAt(r.nextInt(alphabet.length()));
            }
            routes[i] =  new Route(s);
            System.out.print("\n" + routes[i].getPoints());
        }

        Bus[] buses = new Bus[5];
        int busPrice = 15;
        for(int i = 0; i<buses.length; i++){
            buses[i] = new Bus(i, routes[i], busPrice);
            solver.addTransport(buses[i]);
        }

        Scanner scanner = new Scanner(System.in);
//        System.out.print("\n");
//        System.out.print(solver.findTheWay(scanner.nextLine(), scanner.nextLine()));
        MyForm  myForm =  new MyForm(solver);
        myForm.setVisible(true);
        solver.setForm(myForm);
    }

}
