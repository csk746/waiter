import { Injectable } from "@angular/core";
import { CommonService } from "../../common/common.service";
import { User } from "../../model/user";
import { HttpParams } from "@angular/common/http/src/params";

@Injectable()
export class JoinService{

    constructor(private commonService:CommonService){
    }


    joinUser(user:User){
        return this.commonService.post('user/join', user);
    }

    idValidation(loginId:string){
        let user:User = new User();
        user.loginId = loginId;

        return this.commonService.post('user/validation', user);
    }

}
