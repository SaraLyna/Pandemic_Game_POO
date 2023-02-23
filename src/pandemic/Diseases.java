package pandemic;

/**

Enumération représentant les maladies dans le jeu Pandemic.

Les maladies sont représentées par une couleur et une chaîne de caractères correspondant à leur nom.
*/

public enum Diseases {
    BLUE("bleu"),
    RED("rouge"),
    YELLOW("jaune"),
    BLACK("noir");

    private String name;
    /**

    Constructeur de l'énumération Diseases.
    @param name nom de la maladie.
    */
    Diseases(String name) {
        this.name = name;
    }
    /**

    Retourne le nom de la maladie.
    @return le nom de la maladie.
    */
    public String getName() {
        return this.name;
    }
}
