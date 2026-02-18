import java.util.*;

public class Codec 
{

    private Map<String, String> map = new HashMap<>();
    private int id = 0;
    private final String base = "http://tinyurl.com/";

    public String encode(String longUrl) 
    {
        String shortUrl = base + id;
        map.put(shortUrl, longUrl);
        id++;
        return shortUrl;
    }

    public String decode(String shortUrl) 
    {
        return map.get(shortUrl);
    }
}