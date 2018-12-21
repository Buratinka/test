package app.controller.service.utils;

public class Validation
{
    public static boolean isEmpty(String ... param)
    {
        if(!param.equals(null)&&!param.equals(""))return false;
        return true;
    }
}
