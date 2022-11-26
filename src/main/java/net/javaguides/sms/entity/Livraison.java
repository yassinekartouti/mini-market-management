package net.javaguides.sms.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "livraisons")
public class Livraison {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_liv;
	
	@Column(name = "date_livraison", nullable = false)
	private String date_liv;
	
	@ManyToOne
	@JoinColumn(name="COD_FOUR")

	private Fournisseur fournisseur;

	@OneToMany(mappedBy="livraison")
	private Collection<LigneLiv> ligne_livs;
	
	

	
	@Override
	public String toString() {
		return "Livraison [num_liv=" + num_liv + "]";
	}


	public Livraison() {
		
	}


	public Livraison(int num_liv, String date_liv) {
		super();
		this.num_liv = num_liv;
		this.date_liv = date_liv;
	}


	public int getNum_liv() {
		return num_liv;
	}


	public void setNum_liv(int num_liv) {
		this.num_liv = num_liv;
	}


	public String getDate_liv() {
		return date_liv;
	}


	public void setDate_liv(String date_liv) {
		this.date_liv = date_liv;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public Collection<LigneLiv> getLigne_livs() {
		return ligne_livs;
	}


	public void setLigne_livs(Collection<LigneLiv> ligne_livs) {
		this.ligne_livs = ligne_livs;
	}
	
	
}