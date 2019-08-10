import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router"

@Component({
  selector: 'app-done',
  templateUrl: './done.component.html',
  styleUrls: ['./done.component.scss']
})
export class DoneComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    sessionStorage.clear();
  }

  public home() {
    this.router.navigate(['/']);
  }

}
