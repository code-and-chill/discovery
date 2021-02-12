package id.raidnav.products.eureka;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

public class JsonLoader {

  public static String load(Class clazz, String fileName) {
    URL url = Resources.getResource(clazz, fileName);
    try {
      return Resources.toString(url, Charsets.UTF_8);
    } catch (IOException e) {
      throw new RuntimeException("Couldn't load a JSON file.", e);
    }
  }
}
