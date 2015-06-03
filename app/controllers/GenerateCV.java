package controllers;

import static play.libs.Json.toJson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;

import dant.linkedin.core.User;
import dant.linkedin.dao.UserDao;
import dant.linkedin.services.GeneratePDF;

public class GenerateCV extends Controller{
	
	private final static String OUTPUT_PATH = new File("").getAbsolutePath()+File.separator+"output"+File.separator;
	
	@Transactional
	public static Result get() throws DocumentException, IOException{
		
		UserDao userDao = new UserDao();
		User user = userDao.findById(10);
		
		GeneratePDF cv = new GeneratePDF();
		cv.createPdf(user, 0, "cv");
		
		PdfReader cvPDF = new PdfReader(OUTPUT_PATH+File.separator+"cv");
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("status", Boolean.TRUE);
		data.put("cv", cvPDF);
		return ok(toJson(data));
		
	}

}
