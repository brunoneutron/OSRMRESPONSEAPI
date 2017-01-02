package andries.bruno;

import andries.bruno.osrm_json_request.*;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Modifier;

/**
 * Created by andriesbruno on 02/01/2017.
 */
public class Main {

    private static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {

        String query = "http://10.20.24.197:5000/match/v1/driving/129.1196537,35.55562191;129.12377357,35.55810076;129.12673473,35.56190616;129.12791491,35.56569392;129.12862301,35.5690277;129.12961006,35.57243116;129.13188457,35.57728302?timestamps=1412228691;1412228811;1412228922;1412229244;1412229860;1412229866;1412229890&steps=true"
        ;

        String query1 = "http://10.20.24.197:5000/match/v1/driving/129.308403,35.537092;129.308237,35.537485;129.309069,35.537765;129.309267,35.537913;129.308988,35.538577;129.308398,35.538568;129.307866,35.538433;129.307694,35.538852;129.307530,35.539287;129.307396,35.539610;129.307249,35.540000;129.307180,35.540162;129.306834,35.540078;129.306113,35.539862?timestamps=1412229091;1412229191;1412229291;1412229391;1412229491;1412229591;1412229691;1412229791;1412229891;1412229991;1412230091;1412230191;1412230291;1412230391&steps=true";

        String query2 = "https://router.project-osrm.org/route/v1/driving/13.388860,52.517037;13.385983,52.496891?steps=true&alternatives=true";

        printMatchQuery(query1);
        System.out.println();
        printRouteQuery(query2);

    }

    public static void printRouteQuery(String query){
        Routes[] routes = getOSRMRouteResponse(query);
        for(Routes routes1 : routes){
            Legs[] legs = routes1.getLegs();
            for(Legs legs1 : legs){
                Steps[] steps = legs1.getSteps();
                for(Steps steps1 : steps){
                    Maneuver maneuver = steps1.getManeuver();
                    String[] location = maneuver.getLocation();
                    String type = maneuver.getType();
                    String modifier = maneuver.getModifier();
                    if(modifier != null){
                        System.out.print(String.format("%-20s %-20s",type,modifier));
                        for(String str : location){
                            System.out.print(String.format("%-25s",str));
                        }
                        System.out.println();
                    }

                }
            }
        }
    }

    public static void printMatchQuery(String query){
        Matchings[] matchingss = getOSRMMatchResponse(query);
        for(Matchings matchings : matchingss){
            Legs[] legs = matchings.getLegs();
            for(Legs legs1 : legs){
                Steps[] steps = legs1.getSteps();
                for(Steps steps1 : steps){
                    Maneuver maneuver = steps1.getManeuver();
                    String[] location = maneuver.getLocation();
                    String type = maneuver.getType();
                    String modifier = maneuver.getModifier();
                    if(modifier != null){
                        System.out.print(String.format("%-20s %-20s",type,modifier));
                        for(String str : location){
                            System.out.print(String.format("%-25s",str));
                        }
                        System.out.println();
                    }

                }
            }
        }
    }

    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static Matchings[] getOSRMMatchResponse(String query){

        String json = null;

        try {
            json = getJSON(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(json);
        Gson gson = new Gson();
        osrmMatchAPI osrmmatchapi = gson.fromJson(json,osrmMatchAPI.class);
        return osrmmatchapi.getMatchings();
    }

    public static Routes[] getOSRMRouteResponse(String query){
        String json = null;

        try {
            json = getJSON(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(json);
        Gson gson = new Gson();
        osrmRouteAPI osrmrouteapi = gson.fromJson(json,osrmRouteAPI.class);
        return osrmrouteapi.getRoutes();
    }

}
