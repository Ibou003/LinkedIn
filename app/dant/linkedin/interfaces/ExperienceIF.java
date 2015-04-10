package dant.linkedin.interfaces;

import java.util.Date;

import dant.linkedin.core.Establishment;

public interface ExperienceIF {

	public String getTitle();

	public Date getDateStart();

	public Date getDateEnd();

	public Boolean getCurrent();

	public String getDescription();

	public Establishment getEstablishment();

}
