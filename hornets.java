
import java.util.*;
class hornets{
    public static void main(String args[]) {
        //declare variables
        int bees = 0;
        double inputLat;
        double inputLon;
        double distance = 5000;
        int color=0;
        int size=0;
        int bugHead=0;
        int thorax=0;
        int timeOfYear=0;
        double probability;
        double shortest = 500000;
        //put all positive identifications in an array to compare an inputted location
        double[][] positiveIds = {
            {48.980994, -122.688503}, 
            {48.971949, -122.700941}, 
            {49.149394,-123.943134},
            {48.955587,-122.661037},
            {49.025831, -122.810653},
            {49.060215,-122.641648},
            {48.777534, -122.418612},
            {48.993892,-122.702242},
            {48.927519, -122.745016},
            {48.984269,-122.574809},
            {48.979497,-122.581335},
            {48.983375,-122.582465},
            {48.984172,-122.57472},
            {48.301658,-122.343757},
            {47.426186,-119.281728} 
        };
        //Get the location of the sighting
        System.out.println("What is the latitude of the sighting?");
        Scanner input = new Scanner(System.in);
        inputLat = input.nextDouble();//take input
        System.out.println("What is the longititude of the sighting?");
        inputLon = input.nextDouble();//take input

        //compare locations to find closest positive sighting
        for (int row = 0; row < positiveIds.length; row++) {
            distance = distance(positiveIds[row][0], positiveIds[row][1],inputLat, inputLon);
            if (distance <= shortest){
                shortest = distance;
            }
        }
       //if the shortest is in the range of positive sightings
       if (shortest <= 192)
       {
           //Find out if other factors are present to predict probability
            System.out.println("Does the insect have a banded yellow, black, and brown abdomen? Enter 1 for yes and 0 for no");
            color = input.nextInt();//take input
            System.out.println("Does the insect have a yellow head? Enter 1 for yes and 0 for no");
            bugHead = input.nextInt();//take input
            System.out.println("Does the insect have a black thorax? Enter 1 for yes and 0 for no");
            thorax = input.nextInt();//take input
            System.out.println("Is the insect at least an inch in size? Enter 1 for yes and 0 for no");
            size = input.nextInt();//take input
            System.out.println("Has there been a significant reduction of honeybee populations in the area? Enter 1 for yes and 0 for no");
            bees = input.nextInt();//take input
            System.out.println("Did the sighting occur is Fall, Spring, or Summer? Enter 1 for yes and 0 for no");
            timeOfYear = input.nextInt();//take input
   
        //calculate the probability
            probability = (.10*size)+(.20*color)+(.30*bees)+(.10*timeOfYear)+(.20*thorax)+(.10*bugHead);
            probability = Math.round(probability * 100.0);
            //output
            System.out.println("The probabilty that the sighting is worth investigating: "+ probability+"%");
            if(probability>=70.0){
                System.out.println("We encourage investigating this sighting");
            }
            input.close();
        }
        else{
            //sighting is outside of the range
            System.out.println("The sighting is not in the range of positive sightings. Furthest positive sighting is "+shortest+" miles away. Not likely to be worth investigating");
            input.close();
        }
    }
    //funciton to find distacne between locations
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double distance = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			distance = Math.acos(distance);
			distance = Math.toDegrees(distance);
			distance = distance * 60 * 1.1515;
			return (distance);
		}
	}
}
         