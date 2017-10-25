import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  date = new Date();
  utcDate = new Date(this.date.toUTCString());
  time = null;
  clicked = null;

  setPst(){
    this.time = this.utcDate.setHours(this.utcDate.getHours()-8);
    console.log(this.time);
    this.clicked = 'PST';
  }
  setMst(){
    this.time = this.utcDate.setHours(this.utcDate.getHours()-6);
    console.log(this.time);
    this.clicked = 'MST';
  }
  setCst(){
    this.time = this.utcDate.setHours(this.utcDate.getHours()-5);
    console.log(this.time);
    this.clicked = 'CST';
  }
  setEst(){
    this.time = this.utcDate.setHours(this.utcDate.getHours()-4);
    console.log(this.time);
    this.clicked = 'EST';
  }
  clear(){
    this.time = null;
    this.clicked = null;
  }
}
