import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseingredientsComponent } from './chooseingredients.component';

describe('ChooseingredientsComponent', () => {
  let component: ChooseingredientsComponent;
  let fixture: ComponentFixture<ChooseingredientsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChooseingredientsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChooseingredientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
