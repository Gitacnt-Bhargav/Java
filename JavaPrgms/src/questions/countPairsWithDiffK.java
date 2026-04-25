package questions;

import java.util.*;

public class countPairsWithDiffK {

    public static void main(String[] args) {
        int[] vals = new int[]{3,2,1,5,4};
        int k = 2;

        getPairs(vals,k);
    }

    public static void getPairs(int[] vals, int k){
        Set<Integer> set = new HashSet<>();
        for(int a : vals){
            set.add(a);
        }

        for(int a: vals){
            if(set.contains(a-k)){
                System.out.println("pair " + a + " , " + (a-k));
            }
        }

        //here instead of list, set has been used to reduce time complexity. contains in
        //list takes O(n) time but in hashset, takes O(1), and hence time complexity reduces
        /*
        his has O(n^2) time complexity because:
        The outer loop is O(n),
        And arrayList.contains(...) is O(n) as it does a linear search.

        Use a HashSet for constant-time lookup:
        HashSet.contains() is O(1) average time,
        Total time complexity is O(n).
         */
    }
}
