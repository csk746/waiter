import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CommonService } from './common/common.service';
import { LoginService } from './login/login.service';
import {environment} from "../environments/environment";
import {HttpClientInMemoryWebApiModule} from "angular-in-memory-web-api";
import {InMemoryService} from "./mock/in-memory-service.service";
import { MainComponent } from './dashboard/index/main.component';
import { SideMenuComponent } from './dashboard/sidebar/side.menu.component';
import { JoinComponent } from './login/join/join.component';
import { JoinService } from './login/join/join.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    JoinComponent,
    SideMenuComponent,
    MainComponent


  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    //environment.production ? [] : HttpClientInMemoryWebApiModule.forRoot(InMemoryService, { dataEncapsulation: false })
  ],
  providers: [CommonService, LoginService, JoinService],
  bootstrap: [AppComponent]
})
export class AppModule { }
