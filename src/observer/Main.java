package observer;

public class Main {
    public static void main(String[] args) {
        WeatherData data = new WeatherData();

        UserOne userOne = new UserOne(data);

        data.setTemperature("45度");
        data.updateData();

        System.out.println();
    }
}
