import { transition } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { timeInterval } from 'rxjs';

@Component({
  selector: 'app-adjustment-page',
  templateUrl: './adjustment-page.component.html',
  styleUrls: ['./adjustment-page.component.css']
})
export class AdjustmentPageComponent implements OnInit {

  action = ['AddItem', 'Delete Item', 'Update Item'];

  reasons = ['Adding new item to increase stock','Removing item as product is sold','Adding item as Product is returned'];

  durationInSeconds = 5;

  constructor(private snackBar: MatSnackBar) { }

  visible:boolean = false

  updateVisible:boolean = false
  
  openSnackBar() {

  }

  extendDeletePage(){

    this.visible = !this.visible
    this.updateVisible = false

  }

  extendUpdatePage(){

    this.updateVisible = !this.updateVisible
    this.visible = false


  }

    ngOnInit(): void {
  }

}
