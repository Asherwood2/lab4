To run lab 4, run the Lab4Runnable file NOT the guiRunnable. The design patterns adapted were strategy and facade which were done in a new file for lab 4 in guiFoundation. 
The current state of the gui in lab 4 is unchanged from lab 3, I was not able to finish the gui in lab 3 but decided to use lab 3 since it was fresh on my mind.
Lab 3 repo can be found on its own on this GitHub, thank you for your time. 



Submission requirements for the design patterns

The 2 design patterns that I implemented were strategy pattern and the facade pattern.

The advantage I hope to acheive with them is better GUI layout code using the
grid method (strategy pattern) and then seperate all the gui workings from the main driver
class that will run the program. This will simplify my code and seperate tasks that were
together in lab 3.

For the strategy pattern I had changed the existing borderlayout to a gridlayout
which makes the code easier to read. There was little to no changes needing here
to make sure the program still worked how it should,
the other classes were dependent on other lines of code to run successfully.

For the facade pattern to seperate the gui from the driver
I created a class solely for building the gui. I seperated definitive parts into
methods that were clear to understand. I also created a new main to run this. Super simple,
I create an object and then I call an overarching method to create the gui.
Main doesn't have to know the details of what it takes to build the gui and I achieved that.
I changed very little to integrate the facade pattern.
The main in lab 3 had the code, although it was unorganized and was lumped into main, it was
there and properly calling other methods in other classes.

Link to Lab4 repository

https://github.com/Asherwood2/lab4
