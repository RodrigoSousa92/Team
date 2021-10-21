# Small API for a team job which suppose to be done within 3 hours
#### *with a specific requsits of our menthor*
## Name of the project: Team

This API aims to know which shoe belongs to a certain player of each team, and to which team belongs each player, were the entities are: players, shoes, teams.
Each player has as an attribute of the name and shoes has own brand itself, all the teams has an atribute of name.
Also we created many to many relationship between shoes and players, and many to one relationship with players and teams to know for which team belongs each player.
This API consists of 3 models which corresponds to our 3 classes:

### *Models*:
* Player
* Shoe
* Team
This API has 3 repositories, that extend the MongoDB repository apllied for our 3 main classes.

### *Repositories*
* PlayerRepository
* ShoeRepository
* TeamRepository

### Similarly, this API has 3 services and 3 controllers Several endpoints exist, to perform basic CRUD operations.
* PlayerService
* ShoeService
* TeamService

### *Controllers:*
* Player Controller 
* Shoe Controller
* TeamController

### *Endpoints:*
* Get: all shoes
* Get: get shoe by ID

### *Put:*
* update a shoes by its Brand

### *Exceptions:*
* Player Not Found
