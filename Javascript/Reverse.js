function reverse(arr){
	for (var i=0, j=arr.length-1; j>i; i++, j--){
		temp = arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
	}

console.log(arr);

}

	