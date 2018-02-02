import { Component , OnInit} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginService } from './login.service';
import { User } from '../model/user';
import { CommonService } from '../common/common.service';

@Component({
  selector: 'login-component',
  templateUrl: './login.component.html',
  styleUrls: ['../../resource/custom.css']
})
export class LoginComponent {

  loginId:string;
  password:string;
  user: User = new User();

  constructor(private loginService: LoginService, private commonService:CommonService) {
  }

  ngOnInit(){
    this.user.loginId = 'hsim';
    this.user.password = '1234';
  }

  login() {

    this.loginService.loginProcess(this.user).then( res =>{
      this.commonService.saveValue('myInfo', res)
      this.commonService.getRouter().navigateByUrl('home')
    });
  }

  lostPassword() {
    alert('바보')
  }

  createAccount() {
    console.log("create User page route")
  }
}
