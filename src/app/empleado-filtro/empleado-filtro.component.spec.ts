import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoFiltroComponent } from './empleado-filtro.component';

describe('EmpleadoFiltroComponent', () => {
  let component: EmpleadoFiltroComponent;
  let fixture: ComponentFixture<EmpleadoFiltroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmpleadoFiltroComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpleadoFiltroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
