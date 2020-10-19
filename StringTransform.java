package tests;

import java.util.ArrayList;
import java.util.List;

public class StringTransform {
    public static void main(String[] args) {
        String testString = "Lorem at";
        System.out.println("Transformed: "+ transformString(testString, 3));
    }

    private static String transformString(String testString, int size){
        List<String> groupedStrings = splitEqually(testString, size);
        String transformedString = "";
        for (int i = 0; i < groupedStrings.size(); i++) {
            transformedString = transformedString + getReversedString(groupedStrings.get(i));
        }
        return transformedString;
    }

    private static List<String> splitEqually(String testString, int size) {
        List<String> grouped = new ArrayList<>();
        for (int begin = 0; begin < testString.length(); begin += size) {
            grouped.add(testString.substring(begin, Math.min(testString.length(), begin + size)));
        }
        return grouped;
    }

    private static String getReversedString(String theString){
        String reverse = "";
        for (int j = theString.length()-1; j >=0 ; j--) {
            reverse = reverse +theString.charAt(j);
        }
        return reverse;
    }

}
