import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  hallAttributes:any[];

  ngOnInit(){

    this.hallAttributes = [
      {label:'Маси', value:1},
      {label:'Сгъваеми столчета', value:2},
      {label:'Прозорци', value:3},
      {label:'Амфитеатрална', value:4},
      {label:'Маси от столове', value:5}
  ];
  }
}
