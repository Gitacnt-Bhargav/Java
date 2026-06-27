package questions.BinarySearch_onAnswers;

import java.util.Arrays;

public class magneticForceBetweenBalls {

//Leet code - 1552 - Medium

/*
In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his
new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the
balls into the baskets such that the minimum magnetic force between any two balls is maximum.
Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
Given the integer array position and the integer m. Return the required force.

Example 1:
Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.

Example 2:
Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.

Constraints:
n == position.length
2 <= n <= 105
1 <= position[i] <= 109
All integers in position are distinct.
2 <= m <= position.length
*/

    public static void main(String[] args) {
        magneticForceBetweenBalls magneticForceBetweenBalls = new magneticForceBetweenBalls();
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println(magneticForceBetweenBalls.maxOfMinMagneticForce(position, m));

        //to find the min distance between two balls such that we can be able to place all m balls
    }

    public int maxOfMinMagneticForce(int[] position, int m){
        Arrays.sort(position);
        int low = 1, high = position[position.length-1] - position[0];

        int gap;
        int ans =0;

        while(low <=high){
            gap = low + (high - low)/2;

            if(canPlace(position, gap, m)){
                ans = gap;
                low = gap+1;
            }else{
                high = gap-1;
            }
        }

        return ans;

    }

    public boolean canPlace(int[] position, int gap, int m){
        int last = position[0];
        int count = 1;
        for(int i=1; i<position.length; i++){
            if((position[i] - last)>=gap) {
                count++;
                last = position[i];
            }
            if(count >= m ) return true;
        }
        return false;
    }
}
