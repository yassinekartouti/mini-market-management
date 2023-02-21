package net.javaguides.sms.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "articles")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_art;
	
	@Column(name = "nom_article", nullable = false)
	private String nom_art;
	
	@Column(name = "prix_unitaire")
	private float pu;
	
	@Column(name = "qte_stock")
	private float qte_stock;
	
	
	
	@OneToMany(mappedBy="article")
	private Collection<LigneCmd> lignes_cmd;
	
	@OneToMany(mappedBy="article")
	private Collection<LigneLiv> lignes_liv;
	
	

    @Override
	public String toString() {
		return "" + nom_art;
	}

	public Article() {
		
	}

	public Article(int cod_art, String nom_art, float pu, float qte_stock) {
		super();
		this.cod_art = cod_art;
		this.nom_art = nom_art;
		this.pu = pu;
		this.qte_stock = qte_stock;
	}

	public int getCod_art() {
		return cod_art;
	}

	public void setCod_art(int cod_art) {
		this.cod_art = cod_art;
	}

	public String getNom_art() {
		return nom_art;
	}

	public void setNom_art(String nom_art) {
		this.nom_art = nom_art;
	}

	public float getPu() {
		return pu;
	}

	public void setPu(float pu) {
		this.pu = pu;
	}

	public float getQte_stock() {
		return qte_stock;
	}

	public void setQte_stock(float qte_stock) {
		this.qte_stock = qte_stock;
	}

	public Collection<LigneCmd> getLignes_cmd() {
		return lignes_cmd;
	}

	public void setLignes_cmd(Collection<LigneCmd> lignes_cmd) {
		this.lignes_cmd = lignes_cmd;
	}

	public Collection<LigneLiv> getLignes_liv() {
		return lignes_liv;
	}

	public void setLignes_liv(Collection<LigneLiv> lignes_liv) {
		this.lignes_liv = lignes_liv;
	}
    
    


}