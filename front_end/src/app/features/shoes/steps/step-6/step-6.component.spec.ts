import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Step6Component } from './step-6.component';

describe('Step2Component', () => {
  let component: Step6Component;
  let fixture: ComponentFixture<Step6Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Step6Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Step6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
