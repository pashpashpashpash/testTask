package org.example.steps;

import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.regex.Pattern;

public class AssertionSteps {

    private final static String EMAIL_REGEX = ".*\\@reqres.in$";

    public static void assertUsersEmailsIsValid(List<String> emails) {

        SoftAssert softAssert = new SoftAssert();

        for(String email : emails) {
            final Pattern pattern = Pattern.compile(EMAIL_REGEX);
            softAssert.assertTrue(pattern.matcher(email).matches());
        }
    }
}
