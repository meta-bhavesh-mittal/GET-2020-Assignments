import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskServiceService } from './../task-service.service';
import { TaskModalComponent } from '../task-modal/task-modal.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {
  creationDate;
  task;
  constructor(private _Activatedroute: ActivatedRoute, private taskService: TaskServiceService, private router: Router) { }

  ngOnInit(): void {
    this.creationDate = this._Activatedroute.snapshot.paramMap.get("id");
    this.task = this.taskService.getTask(this.creationDate);
    if (this.task.completionDate == null) {
      this.task.completionDate = "Not Defined";
    }

  }
  deleteTask() {
    this.taskService.deleteTask(this.task);
    this.router.navigate(['/']);
  }

  editTask() {
    if (this.task.status == 'COMPLETED') {
      alert("Task Can not Edit");
    }
    else {
      this.router.navigate(['/edit-task', this.creationDate]);
    }
  }


}
