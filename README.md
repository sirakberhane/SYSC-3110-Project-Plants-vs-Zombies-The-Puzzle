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
  - GameGUI CLASS
    -
  
  - ShovelSelectController CLASS
    -
  
  - SkipTurnListener CLASS
    -
  
  - SunflowerSelectController CLASS
    -
  
  - TileController CLASS
    -

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
##### UML Diagram 1 - MVC CLASS

![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/UML_Class_1.png) 

##### UML Diagram 2 - GUI CLASS

![alt text](https://raw.githubusercontent.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/master/Diagrams/UML_Class_2.png) 

##### Sequence Diagram - MVC CLASS
![alt text](https://github.com/sirakberhane/SYSC-3110-Project-Plants-vs-Zombies-The-Puzzle/blob/master/Diagrams/MVC-sequence.png)
