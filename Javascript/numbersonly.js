function numbersonly(arr){
	var newArr= [];
	for(var i=0; i < arr.length; i++){
		if (typeof(arr[i]) === 'number'){
			newArr.push(arr[i]);
		}
	}
console.log(newArr);

}

//BONUS//

function numbersonly(arr){
	for(var i=0; i < arr.length; i++){
		if (typeof(arr[i]) != 'number'){
			arr.pop(i);
		}
	}
console.log(arr);

}

function numbersonly(arr){
	for(var i=0; i < arr.length; i++){
		var nums = arr.filter(typeof(arr[i]='number'));

		}
	}
console.log(arr[nums]);

}