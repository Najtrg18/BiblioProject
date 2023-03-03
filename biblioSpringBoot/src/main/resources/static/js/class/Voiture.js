/**
 * 
 */

class Voiture extends Vehicule {

	static marquesVoitures = ['ALFA', 'FERRARI', 'FIAT', 'YAMAHA', 'LANCIA'];
	/**
	* construsteur par params
	*/
	constructor(id, marque, modele, couleur, immatriculation, nbrPortes, dateControlTechnique) {
		super(id, marque, modele, couleur, immatriculation, dateControlTechnique);
		this.nbrPortes = nbrPortes;
	}
}