package weather.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.dao.WeatherDao;
import weather.entitys.Weather;
import weather.service.WeatherService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class WeatherServiceImpl implements WeatherService {
    WeatherDao weatherDao;

    @Autowired
    public WeatherServiceImpl(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    @Override
    @Transactional
    public Weather getByName(String name) {
        return weatherDao.getByName(name);
    }

}
