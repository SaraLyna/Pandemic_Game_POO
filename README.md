## Se référer à la branche "experimental" pour le rendu final




# l2s4-projet-2023

# Equipe

- Sara Lyna OUYAHIA
- Anais BENIKKEN
- Charles Kevin Adovi KPAKPO

pour le livrable 3 et 4 on aura en plus:
- Clement GUILLAUMIN
- Samuel PAYEN

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

Modélisation des Actions :
Codage des 4 (ou 5 si on compte l'action ne rien faire) actions principales pour pouvoir effectuer un tour de jeu complet et faire faire les actions aux joueurs
et enplus de ça, codage des classe filles de actions (GlobetRotterRole , DoctorRole, ExpertRole et ScientistRole) pour les
actions spécifiques à chaque role.


--Explication du code:


--Classe Actions:
Cette classe represente les actions principales que les joueurs devront effectuer, 
on a 5 méthodes et un constructeur,
la méthode construct() :Pour construire une station de recherche, il faut disposer dans sa main d’une carte joueur
 dont la ville est celle sur laquelle on se trouve. Cette carte est défaussée et on place une station de recherche sur 
 la ville correspondante. Néanmoins, le nombre de stations de recherche est limité. S’il n’y en a plus de disponible, 
 il faut en déplacer une d’une autre ville.
 d'abord on cherchait la carte dans la main du joueur , ensuite on cherchait la position de ce joueur,
 puis pour le reste on a codé tout cela à l'aide d'un iterateur qui parcourait toutes les villes et s'il trouvait une correspondance
  avec la ville de la carte dans la main du joueur il crée une station de recherche justement dans cette ville là,
 et ensuite on défausse la carte de la main du joueur.
 et pour le défaussage il nous fallait une nouvelle version de la méthode removeCard() dans la classe Players.java.
 
 la méthode move(): c'est une methode qui permet au joueur de se déplacer dans n'importe quelle ville voisine
  (de la ville dont laquelle il se trouve)
  on commence d'abord par voir ou se trouve le joueur, dans quelle ville, puis on le fait se déplacer dans une ville voisine.
 
 la méthode discover(): verifie si la ville a une station de recherche, si c'est le cas elle découvre un remede pour une maladie spécifique
  et défausse cinq  cartes de la main du joueur.
   
 la méthode healDisease(): cette méthode permet de checker le stock de cubes de maladies dans une ville puis éradiquer la maladie
 si un remede a été découvert on retire le cube de maladie de la ville et on le remet dans le stock.
 
 et enfin la méthode DontDoAnything(): qui consiste à ce que le joueur ne fasse RIEN.





--Classe DoctorRole:
cette classe hérite de la classe principale Actions.java
le role du doctor consiste à retirer tous les cubes dès qu’il passe dans une ville où il existe des cubes
 d’une maladie guérie, sans que cela compte pour une action.
 et on fait ça à l'aide d'une méthode RemoveCubes(), qui consiste à retirer tous les cubes d'une maladie guérie dans une ville.

--Classe ExpertRole:
cette classe hérite de la classe principale Actions.java
l'expert n’a pas besoin de disposer de carte joueur pour construire une station,
on fait ça à l'aide d'une méthode BuildStationWoCard(), qui consiste à  dire si il existe déja  une station de recherche
 (isResearchCenter()) on déclenche une exception, sinon on ajoute une station de recherche (addResearchCenter()) à une ville
puis on affiche le nom de la ville dans laquelle on a construit cette
station de recherche.

--Classe ScientistRole:
cette classe hérite de la classe principale Actions.java
le scientifique a besoin de disposer de 4 cartes d'une meme maladie pour découvrir un remede, alors 
Si toutes les cartes ont le meme nom de ville , le remède est découvert(discoverCure()), et on a aussi créé une méthode
findRemedy()  qui permettrait de trouver un remede pour une maladie donnée en utilisant la méthode discoverCure() définie plus haut
et qui Vérifie s'il y a assez de cartes de la maladie pour découvrir un remède et si un remède n'a pas encore été découvert pour la maladie donnée

--Classe GlobetRotter:
cette classe hérite de la classe principale Actions.java
le globetrottera la possibilité de se déplacer dans n’importe quelle ville. Ce qui augmente sa capacité d’action
et on a fait ca à l'aide d 'une méthode moveAnywhere() qui lui permet de se déplacer dans la ville de son choix.


### Difficultés restant à résoudre (résolues)

--Implementer la classe Actions et apporter quelques modifications aux classes des roles. 
--Hésitation sur la classe Actions et Players, s'il faut mettre un héritage entre les deux ou pas.

## Livrable 4

### Atteinte des objectifs

Modélisation de la classe Game et rendu final :
jouer au jeu pandemic !



--Explication du code :
Renommage des classes et création des packages,
suppression de la classe Actions et fusion avec Player,
Automatisation de main et Codage de Game (tout en mettant l'ancien main dedans),
itération sur les villes et maladies de : InfectionPaquet et PlayersPaquet à l'aide
d'une boucle for plutot que d'écrire les cartes une par une.

--Classe Game:
méthode play():




Makefile:


Le fonctionnement du fichier JAR :



diaporama de la soutenance .
### Difficultés restant à résoudre (résolues)
Hésitation sur le nom des classes et création de nouveau packages pour plus d'organisation,
Modification de presque toutes les autres classes pour plus de cohérence dans le projet.

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
Avancée pour le rendu final du projet, création des dossiers jar et uml pour la division des uml de chaque livrable.
Modélisation de la classe Actions et discussion avec les deux nouveaux membres du groupe pour choisir la meilleure version.


## Semaine 10
codage des méthodes de la classe Actions.java
chaque membre du groupe a codé une méthode et le dernier a fait les tests
ensuite rendu de l'uml du Livrable3 et enfin on a complété le readme et on essaie d'avancer sur le rendu final.

--BENIKKEN Anais : tests des méthodes de la classe Actions .
--OUYAHIA Sara Lyna: méthode construcrt().
--KPAKPO Charles Kevin Adovi: méthode healDisease().
--GUILLAUMIN Clement: méthode move().
--PAYEN Samuel: méthode discover().

## Semaine 11
premiere version du diaporama de la soutenance finale,
Codage de la classe Game.java
Révision du code

## Semaine 12
<<<<<<< HEAD
creation des packages pandemic , pandemic.player, pandemic.card 
pour mieux gérer l'organisation du jeu.
renommage des classes, codage de game et modification des autres classes pour plus de cohérence.
préparation de la soutenance finale.
=======
Codage de la classe Game,
Création des packages pour plus d'organisation et de lisibilité,
renommage des classes : Cities --> City
Diseases--> Disease
Cards --> Card
DoctorRole --> Doctor
ExpertRole --> Expert
ScientistRole --> Scientist
Players --> Player
Actions n'existe plus car on l'a fusionné avec Player.
Soutenance et présentation du projet.
rendu final.

>>>>>>> experimental
