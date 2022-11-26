package net.javaguides.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "lignescmd")
public class LigneCmd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_ligne;
	
	@Column(name = "quantite_commande", nullable = false)
	private int qte_cmd;
	
	
	@ManyToOne
	@JoinColumn(name="NUM_CMD")
	private Commande commande;
	
	
	@ManyToOne
	@JoinColumn(name="COD_ART")
	private Article article;
	
	
	
    @Override
	public String toString() {
		return "LigneCmd [num_ligne=" + num_ligne + "]";
	}

	public LigneCmd() {
		
	}

	public LigneCmd(int num_ligne, int qte_cmd) {
		super();
		this.num_ligne = num_ligne;
		this.qte_cmd = qte_cmd;
	}

	public int getNum_ligne() {
		return num_ligne;
	}

	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}

	public int getQte_cmd() {
		return qte_cmd;
	}

	public void setQte_cmd(int qte_cmd) {
		this.qte_cmd = qte_cmd;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
    
    
}