package lotto.utils;

public class Validator {
    public static int toInt(String input, String error){
        try{
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(error);
        }
    }
}
