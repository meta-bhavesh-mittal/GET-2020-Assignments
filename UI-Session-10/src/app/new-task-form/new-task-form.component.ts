import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TaskServiceService } from './../task-service.service';
import { TaskModalComponent } from '../task-modal/task-modal.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-task-form',
  templateUrl: './new-task-form.component.html',
  styleUrls: ['./new-task-form.component.css']
})
export class NewTaskFormComponent implements OnInit {
  taskName;
  taskDescription;
  formdata;
  priority;
  constructor(private taskService: TaskServiceService, private router: Router) { }

  ngOnInit(): void {
    this.formdata = new FormGroup({
      taskName: new FormControl("", Validators.compose([
        Validators.required
      ])),
      taskDescription: new FormControl("", Validators.compose([
        Validators.required
      ])),
      priority: new FormControl("", Validators.compose([
        Validators.required
      ]))
    });
  }
  onClickSubmit(data) {
    var task = new TaskModalComponent(data.taskName, data.taskDescription, data.priority, "NEW", new Date(), null);
    this.taskService.createTask(task);
    this.router.navigate(['/']);
  }
}
