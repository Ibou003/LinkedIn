package controllers;

import static play.libs.Json.toJson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.mail.EmailException;
import com.sun.media.jfxmedia.logging.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import dant.linkedin.core.Mail;
import dant.linkedin.services.Mailing;
/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Mails extends Controller
{
 
  
  
  public static Result send()
  {
    
    final Form<Mail> categoryForm = play.data.Form.form(Mail.class).bindFromRequest();
    Map<String, Object> data = new HashMap<String, Object>();
    final Mail category = categoryForm.get();
    play.Logger.info(category.toString());
    play.Logger.info(category.dests.get(0));
    
    Mailing serviceMail = new Mailing();
    
    try
    {
      serviceMail.sendMailToAll(category.dests, category.msg, category.obj, category.filePath, category.fileName);
      data.put("status", Boolean.TRUE);
    }
    catch (EmailException e)
    {
      data.put("status", Boolean.FALSE);
      e.printStackTrace();
    }
    
    return ok(toJson(data));
  }

}
