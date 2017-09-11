

function PopFront(arr){
	temp = arr[0];
	arr[0] = arr[arr.length-1];
	arr[arr.length-1]=temp;

	var firstvalue = arr[arr.length-1];
	arr.pop();
	console.log(arr);
	return firstvalue;
}