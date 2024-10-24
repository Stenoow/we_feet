import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Discipline} from '../../../core/enums/Discipline';
import {SurfaceArea} from '../../../core/enums/SurfaceArea';
import {Trademark} from '../../../core/enums/Trademark';
import {environment} from '../../../../environments/environment';
import {Shoes} from '../../../core/enums/Shoes';
import {TypeSex} from '../../../core/enums/TypeSex';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getDisciplines(): Observable<Discipline[]> {
    return this.http.get<Discipline[]>(this.apiUrl + "/disciplines");
  }

  getSurfaceAreas(disciplineId: number = 0): Observable<SurfaceArea[]> {
    if (disciplineId === 0) {
      return this.http.get<SurfaceArea[]>(this.apiUrl + "/surfacearea");
    }
    return this.http.get<SurfaceArea[]>(this.apiUrl + "/surfacearea?disciplineId=" + disciplineId);
  }

  getTrademarks(): Observable<Trademark[]> {
    return this.http.get<Trademark[]>(this.apiUrl + "/trademarks");
  }

  getShoes(sex: TypeSex, price: number, size: number, disciplineId: number, trademarkId: number, surfaceareaId: number): Observable<Shoes[]> {
    let parameters = `sex=${sex}&price=${price}&size=${size}&disciplineId=${disciplineId}&trademarkId=${trademarkId}&surfaceareaId=${surfaceareaId}`;

    return this.http.get<Shoes[]>(this.apiUrl + "/shoes/filter?" + parameters);
  }

  createShoes(data : any): Observable<any> {
    return this.http.post(this.apiUrl + "/shoes", data);
  }
}
