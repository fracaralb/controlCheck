package acme.entities.announcement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Announcement extends AbstractEntity {

	
	//Serialisation identifier
	protected static final long serialVersionUID	= 1L;
	
	//Attributes
	
	@Temporal(TemporalType.DATE)
	@Past
	protected Date				creationMoment;
	
	@NotBlank
	@Length(max = 100)
	protected String			title;
	
	@NotBlank
	@Length(max = 255)
	protected String 			body;
	
	protected Boolean			criticalFlag;
	
	@URL
	protected String 			link;
	
}
