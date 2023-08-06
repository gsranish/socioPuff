package com.sociopuff.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/***
 * This class works like a Utility contains all methods used in application
 */
public class SocioUtil {

    private SocioUtil()     {       }

    public static Integer getUniqueNumber(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(Integer.MAX_VALUE);
    }
}
