package weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private Guid guid;

    private String pubDate;

    private String title;

    private List<Forecast> forecast;

    private Condition condition;

    private String description;

    private String link;

    private String lat;

    public Guid getGuid ()
    {
        return guid;
    }

    public void setGuid (Guid guid)
    {
        this.guid = guid;
    }

    public String getPubDate ()
    {
        return pubDate;
    }

    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public List<Forecast> getForecast ()
    {
        return forecast;
    }

    public void setForecast (List<Forecast> forecast)
    {
        this.forecast = forecast;
    }

    public Condition getCondition ()
    {
        return condition;
    }

    public void setCondition (Condition condition)
    {
        this.condition = condition;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [guid = "+guid+", pubDate = "+pubDate+", title = "+title+", forecast = "+forecast+", condition = "+condition+", description = "+description+", link = "+link+", lat = "+lat+"]";
    }
}
