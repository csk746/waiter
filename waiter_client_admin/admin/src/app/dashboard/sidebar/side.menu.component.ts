import { Component , OnInit} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router } from "@angular/router";

@Component({
  selector: 'side-menu-component',
  templateUrl: './side.menu.component.html',
  styleUrls: [
    '../../../css/vendors/iCheck/skins/flat/green.css',
    '../../../css/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css',
    '../../../css/vendors/jqvmap/dist/jqvmap.min.css',
    '../../../css/vendors/bootstrap-daterangepicker/daterangepicker.css',
    '../../../css/custom.css', 
  ]
})
export class SideMenuComponent {

  constructor() {
  }

  ngOnInit(){
  }

 
}
