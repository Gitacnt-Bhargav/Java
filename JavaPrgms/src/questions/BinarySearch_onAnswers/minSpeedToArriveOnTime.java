package questions.BinarySearch_onAnswers;

public class minSpeedToArriveOnTime {
//    Leet code - 1870 - Medium

/*
You are given a floating-point number hour, representing the amount of time you have to reach the office.
To commute to the office, you must take n trains in sequential order. You are also given an integer array dist of length n,
where dist[i] describes the distance (in kilometers) of the ith train ride.
Each train can only depart at an integer hour, so you may need to wait in between each train ride.
For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd
train ride at the 2 hour mark.
Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach
the office on time, or -1 if it is impossible to be on time.
Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.

Example 1:
Input: dist = [1,3,2], hour = 6
Output: 1
Explanation: At speed 1:
- The first train ride takes 1/1 = 1 hour.
- Since we are already at an integer hour, we depart immediately at the 1 hour mark. The second train takes 3/1 = 3 hours.
- Since we are already at an integer hour, we depart immediately at the 4 hour mark. The third train takes 2/1 = 2 hours.
- You will arrive at exactly the 6 hour mark.

Example 2:
Input: dist = [1,3,2], hour = 2.7
Output: 3
Explanation: At speed 3:
- The first train ride takes 1/3 = 0.33333 hours.
- Since we are not at an integer hour, we wait until the 1 hour mark to depart. The second train ride takes 3/3 = 1 hour.
- Since we are already at an integer hour, we depart immediately at the 2 hour mark. The third train takes 2/3 = 0.66667 hours.
- You will arrive at the 2.66667 hour mark.

Example 3:
Input: dist = [1,3,2], hour = 1.9
Output: -1
Explanation: It is impossible because the earliest the third train can depart is at the 2 hour mark.

Constraints:

n == dist.length
1 <= n <= 10^5
1 <= dist[i] <= 10^5
1 <= hour <= 10^9
There will be at most two digits after the decimal point in hour.
*/

    public static void main(String[] args) {
        minSpeedToArriveOnTime minSpeedToArriveOnTime = new minSpeedToArriveOnTime();
//        int[] dist = {1,3,2};
//        double hour = 1.9;
        int[] dist = {1,1,100000};
        double hour = 2.01;
        System.out.println(minSpeedToArriveOnTime.minSpeed(dist, hour));
    }


    public int minSpeed(int[] dist, double hour){
//        Every train except the last one requires at least 1 hour of total time slot allocation because of the integer departure rule.
//        If you have $N$ trains, the first $N-1$ trains will take at least $N-1$ hours. If the total allowed hour is less than or equal
//        to $N-1$, it's physically impossible to complete the journey, so it returns -1.

        if (hour <= dist.length - 1) {
            return -1;
        }


        int low = 1;
        int high = (int)1e7;


        System.out.println("low " + low + " high " + high);
        int mid;
        int ans = -1;
        while(low <= high){
            mid = low + (high - low)/2;
            System.out.println("mid" +  mid);
            if(canArrive(dist, hour, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canArrive(int[] dist, double hour, int speed){
        double totHours = 0;

//        for(int dists: dist){
//            totHours = Math.ceil(totHours);
//            System.out.println("totHours " + totHours);
//            totHours += (double) (dists) / speed;
//            System.out.println("totHours " + totHours);
//        }

        int timeTaken = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            // Integer-only ceiling formula: (A + B - 1) / B
            timeTaken += (dist[i] + speed - 1) / speed;
        }
        // Add the last train as a double at the very end
        return hour >= timeTaken + ((double) dist[dist.length - 1] / speed);


    }
}
