package app.controller.utils;

import java.util.Objects;

public class ValidationData
{
    public static boolean isValidParam(Object ... param)
    {
        if(Objects.nonNull(param))return true;
        return false;
    }

    public static boolean isValidAge(int age)
    {
        if(Objects.nonNull(age) && age >= 18)return true;
        return false;
    }


}
