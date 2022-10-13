import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyAadharComponent } from './apply-aadhar.component';

describe('ApplyAadharComponent', () => {
  let component: ApplyAadharComponent;
  let fixture: ComponentFixture<ApplyAadharComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApplyAadharComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApplyAadharComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
