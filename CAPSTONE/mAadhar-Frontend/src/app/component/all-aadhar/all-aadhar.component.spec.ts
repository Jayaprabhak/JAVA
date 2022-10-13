import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllAadharComponent } from './all-aadhar.component';

describe('AllAadharComponent', () => {
  let component: AllAadharComponent;
  let fixture: ComponentFixture<AllAadharComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllAadharComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllAadharComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
