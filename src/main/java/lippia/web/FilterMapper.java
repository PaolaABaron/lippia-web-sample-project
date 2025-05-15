package lippia.web;

import java.util.HashMap;
import java.util.Map;

public class FilterMapper {

    private static final Map<String, String> FILTER_MAP = new HashMap<>();

    static {
        FILTER_MAP.put("popularity", "popular");
        FILTER_MAP.put("rating", "rating");
        FILTER_MAP.put("date", "new");
        FILTER_MAP.put("price", "low to high");
        FILTER_MAP.put("price-desc", "high to low");
    }

    public static String getValidationKey(String filterValue) {
        String result = FILTER_MAP.get(filterValue);
        if (result == null) {
            throw new IllegalArgumentException("No mapping found for filter value: " + filterValue);
        }
        return result;
    }
}
