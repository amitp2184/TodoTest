import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodoListComponent } from './pages/todo-list/todo-list.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule, MatIconModule, MatFormFieldModule, MatOptionModule, MatSelectModule, MatCheckboxModule } from '@angular/material';
import { TodoAddComponent } from './pages/todo-add/todo-add.component';
import { WebServices } from './webservice';
import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdateTodoComponent } from './pages/update-todo/update-todo.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    TodoAddComponent,
    UpdateTodoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatPaginatorModule,
    MatTableModule, 
    MatIconModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    MatCheckboxModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [WebServices,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
