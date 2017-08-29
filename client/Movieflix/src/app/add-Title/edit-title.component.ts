import { Component, OnInit } from '@angular/core';
import {TitleService} from '../Title-service/title.service';
import {Router} from '@angular/router';
import {FormControl, Validators} from '@angular/forms';


@Component({
  selector: 'app-edit-title',
  templateUrl: './edit-title.component.html',
  styleUrls: ['./edit-title.component.css']
})
export class EditTitleComponent implements OnInit {

  title= {
    titleId: null,
    name: null,
    imdbRatings: null,
    type: null,
    year: null,
    genre: null,
    imdbVotes: null,
    director: null,
    actors: null,
    plot: null

  };
  check;
  checkdet;

  add() {
    this.check = 'add';
  }
  update() {
    this.check = 'update';
  }
  delete() {
    this.check = 'delete';
  }
  getdet() {
    this.checkdet = 'getdet';
  }


  updateValues() {
  document.getElementById('nameup').innerHTML = this.title.name;
  }

  constructor(private titleService: TitleService, private router: Router) {
  }

  ngOnInit() {
  }
  addTitle() {
    this.titleService.addTitle(this.title)
      .subscribe(title => {
        console.log(title);
      });
  }
  deleteTitle() {
    this.titleService.deleteTitle(this.title.titleId)
      .subscribe(title => {
        console.log(title);
      });
  }
  updateTitle() {
    this.titleService.updateTitle(this.title)
      .subscribe(title => {
        console.log(title);
      });
  }
  displayTitle() {
    this.titleService.displayTitle(this.title)
      .subscribe(title => {
        console.log(title);
      });
  }
  getOneTitle() {
    this.titleService.getOneTitle(this.title.titleId)
      .subscribe(title => {
        console.log(title);
      });
  }


}
