package quiz.start.services;

import org.springframework.web.client.RestTemplate;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *  Aðalsteinn Ingi Pálsson
 *  aip7@hi.is
 *
 */


/**
 * Service that manages values from controller
 */
public class GeoService {

    private RestTemplate restTemplate;
    private Hashtable hash;


    /*distance*/
    private int distance;

    /*place a and b */
    private String locationA;
    private String locationB;


    public GeoService(){
        restTemplate = new RestTemplate();

    }


    /***
     * function that takes a name of place a and place b and returns info about them
     * distance between them and more
     *
     * @Return Hashtable
     */
    public void apiCallBetweenTwoPlaces(){

        hash = restTemplate.getForObject("http://www.distance24.org/route.json?stops=" + locationA + "|" + locationB, Hashtable.class);

        Enumeration names;
        String key;
        names = hash.keys();
        while(names.hasMoreElements()) {
            key = (String) names.nextElement();

            if(key.equals("distance")){
                distance = Integer.parseInt(hash.get(key).toString());
            }
        }
    }

    /**
     * @param a
     * @param b
     *
     * Returns distance between two places
     *
     * @returns int
     */
    public int getDist(String a, String b){
        locationA = a;
        locationB = b;

        apiCallBetweenTwoPlaces();

        return distance;
    }
}
