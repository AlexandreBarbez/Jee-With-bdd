<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Individus</title>
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
	<h3>Enregistrer un individu</h3>
	<form class="col-md-4" accept-charset="UTF-8" method="post" action="individu">
		<input type="hidden" name="action" value="create"/>

		<c:set var="hasPrenomError" value="${not empty errors['prenom']}"/>
		<div class="form-group ${hasPrenomError ? 'has-error' : ''}">
			<label for="prenom">Prénom</label>
			<input type="text" id="prenom" name="prenom" class="form-control" value="<c:out value="${param['prenom']}"/>"/>
			<c:if test="${hasPrenomError}">
				<div class="label label-danger"><c:out value="${errors['prenom']}"/></div>
			</c:if>
		</div>

		<c:set var="hasNomError" value="${not empty errors['nom']}"/>
		<div class="form-group ${hasNomError ? 'has-error' : ''}">
			<label for="nom">Nom</label>
			<input type="text" id="nom" name="nom" class="form-control" value="<c:out value="${param['nom']}"/>"/>
			<c:if test="${hasNomError}">
				<div class="label label-danger"><c:out value="${errors['nom']}"/></div>
			</c:if>
		</div>

		<c:set var="hasAgeError" value="${not empty errors['age']}"/>
		<div class="form-group ${hasAgeError ? 'has-error' : ''}">
			<label for="age">Age</label>
			<input type="number" id="age" name="age" class="form-control" value="<c:out value="${param['age']}"/>"/>
			<c:if test="${hasAgeError}">
				<div class="label label-danger"><c:out value="${errors['age']}"/></div>
			</c:if>
		</div>
		<button type="submit" class="btn btn-default">Enregistrer</button>
	</form>
</div>

<div class="container">
	<h3>Liste des individus déjà enregistrés</h3>
	<form accept-charset="UTF-8" method="post" action="individu">
		<input type="hidden" name="action" value="delete"/>
		<input type="hidden" name="individuId" value=""/>
		<table class="table">
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${individus}" var="i">
					<tr>
						<td><button class="btn btn-default btn-xs" type="submit" onclick="this.form.individuId.value = '${i.id}'"><span class="glyphicon glyphicon-remove-circle"></span></button></td>
						<td><c:out value="${i.prenom}"/></td>
						<td><c:out value="${i.nom}"/></td>
						<td><c:out value="${i.age}"/> ${i.age > 1 ? 'ans' : 'an'}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
