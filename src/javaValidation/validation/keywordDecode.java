package javaValidation.validation;

/**
 * Created by student on 3/2/16.
 */
public final class keywordDecode {

    public static int decodeKeyword(String keyword) {
        int code = -1;

        switch (keyword) {
            case " for" : code = 1;
                break;
            case " if" : code = 2;
                break;
            case " else" : code = 3;
                break;
            case " else if" : code = 4;
                break;
            case " while" : code = 5;
                break;
            case " do" : code = 6;
                break;
            case " try" : code = 7;
                break;
            case " catch" : code = 8;
                break;
            case " do while" : code = 9;
                break;
            default: code = -1;
                break;
            }

        return code;
        }


}
