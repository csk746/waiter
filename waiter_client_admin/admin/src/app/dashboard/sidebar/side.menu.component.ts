import {Component, OnInit} from '@angular/core';
import * as $ from "jquery";

@Component({
  selector: 'side-menu-component',
  templateUrl: './side.menu.component.html',
  styleUrls: ['../../../resource/custom.css']
})
export class SideMenuComponent implements OnInit{

  constructor() {

  }

  ngOnInit(){

  }

  toggle(event){
    var $currentTarget = $(event.currentTarget);
    $currentTarget.find("ul").toggle(500, function(){
        var cssClass = "";
        var $icon = $currentTarget.find("span.fa")
        if($icon.hasClass("fa-chevron-down")){
            cssClass = "fa-chevron-up";
            $icon.removeClass("fa-chevron-down");
        }else{
            cssClass = "fa-chevron-down";
            $icon.removeClass("fa-chevron-up");
        }

        $icon.addClass(cssClass);

    });
  }
}
