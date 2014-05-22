package fr.epsi.individu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndividuRepository {
    Connection connection ;

    public IndividuRepository(Connection LaConnection)
    {
        connection = LaConnection;
    }
    public void create(Individu individu) throws ValidationException {

        java.sql.Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute("insert into individu (nom, prenom, age) values ('" + individu.getNom() + "','" + individu.getPrenom() + "','" + individu.getAge() + "')");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        individu.validate();
	}

	public void delete(long id) {
        java.sql.Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM individu WHERE individu.id ='"+id+"'");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public List<Individu> getAll() {
		List<Individu> result = new ArrayList<>();
        String request = "select * from individu";
        Individu leMonsieur ;
        try (java.sql.Statement stmt = connection.createStatement();
             java.sql.ResultSet resultSet = stmt.executeQuery(request);){

            while (resultSet.next()) {
                leMonsieur = new Individu();
                long id = resultSet.getLong("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                Integer age = resultSet.getInt("age");

                leMonsieur.setId(id);
                leMonsieur.setNom(nom);
                leMonsieur.setPrenom(prenom);
                leMonsieur.setAge(age);

                result.add(leMonsieur);
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

		return result;
	}
}
