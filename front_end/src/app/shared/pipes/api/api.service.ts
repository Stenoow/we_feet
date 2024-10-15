import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Discipline} from '../../../core/enums/Discipline';
import {SurfaceArea} from '../../../core/enums/SurfaceArea';
import {Trademark} from '../../../core/enums/Trademark';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = environment.apiUrl;

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
