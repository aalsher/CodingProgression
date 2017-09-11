function pushToFront(arr){
	arr[arr.length +1]= 1;
	for (var i =arr.length; i > 0; i--){
		arr[i]= arr[i-1];
	}
	arr[0]= val;
}