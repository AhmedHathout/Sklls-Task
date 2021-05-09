import { Component, OnInit } from '@angular/core';
import { Person } from '../person';
import { HttpErrorResponse } from '@angular/common/http';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
  public persons: Person[] = [];
  public allPersons: Person[] = [];

  constructor(private personService: PersonService) {}

  ngOnInit(): void {
    this.getPersonsByLocation('');
  }

  public getPersonsByLocation(location: string): void {
    this.personService.getPersonsByLocation(location).subscribe(
      (response: Person[]) => {
        this.allPersons = response;
        this.persons = this.allPersons;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public filterPersonsByLocation(location: string): void {
    const results: Person[] = [];
    for (const person of this.allPersons) {
      if (person.location.toLowerCase().trim().indexOf(location.toLowerCase()) !== -1) { // I think it is better this way without trim
        results.push(person);
      }
    }

    this.persons = results;
    if (!location) { // If the location is empty, it will reset the persons list.
      this.persons = this.allPersons;
    }
  }
}
