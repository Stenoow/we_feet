import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {SearchDataService} from '../../../../shared/pipes/search-data.service';
import {FormsModule} from '@angular/forms';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-step-2',
  standalone: true,
  imports: [
    FormsModule,
    NgClass
  ],
  templateUrl: './step-2.component.html',
  styleUrl: './step-2.component.css'
})
export class Step2Component {
  step2Data = {
    size: 40,
  };

  errors = {"size": ""};

  constructor(private router: Router, private formDataService: SearchDataService) { }

  ngOnInit() {
    const savedData = this.formDataService.getStepData(2);
    if (savedData) {
      this.step2Data = savedData;
    }
  }

  onSubmit() {
    console.log(this.step2Data.size)
    if (this.step2Data.size >= 30 && this.step2Data.size <= 60) {
      this.errors["size"] = "";
      this.formDataService.setStepData(2, this.step2Data);
      this.router.navigate(['/step3']);
    } else {
      this.errors["size"] = "La taille de chaussures doit être comprise entre 30 et 60 !";
    }
  }
}
