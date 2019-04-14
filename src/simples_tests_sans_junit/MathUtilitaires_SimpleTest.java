package simples_tests_sans_junit;

import java.util.SortedSet;
import utilitaires.MathUtilitaires;

/**
 * @author jocelyn.goulet
 *
 */
public class MathUtilitaires_SimpleTest
{

	public static void main(String[] args)
	{

		System.out.println("Factoriel...");
		for (int i = 0; i < 10; i++)
		{
			System.out.print(
					"fact " + i + " = " + (int) MathUtilitaires.fact(i) + ", ");
		}

		System.out.println("\n\nModulo...");
		System.out.println("1 mod 3 = " + MathUtilitaires.modulo(1, 3));
		System.out.println("1 mod -3 = " + MathUtilitaires.modulo(1, -3));
		System.out.println("-1 mod -3 = " + MathUtilitaires.modulo(-1, -3));
		System.out.println("-1 mod 3 = " + MathUtilitaires.modulo(-1, 3));

		System.out.println("\nDiviseur De et PGCD...");
		SortedSet<Integer> s1 = null;
		SortedSet<Integer> s2 = null;
		for (int i = -25; i <= 24; i += 5)
		{
			for (int j = -24; j <= 24; j += 3)
			{
				System.out.println("diviseur de i = " + i + " -- "
						+ (s1 = MathUtilitaires.diviseursDe(i)));
				System.out.println("diviseur de j = " + j + " -- "
						+ (s2 = MathUtilitaires.diviseursDe(j)));
				if ((s1 != null) && (s2 != null))
				{
					System.out.println("diviseur commun de i et j :  "
							+ s1.retainAll(s2) + " -- " + s1);
				}
				System.out.println(
						"PGCD entre i et j = " + MathUtilitaires.PGCD(i, j));
				System.out.println();
			}
		}

		System.out.println("X premiers, nombre premier...");
		for (int i = 1; i <= 100; i++)
		{
			System.out.println(
					"pour " + i + " -- " + (s1 = MathUtilitaires.xPremier(i)));
		}

		System.out.println("\nEst premier...");
		for (int i = 1; i <= 43; i++)
		{
			System.out.println("pour " + i + " -- est premier ("
					+ MathUtilitaires.estPremier(i) + "), ses diviseurs sont "
					+ MathUtilitaires.diviseursDe(i));
		}

		System.out.println("\nX premier entre eux...");
		for (int i = 1; i <= 30; i++)
		{
			System.out.println("pour 1 et " + i + " -- "
					+ (MathUtilitaires.xPremierEntreEux(1, i)));
		}
	}

	/**
	 * 
	 * <pre>
	Factoriel...
	fact 0 = 1, fact 1 = 1, fact 2 = 2, fact 3 = 6, fact 4 = 24, fact 5 = 120, fact 6 = 720, fact 7 = 5040, fact 8 = 40320, fact 9 = 362880, 
	
	Modulo...
	1 mod 3 = 1
	1 mod -3 = -2
	-1 mod -3 = -1
	-1 mod 3 = 2
	
	Diviseur De et PGCD...
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = -5
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = 5
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -25 -- [1, 5, 25]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = -4
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = -5
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = -4
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = 4
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = 5
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = 4
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 3, 5, 15]
	PGCD entre i et j = -15
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 3, 5, 15]
	PGCD entre i et j = 15
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = -15 -- [1, 3, 5, 15]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = -5
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = 5
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -10 -- [1, 2, 5, 10]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 5]
	PGCD entre i et j = -5
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 5]
	PGCD entre i et j = 5
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = -5 -- [1, 5]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 0 -- null
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = -21 -- [1, 3, 7, 21]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = -15 -- [1, 3, 5, 15]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = -9 -- [1, 3, 9]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = -6 -- [1, 2, 3, 6]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = -3 -- [1, 3]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 3 -- [1, 3]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 6 -- [1, 2, 3, 6]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 9 -- [1, 3, 9]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 15 -- [1, 3, 5, 15]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 21 -- [1, 3, 7, 21]
	PGCD entre i et j = 0
	
	diviseur de i = 0 -- null
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	PGCD entre i et j = 0
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 5]
	PGCD entre i et j = -5
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 5]
	PGCD entre i et j = 5
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 5 -- [1, 5]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = -5
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = 5
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 10 -- [1, 2, 5, 10]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 3, 5, 15]
	PGCD entre i et j = -15
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = -3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  false -- [1, 3, 5, 15]
	PGCD entre i et j = 15
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = 15 -- [1, 3, 5, 15]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 3]
	PGCD entre i et j = 3
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = -4
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = -5
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = -4
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = -2
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = -3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = -1
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 0 -- null
	PGCD entre i et j = 0
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 3 -- [1, 3]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 6 -- [1, 2, 3, 6]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 9 -- [1, 3, 9]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 12 -- [1, 2, 3, 4, 6, 12]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = 4
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 15 -- [1, 3, 5, 15]
	diviseur commun de i et j :  true -- [1, 5]
	PGCD entre i et j = 5
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 18 -- [1, 2, 3, 6, 9, 18]
	diviseur commun de i et j :  true -- [1, 2]
	PGCD entre i et j = 2
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 21 -- [1, 3, 7, 21]
	diviseur commun de i et j :  true -- [1]
	PGCD entre i et j = 1
	
	diviseur de i = 20 -- [1, 2, 4, 5, 10, 20]
	diviseur de j = 24 -- [1, 2, 3, 4, 6, 8, 12, 24]
	diviseur commun de i et j :  true -- [1, 2, 4]
	PGCD entre i et j = 4
	
	X premiers, nombre premier...
	pour 1 -- null
	pour 2 -- [2]
	pour 3 -- [2, 3]
	pour 4 -- [2, 3]
	pour 5 -- [2, 3, 5]
	pour 6 -- [2, 3, 5]
	pour 7 -- [2, 3, 5, 7]
	pour 8 -- [2, 3, 5, 7]
	pour 9 -- [2, 3, 5, 7]
	pour 10 -- [2, 3, 5, 7]
	pour 11 -- [2, 3, 5, 7, 11]
	pour 12 -- [2, 3, 5, 7, 11]
	pour 13 -- [2, 3, 5, 7, 11, 13]
	pour 14 -- [2, 3, 5, 7, 11, 13]
	pour 15 -- [2, 3, 5, 7, 11, 13]
	pour 16 -- [2, 3, 5, 7, 11, 13]
	pour 17 -- [2, 3, 5, 7, 11, 13, 17]
	pour 18 -- [2, 3, 5, 7, 11, 13, 17]
	pour 19 -- [2, 3, 5, 7, 11, 13, 17, 19]
	pour 20 -- [2, 3, 5, 7, 11, 13, 17, 19]
	pour 21 -- [2, 3, 5, 7, 11, 13, 17, 19]
	pour 22 -- [2, 3, 5, 7, 11, 13, 17, 19]
	pour 23 -- [2, 3, 5, 7, 11, 13, 17, 19, 23]
	pour 24 -- [2, 3, 5, 7, 11, 13, 17, 19, 23]
	pour 25 -- [2, 3, 5, 7, 11, 13, 17, 19, 23]
	pour 26 -- [2, 3, 5, 7, 11, 13, 17, 19, 23]
	pour 27 -- [2, 3, 5, 7, 11, 13, 17, 19, 23]
	pour 28 -- [2, 3, 5, 7, 11, 13, 17, 19, 23]
	pour 29 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
	pour 30 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
	pour 31 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
	pour 32 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
	pour 33 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
	pour 34 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
	pour 35 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
	pour 36 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
	pour 37 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]
	pour 38 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]
	pour 39 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]
	pour 40 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37]
	pour 41 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41]
	pour 42 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41]
	pour 43 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43]
	pour 44 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43]
	pour 45 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43]
	pour 46 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43]
	pour 47 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
	pour 48 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
	pour 49 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
	pour 50 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
	pour 51 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
	pour 52 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
	pour 53 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]
	pour 54 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]
	pour 55 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]
	pour 56 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]
	pour 57 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]
	pour 58 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53]
	pour 59 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59]
	pour 60 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59]
	pour 61 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61]
	pour 62 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61]
	pour 63 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61]
	pour 64 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61]
	pour 65 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61]
	pour 66 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61]
	pour 67 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67]
	pour 68 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67]
	pour 69 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67]
	pour 70 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67]
	pour 71 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71]
	pour 72 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71]
	pour 73 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73]
	pour 74 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73]
	pour 75 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73]
	pour 76 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73]
	pour 77 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73]
	pour 78 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73]
	pour 79 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79]
	pour 80 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79]
	pour 81 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79]
	pour 82 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79]
	pour 83 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83]
	pour 84 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83]
	pour 85 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83]
	pour 86 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83]
	pour 87 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83]
	pour 88 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83]
	pour 89 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 90 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 91 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 92 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 93 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 94 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 95 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 96 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
	pour 97 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
	pour 98 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
	pour 99 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
	pour 100 -- [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
	
	Est premier...
	pour 1 -- est premier (false), ses diviseurs sont [1]
	pour 2 -- est premier (true), ses diviseurs sont [1, 2]
	pour 3 -- est premier (true), ses diviseurs sont [1, 3]
	pour 4 -- est premier (false), ses diviseurs sont [1, 2, 4]
	pour 5 -- est premier (true), ses diviseurs sont [1, 5]
	pour 6 -- est premier (false), ses diviseurs sont [1, 2, 3, 6]
	pour 7 -- est premier (true), ses diviseurs sont [1, 7]
	pour 8 -- est premier (false), ses diviseurs sont [1, 2, 4, 8]
	pour 9 -- est premier (false), ses diviseurs sont [1, 3, 9]
	pour 10 -- est premier (false), ses diviseurs sont [1, 2, 5, 10]
	pour 11 -- est premier (true), ses diviseurs sont [1, 11]
	pour 12 -- est premier (false), ses diviseurs sont [1, 2, 3, 4, 6, 12]
	pour 13 -- est premier (true), ses diviseurs sont [1, 13]
	pour 14 -- est premier (false), ses diviseurs sont [1, 2, 7, 14]
	pour 15 -- est premier (false), ses diviseurs sont [1, 3, 5, 15]
	pour 16 -- est premier (false), ses diviseurs sont [1, 2, 4, 8, 16]
	pour 17 -- est premier (true), ses diviseurs sont [1, 17]
	pour 18 -- est premier (false), ses diviseurs sont [1, 2, 3, 6, 9, 18]
	pour 19 -- est premier (true), ses diviseurs sont [1, 19]
	pour 20 -- est premier (false), ses diviseurs sont [1, 2, 4, 5, 10, 20]
	pour 21 -- est premier (false), ses diviseurs sont [1, 3, 7, 21]
	pour 22 -- est premier (false), ses diviseurs sont [1, 2, 11, 22]
	pour 23 -- est premier (true), ses diviseurs sont [1, 23]
	pour 24 -- est premier (false), ses diviseurs sont [1, 2, 3, 4, 6, 8, 12, 24]
	pour 25 -- est premier (false), ses diviseurs sont [1, 5, 25]
	pour 26 -- est premier (false), ses diviseurs sont [1, 2, 13, 26]
	pour 27 -- est premier (false), ses diviseurs sont [1, 3, 9, 27]
	pour 28 -- est premier (false), ses diviseurs sont [1, 2, 4, 7, 14, 28]
	pour 29 -- est premier (true), ses diviseurs sont [1, 29]
	pour 30 -- est premier (false), ses diviseurs sont [1, 2, 3, 5, 6, 10, 15, 30]
	pour 31 -- est premier (true), ses diviseurs sont [1, 31]
	pour 32 -- est premier (false), ses diviseurs sont [1, 2, 4, 8, 16, 32]
	pour 33 -- est premier (false), ses diviseurs sont [1, 3, 11, 33]
	pour 34 -- est premier (false), ses diviseurs sont [1, 2, 17, 34]
	pour 35 -- est premier (false), ses diviseurs sont [1, 5, 7, 35]
	pour 36 -- est premier (false), ses diviseurs sont [1, 2, 3, 4, 6, 9, 12, 18, 36]
	pour 37 -- est premier (true), ses diviseurs sont [1, 37]
	pour 38 -- est premier (false), ses diviseurs sont [1, 2, 19, 38]
	pour 39 -- est premier (false), ses diviseurs sont [1, 3, 13, 39]
	pour 40 -- est premier (false), ses diviseurs sont [1, 2, 4, 5, 8, 10, 20, 40]
	pour 41 -- est premier (true), ses diviseurs sont [1, 41]
	pour 42 -- est premier (false), ses diviseurs sont [1, 2, 3, 6, 7, 14, 21, 42]
	pour 43 -- est premier (true), ses diviseurs sont [1, 43]
	
	X premier entre eux...
	pour 1 et 1 -- null
	pour 1 et 2 -- [1]
	pour 1 et 3 -- [1, 2]
	pour 1 et 4 -- [1, 3]
	pour 1 et 5 -- [1, 2, 3, 4]
	pour 1 et 6 -- [1, 5]
	pour 1 et 7 -- [1, 2, 3, 4, 5, 6]
	pour 1 et 8 -- [1, 3, 5, 7]
	pour 1 et 9 -- [1, 2, 4, 5, 7, 8]
	pour 1 et 10 -- [1, 3, 7, 9]
	pour 1 et 11 -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
	pour 1 et 12 -- [1, 5, 7, 11]
	pour 1 et 13 -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
	pour 1 et 14 -- [1, 3, 5, 9, 11, 13]
	pour 1 et 15 -- [1, 2, 4, 7, 8, 11, 13, 14]
	pour 1 et 16 -- [1, 3, 5, 7, 9, 11, 13, 15]
	pour 1 et 17 -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
	pour 1 et 18 -- [1, 5, 7, 11, 13, 17]
	pour 1 et 19 -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
	pour 1 et 20 -- [1, 3, 7, 9, 11, 13, 17, 19]
	pour 1 et 21 -- [1, 2, 4, 5, 8, 10, 11, 13, 16, 17, 19, 20]
	pour 1 et 22 -- [1, 3, 5, 7, 9, 13, 15, 17, 19, 21]
	pour 1 et 23 -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22]
	pour 1 et 24 -- [1, 5, 7, 11, 13, 17, 19, 23]
	pour 1 et 25 -- [1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14, 16, 17, 18, 19, 21, 22, 23, 24]
	pour 1 et 26 -- [1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25]
	pour 1 et 27 -- [1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22, 23, 25, 26]
	pour 1 et 28 -- [1, 3, 5, 9, 11, 13, 15, 17, 19, 23, 25, 27]
	pour 1 et 29 -- [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28]
	pour 1 et 30 -- [1, 7, 11, 13, 17, 19, 23, 29]
	 * </pre>
	 */
}
