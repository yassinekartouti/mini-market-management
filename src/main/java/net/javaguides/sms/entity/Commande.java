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
@Table(name = "commandes")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int num_cmd;
	
	@Column(name = "Date_commande", nullable = false)
	private String date_cmd;
	
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	@OneToMany(mappedBy="commande")
	private Collection<LigneCmd> lignes_cmd;

	
	@Override
	public String toString() {
		return "Commande [num_cmd=" + num_cmd + "]";
	}


	public Commande() {
		
	}


	public Commande(int num_cmd, String date_cmd) {
		super();
		this.num_cmd = num_cmd;
		this.date_cmd = date_cmd;
	}


	public int getNum_cmd() {
		return num_cmd;
	}


	public void setNum_cmd(int num_cmd) {
		this.num_cmd = num_cmd;
	}


	public String getDate_cmd() {
		return date_cmd;
	}


	public void setDate_cmd(String date_cmd) {
		this.date_cmd = date_cmd;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Collection<LigneCmd> getLignes_cmd() {
		return lignes_cmd;
	}


	public void setLignes_cmd(Collection<LigneCmd> lignes_cmd) {
		this.lignes_cmd = lignes_cmd;
	}
	
	
	
}
