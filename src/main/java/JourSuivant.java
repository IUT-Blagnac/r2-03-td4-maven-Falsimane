import java.util.Scanner;

public class JourSuivant {

    /**
     * Fait saisir une date à l'utilisateur
     * @param pfDate OUT : un tableau de trois cases représentant une
     * date. 1ere case : jour, 2nde case : mois, 3eme case : annee
     *
     */
    public static void saisieDate(int[] pfDate) {
        // Déclarations des variables :
        int i;
        int saisie;
        String[] tab;
        tab = new String[3];
        tab[0] = "jour";
        tab[1] = "mois";
        tab[2] = "annee";

        if (pfDate.length != 3) {
            System.out.print("Le tableau représentant la date a une taille inattendue : ");
            System.out.println(pfDate.length + " case(s) au lieu de 3 !");
        }
        Scanner clavier = new Scanner(System.in);
        // A vous

        if (pfDate.length == 3){
            for (i = 0; i<3; i=i+1){
                System.out.println("Saisir "+ tab[i]+ " :");
                saisie = clavier.nextInt();
                pfDate[i] = saisie;
            }
            String date = "" + pfDate[0] + " " + pfDate[1] + " " + pfDate[2];
            System.out.println(date);
        }
    }

    /**
     *  @param annee une année
     *  @return vrai si l'année est bissextile, faux sinon
     */
    public static boolean estBissextile(int pfAnnee) {
        // A vous
        return(pfAnnee %4 ==0 && pfAnnee %100 !=0 || pfAnnee % 400 ==0);   
    }

    public static int nbJours(int mois, int annee) {
        // A vous
        if ((mois == 1) || (mois == 3) || (mois ==5) || (mois ==7) || (mois ==8) || (mois ==10) || (mois == 12)){
            return(31);
        }else if ((mois ==11) || (mois == 4) || (mois == 6) || (mois == 9)){
            return (30);
        }else if (mois ==2){
            if (estBissextile(annee)) {
                return 29;
            }else{
                return 28;
            }
        }
        return 0;
    }

    /**
     * Calcul la validité d'une date
     *
     * @param pfDate IN : date initiale
     * @return true si et seulement si pfDate est valide
     *
     */
    public static boolean dateValide(int[] pfDate) {
        if (pfDate.length != 3) {
            System.out.print("Un tableau représentant une date a une taille inattendue : ");
            System.out.println(pfDate + " case(s) au lieu de 3 !");
        }

        if(pfDate[2] < 1582 || pfDate[0] > nbJours(pfDate[1], pfDate[2]) || pfDate[1] >12){
            return false;
        }
        return true;
    }

    /**
     * Calcul du jour suivant
     *
     * @param pfDateJourCourant IN : date initiale
     * @param pfDateJourSuivant OUT : date du jour suivant
     *
     */
    public static void jourSuivant(int[] pfDateJourCourant, int[] pfDateJourSuivant) {
        if (pfDateJourCourant.length != 3 || pfDateJourSuivant.length != 3) {
            System.out.print("Un tableau représentant une date a une taille inattendue : ");
            System.out.println(pfDateJourCourant.length + " ou " + pfDateJourSuivant.length
                + " case(s) au lieu de 3 !");
        }
        // A vous
        if ((pfDateJourCourant[0] == 31 && pfDateJourCourant[1] == 12) &&(nbJours(pfDateJourCourant[1], pfDateJourCourant[2]) == 31)){
            pfDateJourSuivant[0] = 1;
            pfDateJourSuivant[1] = 1;
        }
        else if ((pfDateJourCourant[0] == 29) && (nbJours(pfDateJourCourant[1], pfDateJourCourant[2]) == 29)){
            pfDateJourSuivant[0] = 1;
            pfDateJourSuivant[1] = pfDateJourCourant[1] + 1;
        }
        else if ((pfDateJourCourant[0] == 28) && (nbJours(pfDateJourCourant[1], pfDateJourCourant[2]) == 28)){
            pfDateJourSuivant[0] = 1;
            pfDateJourSuivant[1] = pfDateJourCourant[1] + 1;
        }
        else if ((pfDateJourCourant[0] == 30) && (nbJours(pfDateJourCourant[1], pfDateJourCourant[2]) == 30)){
            pfDateJourSuivant[0] = 1;
            pfDateJourSuivant[1] = pfDateJourCourant[1] + 1;
        }
        else if ((pfDateJourCourant[0] == 31) && (nbJours(pfDateJourCourant[1], pfDateJourCourant[2]) == 31)){
            pfDateJourSuivant[0] = 1;
            pfDateJourSuivant[1] = pfDateJourCourant[1] + 1;
        }
        else if (pfDateJourCourant[0] != 28 || pfDateJourCourant[0] !=29 || pfDateJourCourant[0]!=30 || pfDateJourCourant[0]!=31){
            pfDateJourSuivant[0] = pfDateJourCourant[0] + 1;
        }
    }

    public static void principale() {
        /* Déclaration des variables */
        int[] date = new int[3] ;

        /* -- Etape 1 -- */
        /* Saisie d'une date */
        // A vous :
        saisieDate(date);

        /* -- Etape 2 -- */
        /* Vérification de la date saisie */
        // A vous
        dateValide(date);

        /* -- Etape 3 -- */
        if (dateValide(date)) {
            /* Calcul du jour suivant */
            /* Affichage du jour suivant */
            // A vous
            jourSuivant(date, date);
            System.out.println("Demain nous serons le " + date[0] + "/" 
                + date[1] + "/" + date[2]);

        } else {
            System.out.println("La date du "
                + date[0] + "/" + date[1] + "/" + date[2]
                + " n'est pas une date valide.");
        }
    }

}

