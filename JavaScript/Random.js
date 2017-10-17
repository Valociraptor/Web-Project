var win = 0;
var quarters = Math.floor(Math.random() * 100 + 1);
slot = 0;

console.log("You started with "+quarters+" quarters."); // Determines a random amount of quarters for the player to begin with.
console.log(".");
console.log(".");
console.log(".");
console.log(".");

for (quarters; quarters > 0; quarters--) {
    slot = Math.floor(Math.random() * 100); // Picks a random number between 0 -99


    if (slot == 8)  //If the random number above is equal to 8, the player wins
    {
        win = Math.floor(Math.random() * 100 / 2); //This determines a random number of quarters to win between 1 - 50
        quarters = quarters + win;
        console.log("You insert a coin in the Machine and...~~~~~YOU WON "+win+" QUARTERS YOU LUCKY BASTARD!!!!!!~~~~"+"You now have a total of "+(quarters-1)+" Quarters....Something compels you to put another coin in the slot...")
    }

    else {
        console.log ("You insert a coin in the Machine and...You lost a quarter...You have "+(quarters - 1)+" left.");
    }
}
