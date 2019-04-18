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
		List<Integer> listeVide = new ArrayList<Integer>();

		if (validerLimitesEns(pValDebut, pValFin) && validerLongCombinaison(
				pLongCombinaison, (pValFin - pValDebut) + 1))
		{
			// Assigne les attributs
			setLimitesEns(pValDebut, pValFin);
			setLongCombinaison(pLongCombinaison);

			// Génère l'ensemble de valeurs
			setEnsembleValeurs(genererEnsembleValeurs());

			// Instancie la liste de combinaisons
			setListeDeCombinaisons(new ArrayList<List<Integer>>());

			// Génère une liste vide pour passer à produireListeCombinaisons
			for (int i = 0; i < this.longCombinaison; i++)
			{
				listeVide.add(0);
			}

			// Génère la liste de combinaisons
			produireListeCombinaisons(this.ensembleValeurs,
					this.longCombinaison, listeVide);
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

		int min = Math.min(pDebutEns, pFinEns);
		int max = Math.max(pDebutEns, pFinEns);
		boolean ok = validerLimitesEns(min, max);

		if (ok)
		{
			this.debutEns = min;
			this.finEns = max;
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
		if (pLongueurRestante > 0)
		{
			for (int i = 0; i <= pEnsembleValeurs.size()
					- pLongueurRestante; i++)
			{
				// Ajoute l'élément de l'ensemble à la combinaison
				pCombinaisonCourante.set(
						this.longCombinaison - pLongueurRestante,
						pEnsembleValeurs.get(i));

				// Remplit le reste de la combinaison avec l'ensemble restant
				produireListeCombinaisons(
						pEnsembleValeurs.subList(i + 1,
								pEnsembleValeurs.size()),
						pLongueurRestante - 1, pCombinaisonCourante);
			}
		}
		else
		{
			// Ajoute la combinaison courante à la liste si la longueur est plus
			// grande que 0
			listeDeCombinaisons
					.add(new ArrayList<Integer>(pCombinaisonCourante));
		}

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
				+ getTailleListeDeCombinaisons() + " combinaisons : "
				+ getListeDeCombinaisons();
	}

	public static void main(String[] args)
	{
		ListeCombinatoire liste = new ListeCombinatoire(1, 5, 3);

		System.out.println(liste);
	}
}
