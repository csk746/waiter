import { Component } from '@angular/core';
import { LoginService } from './login.service';

@Component({
  selector: 'login-component',
  templateUrl: './login.component.html',
  styleUrls: ['../../css/custom.css']
})

export class LoginComponent{

    constructor(private loginService :LoginService){
    }

    login(){
      this.loginService.loginProcess(null);
    }
    lostPassword(){
      alert('바보')
    }
    createAccount(){
      console.log ("create User page route")
    }
}