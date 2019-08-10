import { TestBed } from '@angular/core/testing';

import { IngredientListService } from './ingredient-list.service';

describe('IngredientListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IngredientListService = TestBed.get(IngredientListService);
    expect(service).toBeTruthy();
  });
});
