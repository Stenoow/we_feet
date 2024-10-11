import { Routes } from '@angular/router';
import {HomeComponent} from './features/home/home.component';
import {ShoesComponent} from './features/shoes/shoes.component';


export const routes: Routes = [
  { path: "", component: HomeComponent},
  { path: "shoes", component: ShoesComponent},
];
