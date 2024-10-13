import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {SearchDataService} from '../../../../shared/pipes/search-data.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-step-1',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './step-1.component.html',
  styleUrl: './step-1.component.css'
})
export class Step1Component {
  step1Data = {
    sex: '',
  };

  constructor(private router: Router, private formDataService: SearchDataService) { }

  ngOnInit() {
    // Charger les données existantes si elles sont déjà présentes
    const savedData = this.formDataService.getStepData(1);
    if (savedData) {
      this.step1Data = savedData;
    }
  }

  onSubmit() {
    this.formDataService.setStepData(1, this.step1Data);
    this.router.navigate(['/step2']);
  }
}
