function binarySearch(arr,val){
	var mid = math.floor(arr.length/2);
	var end = arr.length;
	var start = 0;

	while (mid >=start && mid <= end){
		if (val == arr[mid]){
			return true;
		}

		else if (val < arr[mid]){
			end= mid;
			mid= math.floor((end-start) / 2);

		}

		else if (val > arr[mid]){
			start = mid;
			mid += math.floor((end-start)/2);
		}
	}
return false;
}

console.log(binarySearch([1,2,3,4,5,6,7,8], 6));