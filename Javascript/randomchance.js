function randomchance(numofquarters){

		var quarterswon = null;
		for (var i= 0; i <= numofquarters; i++){
			quarterswon = (math.random() * (100-50) +50);
		}
		if (quarterswon > 0){
			return numofquarters + quarterswon;
		}
		if (quarterswon <= 0){
			return 0;
		}
	}
	