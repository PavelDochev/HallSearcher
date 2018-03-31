import { Component, OnInit } from '@angular/core';
import { HallAttributesService } from './services/hallAttributes.service';
import { HallAttributesViewModel } from './models/hallAttributesViewModel';
import { HallSearchViewModel } from './models/hallSearchViewModel';
import { HallService } from './services/hall.service';
import { HallViewModel } from './models/hallViewModel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  hallAttributes:any[]=[];
  hallSearchViewModel:HallSearchViewModel;
  halls:HallViewModel[];

  constructor(private hallAttributesService:HallAttributesService,
              private hallService:HallService){}

  async ngOnInit(){
    this.hallSearchViewModel= new HallSearchViewModel();

    await this.hallAttributesService.getByUserName().subscribe(x=>
        (x as HallAttributesViewModel[]).forEach(element => {
          var attr = {label:element.name,value:{id:element.id,name:element.name}}
          this.hallAttributes.push(attr)
        }));
  }

  async searchHalls(){
    await this.hallService.getHallsBySearchCriteria(this.hallSearchViewModel).subscribe(data=>{
       this.halls = data as HallViewModel[]
       this.halls.forEach(element => {
         element.availabilities.forEach(x=>{
           x.startDate = this.timeConverter(x.startDate);
           x.endDate = this.timeConverter(x.endDate);
         })
       });
       this.calculateAveragePriceForHall();
      });
  }

  timeConverter(UNIX_timestamp){
    var a = new Date(UNIX_timestamp * 1000);
    var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
    var year = a.getFullYear();
    var month = months[a.getMonth()];
    var date = a.getDate();
    var hour = a.getHours();
    var min = a.getMinutes();
    var sec = a.getSeconds();
    var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
    return time;
  }

  calculateAveragePriceForHall(){
   
    var diff = Math.abs(this.hallSearchViewModel.startDate.getTime() - this.hallSearchViewModel.endDate.getTime());
    var hours = Math.ceil(diff / (1000 * 3600)); 
    var days = Math.ceil(diff / (1000 * 3600 * 24)); 
    if(days==0) days=1;
    
    var startDateHours = this.hallSearchViewModel.startDate.getHours()
    var endDateHours = this.hallSearchViewModel.endDate.getHours()
    

    this.halls.forEach(x=>{

      var hoursNight = Number(x.startOfNightPeriod.split(':')[0]);
      var hoursNightOver = Number(x.endOfNightPeriod.split(':')[0]);
      
      //how many hours per day are night price
      var hoursAtNight = (24-hoursNight + hoursNightOver)* days;
      
      x.avrgPrice = x.pricePerHour*(hours-hoursAtNight) + x.pricePerHourNight*hoursAtNight;
    });

     


  }
}
