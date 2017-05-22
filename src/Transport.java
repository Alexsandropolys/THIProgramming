import java.util.ArrayList;

/**
 * Created by Alex on 17.04.2017.
 */
abstract public class Transport {
    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String toString(){
        String s;
        s = type+"№"+ number;
        return s;

    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Route getRoute() {
        return route;
    }

    public Transport(int number, Route route, int price){
        this.route = route;
        this.price = price;
        this.number = number;
    }

    protected int price;
    protected int number;
    protected String type;
    protected Route route;

}
