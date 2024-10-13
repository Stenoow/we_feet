import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {SearchDataService} from '../../../../shared/pipes/search-data.service';
import {FormsModule} from '@angular/forms';
import {SurfaceArea} from '../../../../core/enums/SurfaceArea';
import {ApiService} from '../../../../shared/pipes/api/api.service';

@Component({
  selector: 'app-step-4',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './step-4.component.html',
  styleUrl: './step-4.component.css'
})
export class Step4Component {
  step4Data = {
    surfaceAreaId: 0,
  };

  surfaceAreas: SurfaceArea[] = [];

  constructor(private router: Router, private formDataService: SearchDataService, private apiService: ApiService) { }

  ngOnInit() {
    const savedData = this.formDataService.getStepData(4);
    if (savedData) {
      this.step4Data = savedData;
    }
    this.fetchSurfaceAreas();
  }

  fetchSurfaceAreas(): void {
    const disciplineId = this.formDataService.getAllData().step3.disciplineId;
    this.apiService.getSurfaceAreas(disciplineId).subscribe({next: (response) => {
        this.surfaceAreas = response;
      },
      error: (error) => {
        console.error('Erreur lors de la récupération des données', error);
      }}

    );
  }

  onSubmit() {
    this.formDataService.setStepData(4, this.step4Data);
    this.router.navigate(['/step5']);
  }
}
