import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaylaterComponent } from './paylater.component';

describe('PaylaterComponent', () => {
  let component: PaylaterComponent;
  let fixture: ComponentFixture<PaylaterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaylaterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaylaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
