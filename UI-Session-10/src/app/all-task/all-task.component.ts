import { Component, OnInit } from '@angular/core';
import { TaskModalComponent } from '../task-modal/task-modal.component';
import { TaskServiceService } from './../task-service.service';

@Component({
  selector: 'app-all-task',
  templateUrl: './all-task.component.html',
  styleUrls: ['./all-task.component.css']
})
export class AllTaskComponent implements OnInit {

  taskList: TaskModalComponent[];
  constructor(private taskService: TaskServiceService) { }

  ngOnInit(): void {
    this.taskList = this.taskService.getAllTask();
  }

}
