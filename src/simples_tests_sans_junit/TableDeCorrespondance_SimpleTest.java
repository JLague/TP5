package simples_tests_sans_junit;

import structures.*;

public class TableDeCorrespondance_SimpleTest
{
	public static final char[] TAB_CHAR =
	{ '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	public static void main(String[] args)
	{
		System.out.println("Construction avec paramètre:");
		VecteurDeCaracteres tdc = new VecteurDeCaracteres(TAB_CHAR);
		System.out.println(tdc);

		System.out.println("\nConstruction sans paramètre:");
		tdc = new VecteurDeCaracteres();
		System.out.println(tdc);

		System.out.println("\nBoucle pour l'indice selon le caractère ...");
		for (char c = 'A'; c <= 'Z'; c++)
		{
			System.out.print(tdc.getIndice(c) + ", ");
		}
		System.out.print(tdc.getIndice(' ') + ", ");
		System.out.print(tdc.getIndice('-'));

		System.out.println();

		System.out.println("\nBoucle pour le caractère selon l'indice ...");
		for (int i = 0; i < tdc.getTaille(); i++)
		{
			System.out.print(tdc.getCaractere(i) + ", ");
		}
	}

	/**
	 * Sortie selon les valeurs d'origine
	 * 
	 * <pre>
	 *     Construction avec paramètre:
	 * TableDeCorrespondance = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
	 * 
	 * Construction sans paramètre:
	 * TableDeCorrespondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]
	 * 
	 * Boucle pour l'indice selon le caractère ...
	 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27
	 * 
	 * Boucle pour le caractère selon l'indice ...
	 * A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -,
	 * </pre>
	 */
}
