import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './confirm-dialog.component.html',
  styleUrls: ['./confirm-dialog.component.scss']
})
export class ConfirmDialogComponent implements OnInit {

  @Input() header: string;
  @Input() visible = false;

  @Output() hide: EventEmitter<void> = new EventEmitter();
  @Output() confim: EventEmitter<void> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  public onConfirm(): void {
    this.confim.emit();
  }

  public onHide(): void {
    this.hide.emit();
  }

}
