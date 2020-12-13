package com.emna.cosmetiques.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cosmetique {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCosmetique;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomCosmetique;
	
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixCosmetique;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Marque marque;
	public Cosmetique() {
		super();	
	}
	
	public Cosmetique(String nomCosmetique, Double prixCosmetique, Date dateCreation) {
		super();
		this.nomCosmetique = nomCosmetique;
		this.prixCosmetique = prixCosmetique;
		this.dateCreation = dateCreation;
	}

	public Long getIdCosmetique() {
		return idCosmetique;
	}
	public void setIdCosmetique(Long idCosmetique) {
		this.idCosmetique = idCosmetique;
	}
	public String getNomCosmetique() {
		return nomCosmetique;
	}
	public void setNomCosmetique(String nomCosmetique) {
		this.nomCosmetique = nomCosmetique;
	}
	public Double getPrixCosmetique() {
		return prixCosmetique;
	}
	public void setPrixCosmetique(Double prixCosmetique) {
		this.prixCosmetique = prixCosmetique;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Cosmetique [idCosmetique=" + idCosmetique + ", nomCosmetique=" + nomCosmetique + ", prixCosmetique="
				+ prixCosmetique + ", dateCreation=" + dateCreation + "]";
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

}
