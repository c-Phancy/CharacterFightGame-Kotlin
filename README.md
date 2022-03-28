How to Play:

1. Load Characters 1 and 2 by entering either "gimli.txt" or "legolas.txt" when prompted. If nothing is entered, characters will be set to a default value.

2. Click 3 to Fight.

3. Continue through the fight sequence using the Enter key.

4. Replay the game, change the characters, or exit the program.

Assignment Requirements:

Create a game that will allow 2 different fictional characters to face off against each other in a simulated environment.  Please use my attributes exactly – this is MY game, not yours.

This program should have the following classes:

Character Class

            Maximum values should be private val variables and should  be checked on input so they cannot be used for cheating

            Attributes:       Name, Race,

                                    Hit Points (Max 100),

                                    Current hit points (calculated)

                                    Strength (Max 50),

                                    Agility (Max 10),

                                    Weapon,   (object from the Weapon Class)

                                    Armor  (object from the Armor Class)

            Methods:         toString() – to print out details about the character

                                    currentStatus   - print out the current status of this character

                                    reviveCharacter – resets character's currentHits to original hits

                                    reduceHits   (removes some number of hits from the character)



Dice Class

            Attributes:       sidesOfDie

            Methods:         Constructor with (  num_sides )

                                    roll  (returns a random number between 1 and num_sides )

Item Class

            Attributes:       name

Weapons Class - which inherits from Item class

            Attributes:       damageHits

            Methods:         toString



Armor Class - which inherits from Item class

            Attributes:       protectionHits

            Methods:         toString



Your program will load 2 different characters into your game from a text file which describes each character like this – 3 lines of information representing the character, weapon, and armor.  Each character has their own text file.

Dave, elf, 47, 30, 10      #Name, race, hits, strength, agility turn into a Character Object
Bow, 15                    #name, hits   turn into a Weapon Object
Leather, 10                #name, hits   turn into an Armor Object
Create a menu exactly like this:

1. Load Character 1
2. Load Character 2
3. Fight
4. Quit
   Loading the character will create the appropriate class objects for a character, the armor and weapon that this character uses.

Fighting will simulate the fighting with rounds of fighting using the following assumptions, printing the status of each step:

Loop fighting until one character has lost all of their hit points (DIES)
For each fighter
First roll an AGILE sided die for each fighter to determine which fighter goes first. The fighter with the highest score will go first.
Roll a 10-sided die to determine if the fighter hits or misses
The equation would be: roll10 < agility is a hit otherwise a miss.
A hits damage is determined by the character's strength and weapon's power with this formula:
hit = (strength * (1.0/roll4) + (weapon hits)/roll8) (as an integer)
This is then reduced by an armor save from the formula:
armor_save = (opponent's armor hits / roll15 ) (as an integer)
Reduce the opponent's current_hits by the (hit – armor_save) amount (Don't reduce by negative numbers)
End fighting loop (now do the opponent)
PAUSE after each round and print both fighter’s statistics
Print out the winner and both fighter's statistics


A rollN is a roll of an N-sided die.  So a roll7 would be a roll of a 7 sided die numbered 1-7.  For this program you will need to create 6 different Dice objects:  a Dagile for each character, D4, D8, D10, and D15



A typical fight scenario will look like this:

Legolas greenleaf fights with the Bow:
Hit: 31    Gimli's armor saved 8 points
Gimli's hits are reduced by 23 points.
Gimli has 67 left out of 90.
Gimli fights with the axe:
Hit: 46    Legolas greenleaf's armor saved 0 points
Legolas greenleaf's hits are reduced by 46 points.
Legolas greenleaf has 1 left out of 47.


Gimli fights with the axe:
Misses!
Legolas greenleaf fights with the Bow:
Misses!

Gimli fights with the axe:
Misses!
Legolas greenleaf fights with the Bow:
Hit: 13    Gimli's armor saved 21 points
Gimli's hits are reduced by 0 points.
Gimli has 67 left out of 90.

Gimli fights with the axe:
Misses!
Legolas greenleaf fights with the Bow:
Hit: 45    Gimli's armor saved 12 points
Gimli's hits are reduced by 33 points.
Gimli has 34 left out of 90.

Legolas greenleaf fights with the Bow:
Hit: 17    Gimli's armor saved 8 points
Gimli's hits are reduced by 9 points.
Gimli has 25 left out of 90.
Gimli fights with the axe:
Misses!

Legolas greenleaf fights with the Bow:
Misses!
Gimli fights with the axe:
Misses!

Legolas greenleaf fights with the Bow:
Hit: 10    Gimli's armor saved 21 points
Gimli's hits are reduced by 0 points.
Gimli has 25 left out of 90.
Gimli fights with the axe:
Misses!

Legolas greenleaf fights with the Bow:
Hit: 33    Gimli's armor saved 10 points
Gimli's hits are reduced by 23 points.
Gimli has 2 left out of 90.
Gimli fights with the axe:
Hit: 22    Legolas greenleaf's armor saved 1 points
Legolas greenleaf's hits are reduced by 21 points.
Legolas greenleaf has 0 left out of 47.

Gimli WINS!
-------------------------
Legolas greenleaf has 0 left out of 47.
Gimli has 2 left out of 90.
-------------------------
Project Detail Files:   gimli.txt  Download ,   legolas.txt  Download