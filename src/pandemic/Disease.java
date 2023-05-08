package pandemic;

/**
*Enumération représentant les maladies dans le jeu Pandemic.
*Les maladies sont représentées par une couleur et une chaîne de caractères correspondant
* à leur nom ansi que leur etat ( guérie ou non )
*/

public enum Disease {
	
	BLUE("bleu", false),
    RED("rouge", false),
    YELLOW("jaune", false),
    BLACK("noir", false);

    private String name;
    private boolean isCured;

    /**
     * @param name
     * @param isCured
     */
    Disease(String name, boolean isCured) {
        this.name = name;
        this.isCured = isCured;
    }
    
 
    /**
     * @return name of the disease
     */
    public String getDiseaseName() { // maybe delete this and use toString instead ?
        return this.name;
    }
    
    /**
     * @return name of the disease
     */
    public String toString() {
        return this.getDiseaseName();
    }
    
    

    /**
     * @return true if the disease is cured
     * false sinon
     */
    public boolean isCured() {
        return this.isCured;
    }
    

    /**
     * @param isCured
     */
    public void setCured(boolean isCured) {
        this.isCured = isCured;
    }
    
    
    /**
     * @param name
     * @return une maladie
     */
    public static Disease nameToDisease(String name) {
        Disease d = null; // initialiser à null pour gérer les noms de maladies invalides

        if (name.equalsIgnoreCase("bleu")) {
            d = Disease.BLUE;
        }
        else if (name.equalsIgnoreCase("rouge")) {
            d = Disease.RED;
        }
        else if (name.equalsIgnoreCase("jaune")) { 
            d = Disease.YELLOW;
        }
        else if(name.equalsIgnoreCase("noir")) { 
            d = Disease.BLACK;
        }

        if (d == null) { // gérer les noms de maladies invalides
            throw new IllegalArgumentException("Invalid disease name: " + name);
        }

        return d;
    }

    
}