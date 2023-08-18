package com.hongpn.helpers;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFakerHelpers {
    private static Faker faker;

    public static String LOCATE ;
    public static Faker createFaker() {
        //PropertiesHelpers.setPropertiesFile();
        faker = new Faker(new Locale(LOCATE));
        return faker;
    }

    public static Faker createFakerByLocate(String locateName) {
        faker = new Faker(new Locale(locateName));
        return faker;
    }

    public static Faker getFaker() {
        if (faker == null) {
            faker = createFaker();
        }
        return faker;
    }

    public static Faker getFakerByLocate(String locateName) {
        faker = createFakerByLocate(locateName);
        return faker;
    }

    public static void setFaker(Faker faker) {
        DataFakerHelpers.faker = faker;
    }
}
