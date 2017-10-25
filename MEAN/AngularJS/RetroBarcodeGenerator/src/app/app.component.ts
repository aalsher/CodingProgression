import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
	colors = [];
  fillcolors(){
    for(let y=0; y <10; y++){
      const randNum = (Math.floor(Math.random() * 6)) +1;
      if (randNum ===1){
        this.colors.push('Bisque');
      }
      else if(randNum ===2){
        this.colors.push('BlanchedAlmond');
      }
      else if(randNum ===3){
        this.colors.push('BurlyWood');
      }
      else if(randNum ===4){
        this.colors.push('Coral');
      }
      else if(randNum ===5){
        this.colors.push('Crimson');
      }
      else if(randNum ===6){
        this.colors.push('DarkSalmon');
      }
      else if(randNum ===7){
        this.colors.push('FireBrick');
      }
    }
  }

  ngOnInit(){
    this.fillcolors();
  }

}
