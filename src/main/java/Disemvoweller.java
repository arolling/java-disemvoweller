import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Disemvoweller {
  public static void main(String[] args) {}

  public static String removeVowels(String phrase) {
    char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
    char[] phraseArray = phrase.toCharArray();
    for (Integer i = 0 ; i < phraseArray.length ; i++) {
      for (char vowel : vowels) {
        if (phraseArray[i] == vowel) {
          phraseArray[i] = '-';
        }
      }
    }
    String newPhrase = new String(phraseArray);
    return newPhrase;
  }
}
