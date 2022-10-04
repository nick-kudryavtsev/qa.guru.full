package lesson7.randomUtils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    static public String getRandomStringByLength(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    static public String getRandomNumber(int length) {
        boolean useLetters = false;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    public static String getRandomEmail(){
        return getRandomStringByLength(10) + "@ya.ru";
    }
}
