package pandemic;

import java.util.*;

/**
 * this class represents the cities in the Map, the cities in the game pandemic.
 */
public class Cities {
    protected String name;
    protected HashMap<Diseases, Integer> infectionRates;
    protected List<Cities> neighbors;
    protected String sector;
    protected boolean isReasearchCenter;
    protected boolean isInfectionFocus;
    protected boolean hasBeenInfectedThisTurn;
    private int nbCube; //number of cubes in the city,
   
    /**
     * constructor of the class Cities
     * @param name , the name of city
     * @param neighbors , the list of the neighbors
     * @param sector , the sector of the city
     */
    public Cities(String name, String sector) {
        this.name = name;
        this.neighbors = new ArrayList<Cities>();
        this.sector = sector;
        this.isReasearchCenter = false;
        this.isInfectionFocus = false;
        this.nbCube=0;
        this.hasBeenInfectedThisTurn = false;
        this.infectionRates = new HashMap<>();
        this.infectionRates.put(Diseases.BLUE, 0);
        this.infectionRates.put(Diseases.RED, 0);
        this.infectionRates.put(Diseases.YELLOW, 0);
        this.infectionRates.put(Diseases.BLACK, 0);
    }

    /**
     * start a propagation og the infection in the current city,
     * @param d the disease to add,
     */
    private void infectionPropagation(Diseases d) {
    	this.displayAllNeighbors();
        for (Cities neighbor : this.neighbors) {
            neighbor.addCube(d);
        }
    }

    /**
     * adds a disease cube in the current city if it's already contaminated. 
     *if the number of cubes in the city is > 3, the city becomes a center of propagation.
     * each city is infected once in a propagation phase.
     * 
     * @param d the cube to add 
     */
    public void addCube(Diseases d) {
        
        if(hasBeenInfectedThisTurn) {
        	System.out.println(this.name + " is not re-infected because it has already been infected this turn ,");
        }
        else {
        	// marked that the city is infected this turn
        	this.hasBeenInfectedThisTurn = true;
        	int cubesCount = infectionRates.getOrDefault(d, 0);
        	System.out.print(this.name+" is infected by  "+d.getDiseaseName()+", ");
        	if (cubesCount < 3) {
     		infectionRates.put(d, cubesCount + 1);
        		System.out.println("its infection rate for "+d.getDiseaseName()+" rises to "+ infectionRates.get(d));
        	} else {
        	System.out.println(" But she is already at 3, she infects her neighbors");
        	infectionPropagation(d);
        	}
        }
    }

    /**
     * to know if the city is center of propagation
     * 
     * @returntrue if the city is center of propagation, false either
     */
    public boolean isInfectionFocus() {
        return this.isInfectionFocus;
    }

    /**
     * @return the name of the city
     */
    public String getName() {
        return this.name;
    }
    
    

    /**
     * @return a dictionnary of all the cubes of diseases in a city
     */
    public HashMap<Diseases, Integer> getAllCubes() {
        return this.infectionRates;
    }

    /**
     * @return the list of the neighbors
     */
    public List<Cities> getAllCities() {
        return this.neighbors;
    }

	/**
	 * displays the neighbors of the current city
	 */
    public void displayAllNeighbors(){
    	System.out.println("The neighbors of  "+this.getName()+" are :");
    	for(Cities neighbor:this.neighbors) {
    		System.out.println(neighbor);
    	}
    }

    /**
    *Cette méthode permet de convertir l'objet Cities en une chaîne de caractères qui décrit le nom de la ville ainsi que les taux d'infection de chaque maladie présente dans la ville.
    *@return une chaîne de caractères qui décrit le nom de la ville ainsi que les taux d'infection de chaque maladie présente dans la ville
    */
    public String toString() {
        String str = name + " [";
        for (Map.Entry<Diseases, Integer> entry : infectionRates.entrySet()) {
            str += entry.getKey().getDiseaseName() + ":" + entry.getValue() + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
    }
    
    /**
    *Cette méthode permet d'obtenir la liste des villes voisines de la ville actuelle.
    *@return une liste contenant les villes voisines de la ville actuelle
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
	 * setteur de sector
	 * @param sector
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
	/**
	 * @return un booleen,
	 * si c'est bien une station de recherche alors true
	 * sinon false
	 */
	public boolean isResearchCenter() {
		return this.isReasearchCenter;
	}
	

	/**
	 * ajoute une station de recherche
	 * et met le booleen a true
	 */
	public void addResearchCenter() {
		this.isReasearchCenter = true;
	}
    
	
	/**
	 * Get the number of cubes of a specific disease in the city
	 *
	 * @param d the disease to check
	 * @return the number of cubes of the specified disease in the city
	 */
	public int getCubeCount(Diseases d) {
	    return this.infectionRates.get(d);
	}
    
    
     
    /**
     * @param nbCube
     * @return le nombre de cubes
     */
    public int setCube(int nbCube){
    	return this.nbCube=nbCube;
    	
    }
    

    /**
     * @param d: maladie
     * reduit le taux d'infection en réduisant le nombre de cubes dans une ville
     */
    public void reduceInfection(Diseases d) {
    	if(this.infectionRates.containsKey(d)){
    		this.infectionRates.replace(d, this.nbCube--);
    	}
    }
    
    
	/**

    Cette méthode permet de réinitialiser le statut de la ville en indiquant que la ville n'a pas été infectée pendant le tour actuel.
    */
	public void resetTurn() {
		this.hasBeenInfectedThisTurn = false;
	}
	
}
