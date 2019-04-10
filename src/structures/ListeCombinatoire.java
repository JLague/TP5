package structures;

import java.util.List;
import java.util.ArrayList;
import exceptions.ConstructeurException;

/**
 * Classe qui permet de produire une liste de listes de combinaison d'entiers
 * sans remise sans tenir compte de l'ordre à partir d'une liste d'entiers de
 * départ.
 *
 * Voir les combinatoires sur "Wikipédia" :
 * https://fr.wikipedia.org/wiki/Combinatoire
 *
 * @author Dylan Renaud
 * @author Justin Lagüe
 */
public class ListeCombinatoire
{
	public static final int VALEUR_ENS_MIN = 0;
	public static final int VALEUR_ENS_MAX = 50;
	public static final int LONGUEUR_COMBINAISON_MIN = 1;

	private int debutEns = 0;
	private int finEns = 0;
	private int longCombinaison = 0;
	private List<List<Integer>> listeDeCombinaisons = null;
	private List<Integer> ensembleValeurs = null;

	/**
	 * Valide et initialise les attributs de la classe. Il génère le vecteur de
	 * valeurs selon les bornes reçues. Il génère les listes combinatoires en
	 * respectant la longueur voulue et le vecteur de valeurs.
	 *
	 * @param pValDebut la borne min pour l'ensemble des valeurs
	 * @param pValFin la borne max pour l'ensemble des valeurs
	 * @param pLongCombinaison la longueur des combinaisons
	 *
	 * @throws ConstructeurException
	 */
	// TODO ListeCombinatoire - Compléter le code de la méthode
	public ListeCombinatoire(int pValDebut, int pValFin, int pLongCombinaison)
			throws ConstructeurException
	{
		if (validerLimitesEns(pValDebut, pValFin) && validerLongCombinaison(
				pLongCombinaison, pValFin - pValDebut))
		{
			setLimitesEns(pValDebut, pValFin);
			setLongCombinaison(pLongCombinaison);

			setEnsembleValeurs(genererEnsembleValeurs());
			// setListeDeCombinaisons(produireListeCombinaisons(this.ensembleValeurs,
		}
		else
			throw new ConstructeurException(
					"Un ou des paramètres sont invalides");
	}

	public int getDebutEns()
	{
		return debutEns;
	}

	public int getFinEns()
	{
		return finEns;
	}

	public int getLongCombinaison()
	{
		return longCombinaison;
	}

	private List<Integer> getEnsembleValeurs()
	{
		return ensembleValeurs;
	}

	public List<Integer> getCombinaison(int index)
	{
		return listeDeCombinaisons.get(index);
	}

	private List<List<Integer>> getListeDeCombinaisons()
	{
		return listeDeCombinaisons;
	}

	public int getTailleListeDeCombinaisons()
	{
		return listeDeCombinaisons.size();
	}

	private void setLimitesEns(int pDebutEns, int pFinEns)
	{
		// Au besoin, inversion des valeurs pour simplement éviter les
		// erreurs...
		boolean ok = validerLimitesEns(pDebutEns = Math.min(pDebutEns, pFinEns),
				pFinEns = Math.max(pDebutEns, pFinEns));

		if (ok)
		{
			this.debutEns = pDebutEns;
			this.finEns = pFinEns;
		}
	}

	private void setLongCombinaison(int pLongCombinaison)
	{
		boolean ok = validerLongCombinaison(pLongCombinaison,
				((getFinEns() - getDebutEns()) + 1));

		if (ok)
		{
			this.longCombinaison = pLongCombinaison;
		}
	}

	private void setEnsembleValeurs(List<Integer> pEnsemble)
	{
		this.ensembleValeurs = pEnsemble;
	}

	private void setListeDeCombinaisons(List<List<Integer>> listeDeCombinaisons)
	{
		this.listeDeCombinaisons = listeDeCombinaisons;
	}

	private boolean validerLimitesEns(int pValDebut, int pValFin)
	{
		return ((pValDebut < pValFin)
				&& (pValDebut >= ListeCombinatoire.VALEUR_ENS_MIN)
				&& (pValDebut <= ListeCombinatoire.VALEUR_ENS_MAX)
				&& (pValFin >= ListeCombinatoire.VALEUR_ENS_MIN)
				&& (pValFin <= ListeCombinatoire.VALEUR_ENS_MAX));
	}

	private boolean validerLongCombinaison(int pLongCombinaison,
			int pLongEnsemble)
	{
		return ((pLongCombinaison >= ListeCombinatoire.LONGUEUR_COMBINAISON_MIN)
				&& (pLongCombinaison <= pLongEnsemble));
	}

	/**
	 * Génère la liste de valeurs entre les bornes début et de fin incluses.
	 * Considérer cet ensemble comme référence pour produire les combinaisons.
	 *
	 * @return une liste d'entiers entre les bornes début et fin
	 */
	// TODO genererEnsembleValeurs - Compléter le code de la méthode
	public List<Integer> genererEnsembleValeurs()
	{
		List<Integer> liste = new ArrayList<Integer>();

		for (int i = this.debutEns; i <= this.finEns; i++)
		{
			liste.add(i);
		}

		return liste;
	}

	/**
	 * Permet de produire les combinaisons sans remise.
	 *
	 * Devrait être une méthode récursive.
	 *
	 * Source : Voir sur le web, plusieurs algos disponibles.
	 *
	 * Attention : Bien faire vos tests, c'est très facile de vous tromper...
	 *
	 */
	// TODO produireListeCombinaisons - MANDAT 1 ou 2 - Compléter le code de la
	// méthode
	private void produireListeCombinaisons(List<Integer> pEnsembleValeurs,
			int pLongueurRestante, List<Integer> pCombinaisonCourante)
	{
		int chiffre = 0;
		
		for (int i = longCombinaison - 1; i >= 0; i--)
		{
			chiffre = pCombinaisonCourante.get(i);
			
			if (chiffre < this.finEns)
			{
				pCombinaisonCourante.set(i, chiffre + 1);
			}
		}
		
		listeDeCombinaisons.add(pCombinaisonCourante);
		
	}

	/**
	 * Permet de construire une chaîne de caractères structurée pour afficher
	 * les infos d'un objet ListeCombinatoire.
	 *
	 * Évolue selon le développement...
	 *
	 *
	 * <pre>
	 * Exemple de sortie voulue:
	 *
	 * Limite de l'ensemble : [1, 20]
	 * Longueur combinaison : 4
	 * Ensemble : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
	 * Voici les 4845 combinaisons : [[1, 2, 3, 4], [1, 2, 3, 5], [1, 2, 3, 6], [1, 2, 3, 7], ... , [16, 18, 19, 20], [17, 18, 19, 20]]
	 *
	 * </pre>
	 *
	 */
	// TODO toString - Compléter le code de la méthode
	@Override
	public String toString()
	{
		return "Limite de l'ensemble : [" + this.debutEns + ", " + this.finEns
				+ "]\nLongueur combinaison : " + this.longCombinaison
				+ "\nEnsemble : " + getEnsembleValeurs() + "\nVoici les "
				+ getTailleListeDeCombinaisons() + "combinaisons : "
				+ getListeDeCombinaisons();
	}
}
