import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { Router, ActivatedRoute } from '@angular/router';
import { Headers } from "@angular/http/src/headers";
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable()
export class CommonService{
    constructor(private http : HttpClient, private router:Router, private activatedRoute:ActivatedRoute){
    }

    initUrl(url:string):string{
        let urlStr= '/api/' + url ;
        urlStr.replace("api//", "api/");
        return urlStr;
    }

    post(url:string, body:any, options: any, errorHandler:any){

        url = this.initUrl(url);

        let bodyStr = JSON.stringify(body);

        console.log ( bodyStr)

        return this.http.post(url, bodyStr, this.getOptions(options)).toPromise().catch(error => errorHandler(error, this));
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

    getOptions(options:any){
        return options != null ? options : this.getDefaultOption() 
    }

    getDefaultOption():any{
        let header = new HttpHeaders({ 'Content-Type': 'application/json' });
        return { headers:header}
    }

}
