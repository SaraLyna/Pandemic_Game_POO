package pandemic;

import java.util.*;

import pandemic.player.Player;

/**
 * this class represents the cities in the Map, the cities in the game pandemic.
 */
public class City {
    protected String name;
    protected HashMap<Disease, Integer> infectionRates;
    protected List<City> neighbors;
    protected List<Player> players;
    protected String sector;
    protected boolean isResearchCenter;
    protected boolean isInfectionFocus;
    protected boolean hasBeenInfectedThisTurn;
   // private int nbCube; //number of cubes in the city,
   
    /**
     * constructor of the class Cities
     * @param name , the name of city
     * @param neighbors , the list of the neighbors
     * @param sector , the sector of the city
     */
    public City(String name, String sector) {
        this.name = name;
        this.neighbors = new ArrayList<City>();
        this.sector = sector;
        this.isResearchCenter = false;
        this.isInfectionFocus = false;
       // this.nbCube=0;
        this.players = new ArrayList<>();
        this.hasBeenInfectedThisTurn = false;
        this.infectionRates = new HashMap<>();
        this.infectionRates.put(Disease.BLUE, 0);
        this.infectionRates.put(Disease.RED, 0);
        this.infectionRates.put(Disease.YELLOW, 0);
        this.infectionRates.put(Disease.BLACK, 0);
    }

    
    
    /**
     * start a propagation or the infection in the current city,
     * @param d the disease to add,
     */
    private void infectionPropagation(Disease d) {
    	this.displayAllNeighbors();
        for (City neighbor : this.neighbors) {
            neighbor.addCube(d);
        }
    }

    
    /**
     * adds a disease cube in the current city if it's already contaminated. 
     * if the number of cubes in the city is > 3, the city becomes a center of propagation.
     * each city is infected once in a propagation phase.
     * @param d the cube to add 
     */
    public void addCube(Disease d) {  
    	//at some point we need to remove a cube from the corresponding reserve, for now we do that in the addCube method in PandemicMain
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
     * @return true if the city is center of propagation, false either
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
    public HashMap<Disease, Integer> getAllCubes() {
        return this.infectionRates;
    }
    

    /**
     * @return the list of the neighbors
     */
    public List<City> getAllCities() {
        return this.neighbors;
    }
    

	/**
	 * displays the neighbors of the current city
	 */
    public void displayAllNeighbors(){
    	System.out.println("The neighbors of  "+this.getName()+" are :");
    	for(City neighbor:this.neighbors) {
    		System.out.println(neighbor);
    	}
    }
    

    /**
    *Cette méthode permet de convertir l'objet Cities en une chaîne de caractères qui décrit le nom de la ville
    * ainsi que les taux d'infection de chaque maladie présente dans la ville.
    *@return une chaîne de caractères qui décrit le nom de la ville ainsi que les taux d'infection de chaque maladie
    * présente dans la ville
    */
    public String toString() {
        String str = name + " [";
        for (Map.Entry<Disease, Integer> entry : infectionRates.entrySet()) {
            str += entry.getKey().getDiseaseName() + ":" + entry.getValue() + ", ";
        }
        str = str.substring(0, str.length() - 2);
        str += "]";
        return str;
    }
    
    
    /**
    * Cette méthode permet d'obtenir la liste des villes voisines de la ville actuelle.
    * @return une liste contenant les villes voisines de la ville actuelle
    */
    public List<City> getNeighbors(){
    	return this.neighbors;
    }
    
    
    /**
    * Cette méthode permet d'ajouter une ville voisine à la ville actuelle.
    * @param neighbors la ville à ajouter comme voisine de la ville actuelle
    */
    public void addNeighbors(City neighbors){
    	this.neighbors.add(neighbors);
    }
    
    
    /**
    * Cette méthode permet d'obtenir le secteur de la ville actuelle.
    * @return le secteur de la ville actuelle
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
		return this.isResearchCenter;
	}
	

	/**
	 * ajoute une station de recherche
	 * et met le booleen a true
	 */
	public void addResearchCenter() {
		this.isResearchCenter = true;
	}
    
	
	/**
	 * Get the number of cubes of a specific disease in the city
	 * @param d the disease to check
	 * @return the number of cubes of the specified disease in the city
	 */
	public int getCubeCount(Disease d) {
	    return this.infectionRates.get(d);
	}
    
	/**
	 * Sets the number of cubes of a given disease in the city.
	 * @param disease the disease to set the cube count for
	 * @param count the number of cubes to set
	 */
	public void setCubeCount(Disease disease, int count) {
	    if (this.infectionRates.containsKey(disease)) {
	    	this.infectionRates.put(disease, count);
	    }
	    else {
	        System.out.println("Error: " + disease.getDiseaseName() + " is not present in the city " + this.getName());
	    }
	}

        
    /**
     * @param nbCube
     * @return the number of cubes of the city
     
    public int setCube(int nbCube){
    	return this.nbCube=nbCube;  	
    }
    */

    
    /**
     *decreases the number of cubes of a given disease 
     * @param disease ,the given disease 
     */
    public void reduceInfection(Disease disease) {
        if(this.infectionRates.containsKey(disease)){
            int cubeCount = getCubeCount(disease) - 1;
            this.infectionRates.replace(disease, cubeCount);
            setCubeCount(disease, cubeCount);
        }
    }

    
	/**
    * Cette méthode permet de réinitialiser le statut de la ville en indiquant que la ville
    *  n'a pas été infectée pendant le tour actuel.
    */
	public void resetTurn() {
		this.hasBeenInfectedThisTurn = false;
	}



	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		this.players.add(player);
		
	}
	
}
