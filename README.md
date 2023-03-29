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
-Faire en sorte que si un secteur est un foyer d'infection, alors les villes voisines seront infectées
et du coup la propagation de la maladie commence.

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

Modélisation des Cartes :

affichage de la pile de cartes et faire en sorte qu'il y ait plusieurs types de cartes,
dont des cartes d'infection, des cartes epidémie, et des cartes joueurs.



Modélisation des joueurs et de leur role:

faire en sorte que chaque joueur ait un role spécifique parmis le docteur, l'expert, le scientifique et le globetrotter.

Explications du code:

--Classe Cards:
on a créé une classe Cards qui est une classe abstraite ,pour ensuite faire un héritage avec les différents types de cartes
qui en dépendent, dont: InfectionCards, PlayersCards et EpidemicCards qui elle dépend de PlayersCards.
on a créé deux methodes getCityName() et getDiseaseName() pour pouvoir recuperer le nom de la ville et de la maladie de la carte.

--Classe EpidemicCards:
c est une classe qui herite de la classe PlayersCards car les cartes epidemie font partie des cartes joueurs.
on a juste créé une methode toString() pour pouvoir afficher un message lors du tirage d'une carte epidemie.

--Classe InfectionCards:
C'est une classe qui herite de Cards.
on a juste créé une methode toString() pour pouvoir afficher un message lors du tirage d'une carte infection ainsi que les getters pour obtenir les noms des villes et des maladies inscrits sur les cartes.

--Classe PlayersCards:
C'est une classe qui herite de Cards.
on a juste créé une methode toString() pour pouvoir afficher un message lors du tirage d'une carte joueur ainsi que les getters pour obtenir les noms des villes et des maladies inscrits sur les cartes.

--Classe Players:
on a créé une pile de cartes dans la main du joueur, à qui on avait attribué un nom, une localisation sur la carte (une ville)
et un role parmis les quatres prédéfinis.
on a également créé une méthode discard() si jamais le nombre de cartes dans la main du joueur atteignait son maximum, c'est à dire
7, enplus des méthodes addCard() pour ajouter une carte dans la main du joueur.
et aussi une methode getCardsInHand() pour pouvoir recuperer le nombre de carte dans la main du joeur.

--Classe Diseases:
on a créé une classe Diseases, qui est une classe enum pour enumerer les quatres maladies principales: RED, BLUE, 
YELLOW, BLACK. et on une méthode getDIseaseName() pour recuperer le nom de la maladie.
Elle contient egalement une méthode appelée nameToDisease() permettant de transformer le nom d'une maladie en objet 
maladie.


--Classe InfectionPaquet:
c'est une classe qui crée le paquet des cartes d'infection avec une ArrayListe<>(), et il y a une méthode init qui implemente toutes les cartes
une par une.
on a aussi créer les méthodes principales pour pouvoir manier ces cartes, melanger(), tirerCarte() au hasard , AddCarte() pour ajouter une 
nouvelle carte et nbCartes() pour recuperer le nombre de cartes dans le paquet.


--Classe PlayersPaquet:
c'est une classe qui crée le paquet des cartes joueurs avec une ArrayListe<>(), et il y a une méthode init qui implemente toutes les cartes
une par une.
on a aussi créer les méthodes principales pour pouvoir manier ces cartes, melanger(), pour melanger les cartes; tirerCarte(),permettant de tirer une carte; AddCarte() pour ajouter une 
nouvelle carte  à la liste et nbCartes() pour recuperer le nombre de cartes dans le paquet.




--Classe Roles:
c'est une classe enum qui enumère les quatres roles qu'on a, Doctor, Scientist, GlobetRotter et Expert. 

--Classe DoctorRole:
le role du doctor consiste à retirer tous les cubes dès qu’il passe dans une ville où il existe des cubes
 d’une maladie guérie, sans que cela compte pour une action.
 et on fait ça à l'aide d'une méthode RemoveCubes(), qui consiste à retirer tous les cubes d'une maladie guérie dans une ville.

--Classe ExpertRole:
l'expert n’a pas besoin de disposer de carte joueur pour construire une station,
on fait ça à l'aide d'une méthode BuildStationWoCard(), qui consiste à  dire si il existe déja  une station de recherche
 (isResearchCenter()) on déclenche une exception, sinon on ajoute une station de recherche (addResearchCenter()) à une ville
puis on affiche le nom de la ville dans laquelle on a construit cette
station de recherche.

--Classe ResearchCenterException:
c'est une classe ou on a créé nous meme une exception pour pouvoir afficher un message lors d'une erreur(d'une exception).

--Classe ScientistRole:
le scientifique a besoin de disposer de 4 cartes d'une meme maladie pour découvrir un remede, alors 
Si toutes les cartes ont le meme nom de ville , le remède est découvert(discoverCure()), et on a aussi créé une méthode
findRemedy()  qui permettrait de trouver un remede pour une maladie donnée en utilisant la méthode discoverCure() définie plus haut
et qui Vérifie s'il y a assez de cartes de la maladie pour découvrir un remède et si un remède n'a pas encore été découvert pour la maladie donnée

--Classe GlobetRotter:
le globetrottera la possibilité de se déplacer dans n’importe quelle ville. Ce qui augmente sa capacité d’action
et on a fait ca à l'aide d 'une méthode moveAnywhere() qui lui permet de se déplacer dans la ville de son choix.

--Classe pandemicMain:
Cette Classe a pour but d'exécuter notre programme et d'afficher tout ce qui doit s'afficher à l'écran (les villes et les voisins)
selon les secteurs et le nombre de maladie de chaque ville.
et ensuite afficher les cartes et les roles de chaque joueur(simulation d'une partie)



### Difficultés restant à résoudre:

--Créer la relation entre chaque role et son action spécifique.


### Difficultés résolues:

On a eu du mal avec la création des piles de cartes car on avait défint une méthode initCards qui initialisait la pile
 de cartes en faisant appel au constructeur qui lui même faisait appel à la methode initCards(), ce qui déclenchait 
 donc une exécution en "loop". On est donc arrivé à résoudre le problème par la création d'une classe à part entière
  pour les piles de cartes.
La creation des paquets de cartes n'etait pas vraiment facile, on a préféré cependant travailler avec des ArrayList car
 on etait plus à l'aise avec.
On a trouvé quelques difficultés dans le main car toutes les classes devaient avoir un lien , comme par exemple Diseases
 et Cities 
pour pouvoir utiliser la méthode addCube().

## Livrable 3

### Atteinte des objectifs
--Explication du code:


--Classe actions:





--Classe DoctorRole:
le role du doctor consiste à retirer tous les cubes dès qu’il passe dans une ville où il existe des cubes
 d’une maladie guérie, sans que cela compte pour une action.
 et on fait ça à l'aide d'une méthode RemoveCubes(), qui consiste à retirer tous les cubes d'une maladie guérie dans une ville.

--Classe ExpertRole:
l'expert n’a pas besoin de disposer de carte joueur pour construire une station,
on fait ça à l'aide d'une méthode BuildStationWoCard(), qui consiste à  dire si il existe déja  une station de recherche
 (isResearchCenter()) on déclenche une exception, sinon on ajoute une station de recherche (addResearchCenter()) à une ville
puis on affiche le nom de la ville dans laquelle on a construit cette
station de recherche.

--Classe ScientistRole:
le scientifique a besoin de disposer de 4 cartes d'une meme maladie pour découvrir un remede, alors 
Si toutes les cartes ont le meme nom de ville , le remède est découvert(discoverCure()), et on a aussi créé une méthode
findRemedy()  qui permettrait de trouver un remede pour une maladie donnée en utilisant la méthode discoverCure() définie plus haut
et qui Vérifie s'il y a assez de cartes de la maladie pour découvrir un remède et si un remède n'a pas encore été découvert pour la maladie donnée

--Classe GlobetRotter:
le globetrottera la possibilité de se déplacer dans n’importe quelle ville. Ce qui augmente sa capacité d’action
et on a fait ca à l'aide d 'une méthode moveAnywhere() qui lui permet de se déplacer dans la ville de son choix.


### Difficultés restant à résoudre

--Implementer la classe Actions et apporter quelques modifications aux classes des roles.

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
puis pour les joueurs on devra juste créer une pile représentant la pile des cards dans la main du joueur,  on créera un attribut MAX=7 (nombre maximal de Cards qu'un joueur peut avoir lors d'une partie).
et on créera aussi la méthode pour défausser les Cards(si jamais >MAX).


## Semaine 6
codage des classes: ScientistRole, GlobetRotter, ExpertRole, DoctorRole.
mise à jour du diagramme UML avec les nouvelles classes,
codage de la classe Players.

## Semaine 7
Codage des classes Players et Cards.

Codage de la suite de pandemicMain pour l'affichage des villes, des cartes et du reste du plateau de jeu.

Mise à jour du diagramme UML et du Readme.

Ajout des tests PlayersTest.

## Semaine 8
Implementation du main et Création des paquets de cartes avec ArrayList pour la version finale, affichage du résultats
et implementation des tests des classes InfectionPaquet et PlayersPaquet.

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
