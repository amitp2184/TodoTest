import { Component, OnInit } from '@angular/core';
import { WebServices } from 'src/app/webservice';
import { TodoModel } from 'src/app/todo.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-todo-add',
  templateUrl: './todo-add.component.html',
  styleUrls: ['./todo-add.component.css']
})
export class TodoAddComponent implements OnInit {


  private todomodel : TodoModel = new TodoModel();
  constructor(private service: WebServices,
    private router: Router) { }

  ngOnInit() {
   
  }

  /** create todo*/
   addTodo(){
      console.log(this.todomodel);
      var datetime : string = String(this.todomodel.timeOfEvent)
        this.todomodel.timeOfEvent = datetime.split('T')[0] + " "+datetime.split('T')[1] + ':00';
      this.service.addTodo(this.todomodel).subscribe((res:any)=>{

      })
      this.router.navigate(["/"]); //navigate to list page

     }

}
