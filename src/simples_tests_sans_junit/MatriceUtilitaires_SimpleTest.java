package simples_tests_sans_junit;

import java.util.LinkedList;
import java.util.List;

import utilitaires.MatriceUtilitaires;

public class MatriceUtilitaires_SimpleTest
{

	private static final int COEF_DANS_Z = 27;
	private static final int FACT_MULT = -9;

	// private static final int FACT_MULT = 8;

	public static void main(String[] args)
	{

		int detTemp = 0;
		int[][] matTemp = null;
		List<int[][]> listeDeMat = new LinkedList<>();

		/**
		 * Sortie pour la mat 2 X 2
		 * 
		 * <pre>
		 * Matrice 2 X 2:
		 * [1, 2]
		 * [3, 8]
		 * 
		 * getMatCofacteurs:
		 * [8, -3]
		 * [-2, 1]
		 * 
		 * getMatTranspose:
		 * [1, 3]
		 * [2, 8]
		 * 
		 * getMatTranspose de la matrice des cofacteurs:
		 * [8, -2]
		 * [-3, 1]
		 * 
		 * getMatAdjointe:
		 * [8, -2]
		 * [-3, 1]
		 * 
		 * getDeterminant: 2
		 * getDeterminantInverseHill avec 27 comme coeficient dans Z: 14
		 * 
		 * getMatMultScalaire multiplier par la constante -9
		 * [-9, -18]
		 * [-27, -72]
		 * 
		 * getMatModuloX de la matrice précédente où on applique un modulo, la constante 27
		 * [18, 9]
		 * [0, 9]
		 * </pre>
		 */
		int[][] mat2X2 =
		{
				{ 1, 2 },
				{ 3, 8 } };
		// int[][] mat2X2 = { { 10, 13 }, { 16, 21 } };

		/**
		 * Sortie pour la mat 3 X 3
		 * 
		 * <pre>
		 * Matrice 3 X 3
		 * [1, 3, 7]
		 * [2, 4, 8]
		 * [5, 0, 6]
		 * 
		 * getMatCofacteurs:
		 * [24, 28, -20]
		 * [-18, -29, 15]
		 * [-4, 6, -2]
		 * 
		 * getMatTranspose:
		 * [1, 2, 5]
		 * [3, 4, 0]
		 * [7, 8, 6]
		 * 
		 * getMatTranspose de la matrice des cofacteurs:
		 * [24, -18, -4]
		 * [28, -29, 6]
		 * [-20, 15, -2]
		 * 
		 * getMatAdjointe:
		 * [24, -18, -4]
		 * [28, -29, 6]
		 * [-20, 15, -2]
		 * 
		 * getDeterminant: -32
		 * getDeterminantInverseHill avec 27 comme coeficient dans Z: 16
		 * 
		 * getMatMultScalaire multiplier par la constante -9
		 * [-9, -27, -63]
		 * [-18, -36, -72]
		 * [-45, 0, -54]
		 * 
		 * getMatModuloX de la matrice précédente où on applique un modulo, la constante 27
		 * [18, 0, 18]
		 * [9, 18, 9]
		 * [9, 0, 0]
		 * </pre>
		 */
		int[][] mat3X3 =
		{
				{ 1, 3, 7 },
				{ 2, 4, 8 },
				{ 5, 0, 6 } };
		// int[][] mat3X3 = { { 11, 13, 17 }, { 21, 24, 28 }, { 35, 36, 39 } };

		/**
		 * Sortie pour la mat 4 X 4
		 * 
		 * <pre>
		 * Matrice 4 X 4
		 * [0, 2, 1, 0]
		 * [0, 5, 1, 1]
		 * [-1, 0, 1, 1]
		 * [3, 1, 2, 0]
		 * 
		 * getMatCofacteurs:
		 * [-10, 2, 14, -24]
		 * [3, 3, -6, 9]
		 * [-3, -3, 6, 9]
		 * [5, -1, 2, 3]
		 * 
		 * getMatTranspose:
		 * [0, 0, -1, 3]
		 * [2, 5, 0, 1]
		 * [1, 1, 1, 2]
		 * [0, 1, 1, 0]
		 * 
		 * getMatTranspose de la matrice des cofacteurs:
		 * [-10, 3, -3, 5]
		 * [2, 3, -3, -1]
		 * [14, -6, 6, 2]
		 * [-24, 9, 9, 3]
		 * 
		 * getMatAdjointe:
		 * [-10, 3, -3, 5]
		 * [2, 3, -3, -1]
		 * [14, -6, 6, 2]
		 * [-24, 9, 9, 3]
		 * 
		 * getDeterminant: 18
		 * getDeterminantInverseHill avec 27 comme coeficient dans Z: 0
		 * 
		 * getMatMultScalaire multiplier par la constante -9
		 * [0, -18, -9, 0]
		 * [0, -45, -9, -9]
		 * [9, 0, -9, -9]
		 * [-27, -9, -18, 0]
		 * 
		 * getMatModuloX de la matrice précédente où on applique un modulo, la constante 27
		 * [0, 9, 18, 0]
		 * [0, 9, 18, 18]
		 * [9, 0, 18, 18]
		 * [0, 18, 9, 0]
		 * </pre>
		 */
		int[][] mat4X4 =
		{
				{ 0, 2, 1, 0 },
				{ 0, 5, 1, 1 },
				{ -1, 0, 1, 1 },
				{ 3, 1, 2, 0 } };

		/**
		 * Sortie pour la mat 5 X 5
		 * 
		 * <pre>
		 * Matrice 5 X 5
		 * [2, 0, 0, 0, 7]
		 * [0, 9, 1, 1, 5]
		 * [-1, 0, 3, 1, 2]
		 * [3, 1, 3, 0, 0]
		 * [2, 4, 6, 7, 1]
		 * 
		 * getMatCofacteurs:
		 * [458, -333, -347, 269, 615]
		 * [-189, 582, -5, -282, 54]
		 * [-1232, -267, 1321, -678, 352]
		 * [889, 163, 797, -994, -254]
		 * [203, -45, -188, 883, -58]
		 * 
		 * getMatTranspose:
		 * [2, 0, -1, 3, 2]
		 * [0, 9, 0, 1, 4]
		 * [0, 1, 3, 3, 6]
		 * [0, 1, 1, 0, 7]
		 * [7, 5, 2, 0, 1]
		 * 
		 * getMatTranspose de la matrice des cofacteurs:
		 * [458, -189, -1232, 889, 203]
		 * [-333, 582, -267, 163, -45]
		 * [-347, -5, 1321, 797, -188]
		 * [269, -282, -678, -994, 883]
		 * [615, 54, 352, -254, -58]
		 * 
		 * getMatAdjointe:
		 * [458, -189, -1232, 889, 203]
		 * [-333, 582, -267, 163, -45]
		 * [-347, -5, 1321, 797, -188]
		 * [269, -282, -678, -994, 883]
		 * [615, 54, 352, -254, -58]
		 * 
		 * getDeterminant: 5221
		 * getDeterminantInverseHill avec 27 comme coeficient dans Z: 19
		 * 
		 * getMatMultScalaire multiplier par la constante -9
		 * [-18, 0, 0, 0, -63]
		 * [0, -81, -9, -9, -45]
		 * [9, 0, -27, -9, -18]
		 * [-27, -9, -27, 0, 0]
		 * [-18, -36, -54, -63, -9]
		 * 
		 * getMatModuloX de la matrice précédente où on applique un modulo, la constante 27
		 * [9, 0, 0, 0, 18]
		 * [0, 0, 18, 18, 9]
		 * [9, 0, 0, 18, 9]
		 * [0, 18, 0, 0, 0]
		 * [9, 18, 0, 18, 18]
		 * </pre>
		 */
		int[][] mat5X5 =
		{
				{ 2, 0, 0, 0, 7 },
				{ 0, 9, 1, 1, 5 },
				{ -1, 0, 3, 1, 2 },
				{ 3, 1, 3, 0, 0 },
				{ 2, 4, 6, 7, 1 } };
		// int[][] mat5X5 = { { 12, 14, 17, 19, 20 }, { 30, 32, 35, 37, 38 },
		// { 43, 44, 46, 47, 49 }, { 50, 51, 53, 57, 58 }, { 62, 64, 66, 67, 69
		// } };

		// Ajout des matrices dans la liste
		listeDeMat.add(mat2X2);
		listeDeMat.add(mat3X3);
		listeDeMat.add(mat4X4);
		listeDeMat.add(mat5X5);

		/**
		 * Pour toutes les matrices
		 */
		for (int[][] m : listeDeMat)
		{
			System.out.println("Matrice " + m.length + " X " + m[0].length);
			System.out.println(MatriceUtilitaires.toStringMat(m));

			System.out.println("getMatCofacteurs:");
			System.out.println(MatriceUtilitaires.toStringMat(
					matTemp = MatriceUtilitaires.getMatCofacteurs(m)));

			System.out.println("getMatTranspose:");
			System.out.println(MatriceUtilitaires
					.toStringMat(MatriceUtilitaires.getMatTranspose(m)));

			System.out.println("getMatTranspose de la matrice des cofacteurs:");
			System.out.println(MatriceUtilitaires
					.toStringMat(MatriceUtilitaires.getMatTranspose(matTemp)));

			System.out.println("getMatAdjointe:");
			System.out.println(MatriceUtilitaires
					.toStringMat(MatriceUtilitaires.getMatAdjointe(m)));

			System.out.print("getDeterminant: ");
			System.out.println(detTemp = MatriceUtilitaires.getDeterminant(m));

			System.out.print("getDeterminantInverseHill avec " + COEF_DANS_Z
					+ " comme coeficient dans Z: ");
			System.out.println(MatriceUtilitaires
					.getDeterminantInverseHill(detTemp, COEF_DANS_Z));

			System.out
					.println("\ngetMatMultScalaire multiplier par la constante "
							+ FACT_MULT);
			System.out.println(
					MatriceUtilitaires.toStringMat(matTemp = MatriceUtilitaires
							.getMatMultScalaire(m, FACT_MULT)));

			System.out.println(
					"getMatModuloX de la matrice précédente où on applique un modulo, la constante "
							+ COEF_DANS_Z);
			System.out.println(MatriceUtilitaires.toStringMat(
					MatriceUtilitaires.getMatModuloX(matTemp, COEF_DANS_Z)));
		}
	}
}
