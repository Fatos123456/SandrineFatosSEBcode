/**
 * 
 */
package fr.encheres.bo;

import java.time.LocalDate;

/**
 * @author Sébastien
 *
 */
public class Enchere {
	
	private LocalDate date_enchere;
	private int montant_enchere;
	private Article article;
	
	/**
	 * 
	 */
	public Enchere() {
	}



	/**
	 * @param date_enchere
	 * @param montant_enchere
	 * @param article
	 */
	public Enchere(LocalDate date_enchere, int montant_enchere, Article article) {
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
		this.article = article;
	}



	/**
	 * @return the date_enchere
	 */
	public LocalDate getDate_enchere() {
		return date_enchere;
	}


	/**
	 * @param date_enchere the date_enchere to set
	 */
	public void setDate_enchere(LocalDate date_enchere) {
		this.date_enchere = date_enchere;
	}


	/**
	 * @return the montant_enchere
	 */
	public int getMontant_enchere() {
		return montant_enchere;
	}


	/**
	 * @param montant_enchere the montant_enchere to set
	 */
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}



	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((date_enchere == null) ? 0 : date_enchere.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enchere other = (Enchere) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (date_enchere == null) {
			if (other.date_enchere != null)
				return false;
		} else if (!date_enchere.equals(other.date_enchere))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Enchère [date_enchere=" + date_enchere + ", montant_enchere=" + montant_enchere + "]";
	}
	
	

}
