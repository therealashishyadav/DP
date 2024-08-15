import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InvoiceStatementComponent } from './invoice-statement.component';

describe('InvoiceStatementComponent', () => {
  let component: InvoiceStatementComponent;
  let fixture: ComponentFixture<InvoiceStatementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InvoiceStatementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InvoiceStatementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
