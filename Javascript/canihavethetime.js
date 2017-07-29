function canihavethetime(HOUR, MINUTE, PERIOD){

if (MINUTE >= 30){
	MINUTE = "almost";
	HOUR = HOUR +1;
	}

	if (MINUTE <= 30){
		MINUTE = "just after", HOUR;
	}
	

if (PERIOD = "AM"){
	PERIOD= "in the morning";
}
	
	else {
		PERIOD= "in the evening";
	}

console.log("It's", MINUTE, HOUR, PERIOD);

}



