var str = 0;

for (var i = 60; i >= 0; i--) {
    if (i > 30){
        str = i+" days left,"+" THIS IS CRAP IT'S SO FAR AWAY!";
        console.log(str);
    }

    else if (i <= 30  && i > 5){
        str = i+" days left,"+" FINALLY WE ARE GETTING SOMEWHERE";
        console.log(str);
    }

    else if (i <= 5 && i > 0){
        str = i+" OMG OMG OMG OMG OMG OMG";
        console.log(str);
 
    }

    else if (i == 0){
        str = "IT'S MY BIRTHDAY< SUCK IT JABRONIES!!!";
        console.log(str);
    }
}

