import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpleadoLogueadoComponent } from './empleado-logueado.component';

describe('EmpleadoLogueadoComponent', () => {
  let component: EmpleadoLogueadoComponent;
  let fixture: ComponentFixture<EmpleadoLogueadoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmpleadoLogueadoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpleadoLogueadoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
