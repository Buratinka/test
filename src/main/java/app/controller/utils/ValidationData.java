package app.controller.utils;

import java.util.Objects;

public class ValidationData
{
    public static boolean isValidParam(Object ... param)
    {
        boolean f = false;
        try
        {
        if(Objects.nonNull(param) && param != null)f = true;
        }
        catch (NullPointerException ex)
        {
        return false;
        }
        return f;
    }

    public static boolean isValidAge(int age)
    {
        if(Objects.nonNull(age) && age >= 18)return true;
        return false;
    }


}
