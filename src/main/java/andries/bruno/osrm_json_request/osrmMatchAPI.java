package andries.bruno.osrm_json_request;

/**
 * Created by andriesbruno on 02/01/2017.
 */
public class osrmMatchAPI {
    private Tracepoints[] tracepoints;

    private String code;

    private Matchings[] matchings;

    public Tracepoints[] getTracepoints ()
    {
        return tracepoints;
    }

    public void setTracepoints (Tracepoints[] tracepoints)
    {
        this.tracepoints = tracepoints;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public Matchings[] getMatchings ()
    {
        return matchings;
    }

    public void setMatchings (Matchings[] matchings)
    {
        this.matchings = matchings;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [tracepoints = "+tracepoints+", code = "+code+", matchings = "+matchings+"]";
    }
}
