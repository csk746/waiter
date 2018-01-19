import { Component } from '@angular/core';

@Component({
  selector: 'login-component',
  templateUrl: './login.component.html',
  styleUrls: ['../../css/custom.css']
})

export class LoginComponent{

    constructor(){
    }

    login(){
      console.log ( "login")
    }
    lostPassword(){
      alert('바보')
    }
    createAccount(){
      console.log ("create User page route")
    }
}