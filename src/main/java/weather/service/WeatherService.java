package weather.service;

import weather.entitys.Weather;

public interface WeatherService {
    Weather getByName(String name);
    void save(Weather weather);
}
