import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Disemvoweller {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/disemvoweller.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/wordpuzzle", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String phraseInput = request.queryParams("phraseInput");
      String vowellessPhrase = Disemvoweller.removeVowels(phraseInput);

      model.put("vowellessPhrase", vowellessPhrase);
      model.put("template", "templates/wordpuzzle.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/wordpuzzleguess", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/wordpuzzleguess.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

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
