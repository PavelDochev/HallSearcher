import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ServerUtil } from '../utils/serverUtil';
import { HallSearchViewModel } from '../models/hallSearchViewModel';

@Injectable()
export class HallService {
    
    constructor(private http: HttpClient) { }

    getHallsBySearchCriteria(hallSearchVM:HallSearchViewModel) {
        const httpOptions = {
            headers: new HttpHeaders({
              'Content-Type':  'application/json'
            })
          };
        let body = JSON.stringify(hallSearchVM);
        return this.http.post(ServerUtil.SERVER_URL() + '/api/hall/search',body,httpOptions);
    }
}