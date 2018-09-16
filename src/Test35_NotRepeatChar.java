import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by cici on 2018/9/15.
 */
public class Test35_NotRepeatChar {

    /*
    * 题目：在字符串中找出第一个只出现一次的字符
    * 用容器来存放每个字符的出现次数，在这个数据容器中可以根据字符来查找它出现的次数，hash表，key是字符，value是
    * 出现次数。需要从头扫描字符串2次
    * */
    public static char firstNotRepeatingChar(String s) {
        if (s == null || s.length() < 1) {
            throw new IllegalArgumentException("arg should not be null or empty.");
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -2);
            } else {
                map.put(c, i);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        int index = Integer.MAX_VALUE;
        char result = '\0';

        //找最小索引对应的字符
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() >= 0 && entry.getValue() < index) {
                index = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("google"));
        System.out.println(firstNotRepeatingChar("cissie"));
        System.out.print("hello world");
    }
}
