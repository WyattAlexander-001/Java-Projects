package HashMap;

import java.util.Map;

public class MapUtils {

    public static String getKeyForValue(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;  // Return null if the value isn't found in the map
    }
}
