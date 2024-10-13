import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchDataService {
  private formData: any = {
    step1: {},
    step2: {},
    step3: {}
  };

  constructor() { }

  setStepData(step: number, data: any) {
    this.formData[`step${step}`] = data;
  }

  getStepData(step: number) {
    return this.formData[`step${step}`];
  }

  getAllData() {
    return this.formData;
  }
}
