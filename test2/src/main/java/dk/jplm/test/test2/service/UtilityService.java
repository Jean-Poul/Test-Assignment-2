package dk.jplm.test.test2.service;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {

    public String reverseString(String aBc) {
        char[] test = aBc.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = test.length - 1; i >= 0; i--) {
            sb.append(test[i]);
        }
        return sb.toString();
    }

    public String capitalizeString(String cap) {
        char[] stringToCharArr = cap.toCharArray();
        for (int i = 0; i < stringToCharArr.length; i++) {
            if (stringToCharArr[i] >= 'a' && stringToCharArr[i] <= 'z') {
                stringToCharArr[i] = (char) ((int) stringToCharArr[i] - 32);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= stringToCharArr.length - 1; i++) {
            sb.append(stringToCharArr[i]);
        }
        return sb.toString();
    }

    public String lowercaseString(String providedUppercase) {
        char[] stringToCharArr = providedUppercase.toCharArray();
        for (int i = 0; i < stringToCharArr.length; i++) {
            if (stringToCharArr[i] >= 'A' && stringToCharArr[i] <= 'Z') {
                stringToCharArr[i] = (char) ((int) stringToCharArr[i] + 32);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= stringToCharArr.length - 1; i++) {
            sb.append(stringToCharArr[i]);
        }
        return sb.toString();
    }
}
