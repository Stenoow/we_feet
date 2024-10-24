import { Routes } from '@angular/router';
import {HomeComponent} from './features/home/home.component';
import {ShoesComponent} from './features/shoes/shoes.component';
import {SearchDataGuard} from './core/guards/search-data.guard';
import {Step1Component} from './features/shoes/steps/step-1/step-1.component';
import {Step2Component} from './features/shoes/steps/step-2/step-2.component';
import {Step3Component} from './features/shoes/steps/step-3/step-3.component';
import {Step4Component} from './features/shoes/steps/step-4/step-4.component';
import {Step6Component} from './features/shoes/steps/step-6/step-6.component';
import {Step5Component} from './features/shoes/steps/step-5/step-5.component';
import {AdminComponent} from './features/admin/admin.component';


export const routes: Routes = [
  { path: "", component: HomeComponent},
  { path: "step1", component: Step1Component},
  { path: "step2", component: Step2Component, canActivate: [SearchDataGuard]},
  { path: "step3", component: Step3Component, canActivate: [SearchDataGuard]},
  { path: "step4", component: Step4Component, canActivate: [SearchDataGuard]},
  { path: "step5", component: Step5Component, canActivate: [SearchDataGuard]},
  { path: "step6", component: Step6Component, canActivate: [SearchDataGuard]},
  { path: "results", component: ShoesComponent},
  { path: "admin", component: AdminComponent},
];
