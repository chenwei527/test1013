package gene;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestRepeatString {

    public void selectString(String inputString){
        int len = inputString.length();
        for(int i=0; i<len ; i++){
            System.out.println("子链长度为"+(len-i));
            List stringMinusN = new ArrayList<>();
            for (int j=0; j<=i; j++){
//                System.out.println(j);
                String stringNow = inputString.substring(j,len-i+j);
                stringMinusN.add(stringNow);
            }
            System.out.println(stringMinusN);
            Set stringMinusNSet = new HashSet(stringMinusN);
            if (stringMinusN.size() == stringMinusNSet.size()){
                System.out.println("没有重复元素\n");
            } else{
                System.out.println("有重复元素\n");
            }

        }

    }



    public static void main(String[] args) {
        LongestRepeatString myString = new LongestRepeatString();
        myString.selectString("ABCDABCDABCD");

    }
}
