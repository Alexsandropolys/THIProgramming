/**
 * Created by Alex on 17.04.2017.
 */
public class Tram extends Transport {
    public Tram(int number, Route route, int price){
        super(number, route, price);
        this.type = "Трамвай";
    }
}
