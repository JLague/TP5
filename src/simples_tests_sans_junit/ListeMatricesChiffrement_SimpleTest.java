package simples_tests_sans_junit;

import structures.ListeMatricesChiffrement;
import utilitaires.MatriceUtilitaires;

public class ListeMatricesChiffrement_SimpleTest
{
	private static final int MIN = 1;
	private static final int MAX = 20;
	private static final int DIM_MATRICE = 3;
	private static final int COEFFICIENT_DANS_Z = 28;

	public static void main(String[] args)
	{
		ListeMatricesChiffrement mc = new ListeMatricesChiffrement(MIN, MAX,
				DIM_MATRICE, COEFFICIENT_DANS_Z);

		System.out.println(
				"Les méthodes sur l'objet ListeMatricesChiffrement ...");
		System.out.println("getBorneInf : " + mc.getBorneInf());
		System.out.println("getBorneSup : " + mc.getBorneSup());
		System.out.println("getCoefDansZ : " + mc.getCoefDansZ());
		System.out.println("getDimension : " + mc.getDimension());
		System.out.println(
				"getNombreMatrices : " + mc.getNombreMatricesCandidates());
		mc.choisirMatriceCourante(6);
		System.out.println("getMatriceCourante : \n"
				+ MatriceUtilitaires.toStringMat(mc.getCopieMatriceCourante()));
		System.out.println(
				"getMatriceCouranteInverseHill : \n" + MatriceUtilitaires
						.toStringMat(mc.getMatriceCouranteInverseHill()));
/*
		System.out.println(
				"Boucle pour voir le PGCD de chaque matrice candidate avec le coefficient dans Z, devrait toujours être = 1 ...");
		for (int i = 0; i < mc.getNombreMatricesCandidates(); i++)
		{
			mc.choisirMatriceCourante(i);
			System.out.print("[mat " + i + " : "
					+ MathUtilitaires.PGCD(
							MatriceUtilitaires.getDeterminant(
									mc.getCopieMatriceCourante()),
							COEFFICIENT_DANS_Z)
					+ "], ");
		}
*/
		System.out.println(
				"\n\nBoucle pour voir 4 matrices ou moins de l'ensemble au hasard ...");
		for (int i = 0; i < ((4 <= mc.getNombreMatricesCandidates()) ? 4
				: mc.getNombreMatricesCandidates()); i++)
		{
			mc.choisirMatriceCourante();
			System.out.println("getMatriceCourante : \n" + MatriceUtilitaires
					.toStringMat(mc.getCopieMatriceCourante()));
			System.out.println(
					"getMatriceCouranteInverseHill : \n" + MatriceUtilitaires
							.toStringMat(mc.getMatriceCouranteInverseHill()));
		}
	}

	/**
	 * Sortie selon les valeurs d'origine
	 * 
	 * <pre>
	 * Les méthodes sur l'objet ListeMatricesChiffrement ...
	 * getBorneInf : 4
	 * getBorneSup : 14
	 * getCoefDansZ : 28
	 * getDimension : 3
	 * getNombreMatrices : 14
	 * getMatriceCourante : 
	 * [4, 5, 7]
	 * [9, 10, 11]
	 * [12, 13, 14]
	 * 
	 * getMatriceCouranteInverseHill : 
	 * [1, 21, 5]
	 * [26, 0, 3]
	 * [1, 16, 11]
	 * 
	 * Boucle pour voir le PGCD de chaque matrices candidates avec le coefficient dans Z, devrait toujours être = 1 ...
	 * [mat 0 : 1], [mat 1 : 1], [mat 2 : 1], [mat 3 : 1], [mat 4 : 1], [mat 5 : 1], [mat 6 : 1], [mat 7 : 1], [mat 8 : 1], [mat 9 : 1], [mat 10 : 1], [mat 11 : 1], [mat 12 : 1], [mat 13 : 1], 
	 * 
	 * Boucle pour voir 4 matrices ou moins de l'ensemble au hasard ...
	 * getMatriceCourante : 
	 * [4, 5, 7]
	 * [8, 9, 10]
	 * [11, 13, 14]
	 * 
	 * getMatriceCouranteInverseHill : 
	 * [12, 21, 11]
	 * [6, 7, 8]
	 * [13, 19, 12]
	 * 
	 * getMatriceCourante : 
	 * [5, 6, 7]
	 * [8, 9, 10]
	 * [11, 13, 14]
	 * 
	 * getMatriceCouranteInverseHill : 
	 * [8, 21, 27]
	 * [18, 7, 2]
	 * [11, 19, 27]
	 * 
	 * getMatriceCourante : 
	 * [4, 6, 7]
	 * [8, 9, 10]
	 * [11, 12, 14]
	 * 
	 * getMatriceCouranteInverseHill : 
	 * [18, 0, 19]
	 * [22, 21, 20]
	 * [19, 26, 20]
	 * 
	 * getMatriceCourante : 
	 * [4, 5, 6]
	 * [7, 8, 9]
	 * [11, 13, 14]
	 * 
	 * getMatriceCouranteInverseHill : 
	 * [17, 12, 27]
	 * [19, 6, 2]
	 * [1, 1, 27]
	 * 
	 * </pre>
	 */
}
