package weather.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import weather.dao.WeatherDao;
import weather.entitys.Weather;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class WeatherDaoImpl implements WeatherDao {

    @PersistenceContext
    private EntityManager em;


    public Weather getById(Integer id) {
        return em.find(Weather.class, id);
    }

    @Override
    public Weather getByName(String name
    ) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Weather> criteria = builder.createQuery(Weather.class);
        Root<Weather> root = criteria.from(Weather.class);

        CriteriaQuery<Weather> where = criteria.where(
                builder.like(root.<String>get("cityName"), "%" + name + "%")
        );
        return em.createQuery(criteria).getSingleResult();

    }

    @Override
    public void save(Weather weather) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Weather> criteria = builder.createQuery(Weather.class);
        Root<Weather> root = criteria.from(Weather.class);

        CriteriaQuery<Weather> where = criteria.where(
                builder.like(root.<String>get("cityName"), "%" + weather.getCityName() + "%")
        );
        List<Weather> list = em.createQuery(criteria).getResultList();
        if (list.isEmpty())
        {
            em.persist(weather);
        }
        else{
            list.forEach(o -> em.remove(o));
            em.persist(weather);
        }
    }


}
