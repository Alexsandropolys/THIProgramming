/**
 * Created by Alex on 17.04.2017.
 */
public class Bus extends Transport {

    public Bus(int number, Route route, int price){
        super(number, route, price);
        this.type = "Автобус";
    }
}
