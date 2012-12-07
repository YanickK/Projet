ProjetFinale-
=============

Application de restaurant en java

Pour utiliser les bases de données SQLite:

Une fois les fichiers téléchargés sur votre ordinateur, initialiser la variable CHEMIN_POUR_ACCEDER_A_LA_BD
de la classe Login. Vous devez y mettre le chemin pour se rendre au fichier Employes.sqlite après "jdbc:sqlite:/blah/blah/Employes.sqlite"

Faites attention au sens des "/"

Dans la main ou peu importe la classe chosie, vous pouvez instancier la classe et faire l'appel de méthode ainsi:

Login exemple1=new Login("test","test");
System.out.println(exemple1.DBConnect());



