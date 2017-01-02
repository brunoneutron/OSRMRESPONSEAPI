package andries.bruno.osrm_json_request;

/**
 * Created by andriesbruno on 02/01/2017.
 */
public class Routes {
    private String distance;

    private String duration;

    private Legs[] legs;

    private String geometry;

    public String getDistance ()
    {
        return distance;
    }

    public void setDistance (String distance)
    {
        this.distance = distance;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public Legs[] getLegs ()
    {
        return legs;
    }

    public void setLegs (Legs[] legs)
    {
        this.legs = legs;
    }

    public String getGeometry ()
    {
        return geometry;
    }

    public void setGeometry (String geometry)
    {
        this.geometry = geometry;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [distance = "+distance+", duration = "+duration+", legs = "+legs+", geometry = "+geometry+"]";
    }
}
