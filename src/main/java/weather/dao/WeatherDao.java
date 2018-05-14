package weather.dao;

import weather.entitys.Weather;

public interface WeatherDao {
    public Weather getById(Integer id);
    public Weather getByName(String name);
}
