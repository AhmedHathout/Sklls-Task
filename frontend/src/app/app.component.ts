import { Component, OnInit } from '@angular/core';
import { PersonService } from './person.service';
import { Person } from './person';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Sklls';
  //public persons: Person[];
  //constructor(private personService: PersonService) {
  //  this.persons = [];
  //}

  //ngOnInit() {
  //  this.getPersonsByLocation("");
  //}

  //public getPersonsByLocation(location: string): void {
  //  this.personService.getPersonsByLocation(location).subscribe(
  //    (response: Person[]) => {
  //      this.persons = response;
  //    },

  //    (error: HttpErrorResponse) => {
  //      alert(error.message);
  //    }
  //  );
  //}
}
