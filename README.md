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

Modélisation des villes:
-Affichage des villes + affichage des voisins (cities et neighbors)
Modélisation de la carte:
-Faire enc sorte que si un secteur est un foyer d'infection, alors les villes voisines seront infectées
et du coup la propahation de la maladie commence.

Explications du code:

--Classe Cities:

La classe contient un constructeur Cities prenant en parametre le nom de la ville ,
 la liste de ses villes voisines , ainsi que son secteur ;
  de plus , on initialise nos deux booléens isResearchCenter , et isInfectionFocus à false ,
   car au début , la ville n'est pas un foyer d'infection et ne contient pas de centre de recherche .
L'objectif de cette classe est de vérifier si la ville est un foyer d'infection ,
 de déclencher une propagation de maladie chez les villes voisines , et leur ajouter un cube d'infection de la maladie propagée .


-- Classe Mappemonde:

La visée de cette classe , est de lire la carte des villes (cities et neighbors dans le fichier villes.json)
puis stocker les villes dans une liste (de préférence Map,ici)
et les voisins dans une autre Map, histoire de pouvoir les afficher et les utiliser dans le main.
pour pouvoir récupérer le nombre de maladie de chaque ville (couleur de la maladie), et ses voisins
et de les afficher par la suite (pandemicMain),
ça correspond à notre plateau de jeu (Carte du monde) .


-- Classe pandemicMain:

Cette Classe a pour but d'exécuter notre programme et d'afficher tout ce qui doit s'afficher à l'écran (les villes et les voisins)
selon les secteurs et le nombre de maladie de chaque ville.

### Difficultés rencontrées(résolues!):

-- la première difficulté rencontrée , est le fait qu'une ville soit infectée par plus d'une maladie à la fois
( ce qui est du à l'infection des villes voisines appartenant à deux secteurs différents , (villes situées à la frontière)) .
On a d'abord essayé de gérer ça à l'aide d'un void "becomeInfectionFocus" ,
sauf qu'on avait du mal à recupérer la maladie responsable de l'explosion .
Ce qui nous a conduit à créer deux méthodes nommées InfectionPropagation,
 ainsi que addCube qui prennent en paramètre la maladie , ce qui nous permet de mieux gérer la propagation et ainsi,
  d'ajouter le bon cube correspondant à la maladie aux villes voisines .


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
Création des tests pour les classes Cities et Mappemonde ,
Finalisation et quelques modifications pour la classe MappeMonde,
Finalisation du livrable 1 , (+ explication du code ).

## Semaine 5
On a modélisé sur papier les Roles(ou on a aussi mis une classe Abstract pour qu'à la fin on crée des classes pour chaque role, Doctor, Expert, Globetrotter et Scientist),
et les Cards(ou on a mis une classe Abstract pour Cards pour que InfectionCards et EpidemicCards héritent de la classe),
puis pour les joueurs on devra juste créer une pile représebtant la pile des cards dans la main du joueur,  on créera un attribut MAX=7 (nombre maximal de Cards qu'un joueur peut avoir lors d'une partie).
et on créera aussi la méthode pour défausser les Cards(si jamais >MAX).


## Semaine 6

## Semaine 7

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
