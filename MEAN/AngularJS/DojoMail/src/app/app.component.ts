import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
	emails = [{
		email: 'bill@gates.com',
		importance: true,
    subject: 'New Windows',
    content: 'Windows XI will launch in year 2100.'
	},
  {
    email: 'ada@lovelace.com',
		importance: true,
    subject: 'Programming',
    content: 'Loves Numbers'
  },
  {
    email: 'john@carmac.com',
    subject: 'Programming',
    content: 'Loves Numbers'
  },
  {
    email: 'john@carmac.com',
    subject: 'Programming',
    content: 'Loves Numbers'
  }]
}
