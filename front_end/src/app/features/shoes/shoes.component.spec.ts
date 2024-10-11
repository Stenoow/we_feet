import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoesComponent } from './shoes.component';

describe('ShoesComponent', () => {
  let component: ShoesComponent;
  let fixture: ComponentFixture<ShoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShoesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
