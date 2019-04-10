package codingtest.anypointmedia;

import java.util.List;

public class CodingTest2 {

    public static void main(String[] args) {

        DistanceCalc distanceCalc = new DistanceCalc();

        //init point and set base point111
        List<DistanceCalc.Point> pointList = distanceCalc.setDistance("(1,1) (2,2) (4,4) (5,5) 2");

        //sorting and print result
        distanceCalc.printResult(distanceCalc.sortByBaseDistance(pointList));

    }
}
