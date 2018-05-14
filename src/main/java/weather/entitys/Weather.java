package weather.entitys;


import javax.persistence.*;

@Entity
@Table(name = "Weather")
public class Weather {
    public Weather() {
    }

    public Weather(String cityName, String temperature, String windSpeed, String atmospherePressure, String astronomySunrise, String astronomySunset) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.atmospherePressure = atmospherePressure;
        this.astronomySunrise = astronomySunrise;
        this.astronomySunset = astronomySunset;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "wind_speed")
    private String windSpeed;


    @Column(name = "atmosphere_pressure")
    private String atmospherePressure;


    @Column(name = "astronomy_sunrise")
    private String astronomySunrise;

    @Column(name = "astronomy_sunset")
    private String astronomySunset;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getAtmospherePressure() {
        return atmospherePressure;
    }

    public void setAtmospherePressure(String atmospherePressure) {
        this.atmospherePressure = atmospherePressure;
    }

    public String getAstronomySunrise() {
        return astronomySunrise;
    }

    public void setAstronomySunrise(String astronomySunrise) {
        this.astronomySunrise = astronomySunrise;
    }

    public String getAstronomySunset() {
        return astronomySunset;
    }

    public void setAstronomySunset(String astronomySunset) {
        this.astronomySunset = astronomySunset;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", atmospherePressure='" + atmospherePressure + '\'' +
                ", astronomySunrise='" + astronomySunrise + '\'' +
                ", astronomySunset='" + astronomySunset + '\'' +
                '}';
    }
}
