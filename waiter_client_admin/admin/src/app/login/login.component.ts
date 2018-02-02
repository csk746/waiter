import { Component , OnInit} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from './login.service';
import { User } from '../model/user';

@Component({
  selector: 'login-component',
  templateUrl: './login.component.html',
  styleUrls: ['../../css/custom.css']
})
export class LoginComponent {

  loginId:string;
  password:string;
  user: User = new User();

  constructor(private loginService: LoginService) {
  }

  ngOnInit(){
  }

  login() {
    console.log ( this.user.loginId)
    this.loginService.loginProcess(this.user);
  }

  lostPassword() {
    alert('바보')
  }

  createAccount() {
    console.log("create User page route")
  }
}
