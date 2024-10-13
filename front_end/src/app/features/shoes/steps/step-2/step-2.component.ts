import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {SearchDataService} from '../../../../shared/pipes/search-data.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-step-2',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './step-2.component.html',
  styleUrl: './step-2.component.css'
})
export class Step2Component {
  step2Data = {
    size: 40,
  };

  constructor(private router: Router, private formDataService: SearchDataService) { }

  ngOnInit() {
    const savedData = this.formDataService.getStepData(2);
    if (savedData) {
      this.step2Data = savedData;
    }
  }

  onSubmit() {
    this.formDataService.setStepData(2, this.step2Data);
    this.router.navigate(['/step3']);
  }
}
