package dant.linkedin.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import dant.linkedin.core.Competence;
import dant.linkedin.core.Experience;
import dant.linkedin.core.Training;
import dant.linkedin.core.User;

public class GeneratePDF {

	
	private final String imgPath = new File("").getAbsolutePath()+File.separator+"img"+File.separator;
	private final String OUTPUT_PATH = new File("").getAbsolutePath()+File.separator+"output"+File.separator;
	
	/**
	 * Creates a PDF document.
	 * 
	 * @param filename
	 *            the path to the new PDF document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createPdf(User user,
			int templateNumber, String nomCV) throws DocumentException, IOException {
		String nom = user.getLastName();
		String prenom = user.getFirstName();
		String adresse = user.getAddress().toString();
//		String datenaissance = user.get();
		String telephone = user.getMobile();
		String email = user.getEmail();
		// step 1
		Document document = new Document(PageSize.A4);
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(OUTPUT_PATH+File.separator+nomCV));
		// step 3
		document.open();

		System.out.println(document.getPageSize().getHeight() + " : "
				+ document.getPageSize().getWidth());

		// Photo du CV
		Image userImage = Image
				.getInstance(new URL(
						"http://i3.kym-cdn.com/photos/images/original/000/117/814/are-you-wizard.jpg"));
		userImage.setAbsolutePosition(425, 650);
		userImage.scaleAbsolute(100, 130);
		document.add(userImage);

		Font font0 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL,
				new BaseColor(255, 255, 255));
		Font font1 = new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD);
		Font font2 = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD,
				new BaseColor(255, 255, 255));
		Font font3 = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL);
		// Paragraphe Coordonn�es et contact

		Chunk chunkNom = new Chunk("\n" + nom.toUpperCase());
		Chunk chunkPrenom = new Chunk(" " + prenom);
		Chunk chunkAdresse = new Chunk("\n" + adresse);
		Chunk chunkTelephone = new Chunk("\n" + telephone);
		Chunk chunkEmail = new Chunk("\n" + email);

		Paragraph paragraph0 = new Paragraph("", font0);
		paragraph0.add(chunkNom);
		paragraph0.add(chunkPrenom);
		paragraph0.add(chunkAdresse);
		paragraph0.add(chunkTelephone);
		paragraph0.add(chunkEmail);

		paragraph0.setAlignment(Element.ALIGN_LEFT);
		paragraph0.setIndentationLeft(20);

		// Paragraphe Intitul� "Curriculum Vitae"
		Paragraph paragraph1 = new Paragraph("Curriculum Vitae", font1);
		paragraph1.setAlignment(Element.ALIGN_CENTER);
		paragraph1.setSpacingBefore(100);

		// Intitul� Competences
		Chunk chunkCompetencesIntitule = new Chunk("Comp�tences:");
		Paragraph paragraph2 = new Paragraph("", font2);
		paragraph2.add(chunkCompetencesIntitule);
		paragraph2.setAlignment(Element.ALIGN_LEFT);
		paragraph2.setIndentationLeft(20);
		paragraph2.setSpacingBefore(20);

		// Paragraphhe competences
		Paragraph paragraph3 = new Paragraph("", font3);
		paragraph3.setAlignment(Element.ALIGN_LEFT);
		paragraph3.setIndentationLeft(150);

		StringBuffer competencesString = new StringBuffer("");
		for (Competence competence : user.getCompetences()) {
			if (competence != null) {
				competencesString.append(competence.getName() + " ");
			} else
				competencesString.append("...");
		}
		Chunk competencesChunk = new Chunk(competencesString.toString().trim());
		paragraph3.add(competencesChunk);

		// Titre "Experience"
		Chunk chunkExpIntitule = new Chunk("Exp�rience:");
		Paragraph paragraph4 = new Paragraph("", font2);
		paragraph4.add(chunkExpIntitule);
		paragraph4.setAlignment(Element.ALIGN_LEFT);
		paragraph4.setIndentationLeft(40);
		paragraph4.setSpacingBefore(20);

		// Groupes d'experiences
		Paragraph paragraph5 = new Paragraph("", font3);
		paragraph5.setAlignment(Element.ALIGN_LEFT);
		paragraph5.setIndentationLeft(150);

		StringBuffer expString = new StringBuffer("");
		for (Experience experience : user.getExperiences()) {
			if (experience != null) {
				expString.append(experience.toString() + "\n");
			} else
				expString.append("...");
		}
		Chunk expChunk = new Chunk(expString.toString().trim());
		paragraph5.add(expChunk);

		// Titre "Formation"
		Chunk formationIntitule = new Chunk("Formations:");
		Paragraph paragraph6 = new Paragraph("", font2);
		paragraph6.add(formationIntitule);
		paragraph6.setAlignment(Element.ALIGN_LEFT);
		paragraph6.setIndentationLeft(40);
		paragraph6.setSpacingBefore(20);

		// Groupes de formations
		Paragraph paragraph7 = new Paragraph("", font3);
		paragraph7.setAlignment(Element.ALIGN_LEFT);
		paragraph7.setIndentationLeft(150);
		paragraph7.setSpacingBefore(20);

		StringBuffer formString = new StringBuffer("");
		for (Training training : user.getTrainings()) {
			if (training != null) {
				formString.append(training.toString() + "\n");
			} else
				formString.append("...");
		}
		Chunk formsChunk = new Chunk(formString.toString().trim());
		paragraph7.add(formsChunk);

		if (templateNumber == 0) {
			document.add(paragraph0);
			document.add(paragraph1);
			document.add(paragraph2);
			document.add(paragraph3);
			document.add(paragraph4);
			document.add(paragraph5);
			document.add(paragraph6);
			document.add(paragraph7);

			// Image colonne
			Image colonneImage = Image
					.getInstance(imgPath+File.separator+"colonne_motifCV0.png");
			colonneImage.setAbsolutePosition(0, 0);
			document.add(colonneImage);
		}
		else if(templateNumber == 1){//dans cette template, on change la couleur du fond et l'ordre des blocs.
			
			document.add(paragraph0);
			document.add(paragraph1);
			document.add(paragraph2);
			document.add(paragraph3);
			document.add(paragraph6);
			document.add(paragraph7);
			document.add(paragraph4);
			document.add(paragraph5);
			

			// Image colonne
			Image colonneImage = Image
					.getInstance(imgPath+File.separator+"colonne_motifCV1.png");
			colonneImage.setAbsolutePosition(0, 0);
			document.add(colonneImage);
		}

		document.close();
	}
}
