import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import {SearchDataService} from '../../shared/pipes/search-data.service';

@Injectable({
  providedIn: 'root'
})
export class SearchDataGuard implements CanActivate {

  constructor(private router: Router, private formDataService: SearchDataService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const step = parseInt(route.url[0].path.replace('step', ''), 10);

    for (let i = 1; i < step; i++) {
      const stepData = this.formDataService.getStepData(i);
      if (!stepData || Object.keys(stepData).length === 0) {
        this.router.navigate(['/step1']);
        return false;
      }
    }

    return true;
  }
}
