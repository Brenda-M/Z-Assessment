package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MissingInteger{
    
    private static int[] getArray(){
        int[] testArray = new int[7];
        testArray[0] = 7;
        testArray[1] = 2;
        testArray[2] = 4;
        testArray[3] = 5;
        testArray[4] = 6;
        testArray[5] = 3;
       
        return testArray;
    }

    private static int getMissingInt(int[] testArray){
        List<Integer> testlist = new ArrayList<>();
        for (int i : testArray) {
            testlist.add(i);
        }

        for (int i = 1; i < testArray.length+1; i++) {
            if (!testlist.contains(i)) {
                return i;
            }
        }
        return 1000;
    }
    public static void main(String[] args) {
        int[] testArray = getArray();
        System.out.println("Missing: "+getMissingInt(testArray));
    }
}