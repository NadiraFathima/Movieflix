import { Component, OnInit } from '@angular/core';
import {TitleService} from '../Title-service/title.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-title-detail',
  templateUrl: './title-detail.component.html',
  styleUrls: ['./title-detail.component.css']
})

export class TitleDetailComponent{
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
  }

  comments = {
    comments: null,
    userName: null,
    ratings: null,
    titleId: null
  }
avgRatings;

display;
  constructor(private route: ActivatedRoute, private titleService: TitleService) {
    this.route.params.subscribe(params => {
      titleService.getOneTitle(params.id)
        .subscribe(title => {this.title = title; console.log(title); });
  });

}

  displayavgRat() {
    this.titleService.displayavgRat(this.title.titleId)
      .subscribe(avgRatings => {
        this.avgRatings = JSON.stringify(avgRatings); console.log(avgRatings);
      });
    this.display = 'ratcom';
    this.displayComments();
  }

  displayComments() {
    this.titleService.displayComments(this.title.titleId)
      .subscribe(comments => {
        this.comments = comments; console.log(comments);
      });

  }
  addRatcom() {
    this.comments.titleId = this.title.titleId;
    this.titleService.addRatcom(this.title.titleId, this.comments)
      .subscribe(comments => {
        console.log(comments);
      });

  }
}
