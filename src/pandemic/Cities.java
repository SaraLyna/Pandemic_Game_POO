package pandemic;

import java.util.*;

/**
 * Cette classe représente une ville dans le jeu Pandemic.
 */
public class Cities {
    protected String name;
    protected HashMap<Diseases, Integer> infectionRates;
    protected List<Cities> neighbors;
    protected String sector;
    protected boolean isReasearchCenter;
    protected boolean isInfectionFocus;
    protected boolean hasBeenInfectedThisTurn;

    /**
     * @param name le nom de la ville
     * @param neighbors la liste des villes voisines
     * @param sector le secteur de la ville
     */
    public Cities(String name, String sector) {
        this.name = name;
        this.neighbors = new ArrayList<Cities>();
        this.sector = sector;
        this.isReasearchCenter = false;
        this.isInfectionFocus = false;
        this.hasBeenInfectedThisTurn = false;
        this.infectionRates = new HashMap<>();
        this.infectionRates.put(Diseases.BLUE, 0);
        this.infectionRates.put(Diseases.RED, 0);
        this.infectionRates.put(Diseases.YELLOW, 0);
        this.infectionRates.put(Diseases.BLACK, 0);
    }

    /**
     * Permet de démarrer une propagation de l'infection dans la ville courante.
     * 
     * @param d la maladie à ajouter
     */
    private void infectionPropagation(Diseases d) {
    	this.displayAllNeighbors();
        for (Cities neighbor : this.neighbors) {
            neighbor.addCube(d);
        }
    }

    /**
     * Permet d'ajouter un cube de maladie dans la ville courante si elle est contaminée. 
     * Si le nombre de cubes dans la ville est supérieur à 3, la ville devient un point de propagation.
     * Chaque ville n'est infectée qu'une fois par phase de propagation.
     * 
     * @param d le cube à ajouter
     */
    public void addCube(Diseases d) {
        
        if(hasBeenInfectedThisTurn) {
        	System.out.println(this.name + " n'est pas reinfectee parce qu elle a deja ete infectee ce tour");
        }
        else {
        	// Marque la ville comme infectée pour ce tour
        	this.hasBeenInfectedThisTurn = true;
        	int cubesCount = infectionRates.getOrDefault(d, 0);
        	System.out.print(this.name+" est infectee par "+d.getName()+", ");
        	if (cubesCount < 3) {
        		infectionRates.put(d, cubesCount + 1);
        		System.out.println("son taux d'infection pour "+d.getName()+" passe a "+infectionRates.get(d));
        	} else {
        	System.out.println(" mais elle est deja a 3, elle infecte ses voisins");
        	infectionPropagation(d);
        	}
        }
    }

    /**
     * Permet de savoir si la ville est un point de propagation.
     * 
     * @return vrai si la ville est un point de propagation, faux sinon
     */
    public boolean isInfectionFocus() {
        return this.isInfectionFocus;
    }

    /**
     * @return le nom de la ville
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return un dictionnaire contenant le nombre de cubes de chaque maladie dans la ville
     */
    public HashMap<Diseases, Integer> getAllCubes() {
        return this.infectionRates;
    }

    /**
     * @return la liste des villes voisines
     */
    public List<Cities> getAllCities() {
        return this.neighbors;
    }

	/**
	 * Affiche les voisins de la ville courante.
	 */
    public void displayAllNeighbors(){
    	System.out.println("Les voisin de la "+this.getName()+" sont :");
    	for(Cities neighbor:this.neighbors) {
    		System.out.println(neighbor);
    	}
    }

    /**

    Cette méthode permet de convertir l'objet Cities en une chaîne de caractères qui décrit le nom de la ville ainsi que les taux d'infection de chaque maladie présente dans la ville.
    @return une chaîne de caractères qui décrit le nom de la ville ainsi que les taux d'infection de chaque maladie présente dans la ville
    */
    public String toString() {
        String str = name + " [";
        for (Map.Entry<Diseases, Integer> entry : infectionRates.entrySet()) {
            str += entry.getKey().getName() + ":" + entry.getValue() + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
    }
    /**

    Cette méthode permet d'obtenir la liste des villes voisines de la ville actuelle.
    @return une liste contenant les villes voisines de la ville actuelle
    */
    public List<Cities> getNeighbors(){
    	return this.neighbors;
    }
    /**

    Cette méthode permet d'ajouter une ville voisine à la ville actuelle.
    @param neighbors la ville à ajouter comme voisine de la ville actuelle
    */
    public void addNeighbors(Cities neighbors){
    	this.neighbors.add(neighbors);
    }
    /**

    Cette méthode permet d'obtenir le secteur de la ville actuelle.
    @return le secteur de la ville actuelle
    */
	public String getSector() {
		
		return this.sector;
	}
	
	/**

    Cette méthode permet de réinitialiser le statut de la ville en indiquant que la ville n'a pas été infectée pendant le tour actuel.
    */
	public void resetTurn() {
		this.hasBeenInfectedThisTurn = false;
	}
}
