package weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import weather.City;
import weather.entitys.Weather;
import weather.model.MyPojo;
import weather.service.WeatherService;


@Controller
@RequestMapping(value = "/", produces = "application/json")
public class WeatherController {
    String url = "https://query.yahooapis.com/v1/public/yql?q=select " +
            "* from weather.forecast where woeid in (select woeid from geo.places(1) " +
            "where text=\"";

    @Autowired
    WeatherService weatherService;

    @Autowired
    JmsTemplate jmsTemplate;



    public void send(Weather msg){
        jmsTemplate.convertAndSend("inbound.topic", msg);
    }

    /**Пробный запрос*/
    @ResponseBody
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ModelAndView getCity(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cityFromServer", new City());
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "/weather/{name}", method = RequestMethod.GET)
    public Weather getJson(@PathVariable("name") String cityName){
        return weatherService.getByName(cityName);
    }


    @RequestMapping(value = "/addToBase", method = RequestMethod.POST)
    public ModelAndView checkUser(@ModelAttribute("cityFromServer") City city) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        RestTemplate restTemplate = new RestTemplate();
        try{
            MyPojo pojo = restTemplate.getForObject(url + city.getName()+"\") and u=\"c\"&format=json&env= store://datatables.org/alltableswithkeys",
                    MyPojo.class);
            System.out.println(city.getName());
            Weather weather =  new Weather();
            weather.setCityName(pojo.getQuery().getResults().getChannel().getLocation().getCity());
            weather.setAtmospherePressure(pojo.getQuery().getResults().getChannel().getAtmosphere().getPressure());
            weather.setAstronomySunrise(pojo.getQuery().getResults().getChannel().getAstronomy().getSunrise());
            weather.setAstronomySunset(pojo.getQuery().getResults().getChannel().getAstronomy().getSunset());
            weather.setWindSpeed(pojo.getQuery().getResults().getChannel().getWind().getSpeed());
            weather.setTemperature(pojo.getQuery().getResults().getChannel().getItem().getCondition().getTemp());
            System.out.println(weather);
            //weatherService.save(weather);
            //jmsTemplate.convertAndSend("inbound.topic", weather.getClass());
            send(weather);
        }
        catch(Exception e){
            return modelAndView;
        }

        return modelAndView;
    }
}
