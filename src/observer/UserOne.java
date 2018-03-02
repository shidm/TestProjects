package observer;

import java.util.Observable;
import java.util.Observer;

public class UserOne implements Observer {

    public UserOne(Observable obs) {
        obs.addObserver(this::update);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("更新了数据");
        if (o instanceof WeatherData) {
            System.out.println(((WeatherData) o).getTemperature());
        }
    }
}
