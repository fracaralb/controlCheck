package acme.entities.patronageReport;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.patronage.Patronage;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatronageReport extends AbstractEntity {
	
		//Serialisation number
		protected static final long serialVersionUID	= 1L;
		
		//Attributes
		
		@NotNull
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		protected Date 				creationMoment;
		
		@NotBlank
		@Length(min = 1, max = 255)
		protected String 			memorandum;
		
		@URL
		protected String			link;
		
		//Derived attributes 
		
		@Column(unique = true)
		@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?:[0-9]{4}$")
		@NotBlank
		protected String 			sequenceNumber;
		
		//Relationships
		@Valid
		@NotNull
		@ManyToOne(optional = false)
		protected Patronage 		patronage;
		
		
		

}
