import { Injectable } from '@angular/core';
import {InMemoryDbService} from "angular-in-memory-web-api";

@Injectable()
export class InMemoryService implements InMemoryDbService{

  private _database : any;

  constructor() { }

  createDb() {
    this._database = {};
    this.makeUserTableAndDummyData();
    return this._database;
  }

  private makeUserTableAndDummyData(){
    var users  = [{id : 1, loginId: "sopark", password: "1234"}];
    this.createTable("user", users);

    var products  = [{id : 1, name : "중국집"}];
    this.createTable("product", products);
  }

  private createTable(tableName : string , initialData: any[]){
    this._database[tableName] = initialData
  }
}
