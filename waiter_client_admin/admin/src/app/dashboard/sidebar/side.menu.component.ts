import { Component , OnInit} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router } from "@angular/router";

@Component({
  selector: 'side-menu-component',
  templateUrl: './side.menu.component.html',
  styleUrls: [
    '../../../resource/vendors/iCheck/skins/flat/green.css',
    '../../../resource/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css',
    '../../../resource/vendors/jqvmap/dist/jqvmap.min.css',
    '../../../resource/vendors/bootstrap-daterangepicker/daterangepicker.css',
    '../../../resource/custom.css', 
  ]
})
export class SideMenuComponent {

  constructor() {
  }

  ngOnInit(){
  }

 
}
