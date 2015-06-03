package dant.linkedin.utils;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class which has Utility methods
 * 
 */
public class Utility {
  private static Pattern pattern;
  private static Matcher matcher;
  //Email Pattern
  public static final String EMAIL_PATTERN =
      "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

  /** Type phone example : 02 12 34 56 78 . */
  public final static String PHONE_PATTERN = "(^$|^(((\\+|00)33|0)[1-5])((([-. ]{1}\\d{2}){4})|\\d{8})$)";

  /** Type mobile  example : 06 12 34 56 78. */
  public final static String MOBILE_PATTERN = "(^$|^(((\\+|00)33|0)[6-7])((([-. ]{1}\\d{2}){4})|\\d{8})$)";

  /** Type Post code  example : 22000. */
  public final static String POST_CODE_PATTERN = "^(\\d{2})(-| )?(\\d{3})$";



  /**
   * Validate Email with regular expression
   * 
   * @param email
   * @return true for Valid Email and false for Invalid Email
   */
  public static boolean validate(String pattern,String email) {
    Utility.pattern = Pattern.compile(pattern);
    matcher = Utility.pattern.matcher(email);
    return matcher.matches();
 
  }


  /**
   * Checks for Null String object
   * 
   * @param txt
   * @return true for not null and false for null String object
   */
  public static boolean isNotNull(String txt){
    return txt!=null && txt.trim().length()>0 ? true: false;
  }

  public static Date stringToDate(String date, String format) throws Exception
  {
    Date d = null;

    try
    {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      d = formatter.parse(date);
      if (!formatter.format(d).equals(date))
      {
        throw new Exception("error format date");
      }

    }
    catch (ParseException e)
    {
      throw e;
    }
    return d;
  }
  public static String dateToString(Date date, String format)
  {

    SimpleDateFormat formatter = new SimpleDateFormat(format);
    return formatter.format(date);
  }
}
