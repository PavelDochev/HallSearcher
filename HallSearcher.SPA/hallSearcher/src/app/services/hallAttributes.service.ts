import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ServerUtil } from '../utils/serverUtil';

@Injectable()
export class HallAttributesService {
    
    constructor(private http: HttpClient) { }

    getByUserName() {
        return this.http.get(ServerUtil.SERVER_URL() + '/api/getHallAttributes');
    }
}