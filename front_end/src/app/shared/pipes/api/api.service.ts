import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Discipline} from '../../../core/enums/Discipline';
import {SurfaceArea} from '../../../core/enums/SurfaceArea';
import {Trademark} from '../../../core/enums/Trademark';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://127.0.0.1:8081/api';

  constructor(private http: HttpClient) { }

  getDisciplines(): Observable<Discipline[]> {
    return this.http.get<Discipline[]>(this.apiUrl + "/disciplines");
  }

  getSurfaceAreas(disciplineId: number): Observable<SurfaceArea[]> {
    return this.http.get<SurfaceArea[]>(this.apiUrl + "/surfacearea?disciplineId=" + disciplineId);
  }

  getTrademarks(): Observable<Trademark[]> {
    return this.http.get<Trademark[]>(this.apiUrl + "/trademarks");
  }
}
