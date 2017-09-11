function InsertAt(arr, index){
	temp = arr[index];
	arr[index]= arr[index+1];
	arr.pop();
	console.log (arr);
	return temp;
}
