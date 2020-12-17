package fr.encheres.dal;

import fr.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	public void creer (Utilisateur utilisateur);
	
	public Utilisateur connexion(String pseudo, String motDePasse) throws Exception;

	Utilisateur select(int id) throws Exception;


}
