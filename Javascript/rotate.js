function rotatearr(arr, num){
    for(var outer=0; i <num; i++){
        temp= arr[arr.length-1];
        for var (inner=arr.length-1; inner >= 0; j--){
            arr[inner-1]=arr[inner];
        }
        arr[0]= temp;
    }
    console.log(arr);
}