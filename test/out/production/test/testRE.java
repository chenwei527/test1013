import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRE {
    public static int countRE(String reRule, String word){
        Pattern p = Pattern.compile(reRule,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(word);
        int count = 0;
        while (m.find()){
            count++;
        }
        return count;
    }

    protected static int countSyllables(String word)
    {
        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 2) and
        // EfficientDocument (module 3).

        if (word.endsWith("e")){
            word = word.substring(0,word.length() - 1);
            System.out.println(word);

            if(word.contains("a")|word.contains("e")|word.contains("i")|word.contains("o")|word.contains("u")){
                System.out.println("33333");
                return countRE("[aeiouy]+",word);
            }
            else {
                System.out.println("1111");
                return 1;

            }
        } else {
            System.out.println("22222");
            return countRE("[aeiouy]+",word);
        }

    }


//    protected static List<String> getTokens(String pattern)
//    {
//        ArrayList<String> tokens = new ArrayList<String>();
//        Pattern tokSplitter = Pattern.compile(pattern);
//        Matcher m = tokSplitter.matcher(text);
//
//        while (m.find()) {
//            tokens.add(m.group());
//        }
////		System.out.println(tokens);
//        return tokens;
//    }

//    public int getNumSyllables()
//    {
//        //TODO: Implement this method in week 2.  See the Module 2 support videos
//        // if you need help.  And note that there is no need to use a regular
//        // expression for the syllable counting.  We recommend you implement
//        // the helper function countSyllables in Document.java using a loop,
//        // and then call it here on each word.
//
////		List<String> tokens = getTokens("[aiouy]+|[e]+[a-d|f-z]+|[^aeiouy ]+[e] ");
//
//
//        List<String> words = getTokens("[(a-zA-Z)]+");
//
////		System.out.println(words+"getNumSyllables");
//
//        int count = 0;
//
//        for (String word : words ){
//            count += countSyllables(word);
////			System.out.println(countSyllables(word));
//
//        }
//        return count;
//
//    }




    public static void main(String[] args) {
        testRE t = new testRE();
//        int count = countRE("[aeiou]+", "sentence, with, lots, of, commas.!  (And some poaren)).  The output is: 7.5.");
//        System.out.println(count);

        int num = countSyllables("will");
        System.out.println(num);

//        int nummm = getNumSyllables()

//        Here is a series of test sentences. Your program should find 3 sentences, 33 words, and 49 syllables. Not every word will have the correct amount of syllables (example, for example), but most of them will.



    }
}


