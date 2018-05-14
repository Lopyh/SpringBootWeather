package weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Guid {
    private String isPermaLink;

    public String getIsPermaLink ()
    {
        return isPermaLink;
    }

    public void setIsPermaLink (String isPermaLink)
    {
        this.isPermaLink = isPermaLink;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [isPermaLink = "+isPermaLink+"]";
    }
}
