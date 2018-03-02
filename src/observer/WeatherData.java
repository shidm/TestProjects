package observer;

import java.util.Observable;

public class WeatherData extends Observable {

    private String temperature;
    private String pressure;

    public WeatherData() {
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    void updateData(){
        setChanged();
        notifyObservers();
    }

}
