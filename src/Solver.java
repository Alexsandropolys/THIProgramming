import java.util.ArrayList;

/**
 * Created by Alex on 17.04.2017.
 */
public class Solver {
    public ArrayList<Transport> getTransports() {
        return transports;
    }

    public MyForm getForm() {
        return form;
    }

    public void setForm(MyForm form) {
        this.form = form;
    }

    private MyForm form;
    private ArrayList<Transport> transports = new ArrayList<Transport>();
    public void addTransport(Transport transport){
        transports.add(transport);
    }
    public Solver(){}

    public String findTheWay(String A, String B){
        String answ = "";
       lab1: for(int i = 0; i<transports.size(); i++){
            Transport transport = transports.get(i);
            String trPoints = transport.getRoute().getPoints();
            if(trPoints.contains(A) && trPoints.contains(B)){
                answ = transport.getType() + transport.getNumber();
                break lab1;
            }else{
                if(trPoints.contains(B)){
                    for(int j = 0; j<transports.size();j++){
                        Transport secTran = transports.get(j);
                        String secTranPoints = secTran.getRoute().getPoints();
                        for(int g = 0; g<trPoints.length(); g++){
                            String point = "" + trPoints.charAt(g);
                            if(secTranPoints.contains(point) && secTranPoints.contains(A)){
                                answ = transport.getType() + " " + transport.getNumber() + " И " + secTran.getType() + " " + secTran.getNumber() + " Пересадка в точке  " + point + " сумма проезда = " + (transport.getPrice()+secTran.getPrice());
                                break lab1;
                            }
                        }
                    }
                }
            }
        }

        return answ;
    }
}
