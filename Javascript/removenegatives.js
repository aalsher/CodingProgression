function removenegatives(arr){
	newarr = [];
	for(var i=0; i < arr.length; i++){
		if(arr[i] > 0){
			newarr.push(arr[i]);
		}
	}
console.log(newarr);
}


//SOLUTION 2//

function removenegatives(arr){
	// newarr = [];
	for (var i=0; i <arr.length; i++){
		if (arr[i] < 0){
			arr[i]="hello";
		}
		if (typeof arr[i] === 'number'){
		arr.push(arr[i]);
		}
	}
console.log(arr);
}

function removenegatives(arr){
	
}

	