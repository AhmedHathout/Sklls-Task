import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersonService } from './person.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { TopBarComponent } from './top-bar/top-bar.component';

@NgModule({
  declarations: [
    AppComponent, TopBarComponent, PersonListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,

    RouterModule.forRoot([{ path: '', component: PersonListComponent }])
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
