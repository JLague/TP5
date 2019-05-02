package structures;

import java.util.*;

import utilitaires.MatriceUtilitaires;
import utilitaires.MathUtilitaires;

import exceptions.ConstructeurException;

/**
 * Classe qui permet de faire la gestion des matrices candidates pour le chiffre
 * de Hill. Les matrices sont produites à partir des combinaisons sans ordre et
 * sans remise sur un ensemble de valeurs prédéterminées.
 *
 * Utilise la classe "ListeCombinatoire" pour générer les combinaisons de
 * valeurs potentielles pour former les matrices.
 *
 * @author Vos noms
 *
 */
public class ListeMatricesChiffrement implements iMatrice
{

	/**
	 * Valeurs minimum et maximum composant les matrices de chiffrement, donc
	 * les listes combinatoires.
	 */
	private int borneInf = 0;
	private int borneSup = 0;

	/**
	 * Dimension des matrices de chiffrement, elles sont carrées.
	 */
	private int dimension = 0;

	/**
	 * Modulation, valeur en relation avec la longueur du vecteur de caractères
	 * "VecteurDeCaracteres" (table de correspondance) pour le chiffrement.
	 */
	private int coefDansZ = 0;

	/**
	 * Pointeur sur la matrice courante
	 */
	private int[][] matriceCourante = null;

	/**
	 * Liste de matrices candidates
	 */
	List<int[][]> listeMatricesCandidates = null;

	/**
	 * Constructeur, permet d'initialiser l'ensemble des attributs, de faire
	 * générer la liste des matrices candidates et de choisir au hasard une
	 * matrice parmi l'ensemble de matrices générées.
	 *
	 * @param pBorneInf valeur minimum pour construire les matrices à partir des
	 *            combinatoires
	 * @param pBorneSup valeur maximum pour construire les matrices à partir des
	 *            combinatoires
	 * @param pDimension dimension de la matrice [pDimension X pDimension]
	 * @param pCoefDansZ Modulation, valeur en relation avec la longueur du
	 *            vecteur de caractères (table de correspondance) pour le
	 *            chiffrement.
	 *
	 * @throws ConstructeurException
	 */
	// TODO ListeMatricesChiffrement - Compléter le code de la méthode
	public ListeMatricesChiffrement(int pBorneInf, int pBorneSup,
			int pDimension, int pCoefDansZ) throws ConstructeurException
	{
		if (validerBornes(pBorneInf, pBorneSup) && validerDimension(pDimension)
				&& validerCoefDansZ(pCoefDansZ))
		{
			setBornes(pBorneInf, pBorneSup);
			setDimension(pDimension);
			setCoefDansZ(pCoefDansZ);

			this.listeMatricesCandidates = new LinkedList<int[][]>();
			genererListeMatrices(new ListeCombinatoire(pBorneInf, pBorneSup,
					pDimension * pDimension));
			choisirMatriceCourante();
		}
		else
			throw new ConstructeurException(
					"Un ou des paramètres sont invalides");

	}

	public int getBorneInf()
	{
		return borneInf;
	}

	public int getBorneSup()
	{
		return borneSup;
	}

	public int getDimension()
	{
		return dimension;
	}

	public int getCoefDansZ()
	{
		return coefDansZ;
	}

	private int[][] getMatriceCourante()
	{
		return matriceCourante;
	}

	private void setBornes(int pBorneInf, int pBorneSup)
	{
		pBorneInf = pBorneInf > pBorneSup ? pBorneSup ^ pBorneInf ^ (pBorneSup = pBorneInf) : pBorneInf;
		boolean ok = validerBornes(pBorneInf, pBorneSup);
		
		if (ok)
		{
			this.borneInf = pBorneInf;
			this.borneSup = pBorneSup;
		}
	}

	private void setDimension(int pDimension)
	{
		boolean ok = validerDimension(pDimension);

		if (ok)
		{
			this.dimension = pDimension;
		}
	}

	private void setCoefDansZ(int pCoefDansZ)
	{
		boolean ok = validerCoefDansZ(pCoefDansZ);

		if (ok)
		{
			this.coefDansZ = pCoefDansZ;
		}
	}

	private void setMatriceCourante(int[][] pMat)
	{
		matriceCourante = pMat;
	}

	private boolean validerBornes(int pBorneInf, int pBorneSup)
	{
		return (pBorneInf >= 0) && (pBorneSup >= 0) && (pBorneInf <= pBorneSup);
	}

	private boolean validerDimension(int pDimension)
	{
		return (pDimension > 0);
	}

	private boolean validerCoefDansZ(int pCoefDansZ)
	{
		return (pCoefDansZ > 0);
	}

	private boolean validerIndex(int index)
	{
		return (index >= 0) && (index < getNombreMatricesCandidates());
	}

	/**
	 * Obtenir le nombre de matrices candidates pour le chiffrement
	 *
	 * @param le nombre de matrices candidates
	 */
	public int getNombreMatricesCandidates()
	{
		return listeMatricesCandidates.size();
	}

	@Override
	// TODO choisirMatriceCourante - Compléter le code de la méthode
	public void choisirMatriceCourante()
	{
		choisirMatriceCourante(
				MathUtilitaires.alea(0, listeMatricesCandidates.size() - 1));
	}

	@Override
	// TODO choisirMatriceCourante - Compléter le code de la méthode
	public void choisirMatriceCourante(int index)
	{
		if (validerIndex(index))
			setMatriceCourante(this.listeMatricesCandidates.get(index));
		else
			setMatriceCourante(null);
	}

	@Override
	// TODO getCopieMatriceCourante - Compléter le code de la méthode
	public int[][] getCopieMatriceCourante()
	{
		int[][] copie = null;

		if (getMatriceCourante() != null)
		{
			copie = new int[this.dimension][];

			for (int i = 0; i < this.dimension; i++)
			{
				copie[i] = getMatriceCourante()[i].clone();
			}
		}

		return copie;
	}

	@Override
	// TODO getMatriceCouranteInverseHill - Compléter le code de la méthode
	public int[][] getMatriceCouranteInverseHill()
	{
		int[][] matrice = this.getCopieMatriceCourante();
		int[][] matAdj = MatriceUtilitaires.getMatAdjointe(matrice);
		int det = MatriceUtilitaires.getDeterminant(matrice);
		int detHill = MatriceUtilitaires.getDeterminantInverseHill(det,
				this.coefDansZ);
		int[][] matProd = MatriceUtilitaires.getMatMultScalaire(matAdj,
				detHill);

		return MatriceUtilitaires.getMatModuloX(matProd, this.coefDansZ);
	}

	/**
	 * À partir de liste des combinatoires reçue, cette méthode génère les
	 * matrices qui seront candidates pour le chiffrement de Hill et les place
	 * dans la liste de matrices candidates.
	 *
	 * Pour qu'une matrice soit candidate, il faut que la valeur du déterminant
	 * de la matrice soit premier avec la valeur du coefficient dans Z
	 * ("modulo")
	 *
	 * Ou si vous voulez il faut que le PGCD entre le déterminant de la matrice
	 * et le coefficient dans Z soit égale à 1.
	 *
	 * @param pListe, la liste des combinatoires selon les données de l'objet...
	 */
	// TODO genererListeMatrices - Compléter le code de la méthode
	private void genererListeMatrices(ListeCombinatoire pListe)
	{
		int[][] matrice = new int[dimension][dimension];
		Integer[] temp = null;

		// Parcours la liste de combinaison
		for (int i = 0; i < pListe.getTailleListeDeCombinaisons(); i++)
		{
			temp = pListe.getCombinaison(i)
					.toArray(new Integer[dimension * dimension]);

			// Remplie la matrice avec la combinaison
			for (int j = 0; j < dimension * dimension; j++)
			{
				matrice[j / dimension][j % dimension] = (int) temp[j];
			}

			// Si la matrice est candidate, l'ajouter à la liste
			if (MathUtilitaires.PGCD(MatriceUtilitaires.getDeterminant(matrice),
					this.coefDansZ) == 1)
			{
				this.listeMatricesCandidates
						.add(MatriceUtilitaires.getMatCopieProfonde(matrice));
			}
		}
	}


}
