Reflection 1:
The method returns a Player, but it can actually give back any kind of player—HumanPlayer, LinusPlayer, or OmolaPlayer—because all of those classes come from (extend) the Player class.
In Java, if a class is a parent (superclass), a variable of that type can hold an object of any child (subclass).


Reflection 2:
The error happened because once we removed the method body from the player class, it no longer had a picknextmove() method at all.
but the game engine still tried to call picknextmove() on something typed as player, so the compiler complained that the method didn’t exist.
by adding picknextmove() back as an abstract method in player, ww are telling java that every subclass must create its own version of that method.

Reflection 3:
the main class and tictactoegame only work with the player type and never with the specific subclasses.
because of polymorphism, a player variable can actually hold any kind of player object, like humanplayer, linusplayer, or omolaplayer. when the game calls picknextmove(), java looks at the real type of the object and runs the correct overridden method. this automatic choosing of the right method at runtime is called dynamic dispatch.