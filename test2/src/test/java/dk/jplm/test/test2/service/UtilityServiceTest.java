package dk.jplm.test.test2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class UtilityServiceTest {

    @Autowired
    private UtilityService utilityService;

    @Test
    void canReverseStringTest() {
        String actual = utilityService.reverseString("aBc");
        String expected = "cBa";
        assertThat(actual).isEqualTo(expected);
        assertEquals(actual, expected);
    }

    @Test
    void canCapitalizeStringTest() {
        String actual = utilityService.capitalizeString("abc");
        String expected = "ABC";
        assertThat(actual).isEqualTo(expected);
        assertEquals(expected, actual);
    }

    @Test
    void canLowercaseStringTest() {
        String actual = utilityService.lowercaseString("ABC");
        String expected = "abc";
        assertThat(actual).isEqualTo(expected);
        assertEquals(expected, actual);
    }

}