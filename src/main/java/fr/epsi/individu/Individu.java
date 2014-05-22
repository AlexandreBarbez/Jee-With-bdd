package fr.epsi.individu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Individu {

	private Long id;

	private String nom;

	private String prenom;

	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void validate() throws ValidationException {
		Map<String, String> errorMessages = new HashMap<>();

		if (!Objects.toString(nom, "").matches(".{1,30}")) {
			errorMessages.put("nom", "Le nom est obligatoire et doit contenir au plus 30 caractères");
		}
		if (!Objects.toString(prenom, "").matches(".{1,30}")) {
			errorMessages.put("prenom", "Le prénom est obligatoire et doit contenir au plus 30 caractères");
		}
		if (age == null || age < 0) {
			errorMessages.put("age", "L'âge est obligatoire et doit être un nombre positif");
		}

		if (!errorMessages.isEmpty()) {
			throw new ValidationException(errorMessages);
		}
	}

}
