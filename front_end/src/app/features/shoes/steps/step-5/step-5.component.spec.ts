import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Step5Component } from './step-5.component';

describe('Step2Component', () => {
  let component: Step5Component;
  let fixture: ComponentFixture<Step5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Step5Component]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Step5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
