import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { Headers, Http, URLSearchParams } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import { RequestOptionsArgs } from "@angular/http/src/interfaces";


@Injectable()
export class CommonService{


    constructor(private http:Http, private router:Router, private activatedRoute:ActivatedRoute){ 
    }

    post(url:string, body:any, options:RequestOptionsArgs, errorHandler:any){
        url = '/api/' + url ; 
        url = url.replace("api//", "api/");

        let bodyStr = JSON.stringify(body);

        return this.http.post(url, bodyStr, options).toPromise().catch(error => errorHandler(error, this));
    }

    getEnv(){
        return environment;
    }

    getHttp():Http{
        return this.http;
    }

    getRouter():Router{
        return this.router;
    }

    getActivatedRoute():ActivatedRoute{
        return this.activatedRoute;
    }

    getDefaultHeader():Headers{
        return new Headers({ 'Content-Type': 'application/json' });
    }


}
