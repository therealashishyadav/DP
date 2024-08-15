import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-image-slider',
  templateUrl: './image-slider.component.html',
  styleUrls: ['./image-slider.component.css']
})
export class ImageSliderComponent implements OnInit {

  images: string[] = [
    'assets/img/clark-young-ueZXMrZFFKQ-unsplash.jpg',
    'assets/img/artem-gavrysh-F6-U5fGAOik-unsplash.jpg',
    'assets/img/mike-petrucci-c9FQyqIECds-unsplash.jpg'
    // Add more image paths if needed
  ];

  currentSlide: number = 0;
  transform: number = 0;
  private interval: any;

  ngOnInit() {
    this.startSlider();
  }

  ngOnDestroy() {
    this.stopSlider();
  }

  startSlider() {
    this.interval = setInterval(() => {
      this.nextSlide();
    }, 2000);
  }

  stopSlider() {
    clearInterval(this.interval);
  }

  goToSlide(index: number) {
    if (index !== this.currentSlide) {
      this.transform = -index * 100;
      this.currentSlide = index;
    }
  }

  nextSlide() {
    this.currentSlide = (this.currentSlide + 1) % this.images.length;
    this.transform = -this.currentSlide * 100;
  }
  constructor() { }

}
