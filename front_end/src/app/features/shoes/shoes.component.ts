import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {SearchDataService} from '../../shared/pipes/search-data.service';
import {Shoes} from '../../core/enums/Shoes';
import {ApiService} from '../../shared/pipes/api/api.service';
import {Router} from '@angular/router';
import {NgForOf, SlicePipe} from '@angular/common';

@Component({
  selector: 'app-shoes',
  standalone: true,
  imports: [
    FormsModule,
    SlicePipe,
    NgForOf
  ],
  templateUrl: './shoes.component.html',
  styleUrl: './shoes.component.css'
})
export class ShoesComponent {
  shoes: Shoes[] = [];

  constructor(private router: Router, private formDataService: SearchDataService, private apiService: ApiService) { }

  ngOnInit() {
    const savedData = this.formDataService.getAllData();
    for (let i = 1; i <= 6; i++) {
      if (Object.keys(savedData["step" + i]).length <= 0) {
        this.router.navigate(['/step1']);
      }
    }

    this.fetchShoes();
  }

  fetchShoes(): void {
    let datas = this.formDataService.getAllData();
    this.apiService.getShoes(datas.step1.sex, datas.step2.size, datas.step5.price, datas.step3.disciplineId, datas.step6.trademarkId, datas.step4.surfaceAreaId).subscribe({next: (response) => {
        this.shoes = response;
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données', error);
      }}

    );
  }
}
