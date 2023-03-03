package com.m2i.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author najwa
 * 
 */
public class HelloWorld {

	/**
	 * 
	 * @param args liste des params
	 */

	public static void main(String[] args) {

		// int x = 0;
		// Integer i = null;
		// Float f = 1.2f;
		// i.MAX_VALUE;
		// testValueVariables();
		// displayTwoVariables();
		// switchValues();
		// computeSpeed();
		// computeSpeed(null, null);
		// int a = 4;
		// int test = ifNull(3, a);
		// System.out.println("test = " + test);

		// findMonth();
		// int i = 4;
		// testIfSwitch(i);
		// addInteger(result, 2);
		// Integer time = null;
		// time = calculerTempsDeCuisson(400, 1, 3);
		// time = calculerTempsDeCuissonBis(400, 1, 1);
		// CalculerVitesseCuisson();
		// System.out.println(time);
		// calculerMoyenneBis();
		// calculerMoyenneTer();
		// devineNombre();
		Integer resultat = fact(4);
		System.out.println(resultat);
	}

	/**
	 * 
	 * test si entier est null, si oui retourne valDef sinon retourne entier
	 * 
	 * @param entier l entier a tester
	 * @param valDef val de retour au cas ou c est null
	 * @return valeur retournee
	 * 
	 */
	public static Integer ifNull(Integer entier, Integer valDef) {
		// variable result : entier, initialise avec valeur valDef
		Integer result = valDef;
		if (entier != null) {
			// si entier non null, result devient entier
			result = entier;
		}
		return result;
	}

	public static Integer ifNullS(Integer entier, Integer valDef) {
		// variable result : entier, initialise avec valeur valDef
		return (entier == null) ? valDef : entier;
	}

	/**
	 * This method tests values of variables
	 */
	private static void testValueVariables() {

		// Algo ValeursDesVariables
		// variable a, b : entier
		int a, b;
		// Début
		// a <- 3
		a = 3;
		// écrire("a = " & a)
		System.out.println("a = " + a);
		// b<-a+5
		b = a + 5;
		// écrire("a = " & a & " et b = " & b)
		System.out.println("a = " + a + " et b = " + b);
		// a<-7
		a = 7;
		// écrire("a = " & a & " et b = " & b)
		System.out.println("a = " + a + " et b = " + b);
		// Fin

	}

	/**
	 * This method tests values of variables based on value entered manualler by
	 * user
	 */
	private static void testValueVariablesEntered() {

		try (// Algo ValeursDesVariables
				// variable a, b : entier
				Scanner sc = new Scanner(System.in)) {
			int a;
			int b;
			// Début
			// entrer la valeur de a
			System.out.println("Saisir la valeur de a ?");
			a = sc.nextInt();
			// écrire("a = " & a)
			System.out.println("a = " + a);
			// entrer la valeur de b
			System.out.println("Saisir la valeur de b ?");
			b = sc.nextInt();
			// écrire("a = " & a & " et b = " & b)
			System.out.println("a = " + a + " et b = " + b);
			// a<-7
			a = 7;
			// écrire("a = " & a & " et b = " & b)
			System.out.println("a = " + a + " et b = " + b);
			// Fin
		}

	}

	/**
	 * This method displays values of 2 variables
	 */
	private static void displayTwoVariables() {

		// Algo QuelsAffichages
		// Quels affichages produit cet algorithme ?
		// Variable valeur1, valeur2 : entier
		int valeur1, valeur2;
		// Variable chaine1 : texte
		String chaine1;
		// Constante CST : réel <- 49,78
		final double CST = 49.78;
		// Début
		// valeur1 <- 92 % 8
		valeur1 = 92 % 8;
		// valeur2 <- 2 * valeur1
		valeur2 = 2 * valeur1;
		// chaine1 <- "Test"
		chaine1 = "Test";
		// écrire(chaine1 & " , valeur2 = " & valeur2)
		System.out.println(chaine1 + " , valeur2 = " + valeur2);
		// écrire(valeur1 & " # " & CST)
		System.out.println(valeur1 + " # " + CST);
		// Fin

	}

	/**
	 * This method affects second value to both values
	 */
	private static void switchValues() {
		// Algo IlFaitQuoi
		// # Que réalise cet algorithme ?
		// Variable valeur1, valeur2 : réel
		double valeur1, valeur2;
		try (Scanner sc = new Scanner(System.in)) {
			// Début
			// valeur1 <- saisir("Entrez valeur : ")
			System.out.println("Entrez valeur : ");
			valeur1 = sc.nextDouble();
			// valeur2 <- saisir("Entrez autre valeur : ")
			System.out.println("Entrez autre valeur : ");
			valeur2 = sc.nextDouble();
		}
		// # traitement
		// valeur1 <- valeur2
		valeur1 = valeur2;
		// valeur2 <- valeur1
		valeur2 = valeur1;
		// écrire("valeur1 = " & valeur1 & "; valeur2 = " & valeur2)
		System.out.println("valeur1 = " + valeur1 + "; valeur2 = " + valeur2);
		// Fin
	}

	/**
	 * This method computes the speed in km/h from the distance in km and time in
	 * min.
	 */
	private static void computeSpeed() {
		// Algo VitesseMoyenne
		// # Quelle est la Vitesse Moyenne ?
		// Variable distance, temps : entier
		int distanceKm, tempsMin;
		// Variable vitesse : reel
		double vitesseKmH;
		// Constante CST : entier <- 60
		final int HEURE = 60; // 60 min dans une heure
		Scanner scanner = new Scanner(System.in);
		// Debut
		// distance <- saisir(“Saisissez la distance parcourue (km). ”)
		System.out.println("Saisissez la distance parcourue (km).");
		distanceKm = scanner.nextInt();
		// temps <- saisir(“Saisissez le temps de parcours (min). ”)
		System.out.println("Saisissez le temps de parcours (min).");
		tempsMin = scanner.nextInt();
		// # traitement
		// vitesse <- distance / (temps / CST)
		vitesseKmH = distanceKm / (tempsMin / HEURE);
		// Ecrire(“vous vous etes deplace a une Vitesse de “ & vitesse & “ km/h.”)
		System.out.println("vous vous etes deplace a une Vitesse de " + vitesseKmH + " km/h.");
		// Fin
	}

	/**
	 * This method computes the speed in km/h from the distance in km and time in
	 * min.
	 */
	private static void computeSpeed(Integer distanceKm, Integer tempsMin) {
		// Algo VitesseMoyenne
		// Variable vitesse : reel
		double vitesseKmH;
		// Constante CST : entier <- 60
		final int HEURE = 60; // 60 min dans une heure
		Scanner scanner = new Scanner(System.in);
		// Debut
		while (distanceKm == null || distanceKm < 0) {
			// distance <- saisir(“Saisissez la distance parcourue (km). ”)
			System.out.println("Saisissez la distance parcourue (km). Un nombre positif.");
			distanceKm = scanner.nextInt();
		}
		while (tempsMin == null || tempsMin <= 0) {
			// temps <- saisir(“Saisissez le temps de parcours (min). ”)
			System.out.println("Saisissez le temps de parcours (min). Un nombre strictement positif.");
			tempsMin = scanner.nextInt();
		}
		// # traitement
		// vitesse <- distance / (temps / CST)
		vitesseKmH = (distanceKm * HEURE) / tempsMin;
		// Ecrire(“vous vous etes deplace a une Vitesse de “ & vitesse & “ km/h.”)
		System.out.println("vous vous etes deplace a une Vitesse de " + vitesseKmH + " km/h.");
		// Fin
	}

	/**
	 * This method takes one operand and determine if odd or even number
	 * 
	 * @param i operand of type integer
	 */
	private static void testIfSwitch(int i) {

		if (i == 4) {
			System.out.println("that is " + i);
		} else if (i == 5) {
			System.out.println("that is " + i);
		} else if (i == 7) {
			System.out.println("that is " + i);
		} else {
			System.out.println("that is something else");
		} // limiter a 3 if

		switch (i) { // palier aux limites de if
		case 4:
			System.out.println("that is " + i);
			break;
		case 5:
			System.out.println("that is " + i);
			break;
		case 7:
			System.out.println("that is " + i);
			break;
		default:
			System.out.println("that is something else");
			break;
		}

		switch (i) { // palier aux limites de if
		case 2:
		case 4:
		case 6:
		case 8:
			System.out.println("even number " + i);
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
			System.out.println("odd number " + i);
			break;
		default:
			System.out.println("that is something else");
			break;
		}

		if (i == 0 || i == 2 || i == 4 || i == 6 || i == 8) {
			System.out.println("even number " + i);
		} else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
			System.out.println("odd number " + i);
		} else {
			System.out.println("that is something else");
		}
	}

	/**
	 * This method takes two operands and return their sum
	 * 
	 * @param a operand of type integer ex. 1
	 * @param b second operand of type integer ex. 3
	 * @return return sum of operands
	 */

	private static int addInteger(int a, int b) {
		// declaration
		int result;

		// computation a+b
		result = a + b;

		// display of result
		return result;

	}

	/**
	 * This method tests the risk of verglas
	 * 
	 */
	public static void testVerglas() {
		// Algo Test verglas risk
		int tempCel;
		Scanner scanner = new Scanner(System.in);
		// Debut
		// tempCel <- saisir(“Saisissez la temperature (en degres). ”)
		System.out.println("Saisissez la temperature (en degres).");
		tempCel = scanner.nextInt();
		// Test if temperature below -2
		if (tempCel <= -2) {
			// Return message of warning
			System.out.println("risque de verglas ");
		} else {
			System.out.println("aucun risque de verglas ");
		}
		// close scanner
		scanner.close();
	}

	/**
	 * This method tests the risk of verglas - more detailed
	 * 
	 */
	public static void testVerglasDetailed() {
		// Algo Test verglas risk
		int tempCel;
		Scanner scanner = new Scanner(System.in);
		// Debut
		// tempCel <- enter temperature in Celsius
		System.out.println("Saisissez la temperature (en degres).");
		tempCel = scanner.nextInt();
		// Test of temperature and provide message accordingly
		if (tempCel < -2) {
			// Return message of warning
			System.out.println("Risque de verglas ");
		} else if (tempCel >= -2 && tempCel < 15) {
			System.out.println("C'est pas chaud");
		} else if (tempCel >= 15 && tempCel < 30) {
			System.out.println("Bonne température");
		} else {
			System.out.println("Trop chaud");
		}
		// close scanner
		scanner.close();
	}

	/**
	 * This method asks to enter a month in full letter and convert to the
	 * associated number
	 * 
	 */
	private static void findMonth() {

		Scanner scanner = new Scanner(System.in);
		// month <- enter month in alphabetical letter
		System.out.println("Saisissez le mois en nombre");
		int month = scanner.nextInt();

		switch (month) { // palier aux limites de if
		case 1:
			System.out.println("Janvier");
			break;
		case 2:
			System.out.println("Fevrier");
			break;
		case 3:
			System.out.println("Mars");
			break;
		case 4:
			System.out.println("Avril");
			break;
		case 5:
			System.out.println("Mai");
			break;
		case 6:
			System.out.println("Juin");
			break;
		case 7:
			System.out.println("Juillet");
			break;
		case 8:
			System.out.println("Aout");
			break;
		case 9:
			System.out.println("Septembre");
			break;
		case 10:
			System.out.println("Octobre");
			break;
		case 11:
			System.out.println("Novembre");
			break;
		case 12:
			System.out.println("Decembre");
			break;
		default:
			System.out.println("vous n'avez pas saisi de chiffre correspondant à un mois connu");
			break;
		}
	}

	/**
	 * Calculate the cooking time based on type of meat, cooking type and weight
	 */
	private static void calculateCookingTime() {
		// Variable typeViande, modeCuisson, poidsG : entier
		int typeViande, modeCuisson, poidsG;
		// Constante SECONDES : secondes <- 60
		double tempsCuisson;
		double i = 0;
		final double PERC_11 = 10 / 500;
		final double PERC_12 = 17 / 500;
		final double PERC_13 = 25 / 500;
		final double PERC_21 = 15 / 400f;
		final double PERC_22 = 25 / 400f;
		final double PERC_23 = 40 / 400f;
		final int SECONDES = 60; // 60 sec dans une minute
		Scanner scanner = new Scanner(System.in);
		// Debut
		// typeViande <- saisir(“Saisissez type de la viande - 1 pour boeuf ou 2 pour
		// agneau ”)
		System.out.println("Saisissez type de la viande - 1 pour boeuf ou 2 pour agneau :");
		typeViande = scanner.nextInt();
		// temps <- saisir(“Saisissez le mode de cuisson et poids de la viande - 1 pour
		// bleu, 2 pour à point ou 3 pour bien cuit”)
		System.out.println(
				"Saisissez le mode de cuisson et poids de la viande - 1 pour bleu, 2 pour à point ou 3 pour bien cuit :");
		modeCuisson = scanner.nextInt();
		// temps <- saisir(“Saisissez le poids en gramme :”)
		System.out.println("Saisissez le poids en gramme :");
		poidsG = scanner.nextInt();
		// # traitement
		switch (typeViande) {
		case 1:
			switch (modeCuisson) {
			case 1:
				i = PERC_11;
				break;
			case 2:
				i = PERC_12;
				break;
			case 3:
				i = PERC_13;
				break;
			default:
				System.out.println("saisie incomprise");
				break;
			}
			break;
		case 2:
			switch (modeCuisson) {
			case 1:
				i = PERC_21;
				break;
			case 2:
				i = PERC_22;
				break;
			case 3:
				i = PERC_23;
				break;
			default:
				System.out.println("mode cuisson incompris");
				break;
			}
			break;
		default:
			System.out.println("type viande incompris");
			break;
		}
		// tempsCuisson <- perc * poidsG * SECONDES
		tempsCuisson = i * poidsG * SECONDES;
		// Ecrire(“vous vous etes deplace a une Vitesse de “ & vitesse & “ km/h.”)
		System.out.println("Le temps de cuisson de la viande en secondes : " + tempsCuisson + " secondes.");

		// close scanner
		scanner.close();
		// Fin
	}

	/**
	 * Calculer le temps de cuisson d'une viande en fonction du type et de son poids
	 * 
	 * @param poids         en grammes
	 * @param typeDeViande  (1 pour boeuf et 2 pour agneau)
	 * @param typeDeCuisson (1 pour bleu 2 pour a point 3 pour bien cuit)
	 * @return temps de cuisson ex 600 secondes
	 */
	public static Integer calculerTempsDeCuisson(Integer poids, Integer typeDeViande, Integer typeDeCuisson) {
		Float tempsDeCuisson = null; // temps de cuisson en sec
		// tester type de viande
		switch (typeDeViande) {
		// si typeDeViande == 1
		// alors boeuf
		case 1:
			// tester le type de cuisson
			switch (typeDeCuisson) {
			// si typeDeCuisson == 1
			// alors cuisson bleu
			case 1:
				// temps de cuisson = poids/500 * 10
				tempsDeCuisson = (poids / 500f) * 10;
				break;
			// sinon si typeDeCuisson == 2
			// alors cuisson a point
			case 2:
				// temps de cuisson = poids/500 * 17
				tempsDeCuisson = poids / 500f * 17;
				break;
			// sinon typeDeCuisson == 3
			// alors cuisson bien cuit
			case 3:
				// temps de cuisson = poids/500 * 25
				tempsDeCuisson = poids / 500f * 25;
				break;
			// cas non listé de mode de cuisson
			default:
				System.out.println("mode cuisson incompris");
				break;
			}
			break;
		// si typeDeViande == 2
		// alors agneau
		case 2:
			// tester le type de cuisson
			switch (typeDeCuisson) {
			// si typeDeCuisson == 1
			// alors cuisson bleu
			case 1:
				// temps de cuisson = poids/400f * 15
				tempsDeCuisson = poids / 400f * 15;
				break;
			// sinon si typeDeCuisson == 2
			// alors cuisson a point
			case 2:
				// temps de cuisson = poids/400f * 25
				tempsDeCuisson = poids / 400f * 25;
				break;
			// sinon typeDeCuisson == 3
			// alors cuisson bien cuit
			case 3:
				// temps de cuisson = poids/400f * 40
				tempsDeCuisson = poids / 400f * 40;
				break;
			// cas non listé de mode de cuisson
			default:
				System.out.println("mode cuisson incompris");
				break;
			}
			break;
		// cas non listé de type de viande
		default:
			System.out.println("type viande incompris");
			break;
		}
		tempsDeCuisson *= 60;
		// ecrit la valeur du temps de cuisson
		System.out.println("Le temps de cuisson de la viande en secondes : " + tempsDeCuisson + " secondes.");

		return tempsDeCuisson.intValue();
	}

	public static Integer calculerTempsDeCuissonBis(Integer poids, Integer typeDeViande, Integer typeDeCuisson) {

		// temps de cuisson en sec

		Float tempsDeCuisson = 0f;

		// tester type de viande

		// si typeDeViande == 1

		if (typeDeViande == 1) {

			// alors boeuf

			// tester le type de cuisson

			// si typeDeCuisson == 1

			if (typeDeCuisson == 1) {

				// alors cuisson bleu

				// temps de cuisson = poids/500 * 10

				tempsDeCuisson = (poids / 500f) * 10;

			}

			// sinon si typeDeCuisson == 2

			else if (typeDeCuisson == 2) {

				// alors cuisson a point

				// temps de cuisson = poids/500 * 17

				tempsDeCuisson = (poids / 500f) * 17;

			}

			// sinon typeDeCuisson == 3

			else if (typeDeCuisson == 3) {

				// alors cuisson bien cuit

				// temps de cuisson = poids/500 * 25

				tempsDeCuisson = (poids / 500f) * 25;

			}

		}

		// si typeDeViande == 2

		else if (typeDeViande == 2) {

			// alors agneau

			// tester le type de cuisson

			// si typeDeCuisson == 1

			if (typeDeCuisson == 1) {

				// alors cuisson bleu

				// temps de cuisson = poids/400f * 15

				tempsDeCuisson = (poids / 400f) * 15;

			}

			// sinon si typeDeCuisson == 2

			else if (typeDeCuisson == 2) {

				// alors cuisson a point

				// temps de cuisson = poids/400f * 25

				tempsDeCuisson = (poids / 400f) * 25;

			}

			// sinon typeDeCuisson == 3

			else if (typeDeCuisson == 3) {

				// alors cuisson bien cuit

				// temps de cuisson = poids/400f * 40

				tempsDeCuisson = (poids / 400f) * 40;

			}

		}

		// retourne le temps de cuisson en sec

		tempsDeCuisson = tempsDeCuisson * 60;

		return tempsDeCuisson.intValue();

	}

	private static void CalculerVitesseCuisson() {

		Integer[] tempsCuissonBoeuf = { 10, 17, 25 }; // creation d'un tableau
		Integer[] tempsCuissonAgneau = { 10, 17, 25 };

		List tableau = new ArrayList<>(2); // declaration d'un tableau de capacite 2, mais java alloue de la memoire
		tableau.add(10);
		tableau.add(17);
		tableau.add(25);

		// collections -

		Integer[][] typeViandes = { tempsCuissonBoeuf, tempsCuissonAgneau };

		System.out.println(typeViandes[0][0]);
	}

	private static void calculerVitesseCuisson(Integer typeViande, Integer poids, Integer typeCuisson) {

		Integer[] tempsCuissonBoeuf = { 10, 17, 25 }; // creation d' un tableau
		Integer[] tempsCuissonAgneau = { 15, 25 }; // creation d' un tableau
		Float tempsCuisson;

		Integer[][] typeViandes = { tempsCuissonBoeuf, tempsCuissonAgneau, { 1, 3, 6 } };

		tempsCuisson = (poids / 500f) * typeViandes[typeViande][typeCuisson] * 60;

		System.out.println(tempsCuisson);

		System.out.println(typeViandes);

		for (int i = 0; i < typeViandes.length; i++) {
			for (int j = 0; j < typeViandes[i].length; j++) {
				System.out.println(typeViandes[i][j]);
			}
		}

		int a = 0;
		int b = 0;
		// Debut
		while (a < typeViandes.length) {
			// distance <- saisir(“Saisissez la distance parcourue (km). ”)
			while (b < typeViandes.length) {
				System.out.println(typeViandes[a][b]);
				b++;
			}
			a++;

		}
	}

	/**
	 * Calculer la moyenne des notes saisies
	 */
	private static void calculerMoyenne() {
		// Debut
		// Declarations
		Scanner scanner = new Scanner(System.in);
		// entier nombre des notes à saisir
		int nbNotes;
		// float sommeNotes
		Float sommeNotes = 0f;
		// float moyenne
		Float moyenne;
		// Saiside du nombre de notes
		System.out.println("Entrez le nombre de notes :");
		nbNotes = scanner.nextInt();
		// Saisie des notes avec une boucle Pour avec i allant de 0 à nbNote
		for (int i = 0; i < nbNotes; i++) {
			// Demande de note
			System.out.println("Note :");
			sommeNotes += scanner.nextFloat();
		}
		// Calcul de la moyenne
		// moyenne = sommeNotes / nbNotes
		moyenne = sommeNotes / nbNotes;
		// afficher la moyenne
		System.out.println("La moyenne est :" + moyenne);
	}

	/**
	 * Calculer la moyenne des notes saisies
	 */
	private static void calculerMoyenneBis() {
		// Debut
		// Declarations
		Scanner scanner = new Scanner(System.in);
		// float sommeNotes
		Float sommeNotes = 0f;
		// float note
		Float note = 0f;
		// float moyenne
		Float moyenne;
		// int nbNote
		int nbNotes = 0;
		// Saisie première valeure
		System.out.println("Note (-1 pour terminer) ?");
		note = scanner.nextFloat();
		// Saisie des notes avec une boucle Pour avec i allant de 0 à la saisie de note
		// = -1
		while (note != -1) {
			// incremente nbNotes
			nbNotes++;
			// ajout note à la somme
			sommeNotes += note;
			// Saisie prochaine note
			System.out.println("Note (-1 pour terminer) ?");
			note = scanner.nextFloat();
		}
		// Calcul de la moyenne
		// moyenne = sommeNotes / nbNotes
		moyenne = sommeNotes / nbNotes;
		// afficher la moyenne
		System.out.println("La moyenne est :" + moyenne);
	}

	/**
	 * Calculer la moyenne des notes saisies
	 */
	private static void calculerMoyenneTer() {
		// Debut
		// Declarations
		Scanner scanner = new Scanner(System.in);
		// float sommeNotes
		Float sommeNotes = 0f;
		// float note
		Float note = null;
		// float moyenne
		Float moyenne = null;
		// float pourcentage notes sup à 10
		int pourcentage;
		// int nbNote totales
		int nbNotes = 0;
		// int nbNote positives
		int nbNotesPos = 0;
		// Saisie première valeure
		System.out.println("Note (-1 pour terminer) ?");
		note = scanner.nextFloat();
		// Saisie des notes avec une boucle Pour avec i allant de 0 à la saisie de note
		// = -1
		while (note != -1) {
			// on incremente nbNotes++
			nbNotes++;
			// on ajoute note à sommeNotes
			sommeNotes += note;
			// si note sup à 10, ajout à nbNotesPos
			if (note >= 10) {
				nbNotesPos++;
			}
			// Saisie prochaine note
			System.out.println("Note (-1 pour terminer) ?");
			note = scanner.nextFloat();
		}
		// cas où utilisateur a saisi aucune note
		if (nbNotes != 0) {
			// Calcul de la moyenne
			// moyenne = sommeNotes / nbNotes
			moyenne = sommeNotes / nbNotes;
			// Calcul pourcentage de notes positives
			pourcentage = (nbNotesPos * 100) / nbNotes;
			// afficher la moyenne et le pourcentage
			System.out.println("La moyenne est :" + moyenne + " (" + pourcentage + "% >=10)");
		}
	}

	/**
	 * Devinez un nombre entier aléatoirement compris entre 1 et 100. L’utilisateur
	 * doit trouver ce nombre. Pour cela, à chaque tentative de l’utilisateur, un
	 * indice lui est donné pour lui indiquer si le nombre est plus grand, plus
	 * petit ou égal à la valeur essayée. Le programme se termine lorsque
	 * l’utilisateur a trouvé le nombre.
	 */
	private static void devineNombre() {
		// Debut
		// Declarations
		Scanner scanner = new Scanner(System.in);
		// nb tire aleatoirement
		Random r = new Random();
		Integer nbADev = r.nextInt(101);
		// int nb saisi
		Integer nbSaisi = null;
		// Saisie première valeure
		System.out.println("À quel nombre entre 1 et 100 je pense ?");
		// Saisie des nombres jusqu'a obtenir le nb à deviner
		do {
			nbSaisi = scanner.nextInt();
			// comparaison des 2 valeurs
			if (nbSaisi > nbADev) {
				System.out.println("C’est moins !");
			} else if (nbSaisi < nbADev) {
				System.out.println("C’est plus !");
			}
		} while (nbSaisi != nbADev);
		// afficher la reussite
		System.out.println("Bravo ! Vous avez trouvé !");
	}

	/**
	 * cette methode renvoit le fact de n N! = n*n(n-1)...*(1)
	 * 
	 * @param nombre
	 * @return
	 */
	public static Integer fact(Integer nombre) {
		if (nombre != 1) {
			return nombre * fact(nombre - 1);
		} else {
			return 1;
		}
	}

	/**
	 * cette methode renvoit le fact de n N! = n*n(n-1)...*(1)
	 * 
	 * @param nombre
	 * @return
	 */
	public static Integer factBoucle(Integer nombre) {
		Integer resultat = 1;
		for (int i = 2; i <= nombre; i++) {
			resultat = resultat * i;
		}
		return resultat;
	}

}