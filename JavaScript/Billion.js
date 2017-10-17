
var money = .01;


for (i = 2; i <= 100; i++) {
    money = money*2;
    
    if (money >= Infinity)
    {
        break;
    }
}

console.log(money);
console.log(i);

// After 30 days the servant has $5,368,709.12
// It takes 21 days to get to 10,000
// It takes 30 days to get to a Billion
// It takes 101 days to get to Infinity dollars
