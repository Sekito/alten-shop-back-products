# Projet

## Base de Données
Ce projet utilise H2 en mémoire comme base de données. La base de données sera opérationnelle lorsque l'application démarrera.

**Configuration de la Base de Données** :
Le fichier `data.sql` contient les scripts de création et de peuplement de la base de données et des tables.

## Front-End
L'application front-end fonctionne sur le port **3000**.

## Back-End
L'application back-end fonctionne sur le port **8080**.

## Documentation de l'API
**Swagger** : 
Vous pouvez accéder à la documentation de l'API via Swagger à l'adresse suivante : [Swagger UI](http://localhost:8080/swagger-ui/index.html#/).

**Postman** :
Le fichier `AltenProductAPI.postman_collection` contient la collection d'API pour Postman.

## Problèmes Connus
- Il existe des bugs dans l'application front-end.
- J'ai corrigé Certains bugs, mais d'autres restent non résolus.
- En particulier, lors de la création d'un nouveau produit, vous devez sélectionner les champs **statut d'inventaire** et **catégorie**.


## Build le Projet:
-*mvn clean install*
-*mvn spring-boot:run*  OU  *java -jar target/product-management-0.0.1-SNAPSHOT.jar*

###Frontend
npm install => 
ng serve


  

