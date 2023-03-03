"use strict"; // compatbile avec eCMA 2015
/*
** callback 
*/

function checkCouleur(input) {
	input.value = input.value.toUpperCase();
}

function initForm(marques) {
	let inputs = document.querySelectorAll("input[type='text']");
	inputs.forEach((input) => input.onblur = blurEvent);
	let btnValidation = document.querySelector("#btnValidation");
	btnValidation.disabled = "disabled";
	creerSelectMarque(marques);
}

function focusEvent(input) {
	console.log("focus");
	let btnValidation = document.querySelector("#btnValidation");
	btnValidation.disabled = "";
}

function blurEvent(input) {
	console.log("blur");
	let btnValidation = document.querySelector("#btnValidation");
	// si tous les champs sont remplis
	btnValidation.disabled = (validerForm()) ? "" : "disabled";
}

function validerForm() {
	let inputs = document.querySelectorAll("input[type='text']");
	let formValid = true;
	inputs.forEach(function(input) {
		let len = input.value.length;
		if (len == 0) {
			formValid = false;
		}
	});
	return formValid
}

function creerSelectMarque(marques) {
	let selectMarque = document.querySelector("#marque");
	let options = "<option value=''></option>";

	marques.forEach((marque) => options += "<option value='" + marque + "'>" + marque + "</option>");

	marque.innerHTML = options;
}

//document.innerHTML("<option></option>")

function checkImmatriculation(input) {
	input.value = input.value.toUpperCase();

	let immatriculation = input.value;

	let tab = immatriculation.match("([a-zA-Z]){2}([1-9]([0-9]){0,2})([a-zA-Z]){2}");

	input.style.backgroundColor = (tab == null) ? "red" : "green";

	document.querySelector("#erreur").innerHTML = (tab == null) ? "format : XX000XX" : "";
}
/*
** callback d'init de la PAGE
*/
function initPage() {
	//alert("page chargee");
	//document.querySelector("body").style.cursor = "progress";
	let marques = ['ALFA', 'FERRARI', 'FIAT', 'YAMAHA'];
	initForm();
	let couleur = document.querySelector("#couleur"); //renvoie un element
	let couleur1 = document.getElementById("couleur");
	//	couleur.style.backgroundColor = 'red';

	let inputs = document.querySelectorAll("input"); //renvoie un tableau

	//	//legacy
	//	for (let i = 0; i < inputs.length; i++) { inputs[i].style.backgroundColor = 'green'; }
	//
	//	//closure
	//	inputs.forEach(function(input) {
	//		input.style.backgroundColor = 'green';
	//	});
	//
	//	//lambda
	//	inputs.forEach((input) => { input.style.backgroundColor = 'green'; }
	//	);


}


function blurEvent(input) {
	let inputs = document.querySelectorAll("input[type='text']");
	let error = false;
	inputs.forEach(function(input) {
		if (!input.checkValidity()) {
			error = true;
			alert(input.validity);
		}
	});
	let btnValidation = document.querySelector("#btnValidation");
	// si tous les champs sont remplis
	btnValidation.disabled = (error) ? "disabled" : "";
}

//sessionStorage.setItem("name", "Johne Doe");
//creation dans garage.js
// rafraichir page d'accueil
//constater local storage et storage

