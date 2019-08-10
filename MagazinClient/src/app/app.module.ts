import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule, HttpClient } from '@angular/common/http';  

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './components/layout/layout.component';
import { ChoosesandwichComponent } from './pages/choosesandwich/choosesandwich.component';
import { ChooseingredientsComponent } from './pages/chooseingredients/chooseingredients.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { DoneComponent } from './pages/done/done.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    ChoosesandwichComponent,
    ChooseingredientsComponent,
    CheckoutComponent,
    DoneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
