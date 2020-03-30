import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewTaskFormComponent } from './new-task-form/new-task-form.component';
import { AllTaskComponent } from './all-task/all-task.component';
import { AppComponent } from './app.component';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
const routes: Routes = [
  { path: 'new-task-form', component: NewTaskFormComponent },
  { path: 'app-component', component: AppComponent },
  { path: 'all-task', component: AllTaskComponent },
  { path: 'task-details/:id', component: TaskDetailsComponent },
  { path: 'edit-task/:id', component: EditTaskComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
