import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { TaskServiceService } from './../task-service.service';
import { TaskModalComponent } from '../task-modal/task-modal.component';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {
  creationDate;
  completionDate;
  task;
  taskName;
  taskDescription;
  formdata;
  taskPriority;
  taskStatus;
  constructor(private _Activatedroute: ActivatedRoute, private taskService: TaskServiceService, private router: Router) { }

  ngOnInit(): void {
    this.creationDate = this._Activatedroute.snapshot.paramMap.get("id");
    this.task = this.taskService.getTask(this.creationDate);
    this.completionDate = this.task.completionDate;
    this.formdata = new FormGroup({
      taskName: new FormControl(this.task.taskName, Validators.compose([
        Validators.required
      ])),
      taskDescription: new FormControl(this.task.taskDescription, Validators.compose([
        Validators.required
      ])),
      taskPriority: new FormControl(this.task.taskPriority, Validators.compose([
        Validators.required
      ])),
      taskStatus: new FormControl(this.task.status, Validators.compose([
        Validators.required
      ])),
    });
  }

  onClickSubmit(data) {
    this.task.taskName = data.taskName;
    this.task.taskDescription = data.taskDescription;
    this.task.taskPriority = data.taskPriority;
    this.task.status = data.taskStatus;
    console.log(this.task.taskStatus);
    if (data.taskStatus == 'COMPLETED') {
      this.task.completionDate = new Date();
    }
    this.taskService.updateTask(this.task);
    this.router.navigate(['/']);
  }
}
