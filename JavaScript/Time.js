
   var hour = 7;
   var minute = 30;
   var period = "AM";

    if (period == "AM") {
    period = "morning";
    }
    else {
        period = "evening";
    }


if(minute > 30) {
    minute = "It's almost ";
    hour = hour + 1;
}

if(minute < 30) {
    minute = "It's just after "
}

if (minute == 30) {
    minute = "It's half past "
}

console.log(minute, hour, "in the ", period);

