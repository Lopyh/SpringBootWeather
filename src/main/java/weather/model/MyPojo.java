package weather.model;


public class MyPojo {
    private QueryMy query;
    public QueryMy getQuery ()
    {
        return query;
    }

    public void setQuery(QueryMy query) {
        this.query = query;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [query = "+query+"]";
    }
}
