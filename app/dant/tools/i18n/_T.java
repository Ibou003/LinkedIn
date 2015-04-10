package dant.tools.i18n;

// Dependencies begin --------------------------------------------------------------------------------------------------
import java.util.ResourceBundle;
//----------------------------------------------------------------------------------------------------------------------


/**
 * <h1>I18n.</h1>
 * @version V1P0R0
 */
public class _T  
{
  // Fields begin ------------------------------------------------------------------------------------------------------
  
  /** Bundle resources to access i18n file  */
  private static ResourceBundle rb= null; 
  //--------------------------------------------------------------------------------------------------------------------


  // Public functions begin --------------------------------------------------------------------------------------------
  /**
   * <b> Constructor.</b>
   * @return none
   */
  public _T()
  {
  }
  
  /**
   * <b>Initialisation</b>
   * 
   * @param <b>text</b> Text to translate
   * @return String
   */
  public static void init(String i18nFile)
  {
    rb = ResourceBundle.getBundle(i18nFile);
  }
  
  /**
   * <b> Get Translate text on general file.</b>
   * 
   * @param <b>text</b> Text to translate
   * @return String
   */
  public static String T(String text)
  {
    if(rb != null)
    {
      return rb.getString(text);
    }
    else
    {
      return "";
    }
  }
  

  /**
   * <b> Get Translate text.</b>
   * @param <b>i18nFile</b> file
   * @param <b>text</b> Text to translate
   * @return String
   */
  public static String T(String i18nFile, String text)
  {
    ResourceBundle _rb = ResourceBundle.getBundle(i18nFile);
    return _rb.getString(text);
  }
  
  // -------------------------------------------------------------------------------------------------------------------

  // Properties begin --------------------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------------------------------------
}
// end of class
