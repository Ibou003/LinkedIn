package controllers;

import java.util.List;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import dant.linkedin.core.Training;
import dant.linkedin.core.User;
import dant.linkedin.dao.UserDao;
import dant.linkedin.services.Searchs;



/**
 * @author nasser
 * @version 0.1
 * @date 11/02/2015
 * @test lucasdu75
 */
public class Application extends Controller
{

//  @Security.Authenticated(Secured.class)
//  @Transactional
  @play.db.jpa.Transactional
  public static Result index()
  {
/*
    Logger.info("test log");

		UserDao countryDao = new UserDao();
		//User users = countryDao.authenticate("dantlinkedin@gmail.com", "password");
		Training training = new Training();
		training.setId(1);
		*/
		Searchs searcher = new Searchs();
		searcher.displayUserTableData();
		
		try
    {
      searcher.doIndex();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    
		String consoleInput = "Lucas";
		List<User> result = searcher.search(consoleInput);
		//countryDao.findByTraining(training).toString()
    return ok(index.render(result.toString()));

  }

}
