import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {SearchDataService} from '../../../../shared/pipes/search-data.service';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../../shared/pipes/api/api.service';
import {Discipline} from '../../../../core/enums/Discipline';

@Component({
  selector: 'app-step-3',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './step-3.component.html',
  styleUrl: './step-3.component.css'
})
export class Step3Component {
  step3Data = {
    disciplineId: 0,
  };

  disciplines: Discipline[] = [];

  constructor(private router: Router, private formDataService: SearchDataService, private apiService: ApiService) {

  }

  ngOnInit() {
    const savedData = this.formDataService.getStepData(3);
    if (savedData) {
      this.step3Data = savedData;
    }
    this.fetchDisciplines();
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
    this.formDataService.setStepData(3, this.step3Data);
    this.router.navigate(['/step4']);
  }
}
