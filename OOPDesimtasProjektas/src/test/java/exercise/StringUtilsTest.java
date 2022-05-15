package exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @ParameterizedTest
//    @NullSource
//    @EmptySource
//    @NullAndEmptySource
    @ValueSource(strings = {"  ", "","           "})
    void testIsBlank(String obj) {
        assertTrue(StringUtils.isBlank(obj));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testIsBlankWithMultipleParam(String input, boolean output){
        assertEquals(output,StringUtils.isBlank(input));
    }

    private static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(null,true),
                Arguments.of("  ",true),
                Arguments.of("Labas",false)
        );
    }

}
