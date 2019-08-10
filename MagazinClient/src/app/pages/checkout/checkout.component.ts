import { Component, OnInit } from '@angular/core';
import { CheckoutService } from '../../services/checkout-service/checkout.service';
import { Router } from "@angular/router"
import { Order } from "../../models/order"

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {

  order: Order;

  constructor(private checkoutService: CheckoutService,
    private router: Router) { }

  ngOnInit() {

    if (sessionStorage.getItem("order") == null) {
      this.router.navigate(['/ChooseIngredients']);
    }

    this.order = JSON.parse(sessionStorage.getItem("order"));
  }

  public voltar() {
    this.router.navigate(['/ChooseIngredients']);
  }

  public confirmOrder() {
    this.checkoutService.getSendOrder(this.order).subscribe();

    this.router.navigate(['/Done']);
  }

}
