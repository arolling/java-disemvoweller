import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DisemvowellerTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();
  // Unit testing

  @Test
  public void removeVowels_VowellessWordWillBeReturnedAsIs_returnsRhythm() {
    assertEquals("Rhythm", Disemvoweller.removeVowels("Rhythm"));
  }

  @Test
  public void removeVowels_removesVowelsFromASingleWord_returnsSBSTS() {
    assertEquals("-sb-st-s", Disemvoweller.removeVowels("Asbestos"));
  }

  @Test
  public void removeVowels_removesVowelsFromAPhrase_returnsMryHdLttlLmb() {
    assertEquals("M-ry h-d - l-ttl- l-mb.", Disemvoweller.removeVowels("Mary had a little lamb."));
  }

  //Integration testing
  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("Leap year detector");
  // }
}
