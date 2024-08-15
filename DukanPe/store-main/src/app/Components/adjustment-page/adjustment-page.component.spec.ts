import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdjustmentPageComponent } from './adjustment-page.component';

describe('AdjustmentPageComponent', () => {
  let component: AdjustmentPageComponent;
  let fixture: ComponentFixture<AdjustmentPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdjustmentPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdjustmentPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
