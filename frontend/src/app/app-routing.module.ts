import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './_herlpers';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './app.component';
import { PersonListComponent } from './person-list/person-list.component';

const routes: Routes = [
  { path: '', component: PersonListComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },

  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
