package HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Using HashMap
        System.out.println("Using HashMap:");
        HashMap<String, String> capitalCitiesHashMap = new HashMap<String, String>();
        
        // Add keys and values (Country, City) to HashMap
        capitalCitiesHashMap.put("England", "London");
        capitalCitiesHashMap.put("Germany", "Berlin");
        capitalCitiesHashMap.put("Norway", "Oslo");
        capitalCitiesHashMap.put("USA", "Washington DC");
        System.out.println(capitalCitiesHashMap);

        // Using LinkedHashMap
        System.out.println("\nUsing LinkedHashMap:");
        LinkedHashMap<String, String> capitalCitiesLinkedHashMap = new LinkedHashMap<String, String>();
        
        // Add keys and values (Country, City) to LinkedHashMap
        capitalCitiesLinkedHashMap.put("England", "London");
        capitalCitiesLinkedHashMap.put("Germany", "Berlin");
        capitalCitiesLinkedHashMap.put("Norway", "Oslo");
        capitalCitiesLinkedHashMap.put("USA", "Washington DC");
        System.out.println(capitalCitiesLinkedHashMap); //Ordered Hashmap!
        System.out.println(capitalCitiesLinkedHashMap.get("USA")); //gets Washington DC
        System.out.println(getKeyForValue(capitalCitiesLinkedHashMap, "Washington DC")); //gets USA, this is if I'm using the method inside the main...
        System.out.println(MapUtils.getKeyForValue(capitalCitiesLinkedHashMap, "Washington DC")); //gets USA using a different class!
        
        System.out.println("Numeric Alphabet:");
        HashMap<Integer, String> numericAlphabet = new HashMap<Integer, String>();
        numericAlphabet.put(1, "Aa");
        numericAlphabet.put(2, "Bb");
        System.out.println(numericAlphabet.get(1));
        System.out.println(numericAlphabet.get(2));
        
    }
    
    //Utility Method
    public static String getKeyForValue(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;  // Return null if the value isn't found in the map
    }

}
