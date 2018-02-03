import { Component , OnInit} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonService } from '../../common/common.service';
import { User } from '../../model/user';
import { JoinService } from './join.service';

@Component({
  selector: 'join-component',
  templateUrl: './join.component.html',
  styleUrls: ['../../../resource/custom.css', 'join.component.css'],
})
export class JoinComponent {

  user:User= new User();
  loginId:string;
  password:string;

  idCheck=true;

  constructor(private commonService:CommonService, private joinService:JoinService) {
  }

  ngOnInit(){
  }

  setGender(gender:string){
    this.user.gender = gender ; 
  }
  getMaleButtonClassName() {
    return this.getGenderButtonClassName('MALE');
  }
  getFemaleButtonClassName() {
    return this.getGenderButtonClassName('FEMALE');
  }

  getGenderButtonClassName(gender: string) {
    if (gender == this.user.gender) {
      return 'btn btn-primary'
    }
    return 'btn btn-default';
  }

  createAccount() {
    console.log("create User page route")
  }

  validationId(loginId:string){
    this.joinService.idValidation(loginId).then( res=>{
      console.log ( res)
      this.idCheck = res;
    })

  }

  join(){
    this.joinService.joinUser(this.user).then( res =>{
      this.commonService.getRouter().navigateByUrl('/login')
    })
  }

}
