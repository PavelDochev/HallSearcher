import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { OwlNativeDateTimeModule,OwlDateTimeModule } from 'ng-pick-datetime';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import {CalendarModule} from 'primeng/calendar';
import {MultiSelectModule} from 'primeng/multiselect';
import { HallAttributesService } from './services/hallAttributes.service';
import { HttpClientModule } from '@angular/common/http';
import { HallService } from './services/hall.service';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CalendarModule,
    HttpClientModule,    
    MultiSelectModule,
    BrowserAnimationsModule
  ],
  providers: [HallAttributesService,
    HallService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
