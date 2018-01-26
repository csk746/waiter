import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable()
export class CommonService{
    constructor(private http : HttpClient, private router:Router, private activatedRoute:ActivatedRoute){
    }

    post(url:string, body:any, options: any, errorHandler:any){
        url = '/api/' + url ;
        url = url.replace("api//", "api/");

        let bodyStr = JSON.stringify(body);

        return this.http.post(url, bodyStr, options ? options : {} ).toPromise().catch(error => errorHandler(error, this));
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

    getDefaultHeader():Headers{
        return new Headers({ 'Content-Type': 'application/json' });
    }


}
