import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {SearchDataService} from '../../shared/pipes/search-data.service';
import {ApiService} from '../../shared/pipes/api/api.service';
import {Discipline} from '../../core/enums/Discipline';
import {SurfaceArea} from '../../core/enums/SurfaceArea';
import {Trademark} from '../../core/enums/Trademark';
import {TypeSex} from '../../core/enums/TypeSex';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    RouterLink,
    FormsModule
  ],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  adminData = {
    name: "",
    sex: "",
    price: 0,
    minSize: 30,
    maxSize: 60,
    link: "",
    disciplineId: 0,
    surfaceareaId: 0,
    trademarkId: 0,
  };

  tradeMarks: Trademark[] = [];
  surfaceAreas: SurfaceArea[] = [];
  disciplines: Discipline[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.fetchDisciplines();
    this.fetchSurfaceAreas();
    this.fetchTrademarks();
  }

  fetchTrademarks(): void {
    this.apiService.getTrademarks().subscribe({next: (response) => {
        this.tradeMarks = response;
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données', error);
      }}

    );
  }

  fetchSurfaceAreas(): void {
    this.apiService.getSurfaceAreas().subscribe({next: (response) => {
        this.surfaceAreas = response;
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données', error);
      }}

    );
  }

  fetchDisciplines(): void {
    this.apiService.getDisciplines().subscribe({next: (response) => {
        this.disciplines = response; // Assigner les données récupérées
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données', error);
      }}

    );
  }

  onSubmit() {
    console.log(this.adminData)
    this.apiService.createShoes(this.adminData).subscribe({next: (response) => {
        console.log(response);
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données', error);
      }}

    );
  }
}
