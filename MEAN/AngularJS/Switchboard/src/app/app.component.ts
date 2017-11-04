import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  buttons = [];
  status= null;

  initiateButtons(){
    this.buttons = [true, true, true, true, true, true, true, true, true, true];
  }

  click(idx){
    this.buttons[idx] = !this.buttons[idx];
  }

  ngOnInit(){
    this.initiateButtons();
  }
}
