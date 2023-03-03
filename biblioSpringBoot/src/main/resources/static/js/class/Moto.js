/**
 * 
 */

class Moto extends Vehicule {

	static marquesMoto = ['ALFA', 'FERRARI', 'FIAT', 'YAMAHA', 'LANCIA'];
	/**
	* construsteur par params
	*/
	constructor(id, marque, modele, couleur, immatriculation, isBequille, dateControlTechnique) {
		super(id, marque, modele, couleur, immatriculation, dateControlTechnique);
		this.isBequille = isBequille;
	}
}