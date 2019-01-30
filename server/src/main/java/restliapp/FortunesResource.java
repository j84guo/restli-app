package restliapp;

import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import java.util.HashMap;
import java.util.Map;

// Simple Rest.li Resource that serves up a fortune cookie.
@RestLiCollection(name="fortunes", namespace="restliapp")
public class FortunesResource extends CollectionResourceTemplate<Long, Fortune> {
  // In-memory store for the fortunes
  static Map<Long, String> fortunes = new HashMap<>();
  static {
    fortunes.put(1L, "Today is your lucky day.");
    fortunes.put(2L, "There's no time like the present.");
    fortunes.put(3L, "Don't worry, be happy.");
  }

  @Override
  public Fortune get(Long key) {
    // Retrieve the requested fortune
    String fortune = fortunes.get(key);
    if (fortune == null) {
      fortune = "Your luck has run out. No fortune for id = " + key;
    }
    // return an object that represents the fortune cookie
    return new Fortune().setFortune(fortune);
  }
}
