import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {SearchDataService} from '../../shared/pipes/search-data.service';

@Component({
  selector: 'app-shoes',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './shoes.component.html',
  styleUrl: './shoes.component.css'
})
export class ShoesComponent {
  constructor(private formDataService: SearchDataService) { }

  ngOnInit() {
    const savedData = this.formDataService.getAllData();
    for (let i = 0; savedData.length; i++) {
      console.log(savedData[i])
    }
    console.log(savedData)
    console.log(savedData.length)
  }
}
