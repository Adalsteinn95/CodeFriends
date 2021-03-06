package quiz.start.model;

import org.springframework.web.client.RestTemplate;
import quiz.start.services.GeoService;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Geography question class
 */
public class GeoQuestions extends Question {

    private String currentLoc;
    private String currentCountry;

    /* dest 1 and dest 2*/
    private String dest1;
    private String dest2;

    /* dest 1 and dest 2*/
    private String destCountry;
    private String destCountry2;


    /* distance between currentLoc && dest1 ||
     * currentloc && dest2
     */
    private double distance1;
    private double distance2;

    private Random r;

    /**
     * API
     */
    GeoService api;

    /*Cities and countries */
    private String[] allobjects;

    private String[] allcountries;
    private String[] allcities;

    /*random values*/
    int randomNum;
    int randomNum2;

    /*score*/
    public boolean correct = false;
    public int score = 0;

    /*Answer country*/
    public String answerCity;

    /**
     * Constructor for geoquestion
     * @param location
     */
    public GeoQuestions(String location){
        super();

        /*API call to get all available cities*/
        RestTemplate restTemplate = new RestTemplate();

        Hashtable cities = restTemplate.getForObject("https://notendur.hi.is/~aip7/API/countries.json", Hashtable.class);


        allobjects = new String[658];


        allcountries = new String[allobjects.length];
        allcities = new String[allobjects.length];

        Enumeration names;
        String key;
        names = cities.keys();
        while(names.hasMoreElements()) {
            key = (String) names.nextElement();

            if(key.equals("cities")){
                allobjects = cities.get(key).toString().split("},");
            }
        }


        for(int i = 0;i < allobjects.length;i++){
            allcities[i] = allobjects[i].split(",")[0].split("=")[1];
            allcountries[i] = allobjects[i].split(",")[1].split("=")[1];

        }

        allcountries[657] = allcountries[657].substring(0,allcountries[657].length()-2);

        currentLoc = location;
        currentCountry = "United Kingdom";

        /*Random generator*/
        randomNum = ThreadLocalRandom.current().nextInt(0, allcities.length + 1);
        randomNum2 = ThreadLocalRandom.current().nextInt(0, allcities.length + 1);

        /*this will get a random value from cities*/
        dest1 = allcities[randomNum];
        dest2 = allcities[randomNum2];

        destCountry = allcountries[randomNum];
        destCountry2 = allcountries[randomNum2];


        api = new GeoService();

        distance1 = api.getDist(currentLoc,dest1);
        distance2 = api.getDist(currentLoc,dest2);

        if(distance1 >= distance2){
          answerCity = dest2;
        } else {
          answerCity = dest1;
        };

    }


    /**
     * Function to calculate distances between cities
     * @param answer
     */
    public void compareDist(String answer){

        if (answer.equals(dest1)) {
            if (distance2 >= distance1) {
                score++;
                currentLoc = dest1;
                currentCountry = allcountries[randomNum];
            }
            else {
              score = 0;
            }
        }

        if (answer.equals(dest2)) {
            if (distance1 >= distance2) {
                score++;
                currentLoc = dest2;
                currentCountry = allcountries[randomNum2];
            }
            else {
              score = 0;
            }
        }


        /*Random generator*/
        randomNum = ThreadLocalRandom.current().nextInt(0, allcities.length + 1);
        randomNum2 = ThreadLocalRandom.current().nextInt(0, allcities.length + 1);


        /*this will get a random value from cities*/
        dest1 = allcities[randomNum];
        dest2 = allcities[randomNum2];

        destCountry = allcountries[randomNum];
        destCountry2 = allcountries[randomNum2];

        distance1 = api.getDist(currentLoc,dest1);
        distance2 = api.getDist(currentLoc,dest2);
        if(distance1 >= distance2){
          answerCity = dest2;
        } else {
          answerCity = dest1;
        };
    }

    public String getDest1() {
        return dest1;
    }

    public String getDest2() {
        return dest2;
    }

    public String getCountry() {
        return destCountry;
    }

    public String getCountry2() {
        return destCountry2;
    }

    public String getCurrentLoc(){
        return currentLoc;
    }

    public String getCurrentCountry(){
        return currentCountry;
    }
    public String wasPreviousQuestionCorrect() {
        return Integer.toString(score);
    }
    public String getCorrectAnswer() {
      return answerCity;
    }

}
