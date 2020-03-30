import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewTaskFormComponent } from './new-task-form/new-task-form.component';
import { AllTaskComponent } from './all-task/all-task.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TaskServiceService } from './task-service.service';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { EditTaskComponent } from './edit-task/edit-task.component';


const appRoutes: Routes = [

];
@NgModule({
  declarations: [
    AppComponent,
    NewTaskFormComponent,
    AllTaskComponent,
    TaskDetailsComponent,
    EditTaskComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [TaskServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
