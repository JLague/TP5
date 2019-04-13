package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import utilitaires.MathUtilitaires;
import utilitaires.MatriceUtilitaires;

public class MatriceUtilitairesTest
{
	int[][] mat, grosseMat, rectangle;

	@Before
	public void MatriceUtilitaires()
	{
		mat = new int[][]
		{
				{ 6, 1, -5 },
				{ -2, -5, 4 },
				{ -3, 3, -1 } };

		grosseMat = new int[][]
		{
				{ 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		rectangle = new int[][]
		{
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 } };
	}

	@Test
	public void testToStringMat()
	{
		// Tests visuels
		System.out.println(MatriceUtilitaires.toStringMat(mat));
		System.out.println(MatriceUtilitaires.toStringMat(grosseMat));
		System.out.println(MatriceUtilitaires.toStringMat(rectangle));
	}

	@Test
	public void testGetMatTranspose()
	{
		// Transposées manuellement
		int[][] matT = new int[][]
		{
				{ 6, -2, -3 },
				{ 1, -5, 3 },
				{ -5, 4, -1 } };

		int[][] grosseMatT = new int[][]
		{
				{ 1, 6, 11, 16, 21 },
				{ 2, 7, 12, 17, 22 },
				{ 3, 8, 13, 18, 23 },
				{ 4, 9, 14, 19, 24 },
				{ 5, 10, 15, 20, 25 } };

		int[][] rectangleT = new int[][]
		{
				{ 1, 5 },
				{ 2, 6 },
				{ 3, 7 },
				{ 4, 8 } };

		// Transposées automatiquement
		int[][] matTranspose = MatriceUtilitaires.getMatTranspose(mat);
		int[][] grosseMatTranspose = MatriceUtilitaires
				.getMatTranspose(grosseMat);
		int[][] rectangleTranspose = MatriceUtilitaires
				.getMatTranspose(rectangle);

		// Tests
		boucleTestTranspose(matT, matTranspose);
		boucleTestTranspose(grosseMatT, grosseMatTranspose);
		boucleTestTranspose(rectangleT, rectangleTranspose);
	}

	@Test
	public void testGetMatMultScalaire()
	{
		// Matrices multipliées
		int[][] matM = MatriceUtilitaires.getMatMultScalaire(mat, 5);
		int[][] grosseMatM = MatriceUtilitaires.getMatMultScalaire(grosseMat,
				-5.5f);
		int[][] rectangleM = MatriceUtilitaires.getMatMultScalaire(rectangle,
				173.432f);

		// Tests
		boucleTestMultScalaire(mat, matM, 5);
		boucleTestMultScalaire(grosseMat, grosseMatM, -5.5f);
		boucleTestMultScalaire(rectangle, rectangleM, 173.432f);
	}

	@Test
	public void testGetMatModuloX()
	{
		// Matrices avec le modulo appliqué
		int[][] matMod27 = MatriceUtilitaires.getMatModuloX(mat, 27);
		int[][] matModMoins11 = MatriceUtilitaires.getMatModuloX(mat, -11);
		int[][] rectangleMod2 = MatriceUtilitaires.getMatModuloX(rectangle, 2);

		// Tests
		boucleTestModulo(mat, matMod27, 27);
		boucleTestModulo(mat, matModMoins11, -11);
		boucleTestModulo(rectangle, rectangleMod2, 2);
	}

	/**
	 * Boucle permettant de tester la méthode getMatModuloX de
	 * MatriceUtilitaires
	 * 
	 * @param mat la matrice d'origine
	 * @param matMod la matrice avec le modulo appliqué
	 * @param mod le modulo à appliquer
	 */
	private void boucleTestModulo(int[][] mat, int[][] matMod, int mod)
	{
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[i].length; j++)
			{
				assertEquals(matMod[i][j],
						MathUtilitaires.modulo(mat[i][j], mod));
			}
		}
	}

	/**
	 * Boucle permettant de tester la méthode getMatTranspose de
	 * MatriceUtilitaires
	 * 
	 * @param mat1 première matrice transposée
	 * @param mat2 deuxième matrice transposée
	 */
	private void boucleTestTranspose(int[][] mat1, int[][] mat2)
	{
		for (int i = 0; i < mat1.length; i++)
		{
			for (int j = 0; j < mat1[i].length; j++)
			{
				assertEquals(mat1[i][j], mat2[i][j]);
			}
		}
	}

	/**
	 * Boucle permettant de tester la méthode getMatMultScalaire de la classe
	 * MatriceUtilitaires
	 * 
	 * @param mat la matrice d'origine
	 * @param matM la matrice multipliée par un scalaire
	 * @param scalaire le nombre avec lequel multiplier la matrice
	 */
	private void boucleTestMultScalaire(int[][] mat, int[][] matM,
			float scalaire)
	{
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[i].length; j++)
			{
				assertTrue(matM[i][j] == Math.floor(mat[i][j] * scalaire));
			}
		}
	}

}
