# l2s4-projet-2023

# Equipe

- Sara Lyna OUYAHIA
- Anais BENIKKEN
- Charles Kevin Adovi KPAKPO
- Ayman EL ALASS

# Sujet

[Le sujet 2023](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2023.pdf)

# Livrables

## Livrable 1

### Atteinte des objectifs:

Modélisation des villes,
Modélisation de la carte.

Explications du code:

--Classe Cities:

La classe contient un constructeur Cities prenant en parametre le nom de la ville , la liste de ses villes voisines , ainsi que son secteur ; de plus , on initialise nos deux booléens isResearchCenter , et isInfectionFocus à false , car au début , la ville n'est pas un foyer d'infection et ne contient pas de centre de recherche .
L'objectif de cette classe est de vérifier si la ville est un foyer d'infection , de déclencher une propagation de maladie chez les villes voisines , et leur ajouter un cube d'infection de la maladie propagée .


-- Classe Mappemonde:

La visée de cette classe , est de lire la carte des villes et de les afficher par la suite , ça correspond à notre plateau de jeu 


-- Classe pandemicMain:

Cette Classe a pour but d'executer notre programme et d'afficher tout ce qui doit s'afficher à l'écran 

### Difficultés rencontrées(résolues!):

-- la première difficulté rencontrée , est le fait qu'une ville soit infectée par plus d'une maladie à la fois ( ce qui est du à l'infection des villes voisines appartenant à deux secteurs différents , (villes situées à la frontière)) .
On a d'abord essayé de gérer ça à l'aide d'un void "becomeInfectionFocus" , sauf qu'on avait du mal à recupérer la maladie responsable de l'explosion .
Ce qui nous a conduit à créer deux méthodes nommées InfectionPropagation, ainsi que addCube qui prennent en paramètre la maladie , ce qui nous permet de mieux gérer la propagation et ainsi d'ajouter le bon cube correspondant à la maladie aux villes voisines .

### Difficultés restant à résoudre :

-- lorsque une ville se trouvant à la frontière , contient deux cubes de la meme maladie(maladie de son secteur ) , est contaminée par sa ville voisine (située dans un autre secteur ) , cette dernière reçoit un cube infection différent de celui de son secteur . 
Meme si , le nombre de cubes qu'elle contient est égal à 3 , cette ville ne doit pas déclencher une propagation et ne doit pas devenir un foyer , car les cubes de maladies sont différents .

## Livrable 2

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
Modélisation du diagramme UML (modélisation de toutes les classes du jeu)
 et des classes Java:( Actions.java , Cards.java, Cities.java, Cubes.java, Diseases.java, 
EpidemicCards.java, InfectionCards.java, Pandemic.java, pandemicMain.java, Players.java, PlayersCards.java,Roles.java).

Lecture du fichier JSON sur eclipse, création du jars.
Modélisation des villes, création d'un fichier villes.json avec toutes les villes.


## Semaine 2
On a complété le code des méthodes de la classe Cities qui sert à afficher les villes,
Création de la classe : MappeMonde.java
on a essayé d'écrire le code des méthodes de la MappeMonde pour lire le fichier Json et modéliser la carte,
on a ajouté la classe MappeMonde au diagramme UML

## Semaine 3
Amélioration du Diagramme UML,
Implémentation de la classe MappeMonde (on a réussi à afficher cities et neighbors),
amélioration des méthodes de la classe Cities

## Semaine 4
Création des tests pour les classes Cities et Mappemonde 
Finalisation du livrable 1 , (+ explication du code ).

## Semaine 5

## Semaine 6

## Semaine 7

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
