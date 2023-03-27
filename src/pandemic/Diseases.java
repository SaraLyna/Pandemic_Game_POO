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
    @param name nom de la maladie
    */
     Diseases(String name) {
        this.name = name;
    }
    /**

    Retourne le nom de la maladie.
    @return le nom de la maladie.
    */
    public String getDIseaseName() {
        return this.name;
    }
    
    /**
     * @param name
     * @return une maladie
     */
    public static Diseases nameToDisease(String name) {
        Diseases d = null; // initialiser à null pour gérer les noms de maladies invalides

        if (name.equalsIgnoreCase("bleu")) {
            d = Diseases.BLUE;
        }
        else if (name.equalsIgnoreCase("rouge")) {
            d = Diseases.RED;
        }
        else if (name.equalsIgnoreCase("jaune")) { 
            d = Diseases.YELLOW;
        }
        else if(name.equalsIgnoreCase("noir")) { 
            d = Diseases.BLACK;
        }

        if (d == null) { // gérer les noms de maladies invalides
            throw new IllegalArgumentException("Invalid disease name: " + name);
        }

        return d;
    }

    
}
