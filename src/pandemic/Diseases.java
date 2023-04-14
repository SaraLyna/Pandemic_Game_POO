package pandemic;

/**

Enumération représentant les maladies dans le jeu Pandemic.

Les maladies sont représentées par une couleur et une chaîne de caractères correspondant à leur nom ansi que leur etat ( guérie ou non )
*/

public enum Diseases {
	
	BLUE("bleu", false),
    RED("rouge", false),
    YELLOW("jaune", false),
    BLACK("noir", false);

    private String name;
    private boolean isCured;

    Diseases(String name, boolean isCured) {
        this.name = name;
        this.isCured = isCured;
    }

    public String getDiseaseName() {
        return this.name;
    }

    public boolean isCured() {
        return this.isCured;
    }

    public void setCured(boolean isCured) {
        this.isCured = isCured;
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