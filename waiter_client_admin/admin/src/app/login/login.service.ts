import { Injectable } from "@angular/core";
import { CommonService } from "../common/common.service";
import { User } from "../model/user";


@Injectable()
export class LoginService{

    constructor(private commonService:CommonService){
    }

    loginProcess(user:User){
        this.commonService.post("login", user, null, this.loginErrorHandler).then( res => {
            return res ; 
        })
    }

    loginErrorHandler(error: any, that: any) {
        switch (error.status) {
          default:
            alert("statusCode : " + error.status)
            break;
        }
        return Promise.reject(error.message || error);
      }


}
