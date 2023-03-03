/**
 * 
 */
"use strict";

const urlWebService = "http://localhost:8080/garageRS/serviceRS/";
//const marquesMoto = ['ALFA', 'FERRARI', 'FIAT', 'YAMAHA', 'LANCIA'];

function afficherSansCT(voitures) {

	//afficher la liste des voitures dans "sansCT"
	let ul = document.querySelector("#voituresSansCT ul");

	//iteration sur voitures
	let voitureSCTRows = "";
	voitures.forEach(function(voiture) {
		if (voiture.dateControlTechnique == null) {
			voitureSCTRows += '<li ondragstart="dragVoitureSansCT(event)" class="list-group-item bg-danger" draggable="true" id="'
			voitureSCTRows += voiture.id + '"> ' + voiture.id + "/" + voiture.immatriculation + "</li>";
		}
	});
	ul.innerHTML = voitureSCTRows;
}

function allowDrop(ev) {
	ev.preventDefault();
}

function dragVoitureSansCT(ev) {
	ev.dataTransfer.setData("voitureId", ev.target.id);
}

function dropVoitureSansCT(ev) {
	ev.preventDefault();
	var voitureId = ev.dataTransfer.getData("voitureId");
	let ul = document.querySelector("#voituresAvecCT ul");
	let voiture = document.getElementById(voitureId);
	voiture.classList.remove("bg-danger");
	voiture.classList.add("bg-success");
	ul.appendChild(document.getElementById(voitureId));
}

function validerVoituresCT() {
	let listeVoituresCT = document.querySelectorAll("#voituresAvecCT li");
	let ids = [];
	listeVoituresCT.forEach(function(voiture) {
		let id = voiture.textContent.split("/")[0];
		//sauvergade des ids
		ids.push(id); // ajouter dans une collections
	});
	//appel qu WS
	let voitureService = new VehiculeService("voiture", urlWebService);
	//recuperation des motos par ws
	voitureService.validerCTAjax(ids).then(
		function(voitures) {
			alert("validation CT OK");
			//on vide la liste
			listeVoituresCT.forEach((li) => li.parentElement.removeChild(li));
			//maj local storage
			loadVoitures();
		},
		function(erreur) {
			alert(erreur + " dans catch");
		}).catch(function(erreur) {
			alert(erreur + " dans catch");
		});

	//let idsString = JSON.stringify(ids);
	//on vide la liste
	//listeVoituresCT.forEach((li)=>li.parentElement.removeChild(li));

}

function afficherAvecCT(voitures) {

	//afficher la liste des voitures dans "sansCT"
	let ul = document.querySelector("#voituresAvecCT ul");

	//iteration sur voitures
	let voitureACTRows = "";
	voitures.forEach(function(voiture) {
		if (voiture.dateControlTechnique != null) {
			voitureACTRows += '<li ondragstart="dragVoitureAvecCT(event)" class="list-group-item bg-danger" draggable="true" id="'
			voitureACTRows += voiture.id + '"> ' + voiture.id + "/" + voiture.immatriculation + "</li>";
		}
	});
	ul.innerHTML = voitureACTRows;
}

function dragVoitureAvecCT(ev) {
	ev.dataTransfer.setData("voitureId", ev.target.id);
}

function dropVoitureAvecCT(ev) {
	ev.preventDefault();
	var voitureId = ev.dataTransfer.getData("voitureId");
	let ul = document.querySelector("#voituresSansCT ul");
	let voiture = document.getElementById(voitureId);
	voiture.classList.remove("bg-success");
	voiture.classList.add("bg-danger");
	ul.appendChild(document.getElementById(voitureId));
}

/**
 * fonction pour dessiner les Xièmes voitures en fonction du nbr de portes 
 */
function dessinerHistoNbrPortes(voitures) {

	const sizeMaxH = 500;
	const sizeMaxV = 150;
	const offset = 10;
	const frq = sizeMaxH / offset;

	var histo = document.querySelector("#histoNbrPortes");
	histo.width = sizeMaxH;
	histo.height = sizeMaxV;

	var ctx = histo.getContext("2d");

	var nbVoituresAffichees = 0;

	voitures.forEach(function(voiture) {
		let size = voiture.nbrPortes * 10;
		if (nbVoituresAffichees < offset) {
			ctx.beginPath();
			ctx.rect(nbVoituresAffichees * frq, sizeMaxV - size, frq - 1, sizeMaxV);
			switch (voiture.nbrPortes) {
				case 3: ctx.fillStyle = "yellow";
					break;
				case 4: ctx.fillStyle = "green";
					break;
				case 5: ctx.fillStyle = "red";
					break;
				case 6: ctx.fillStyle = "blue";
					break;
				case 7: ctx.fillStyle = "orange";
					break;
				default: console.log("pb avec couleur");
			}
			ctx.fill();
			nbVoituresAffichees++;
		}
	});
}

function afficherVoitures(voitures) {
	//recuperation du tbody du tableau de voitures
	let tbody = document.querySelector("#voitures tbody");
	let voitureRows = "";
	//iteration sur voitures
	voitures.forEach(function(voiture) {
		voitureRows += "<tr>";
		voitureRows += "<td>" + voiture.id + "</td>";
		voitureRows += "<td>" + voiture.marque + "</td>";
		voitureRows += "<td>" + voiture.modele + "</td>";
		voitureRows += "<td>" + voiture.couleur + "</td>";
		voitureRows += "<td>" + voiture.nbrPortes + "</td>";
		voitureRows += "<td>" + ((voiture.dateControlTechnique == null) ? "NC" : formatDate(voiture.dateControlTechnique)) + "</td>";
		voitureRows += "</tr>";
	});

	tbody.innerHTML = voitureRows;

	dessinerHistoNbrPortes(voitures);
}

function formatDate(date) {
	let dateFormatee;
	dateFormatee = date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " a " + date.getHours() + ":" + date.getMinutes();
	return dateFormatee;
}

function saveUpdateMoto(motoForm) {
	let isBequille = (motoForm['isBequille'].checked == true) ? true : false;
	//recuperation de la moto saisie
	let moto = new Moto(null, motoForm['marque'].value, motoForm['modele'].value, motoForm['couleur'].value, motoForm['immatriculation'].value, isBequille);

	let motoService = new VehiculeService("moto", urlWebService);
	//recuperation des motos par ws
	motoService.saveAjax(moto).then(
		function(moto) {
			alert("l'id de la nouvelle moto est " + moto.id);
			loadMotos();
		},
		function(erreur) {
			alert(erreur + " dans then");
		}).catch(function(erreur) {
			alert(erreur + " dans catch");
		});
	//raz du formulaire
	motoForm.reset();

	return false;
}

function initPage() {

	//recuperation en session si elles existent
	let voituresStorage = localStorage.getItem("voitures")
	if (voituresStorage != undefined) {
		voitures = JSON.parse(voituresStorage, convertionJSON);
		loadVoitures(voitures);
		afficherVoitures(voitures);
	}
	numItem = (localStorage.getItem("lastItem") != undefined) ? localStorage.getItem("lastItem") : 1;
	document.querySelector("#pills-tab li:nth-child(" + lastItem + ") a").click();
}

//recuperation dernier page ouvert
//	let dernierePageUrl = localStorage.getItem('dernierePageVue');
//	if (dernierePageUrl == null) {
//		//memorisation page actuelle
//	let dernierePageUrl = window.location.href; //memorisation a chaque changement d'onglet

//lorsque l'evenement mouseover est declenche, executer maFonction
//document.querySelector("#pills-tab li:nth-child(" + numItem + ") a").click();

/*** fonction qui memorise le numero de l item selected*/
function saveNumItemStorage(event) {
	let ul = event.target.parentElement.parentElement;
	let li = event.target.parentElement;
	let numItem = -1;
	let compteur = 1;
	//on recherche la position du li
	ul.querySelectorAll("li").forEach((liCurr) => {
		if (li == liCurr) {
			numItem = compteur;
		}
		compteur++;
	});
	//on memorise la position
	localStorage.setItem("lastItem", numItem);
};
	//callback memorisation num itemdocument.querySelectorAll("#pills-tab li a").forEach((a) => {a.onclick = saveNumItemStorage;});	function saveNumItemStorage() {
	let ul = event.target.parentElement.parentElement;
	let numItem = ul.children.indexOf(this.parentElement);
	localStorage.setItem("lastItem", numItem);
	}
	let liste = ArrayList < String >;
	document.querySelectorAll("#pills-tab li a").forEach((a) => {
		a.onclick = saveNumItemStorage;
	});
}
//stockage de l'url dans localstorage
//	localStorage.setItem('dernierePageVue', dernierePageUrl);
//	}




//init du formMoto
creerSelectMarque(Moto.marquesMoto);

afficherSansCT(voitures);
afficherAvecCT(voitures);
}

function loadVoitures() {
	const xhttp = new XMLHttpRequest();
	//declaration dela  callback au retour de la requete
	xhttp.onload = function() {
		//let voitures = JSON.parse(this.responseText);
		let voitures = JSON.parse(this.responseText, convertionJSON);
		localStorage.setItem("voitures", JSON.stringify(voitures))
		afficherVoitures(voitures);
		//afficherCT(voitures);
	}
	//preparatin de la requee
	xhttp.open("GET", "http://localhost:8080/garageRS/serviceRS/voiture", true);
	//appel de la requete ajax
	xhttp.send();
}

function convertionJSON(key, value) {
	if (key.startsWith("date")) {
		return new Date(value);
	} else {
		return value;
	}
}


function loadMotos() {
	let motoService = new VehiculeService("moto", urlWebService);
	//recuperation des motos par ws
	motoService.findAllAjax().then(
		afficherMoto,
		function(erreur) {
			alert(erreur + " dans then");
		}).catch(function(erreur) {
			alert(erreur + " dans catch");
		});

	//affichage du tableau de motos
	//afficherMoto(motoService.vehicules);
}

function afficherMoto(motos) {
	//recuperation du tbody du tableau de voitures
	let tbody = document.querySelector("#motos tbody");
	let motoRows = "";
	//iteration sur voitures
	motos.forEach(function(moto) {
		motoRows += "<tr>";
		motoRows += "<td>" + moto.id + "</td>";
		motoRows += "<td>" + moto.marque + "</td>";
		motoRows += "<td>" + moto.modele + "</td>";
		motoRows += "<td>" + moto.couleur + "</td>";
		motoRows += "<td>" + moto.isBequille + "</td>";
		motoRows += "</tr>";
	});

	tbody.innerHTML = motoRows;
}
function creerSelectMarque(marques) {
	let selectMarque = document.querySelector("#marque");
	let options = "<option value=''></option>";

	marques.forEach((marque) => options += "<option value='" + marque + "'>" + marque + "</option>");

	marque.innerHTML = options;

}

localStorage.setItem("maClef", "ma valeur");
//recuperation du cookie
function checkCookie(nomCookie) {
	let cookies = document.cookie.split(";"); // a;b;c  tab[a,b,c]
	let isPresent = false;
	cookies.forEach(function(cookie) {
		let nomValeur = cookie.split("=");
		if (nomValeur[0] == nomCookie) {
			isPresent = true;
		}
	});
	return isPresent;
}
checkCookie("pub");
///si cookie pas present
if (!checkCookie("pub")) {
	//on affiche l alerte
	alert("ma pub");
	//on cree le cookie
	document.cookie = "pub=true;path=/";
}


function countVisite(cookieName) {
	let cookies = document.cookie.split(";"); // nom=valeur; expires=30/12/1999;path="/"--> cookies = [nom=valeur,expires=30/12/1999,path="/"]
	let nbrVisite = 1;
	cookies.forEach(function(nom) // nom prendra les valeurs de cookies une par une
	{
		let nomValeur = nom.split("="); //nomValeur =[nom, valeur; expires=30/12/1999;path="/"-]
		if (nomValeur[0].trim() == cookieName) {
			nbrVisite = parseInt(nomValeur[1]) + 1;

		}
	});
	document.cookie = "nbrVisite=" + nbrVisite + ";path=/";

	return nbrVisite;
}
//alert("cest votre " + countVisite("nbrVisite") + " ème visite");