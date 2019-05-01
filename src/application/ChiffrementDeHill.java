package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.SortedSet;
import javax.swing.*;
import structures.*;
import utilitaires.FichierUtilitaires;
import utilitaires.InputUtilitaires;
import utilitaires.MathUtilitaires;

/**
 * Application de chiffrement et de déchiffrement de Hill
 * 
 */
public class ChiffrementDeHill extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private static final int BORNE_MIN = 1;
	private static final int BORNE_MAX = 12;
	private static final int DIM_MAT = 3;
	private static final String NOM_FICHIER_DICO = "dictionnaire.txt";
	private static final String NOM_FICHIER_PROVERBES = "proverbes.txt";
	private static final String EXT_FICHIER = ".crypto.txt";

	// Menu de l'application
	private JPanel panelMenu = null;
	private JMenuBar menuBar = null;
	// Zone de texte de sortie
	private JEditorPane output = null;
	// Zone d'information
	private JTextArea info = null;

	// Attributs pour les data
	private String messageBlanc = "";
	private String messageGris = "";
	private String sortieHTML = "";

	// Structures de données
	private VecteurDeCaracteres vecCaracteres = new VecteurDeCaracteres();
	private ListeMatricesChiffrement listeDeMatricesCandidates = null;
	private SortedSet<String> dico = FichierUtilitaires
			.lireDictionnaire(new File(NOM_FICHIER_DICO));
	private MessageChiffrerDechiffrer mesChiffrerDechiffrer = null;
	private String[] proverbes = FichierUtilitaires
			.lireDictionnaire(new File(NOM_FICHIER_PROVERBES))
			.toArray(new String[0]);

	public ChiffrementDeHill()
	{
		super();

		String textInfo = "";

		// Prépare le layout de placement du JPanel
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// menu du haut
		initMenuBar();
		add(panelMenu);

		output = new JEditorPane();
		output.setPreferredSize(new Dimension(800, 600));
		output.setEditable(false);
		output.setBackground(Color.LIGHT_GRAY);
		output.setContentType("text/html");
		add(new JScrollPane(output));

		info = new JTextArea();
		info.setPreferredSize(new Dimension(800, 50));
		info.setEnabled(true);
		info.setBackground(Color.YELLOW);
		add(info);

		listeDeMatricesCandidates = new ListeMatricesChiffrement(BORNE_MIN,
				BORNE_MAX, DIM_MAT, vecCaracteres.getTaille());

		mesChiffrerDechiffrer = new MessageChiffrerDechiffrer(vecCaracteres,
				listeDeMatricesCandidates, dico);

		// Remplir info de contrôle
		textInfo = "-- Vecteur de caractères : " + vecCaracteres + ".\n";
		textInfo += "-- Les combinaisons de " + BORNE_MIN + " à " + BORNE_MAX
				+ " donnent "
				+ listeDeMatricesCandidates.getNombreMatricesCandidates()
				+ " matrices candidates de "
				+ listeDeMatricesCandidates.getDimension() + " X "
				+ listeDeMatricesCandidates.getDimension() + ".\n";

		info.setText(textInfo);
	}

	private void initMenuBar()
	{
		JMenuItem menuItem;

		panelMenu = new JPanel(new FlowLayout(FlowLayout.LEFT));

		menuBar = new JMenuBar();

		// Menu Fichier
		JMenu menuFichier = new JMenu("Fichier");

		String titresMenuFichier[] =
		{ "Ouvrir message gris...", "Enregistrer sous message gris...",
				"Quitter" };

		for (String titreMenuItem : titresMenuFichier)
		{
			menuItem = new JMenuItem(titreMenuItem);
			menuFichier.add(menuItem);
			menuItem.addActionListener(this);
		}
		menuBar.add(menuFichier);

		// Menu Action
		JMenu menuAction = new JMenu("Action");

		String titresMenuAction[] =
		{ "Chiffrement sans saisie", "Chiffrement avec saisie...",
				"Dechiffrement", "Vider zone de texte" };

		for (String titreMenuItem : titresMenuAction)
		{
			menuItem = new JMenuItem(titreMenuItem);
			menuAction.add(menuItem);
			menuItem.addActionListener(this);
		}
		menuBar.add(menuAction);

		panelMenu.add(menuBar);
	}

	/**
	 * Méthode d'écoute des boutons et des options de menu. Implémentation de
	 * l'interface ActionListener.
	 * 
	 * @param event , l'évenement qui a sollicité la méthode. Permet de
	 *            connaître le composant graphique stimulé.
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();

		if (command.equals("Ouvrir message gris..."))
		{
			gestionOuvrirMessageGris();
		}
		else if (command.equals("Enregistrer sous message gris..."))
		{
			gestionEnregistrerSousMessageGris();
		}
		else if (command.equals("Chiffrement sans saisie"))
		{
			gestionChiffrementSansSaisie();
		}
		else if (command.equals("Chiffrement avec saisie..."))
		{
			gestionChiffrementAvecSaisie();
		}
		else if (command.equals("Dechiffrement"))
		{
			gestionDechiffrement();
		}
		else if (command.equals("Vider zone de texte"))
		{
			gestionViderOutput();
		}
		else if (command.equals("Quitter"))
		{
			gestionQuitter(); // System.exit(0);
		}

		afficherOutput();
	}

	/**
	 * Appelle une interface graphique pour obtenir le nom d'un fichier, lit le
	 * message gris à partir du fichier.
	 */
	private void gestionOuvrirMessageGris()
	{
		File fichier = FichierUtilitaires.obtenirNomFichier("Ouvrir");

		if (fichier != null)
		{
			this.messageGris = FichierUtilitaires.lireMessage(fichier);
			this.messageBlanc = "";
			this.sortieHTML += messageTitre(
					"--- Opération de lecture d'un message gris...");
		}
		else
			this.sortieHTML += messageWarning(
					"Désolé, l'opération de lecture d'un message gris a été annulée...")
					+ "<br />";

		ajouterASortieHTML2();
	}

	/**
	 * Appelle une interface graphique pour obtenir le nom d'un fichier, écrit
	 * le message gris dans le fichier.
	 */
	private void gestionEnregistrerSousMessageGris()
	{
		if ((this.messageGris != null) && !this.messageGris.isEmpty())
		{
			File fichier = FichierUtilitaires.obtenirNomFichier("Enregistrer",
					new File(BORNE_MIN + " à " + BORNE_MAX + " et matrice "
							+ listeDeMatricesCandidates.getDimension() + " X "
							+ listeDeMatricesCandidates.getDimension() + " - "
							+ this.messageBlanc + EXT_FICHIER));

			if (fichier != null)
			{
				FichierUtilitaires.enregistrerMessage(messageGris, fichier);
				this.sortieHTML += messageTitre(
						"--- Opération d'enregistrement d'un message gris...");
			}
			else
				this.sortieHTML += messageWarning(
						"Désolé, l'opération d'enregistrement d'un message gris a été annulée...")
						+ "<br />";
		}
		else
			this.sortieHTML += messageWarning(
					"Désolé, pas de message gris enregistré pour le moment...")
					+ "<br />";

		ajouterASortieHTML2();
	}

	/**
	 * Permet de présenter un exemple de fonctionnement
	 */
	public void gestionQuitter()
	{
		String messageBoite = "Voulez-vous sauvegarder le message gris avant de quitter.";
		String titreBoite = "Sauvegarder le message gris";
		int choix = 0;

		if ((this.messageGris != null) && !this.messageGris.isEmpty())
		{
			choix = JOptionPane.showConfirmDialog(this, messageBoite,
					titreBoite, JOptionPane.YES_NO_OPTION);

			if (choix == JOptionPane.YES_OPTION)
			{
				this.gestionEnregistrerSousMessageGris();
			}
		}

		System.exit(0);
	}

	/**
	 * Prend un message aléatoirement dans une banque de messages et le chiffre.
	 * Met le message aléatoire dans le message blanc et le message chiffré dans
	 * le massage gris.
	 */
	private void gestionChiffrementSansSaisie()
	{
		if ((this.proverbes != null) && (this.proverbes.length > 0))
		{
			this.messageBlanc = proverbes[MathUtilitaires.alea(0,
					(proverbes.length - 1))].trim().toLowerCase();
			this.messageGris = this.mesChiffrerDechiffrer.encoder(messageBlanc);
			this.sortieHTML += messageTitre(
					"--- Opération de chiffrement sans saisie...");
		}
		else

			this.sortieHTML += messageWarning(
					"Désolé, aucun message disponible dans le tableau interne de messages...")
					+ "<br />";

		ajouterASortieHTML();
	}

	/**
	 * Saisie un message pour le chiffrer. Met le message saisi dans le message
	 * blanc et le message chiffré dans le message gris.
	 */
	private void gestionChiffrementAvecSaisie()
	{
		String messageBoite = "Saisir ici, le message à chiffrer (message blanc):";
		String titreBoite = "Saisir message...";

		this.messageBlanc = InputUtilitaires.saisirString(messageBoite,
				titreBoite);

		if ((this.messageBlanc != null) && !this.messageBlanc.isEmpty())
		{
			this.messageBlanc = this.messageBlanc.trim().toLowerCase();
			this.messageGris = this.mesChiffrerDechiffrer.encoder(messageBlanc);
			this.sortieHTML += messageTitre("--- Opération de chiffrement avec saisie...");
		}
		else
		{
			this.messageBlanc = "";
			this.sortieHTML += messageWarning("Désolé, aucun message saisi...")
					+ "<br />";
		}

		ajouterASortieHTML();
	}

	/**
	 * Déchiffre le message gris s'il n'est pas vide et le met dans le message
	 * blanc.
	 */
	private void gestionDechiffrement()
	{

		if ((this.messageGris != null) && !this.messageGris.isEmpty())
		{
			this.messageBlanc = this.mesChiffrerDechiffrer.decoder(messageGris);
			this.sortieHTML += messageTitre(
					"--- Opération de déchiffrement...");
		}
		else
			this.sortieHTML += messageWarning(
					"Désolé, aucun message à déchiffrer...") + "<br />";

		ajouterASortieHTML2();
	}

	private void gestionViderOutput()
	{
		this.sortieHTML = "";
		this.messageBlanc = "";
		this.messageGris = "";
	}

	private void ajouterASortieHTML()
	{
		this.sortieHTML += messageInfo(
				"<b>Message blanc : </b>[" + this.messageBlanc + "]")
				+ "<br />";
		this.sortieHTML += messageInfo(
				"<b>Message gris : </b>[" + this.messageGris + "]") + "<br />";
	}
	
	private void ajouterASortieHTML2()
	{
		this.sortieHTML += messageInfo(
				"<b>Message gris : </b>[" + this.messageGris + "]") + "<br />";
		this.sortieHTML += messageInfo(
				"<b>Message blanc : </b>[" + this.messageBlanc + "]")
				+ "<br />";
		
	}

	private String messageTitre(String message)
	{
		return "<h2>" + message + "</h2>";
	}

	private String messageInfo(String message)
	{
		return "<font size='5' color='blue'>" + message + "</font>";
	}

	private String messageWarning(String message)
	{
		return "<h3><font color='red'>" + message + "</font></h3>";
	}

	private void afficherOutput()
	{
		this.output.setText(this.sortieHTML);
	}
}
