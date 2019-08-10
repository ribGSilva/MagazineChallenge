import { Component, OnInit } from '@angular/core';
import { SandwichListServiceService } from '../../services/sandwich-list-service/sandwich-list-service.service';
import { Router } from "@angular/router"
import { Sandwich } from "../../models/sandwich"

@Component({
  selector: 'app-choosesandwich',
  templateUrl: './choosesandwich.component.html',
  styleUrls: ['./choosesandwich.component.scss']
})
export class ChoosesandwichComponent implements OnInit {

  sandwichList: Sandwich[];

  constructor(private router: Router,
    private sandwichListServiceService: SandwichListServiceService) { }

  ngOnInit() {
    sessionStorage.clear();
    this.sandwichListServiceService.getSandwichList().subscribe(res => {
      this.sandwichList = res
    });
  }

  choose(sandwich: Sandwich) {
    this.router.navigate(['/ChooseIngredients']);
    sessionStorage.setItem("sandwich", JSON.stringify(sandwich));
  }

}
