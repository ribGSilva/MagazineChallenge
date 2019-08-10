import { TestBed } from '@angular/core/testing';

import { SandwichListServiceService } from './sandwich-list-service.service';

describe('SandwichListServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SandwichListServiceService = TestBed.get(SandwichListServiceService);
    expect(service).toBeTruthy();
  });
});
