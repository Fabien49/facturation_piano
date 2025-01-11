import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildStudentComponent } from './child-student.component';

describe('ChildStudentComponent', () => {
  let component: ChildStudentComponent;
  let fixture: ComponentFixture<ChildStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ChildStudentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ChildStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
