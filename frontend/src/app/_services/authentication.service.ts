import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { environment } from 'src/environments/environment';
import { User } from '../_models/user';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User | null>;
    public currentUser: Observable<User | null>;

  constructor(private http: HttpClient) {
    const currentUserString = localStorage.getItem('currentUser');
    if (currentUserString) {
      this.currentUserSubject = new BehaviorSubject<User | null>(JSON.parse(currentUserString));
    }
    else {
      this.currentUserSubject = new BehaviorSubject<User | null>(null);
    }
    this.currentUser = this.currentUserSubject.asObservable();
  }

    public get currentUserValue(): User | null {
        return this.currentUserSubject.value;
    }

  login(username: string, password: string) {
    const auth = window.btoa(username + ':' + password);
    const headers = new HttpHeaders({ 'Authorization' : `Basic ${auth}` });
    return this.http.post<any>(`${environment.apiUrl}/validatelogin`, {}, { headers: headers })
            .pipe(map(user => {
                // store user details and basic auth credentials in local storage to keep user logged in between page refreshes
                user.authdata = auth;
                localStorage.setItem('currentUser', JSON.stringify(user));
                this.currentUserSubject.next(user);
                return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}
