import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChoosesandwichComponent } from './choosesandwich.component';

describe('ChoosesandwichComponent', () => {
  let component: ChoosesandwichComponent;
  let fixture: ComponentFixture<ChoosesandwichComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChoosesandwichComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChoosesandwichComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
