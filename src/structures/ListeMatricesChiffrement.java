package structures;

import java.util.*;

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
		boolean ok = validerBornes(pBorneInf = Math.min(pBorneInf, pBorneSup),
				pBorneSup = Math.max(pBorneInf, pBorneSup));

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
	}

	
	@Override
	// TODO choisirMatriceCourante - Compléter le code de la méthode
	public void choisirMatriceCourante(int index)
	{
	}

	@Override
	// TODO getCopieMatriceCourante - Compléter le code de la méthode
	public int[][] getCopieMatriceCourante()
	{
		return null;
	}

	@Override
	// TODO getMatriceCouranteInverseHill - Compléter le code de la méthode
	public int[][] getMatriceCouranteInverseHill()
	{
		return null;
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
	}
}
