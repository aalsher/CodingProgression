function InsertAt(arr, index, newvalue){
	arr[arr.length+1]=1;
	temp = arr[index];
	arr[index] = newvalue;
	arr[index+1] = temp;
	arr.pop();
console.log(arr);
}