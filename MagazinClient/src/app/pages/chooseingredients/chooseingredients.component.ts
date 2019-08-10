import { Component, OnInit } from '@angular/core';
import { IngredientListService } from '../../services/ingredient-list-service/ingredient-list.service';
import { Router } from "@angular/router"
import { IngredientItem } from "../../models/ingredientitem"
import { Promotion } from "../../models/promotion"
import { Sandwich } from "../../models/sandwich"
import { Ingredient } from "../../models/ingredient"
import { Order } from "../../models/order"

@Component({
  selector: 'app-chooseingredients',
  templateUrl: './chooseingredients.component.html',
  styleUrls: ['./chooseingredients.component.scss']
})
export class ChooseingredientsComponent implements OnInit {

  promotions: Promotion[];

  originalSandwich: Sandwich;
  ingredientList: Ingredient[];

  sandwich: Sandwich;
  total: number;

  order: Order;

  constructor(private ingredientListService: IngredientListService,
    private router: Router) { }

  ngOnInit() {

    sessionStorage.removeItem("order");

    if (sessionStorage.getItem("sandwich") == null) {
      this.router.navigate(['/']);
    }

    this.originalSandwich = JSON.parse(sessionStorage.getItem("sandwich"));

    this.sandwich = JSON.parse(sessionStorage.getItem("sandwich"));

    this.ingredientListService.getIngredientList().subscribe(res => {
      this.ingredientList = res
    });

    this.ingredientListService.getPromotionList().subscribe(res => {
      this.promotions = res
    });

    this.calculateOrder();
  }

  public plus(ingredient: Ingredient) {
    if (this.hasItem(this.sandwich, ingredient)) {
      this.getItem(this.sandwich, ingredient).quantity =
        this.getItem(this.sandwich, ingredient).quantity + 1;
    } else {
      let quantity: number = 1;
      let newItem: IngredientItem = { ingredient, quantity };
      this.sandwich.ingredients.push(newItem);
    }
    this.calculateOrder();
  }

  public less(ingredient: Ingredient) {
    if (this.hasItem(this.sandwich, ingredient) && this.getItem(this.sandwich, ingredient).quantity != 0) {
      this.getItem(this.sandwich, ingredient).quantity =
        this.getItem(this.sandwich, ingredient).quantity - 1;
    }
    this.calculateOrder();
  }

  public getQuantityIngredient(ingredient: Ingredient): number {
    if (this.hasItem(this.sandwich, ingredient)) {
      return this.getItem(this.sandwich, ingredient).quantity;
    } else {
      return 0;
    }
  }

  public calculateOrder() {
    this.ingredientListService.getCalculateSandwichPrice(this.sandwich).subscribe(res => {
      this.order = res;
      this.total = this.order.cost
    });
  }

  public checkOrder() {
    this.router.navigate(['/Checkout']);
    sessionStorage.setItem("order", JSON.stringify(this.order));
  }

  public hasItem(sandwich: Sandwich, item: Ingredient): boolean {
    for (let ingredient of sandwich.ingredients) {
      if (ingredient.ingredient.name == item.name) {
        return true;
      }
    }
    return false;
  }

  public getItem(sandwich: Sandwich, item: Ingredient): IngredientItem {
    for (let ingredient of sandwich.ingredients) {
      if (ingredient.ingredient.name == item.name) {
        return ingredient;
      }
    }
    return null;
  }

  public removeItem(sandwich: Sandwich, item: Ingredient) {
    for (let ingredient of sandwich.ingredients) {
      if (ingredient.ingredient.name == item.name) {
        sandwich.ingredients.splice(sandwich.ingredients.findIndex(item => item == ingredient), 1);
      }
    }
  }

  public voltar() {
    this.router.navigate(['/ChooseSandwich']);
  }
}
