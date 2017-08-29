import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { AddUserComponent } from './add-user/add-user.component';
import {UserService} from './user-service/user.service';
import { TitleComponent } from './Title/title.component';
import {TitleService} from './Title-service/title.service';
import { EditTitleComponent } from './add-Title/edit-title.component';
import { TitleDetailComponent } from './title-detail/title-detail.component';

const appRoutes: Routes = [
  {path: 'login', component: AddUserComponent},
  {path: 'modify-Title', component: EditTitleComponent },
  {path: 'Title', component: TitleComponent },
  {path: 'Title/:id', component: TitleDetailComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'}

];


@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    TitleComponent,
    EditTitleComponent,
    TitleDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService, TitleService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
