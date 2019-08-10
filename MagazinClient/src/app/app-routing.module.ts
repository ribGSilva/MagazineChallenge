import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LayoutComponent } from './components/layout/layout.component'
import { ChoosesandwichComponent } from './pages/choosesandwich/choosesandwich.component'
import { ChooseingredientsComponent } from './pages/chooseingredients/chooseingredients.component'
import { CheckoutComponent } from './pages/checkout/checkout.component'
import { DoneComponent } from './pages/done/done.component'


const routes: Routes = [
  { path: '', redirectTo: '/ChooseSandwich', pathMatch: 'full' },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', redirectTo: '/ChooseSandwich', pathMatch: 'full' },
      { path: 'ChooseSandwich', component: ChoosesandwichComponent },
      { path: 'ChooseIngredients', component: ChooseingredientsComponent },
      { path: 'Checkout', component: CheckoutComponent },
      { path: 'Done', component: DoneComponent }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
