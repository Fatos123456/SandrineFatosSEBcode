package fr.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.encheres.bo.Utilisateur;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT_UTILISATEUR ="insert into utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)"
													+ "values(?,?,?,?,?,?,?,?,?,?,?)";

	private static final String CONNEXION = "select no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville from utilisateurs where (pseudo=?) AND (mot_de_passe=?)";
	
	private static final String SELECT_ALL = "SELECT*FROM UTILISATEURS where no_utilisateur=?";
	
	public void creer(Utilisateur utilisateur) {
	
	try(Connection cnx = ConnectionProvider.getConnection())
	{
		try
		{
			//Commencer une requête pour insérer les données remplies par l'utilisateur au moment de l'inscription en base de données
			
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setInt(11, utilisateur.getAdministrateur());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			//Ajouter un numéro d'utilisateur (identifiant) pour chaque inscription
			if(rs.next())
			{
				utilisateur.setId(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
				
			} catch (SQLException e) {
			e.printStackTrace();
			}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
	
		}


	@Override
	public Utilisateur connexion(String pseudo, String motDePasse) throws Exception {

		// instancie a null l'utilisateur, pseudo et mot de passe
		 Utilisateur utilisateur = null;
		 
        //Créer la connexion et démarre la requête pour récupérer le pseudo et le mot de passe de l'utilisateur en base de données
		 
        try (Connection cnx = ConnectionProvider.getConnection()) {
        PreparedStatement pstmt = cnx.prepareStatement(CONNEXION);
        pstmt.setString(1, pseudo);         
        pstmt.setString(2, motDePasse);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {
	         utilisateur = new Utilisateur
	         (rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
	         rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
	         rs.getString("code_postal"), rs.getString("ville"), null);
	     	}

        //Si cela ne fonctionne pas afficher une erreur à l'utilisateur
        
         } catch (Exception e) {
	        e.printStackTrace();
         	}
        
		return utilisateur;
        
     
	}



	 

    @Override
    public Utilisateur select(int id) throws Exception {
        Utilisateur utilisateur = new Utilisateur();
        try(
                Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
            
        
            utilisateur.setId(rs.getInt("id"));
            utilisateur.setPseudo(rs.getString("pseudo"));
            utilisateur.setNom(rs.getString("nom"));
            utilisateur.setPrenom(rs.getString("prenom"));
            utilisateur.setEmail(rs.getString("email"));
            utilisateur.setTelephone(rs.getString("telephone"));
            utilisateur.setRue(rs.getString("rue"));
            utilisateur.setCodePostal(rs.getString("code_postal"));
            utilisateur.setVille(rs.getString("ville"));
            utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
            utilisateur.setCredit(rs.getInt("credit"));
            utilisateur.setAdministrateur(rs.getInt("administrateur"));
            
        }}
        catch(SQLException e)
        {
            e.printStackTrace();
            Exception Exception = new Exception();
            throw Exception;
        }
            return utilisateur;
    }
	
}
