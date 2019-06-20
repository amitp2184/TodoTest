import { Component, OnInit } from '@angular/core';
import { TodoModel } from 'src/app/todo.model';
import { WebServices } from 'src/app/webservice';
import { ActivatedRoute, Router } from '@angular/router';
import { ConnectedOverlayPositionChange } from '@angular/cdk/overlay';

@Component({
  selector: 'app-update-todo',
  templateUrl: './update-todo.component.html',
  styleUrls: ['./update-todo.component.css']
})
export class UpdateTodoComponent implements OnInit {

  private todomodel: TodoModel = new TodoModel();
  todo: TodoModel[] = [];
  private id: any;

  constructor(private service: WebServices,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.id = +params['id'];
    })
    this.getTodo();
  }

/** get todo By Id*/
  getTodo() {
   this.service.getTodoById(this.id).subscribe((res: any) => {
   console.log(res)
      this.todomodel.title = res.title;
      this.todomodel.description = res.description;
      this.todomodel.timeOfEvent = res.timeOfEvent.split('.')[0];
      this.todomodel.todoSeqId = res.todoSeqId;
    })
  }

  /** update todo*/
  updateTodo() {
    var datetime : string = String(this.todomodel.timeOfEvent)
    console.log(datetime)
    this.todomodel.timeOfEvent = datetime.split('T')[0] + " "+datetime.split('T')[1];
    this.service.updateTodo(this.todomodel).subscribe((res: any) => {
    })
    this.router.navigate(["/"]);

  }
}