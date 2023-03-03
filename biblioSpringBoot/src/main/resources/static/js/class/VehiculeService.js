/**
 * 
 */

class VehiculeService {

	/**
	* construsteur par params
	*/
	constructor(type, urlWebService) {
		this.type = type;
		this.urlWebService = urlWebService;
		this.vehicules = [];
	}

	/**
	 * recuperation depuis le web service
	 */
	findAllAjax() {
		let that = this;
		return new Promise(function(resolve, reject) {
			const xhttp = new XMLHttpRequest();
			// declaration de la callback au retour de la requete
			xhttp.onload = function() {
				//that.vehicules = JSON.parse(this.responseText);
				//afficherMotos(that.vehicules);
				if (xhttp.status == 200) {
					resolve(JSON.parse(this.responseText)); // on recupere une promesse, pas un tableau
				} else {
					reject("erreur sur Ajax " + that.type);
				}
			}
			// preparation de la requete
			xhttp.open("GET", that.urlWebService + that.type, true);
			//appel de la requet ajax
			xhttp.send();
			//maintenir l'ordre de onlad, open et send
		});
	}

	saveAjax(vehicule) {
		let that = this;
		return new Promise(function(resolve, reject) {
			const xhttp = new XMLHttpRequest();
			// declaration de la callback au retour de la requete
			xhttp.onload = function() {
				//that.vehicules = JSON.parse(this.responseText);
				//afficherMotos(that.vehicules);
				if (xhttp.status == 200) {
					resolve(JSON.parse(this.responseText)); // on recupere une promesse, pas un tableau
				} else {
					reject("erreur sur Ajax " + that.type);
				}
			}
			// preparation de la requete
			xhttp.open("POST", that.urlWebService + that.type, true);
			xhttp.setRequestHeader("Content-Type","application/json");
			xhttp.setRequestHeader("Accept","application/json");
			//appel de la requet ajax
			xhttp.send(JSON.stringify(vehicule));
			//maintenir l'ordre de onlad, open et send
		});
	}
	
		validerCTAjax(ids) {
		let that = this;
		return new Promise(function(resolve, reject) {
			const xhttp = new XMLHttpRequest();
			// declaration de la callback au retour de la requete
			xhttp.onload = function() {
				//that.vehicules = JSON.parse(this.responseText);
				//afficherMotos(that.vehicules);
				if (xhttp.status == 200) {
					resolve(JSON.parse(this.responseText)); // on recupere une promesse, pas un tableau
				}
				if (xhttp.status == 404) {
					// und es voitures n'a pa ete trouvee
					reject(JSON.parse(this.responseText));
				}
				else {
					reject("erreur validerCT Ajax sur " + that.type);
				}
			}
			// preparation de la requete
			xhttp.open("PUT", that.urlWebService + that.type + "/validerCT", true);
			xhttp.setRequestHeader("Content-Type","application/json");
			xhttp.setRequestHeader("Accept","application/json");
			//appel de la requet ajax
			xhttp.send(JSON.stringify(ids));
			//maintenir l'ordre de onlad, open et send
		});
	}

	// stockage en local sur le poste de l'internaute
	saveStorage() {
		localStorage.setItem(this.type, JSON.stringify(this.vehicules));
	}

	// recuperation en local sur le poste de l'internaute
	loadStorage() {
		this.vehicules = JSON.parse(localStorage.getItem(this.type));
	}


}