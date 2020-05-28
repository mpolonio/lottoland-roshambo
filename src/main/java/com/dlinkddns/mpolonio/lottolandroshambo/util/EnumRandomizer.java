package com.dlinkddns.mpolonio.lottolandroshambo.util;

import java.util.Random;

public class EnumRandomizer {

    private static Random random = new Random();

    private EnumRandomizer() {}

    public static <T extends Enum<?>> T getEnumConstant(Class<T> enumClass) {
        if (enumClass == null) {
            throw new IllegalArgumentException("enumClass parameter is not allowed to be null.");
        }
        if (!enumClass.isEnum()) {
            throw new IllegalArgumentException("Provided enumClass parameter is not an Enum.");
        }

        T enumValue = null;

        T[] enumValues = enumClass.getEnumConstants();
        int enumConstantsLength = enumClass.getEnumConstants().length;

        if (enumConstantsLength==0){
            throw new IllegalArgumentException("Provided enumClass parameter has no Enum constants.");
        }

        enumValue = enumValues[random.nextInt(enumConstantsLength)];

        return enumValue;
    }
}