import { Injectable } from '@angular/core';
import { TaskModalComponent } from './task-modal/task-modal.component';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
  taskList: TaskModalComponent[] = [];
  task: TaskModalComponent;
  constructor() {
  }

  createTask(task: TaskModalComponent) {
    var taskString = this.taskToString(task);
    localStorage.setItem(String(task.creationDate), taskString);
  }

  stringToTask(str: string) {
    var tempStr = str.split(",");

    if (tempStr[5] == "null") {
      this.task = new TaskModalComponent(String(tempStr[0]), String(tempStr[1]),
        String(tempStr[2]), String(tempStr[3]), tempStr[4], null);
    }
    else {
      this.task = new TaskModalComponent(String(tempStr[0]), String(tempStr[1]),
        String(tempStr[2]), String(tempStr[3]), tempStr[4], tempStr[5]);
    }
    return this.task;
  }

  taskToString(task: TaskModalComponent) {

    var tTs = task.taskName + ','
      + task.taskDescription + ',' + task.taskPriority
      + ',' + task.status + ',' + task.creationDate
      + ',' + task.completionDate;

    return tTs;
  }

  getAllTask() {
    for (let key in localStorage) {
      if (localStorage.getItem(String(key)) != null) {

        var task = this.stringToTask(localStorage.getItem(key));
        this.taskList.push(this.stringToTask(localStorage.getItem(key)));
      }
    }
    return this.taskList;
  }

  getTask(creationDate: string) {
    var task = this.stringToTask(localStorage.getItem(creationDate));
    return task;
  }

  updateTask(task: TaskModalComponent) {
    localStorage.removeItem(String(task.creationDate));
    this.createTask(task);
  }

  deleteTask(task: TaskModalComponent) {
    localStorage.removeItem(String(task.creationDate));
  }
}
