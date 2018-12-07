# SYSC 3110 Project – Plants vs Zombies: The Puzzle! 

## Milestone 1 (master branch) - Completed On: Monday, October 29th, 2018
* Implement a text-based version of the popular Plants vs Zombies (PvZ) game.

### Implementations

#### PLANT - Sirak Berhane
* Plants have two subclasses: PassivePlant and ShooterPlant

* Sunflower; subclass of PassivePlant
  - Generates 50 sun every four turns
  - Cost = 50 sun
  - Hit Threshold = 5 damage.

* Peashooter; subclass of ShooterPlant
  - Shoots peas at incoming Zombies
  - Cost = 100 sun
  - Pea Damage = 2 damage per turn
  - Hit Threshold = 10.

#### ZOMBIES - Ryan Tordesillas 
* Zombies have one subclass so far; BasicZombie

* BasicZombie:
  - Speed = Basic Zombie Speed (0.5 tiles per turn/1 tile every two turns)
  - Zombie Damage = Basic Zombie Damage (1 damage per turn)
  - Hit Threshold = Basic Zombie Hit Threshold (10).

#### GAME RUNNABLE - Jolar Tabungar
##### LEVEL:
* Keeps track of the current game state, the states of the five lawns and advances to next states:
   - Keeps track of waveCount, number of zombies remaining in wave, int[5] lawns
   - Each state advances to the next due to player command and plant and zombie behavior 
    
* The central logic component, tells plants and zombies what to do:
   - Peashooters will attack zombies in their lawn every turn, only damages the zombie closest to them (in front of them)
   - Tells Sunflowers to generate sun every turn, but a sunflower keeps track of when it actually produces sun
   - Zombies will walk left until they encounter a plant; they will stop and proceed attacking until the plant is dead
   - When a zombie reaches the end of the lawn, the lawn mower is triggered and clears that lawn of all zombies

* Adds plants and zombies to the level (adding plants dependent on the Player class), zombies are spawned in waves
   - Plants are placed when suitable by the Player who buys them with sun, also can be removed by the player
   - Zombies are spawned in waves that are set when a level is constructed
      -> An arrayList<Integer> is passed in as a parameter -> each element in the arrayList<Integer> is the number of zombies spawned *          each wave
* Determines if the player wins or loses
   - If a zombie reaches the end tile of a lawn and the lawn mower has already been activated, player loses
   - If a player manages to kill all the zombies in the level, player wins

##### LAWN:
  - Keeps track of it's respective plants, zombies and it's lawnmower
  - Has a plants arrayList, zombie arrayList, lawnMower boolean

###### PLAYER: 
  - Responsible for all user input via commands user enters in
  - Keeps track of the player's sun count

##### COMMAND LIST:
  - place plantType x y  ->     Places a plant of plantType at tile (x, y)
  - remove x y           ->     Removes plant at tile (x, y)
  - help                 ->     Prints the command list
  - types                ->     Prints the plant types and their costs
  - skip/ENTER           ->     Skips the turn; ie. player cannot place any plants due to lack of sun

###### PRINTSTATE:
  - Prints the current game state provided by Level
  - The board uses a 9x5 String Array to simulate the lawn tiles of the PvZ game with "|" characters separating the tiles
  - Plants and Zombies (entities) are depicted as E = HitThreshold
  - Ex. Sunflower with HitThreshold of 5 -> S = 5
  - Lawn mowers are depicted as [  LM  ] when not activated and [  X   ] once activated

#### UML/Sequence Diagrams - Karl Schnalzer
##### UML 
![alt text](https://github.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/blob/master/Diagrams/UML_Class_M1.png) 

##### Sequence Diagram - Plant Class
![alt text](https://github.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/blob/master/Diagrams/plant-shoot-zombie-sequence-new.png) 

##### Sequence Diagram - Zombie Class
![alt text](https://github.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/blob/master/Diagrams/zombie-destroy-plant-sequence-new.png) 



## Milestone 2 (master branch) - Completed On: Friday, November 16th, 2018

### Implementations 

#### GUI - Jolar Tabungar 
* GUI Classes Implemented:
  * GameGUI -> Creates a new GUI with 9 by 5 grid (Lawn). It is able to populate board with zombies automatically every turn and the                    user can place either a sunflower or peashooter plant. It has 4 main functions place plant, remove plant, update state of                the board with each turn, and clearing the board when finished with the game.
  
  * ShovelSelectController -> Shovel Selector has a mouse listener and only has one main function to remove existing plant type from the                                board.
  
  * SkipTurnListener -> Button that is able to skip or move the game one turn forward.
 
  * SunflowerSelectController -> Using mouse listener the user is able to select a sunflower from the menu and place it to the main                                       board (lawn).
  
  * TileController -> Has Mouse listener, and anytime the user places a plant it will update the board with the updated plant position.

#### JUnit Tests
##### Plants - Karl Schnalzer
* Test Classes Include: 
  - PlantTest CLASS -> testPlant(), testPlantCost(), testPlantHit(), testSetPlantHit(), testXPos(), testYPos()
  - PeashooterTest CLASS -> testPeashooterPosition(), testPeashooterHealth(), testPeashooterBuyThreshold()
  - SunflowerTest CLASS -> testSunfloerPosition()

##### Zombies - Sirak Berhane
* Test Classes Include: 
  - BasicZombieTest CLASS -> testZombieSpeed(), testZombieAttack(), testZombieType(), testZombieMovement(), testZombieIsNotDead(), testZombieIsDead(0

#### Road Map - Ryan Tordesillas 
* Completed and future implemtations of Milestones 1 to 4: 
![alt text](https://github.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/blob/master/Diagrams/Roadmap.PNG)

#### UML/Sequence Diagrams - Karl Schnalzer
##### UML Diagram - GUI CLASS

![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/UML_Class_2.png) 

##### Sequence Diagram - MVC CLASS
![alt text](https://github.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/blob/master/Diagrams/MVC-sequence.png)



## Milestone 3 (master branch) - Completed On: Sunday, November 25th, 2018

### Implementations

#### PLANTS - Sirak Berhane
Added 4 new Plants and an extra subclass; Explosive Plant 
type to the Plants vs. Zombies GUI:

* Wallnut : subclass of Passive Plant Type
  - Defensive plant type, used as a shield to protect other plants.
  - Has a slightly longer health points compared to the other plants
  - Cost: 50
  - Hit Threshold: 20

* Snow Pea Shooter : subclass of Shooter Plant Type
  - Shoots snow/frozen peas that damage and slow the zombies.
  - Cost: 175
  - Hit Threshold: 10
  - Attack: 3

* Hypno Shroom : subclass of Passive Plant Type
  - When eaten, Hypno-shrooms will make a zombie turn around and fight for you.
  - One time use plant (immediatly dies)
  - Cost: 125
  - Hit Threshold: 1

* Potato Mine : subclass of Explosive Plant Type
  - Potato mines will exlode on contact after 3 turns.
  - Cost: 75
  - Hit Threshold: 15
  - Attack: 10

#### ZOMBIES - Ryan Tordesillas
Added 4 new Zombies to the Plants vs. Zombies GUI:

* Bucket Zombie
  - Bucket gives this zombie extra shield from shooter type plants
  - Attack: 1
  - Hit Threshold: 15
  - Speed: 0.5x or every second turn

* Football Zombie
  - Like a football player this zombie has a full upper 
    body shield as well as more speed compared to the other zombies.
  - Attack: 2
  - Hit Threshold: 20
  - Speed: 0.8x or every turn

* Gargantuar Zombie
  - Boss level, this zombie is large in size making
    it the slowest zombie but the highest attack when near plants.
  - Attack: 4
  - Hit Threshold: 35
  - Speed: 0.2x or every third turn

* Newspaper Zombie
  - Reads a newspaper but once this zombie drops their newspaper their speed doubles.
  - Attack: 1
  - Hit Threshold: 20
  - Speed: 0.5 - 1x or every turn or second turn

#### GUI - Jolar Tabungar
* GUI Classes Implemented 
  * ImagePanel -> Used for drawing the lawn tiles on the grid panel. 
  
  * Wall-nut, Snow Pea, Potato Mine, and Hypno-Shroom Select Controller -> Contains a mouse listener for when the user wants to plant       either of the above plants during when the game is running.
  
#### JUnit Test Cases
* Refined old test cases

#### UML Diagrams - Karl Schnalzer
##### UML Diagram - Plants and Zombies
![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/UML_Class_1_Milestone_3.png) 

##### UML Diagram - GUI
![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/UML_Class_2_Milestone_3.png) 



## Milestone 4 (master branch) - Completed On: Friday, December 7th, 2018 (FINAL)

### Implementations

#### GUI - Jolar Tabungar
* Undo and Redo Features (Bug fixes and Improvements made)
* Level Builder -> Player is able to create their own level
* All levels are imported as .XML format for simplicity with each 
     
#### Save/Load State - Ryan Tordesillas
* Implentation of Serialization Libraries 
* Save current game status to a file
* Load previous game status if the player wants to continue playing from last save

#### JUnit Test Cases - Sirak Berhane
* New Plant and Zombie Test Cases
    - PlantTypeTest CLASS: testHypnoShroom(), testPotatoMine(), testSnowPeashooter(), testWallnut()
    - ZombieTypeTest CLASS: testBucketZombie(), testFootballZombie(), testGargantuarZombie(), testNewspaperZombie()
  
#### UML/Sequence Diagrams - Karl Schnalzer
##### UML Diagram - Plants and Zombies
![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/Milestone4_UML_Class_1.png) 

##### UML Diagram - GUI
![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/Milestone4_UML_Class_2.png) 

##### Sequence Diagram - Load Game
![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/Load%20Sequence%20diagram.png)

##### Sequence Diagram - Save Game
![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/Save%20Sequence%20diagram.png)

### Optional Features
* Real-Time Game Play -> [NOT IMPLEMENTED]
* Android Version -> [NOT IMPLEMENTED]
