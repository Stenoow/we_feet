import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {SearchDataService} from '../../../../shared/pipes/search-data.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-step-5',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './step-5.component.html',
  styleUrl: './step-5.component.css'
})
export class Step5Component {
  step5Data = {
    price: 0,
  };

  constructor(private router: Router, private formDataService: SearchDataService) { }

  ngOnInit() {
    const savedData = this.formDataService.getStepData(5);
    if (savedData) {
      this.step5Data = savedData;
    }
  }

  onSubmit() {
    this.formDataService.setStepData(5, this.step5Data);
    this.router.navigate(['/step6']);
  }
}
