import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TodoListComponent } from './pages/todo-list/todo-list.component';
import { TodoAddComponent } from './pages/todo-add/todo-add.component';
import { UpdateTodoComponent } from './pages/update-todo/update-todo.component';

const routes: Routes = [
{
  path: '',
  component: TodoListComponent,
},
{
path: 'add-todo',
component: TodoAddComponent
},
{
  path: 'update-todo/:id',
  component: UpdateTodoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
