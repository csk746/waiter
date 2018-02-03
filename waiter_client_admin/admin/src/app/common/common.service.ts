import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { Router, ActivatedRoute } from '@angular/router';
import { Headers } from "@angular/http/src/headers";
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable()
export class CommonService{
    constructor(private http : HttpClient, private router:Router, private activatedRoute:ActivatedRoute){
    }

    storage:Map<string, any>= new Map();

    getUrl(url:string):string{
        let urlStr= '/api/' + url ;
        urlStr.replace("api//", "api/");
        return urlStr;
    }

    getBodyStr(body:any):string{
        if ( !body ) return null ; 
        let bodyStr = JSON.stringify(body);
        console.log ( " requestBody : " + bodyStr);
        return bodyStr ;
    }

    post(url:string, body:any){
        return this.postWithOption(url, body, null , null);
    }

    postWithOption(url:string, body:any, options: any, errorHandler:any){
        if ( !errorHandler) errorHandler = this.defaultErrorHandler;

        return this.http.post(this.getUrl(url), this.getBodyStr(body), this.getOptions(options)).toPromise().catch(error => errorHandler(error, this));
    }

    put(url:string, body:any){
        return this.putWithOption(url, body, null, null);
    }
    putWithOption(url:string, body:any, options: any, errorHandler:any){
        if ( !errorHandler) errorHandler = this.defaultErrorHandler;

        return this.http.put(this.getUrl(url), this.getBodyStr(body), this.getOptions(options)).toPromise().catch(error => errorHandler(error, this));
    }

    delete(url:string){
        this.deleteWithOption(url, null, null);
    }
    deleteWithOption(url:string, options: any, errorHandler:any){
        if ( !errorHandler) errorHandler = this.defaultErrorHandler;

        return this.http.delete(this.getUrl(url), this.getOptions(options)).toPromise().catch(error => errorHandler(error, this));
    }
    get(url:string){
        return this.getWithOption(url, null, null);
    }
    getWithOption(url:string, options: any, errorHandler:any){
        if ( !errorHandler) errorHandler = this.defaultErrorHandler;
        return this.http.get(this.getUrl(url), this.getOptions(options)).toPromise().catch(error => errorHandler(error, this));
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
        return { headers:this.getDefaultHeader()}
    }
    getDefaultHeader(){
        let header = new HttpHeaders({ 'Content-Type': 'application/json' });

        return header ;
    }
    
    defaultErrorHandler(error: any, that: any) {
        switch (error.status) {
          default:
            alert("statusCode : " + error.status)
            break;
        }
        return Promise.reject(error.message || error);
      }

      saveValue(key:string, value:any){
          this.storage.set(key, value);
      }
      getValue(key:string){
          return this.storage.get(key);
      }

}
