import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { Router, ActivatedRoute } from '@angular/router';
import { Headers } from "@angular/http/src/headers";
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable()
export class CommonService{
    constructor(private http : HttpClient, private router:Router, private activatedRoute:ActivatedRoute){
    }

    post(url:string, body:any, options: any, errorHandler:any){
        url = '/api/' + url ;
        url = url.replace("api//", "api/");

        let bodyStr = JSON.stringify(body);

        console.log ( bodyStr)

        let header = this.getDefaultHeader();

        return this.http.post(url, bodyStr, {headers: header } ).toPromise().catch(error => errorHandler(error, this));
    }

    getEnv(){
        return environment;
    }

    getHttp() : HttpClient{
        return this.http;
    }

    getRouter():Router{
        return this.router;
    }

    getActivatedRoute():ActivatedRoute{
        return this.activatedRoute;
    }

    getDefaultHeader():HttpHeaders{
        return new HttpHeaders({ 'Content-Type': 'application/json' });
    }


}
