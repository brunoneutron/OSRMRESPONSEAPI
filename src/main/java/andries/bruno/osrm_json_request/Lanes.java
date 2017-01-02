package andries.bruno.osrm_json_request;

/**
 * Created by andriesbruno on 02/01/2017.
 */
public class Lanes {
    private String[] indications;

    private String valid;

    public String[] getIndications ()
    {
        return indications;
    }

    public void setIndications (String[] indications)
    {
        this.indications = indications;
    }

    public String getValid ()
    {
        return valid;
    }

    public void setValid (String valid)
    {
        this.valid = valid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [indications = "+indications+", valid = "+valid+"]";
    }
}
