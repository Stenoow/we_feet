import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {SearchDataService} from '../../../../shared/pipes/search-data.service';
import {FormsModule} from '@angular/forms';
import {Trademark} from '../../../../core/enums/Trademark';
import {ApiService} from '../../../../shared/pipes/api/api.service';

@Component({
  selector: 'app-step-6',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './step-6.component.html',
  styleUrl: './step-6.component.css'
})
export class Step6Component {
  step6Data = {
    trademarkId: 0,
  };

  tradeMarks: Trademark[] = [];

  constructor(private router: Router, private formDataService: SearchDataService, private apiService: ApiService) { }

  ngOnInit() {
    const savedData = this.formDataService.getStepData(6);
    if (savedData) {
      this.step6Data = savedData;
    }
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

  onSubmit() {
    this.formDataService.setStepData(6, this.step6Data);
    this.router.navigate(['/results']);
  }
}
