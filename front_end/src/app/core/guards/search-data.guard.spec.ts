import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { searchDataGuard } from './search-data.guard';

describe('searchDataGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => searchDataGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
