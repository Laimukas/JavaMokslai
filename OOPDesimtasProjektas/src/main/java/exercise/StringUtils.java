package exercise;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

//    private StringUtils() { //cia gaunasi tas pats kaip virsuj uzrasytas @NoArgsConstructor...
//
//    }

    public static boolean isBlank(String obj) {
        if (obj == null || "".equals(obj.trim())) {
            return true;
        }
        return false;
    }
}
