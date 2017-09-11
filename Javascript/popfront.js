

function pushToFront(arr, addvalue){
	newarr=[];
	newarr.push(addvalue);
	
	for (var i=0; i <arr.length; i++){
		newarr.push(arr[i]);
	}
console.log (newarr);
}