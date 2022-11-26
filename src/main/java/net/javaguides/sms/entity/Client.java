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
@Table(name = "clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_cli;
	
	@Column(name = "nom_client", nullable = false)
	private String nom_cli;
	
	@Column(name = "prenom_client")
	private String pre_cli;
	
	@Column(name = "adresse_client")
	private String adr_cli;
	
	@Column(name = "telephone_client")
	private String tel_cli;
	
	@Column(name = "ville_client")
	private String ville_cli;
	
	@OneToMany(mappedBy="client")
	private Collection<Commande> commandes;
	
	

	@Override
	public String toString() {
		return "Client [nom_cli=" + nom_cli + "]";
	}

	public Client() {
		
		
	}

	public Client(int cod_cli, String nom_cli, String pre_cli, String adr_cli, String tel_cli, String ville_cli) {
		super();
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.pre_cli = pre_cli;
		this.adr_cli = adr_cli;
		this.tel_cli = tel_cli;
		this.ville_cli = ville_cli;
	}

	public int getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getPre_cli() {
		return pre_cli;
	}

	public void setPre_cli(String pre_cli) {
		this.pre_cli = pre_cli;
	}

	public String getAdr_cli() {
		return adr_cli;
	}

	public void setAdr_cli(String adr_cli) {
		this.adr_cli = adr_cli;
	}

	public String getTel_cli() {
		return tel_cli;
	}

	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}

	public String getVille_cli() {
		return ville_cli;
	}

	public void setVille_cli(String ville_cli) {
		this.ville_cli = ville_cli;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	
	
	
}
