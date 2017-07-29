function birthdaycountdown(num){
	var daysUntilMyBirthday= null; 

	if (num > 30){
		daysUntilMyBirthday = "Such a long time ... :(";
	}
	if(num< 30 && num >=5){
		daysUntilMyBirthday= "Almost there ish...!";
	}
	if (num < 5 && num > 0){
		daysUntilMyBirthday= "YOU ARE SO DAMN CLOSE!";
	}
	if (num == 0){
		daysUntilMyBirthday = "Party!";
	}

console.log (num + " days until my birthday. "+ daysUntilMyBirthday);

}


