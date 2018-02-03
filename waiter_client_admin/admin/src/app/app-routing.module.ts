import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SideMenuComponent } from './dashboard/sidebar/side.menu.component';
import { MainComponent } from './dashboard/index/main.component';
import { JoinComponent } from './login/join/join.component';

const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent},
    { path: 'join', component: JoinComponent},
    {
        path: 'home',
        component : MainComponent,
        children:[
           { path: 'main', component: LoginComponent},
        ]
    }
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
    declarations: []
  })
  export class AppRoutingModule { }