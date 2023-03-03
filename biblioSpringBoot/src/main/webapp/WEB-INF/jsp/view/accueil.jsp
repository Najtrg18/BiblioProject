<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>garage Spring MVC</title>
<%@include file="head/head.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/class/Vehicule.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/class/Moto.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/class/VehiculeService.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/garage.js"></script>
</head>
<body onload="initPage()">
	<div id="page">
		<jsp:include page="header/header.jsp"></jsp:include>
		<jsp:include page="nav/nav.jsp"></jsp:include>
		<div id="content">
			<div id="left">left gauche</div>
			<div id="center">
				<h1>Accueil</h1>
				<h1>garage Spring MVC</h1>
				<!-- MENU ONGLETS -->
				<ul class="nav nav-tabs" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="voiture-tab" data-bs-toggle="pill" data-bs-target="#voiture"
						type="button" role="tab" aria-controls="voiture"
						aria-selected="false">Voitures</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="moto-tab" data-bs-toggle="pill" data-bs-target="#moto"
						type="button" role="tab" aria-controls="moto"
						aria-selected="false">Motos</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="bateau-tab" data-bs-toggle="pill" data-bs-target="#bateau"
						type="button" role="tab" aria-controls="bateau"
						aria-selected="false">Bateaux</a></li>
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="ct-tab" data-bs-toggle="pill"
						data-bs-target="#ct" type="button" role="tab" aria-controls="ct"
						aria-selected="true">Control Technique</a></li>
				</ul>
				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane fade " id="voiture" role="tabpanel"
						aria-labelledby="voiture-tab" tabindex="0">
						<!-- ************************ ONGLET VOITURES ************************ -->
						<canvas id="histoNbrPortes" style="border: 1px solid #d3d3d3;">
						</canvas>

						<table id="voitures">
							<thead>
								<tr>
									<th>id</th>
									<th>Marque</th>
									<th>modele</th>
									<th>couleur</th>
									<th>nombre de portes</th>
									<th>date controle technique</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<button onclick="loadVoitures()" class="btn btn-primary">load
							des voitures</button>
					</div>
					<div class="tab-pane fade" id="moto" role="tabpanel"
						aria-labelledby="moto-tab" tabindex="0">
						<!-- ************************ ONGLET MOTOS ************************ -->

						<div class="accordion" id="accordionPanelsStayOpenExample">
							<div class="accordion-item">
								<h2 class="accordion-header" id="panelsStayOpen-headingOne">
									<button class="accordion-button" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#panelsStayOpen-collapseOne"
										aria-expanded="true"
										aria-controls="panelsStayOpen-collapseOne">Affichage
										des motos</button>
								</h2>
								<div id="panelsStayOpen-collapseOne"
									class="accordion-collapse collapse show"
									aria-labelledby="panelsStayOpen-headingOne">
									<div class="accordion-body">
										<strong>
											<table id="motos">
												<thead>
													<tr>
														<th>id</th>
														<th>Marque</th>
														<th>modele</th>
														<th>couleur</th>
														<th>bequille</th>
														<th></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
											<button onclick="loadMotos()">load des motos</button>
										</strong>
									</div>
								</div>
							</div>
							<div class="accordion-item">
								<h2 class="accordion-header" id="panelsStayOpen-headingTwo">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#panelsStayOpen-collapseTwo"
										aria-expanded="false"
										aria-controls="panelsStayOpen-collapseTwo">Ajout
										d'une moto</button>
								</h2>
								<div id="panelsStayOpen-collapseTwo"
									class="accordion-collapse collapse"
									aria-labelledby="panelsStayOpen-headingTwo">
									<div class="accordion-body">
										<strong><form method="post"
												onsubmit="return saveUpdateMoto(this)" id="motoForm">

												<div class="mb-3">
													<label class="form-label">id</label><input name="id"
														type="text" value="" class="form-control"
														readonly="readonly" />
												</div>
												<div class="mb-3">
													<label class="form-label">marque</label> <select
														id="marque" name="marque" class="form-select">
														<option value=""></option>
													</select>

												</div>
												<div class="mb-3">
													<label class="form-label">modele</label><input
														name="modele" class="form-control" type="text" value=""
														required="required" />
												</div>
												<div class="mb-3">
													<label class="form-label">couleur</label><input
														onfocus="focusEvent(this)" onchange="checkCouleur(this)"
														id="couleur" name="couleur" type="text"
														class="form-control" value="" required="required"
														placeholder="couleur de votre vehicule" /> <span></span>
												</div>
												<div class="mb-3">
													<label class="form-label">immatriculation</label><input
														id="immatriculation" onchange="checkImmatriculation(this)"
														name="immatriculation" type="text" class="form-control"
														value="" required="required" /> <span></span>
												</div>
												<div class="mb-3">
													<label class="form-check-label">bequille</label><input
														id="isBequille" name="isBequille" type="checkbox"
														class="form-check-input" value="true" /> <span></span>
												</div>
												<p>
													<input id="btnValidation" type="submit"
														class="btn btn-primary" />
												</p>
											</form></strong>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="bateau" role="tabpanel"
						aria-labelledby="bateau-tab" tabindex="0">
						<!-- ************************ ONGLET BATEAUX ************************ -->
						<table>
							<thead>
								<tr>
									<th>id</th>
									<th>Marque</th>
									<th>modele</th>
									<th>couleur</th>
									<th>in board</th>
									<th></th>
								</tr>
							</thead>
							<c:forEach items="${bateaux }" var="bateau">
								<tr>
									<td><c:out value="${bateau.id }"></c:out></td>
									<td><c:out value="${bateau.marque }"></c:out></td>
									<td><c:out value="${bateau.modele }"></c:out></td>
									<td><c:out value="${bateau.couleur }"></c:out></td>
									<td><c:if test="${bateau.isInboard }">oui</c:if></td>
									<td><a href="bateauDetail/${bateau.id }">detail</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="tab-pane fade show active" id="ct" role="tabpanel"
						aria-labelledby="ct-tab" tabindex="0">
						<div class="container text-center" style="margin-bottom: 5%">
							<div class="row">
								<div class="col bg-danger">
									<button class="btn btn-outline-success btn-lg"
										onclick="validerVoituresCT()">Valider</button>
								</div>
							</div>
							<div class="row">
								<div class="col bg-danger">sans CT</div>
								<div class="col bg-success">CT</div>
							</div>
							<div class="row bg-success-subtle">
								<div class="col bg-danger-subtle" id="voituresSansCT"
									ondrop="dropVoitureAvecCT(event)" ondragover="allowDrop(event)">
									<!-- ************************ ONGLET CONTROL TECHNIQUE ************************ -->
									<ul class="list-group list-group-flush" id="voituresSCT">
										<!-- 										<li class="list-group-item bg-danger" draggable="true">item</li> -->
										<!-- 										<li class="list-group-item bg-danger">item</li> -->
										<!-- 										<li class="list-group-item bg-danger">item</li> -->
									</ul>
								</div>
								<div id="voituresAvecCT" class="col bg-success-subtle"
									ondrop="dropVoitureSansCT(event)" ondragover="allowDrop(event)">
									<ul class="list-group list-group-flush" id="voituresACT">
										<!-- 										<li class="list-group-item bg-success">item</li> -->
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="right">right</div>
		</div>
		<jsp:include page="footer/footer.jsp"></jsp:include>
	</div>
</body>
</html>